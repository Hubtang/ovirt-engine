package org.ovirt.engine.exttool.logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.apache.commons.lang.StringUtils;
import org.ovirt.engine.api.extensions.Base;
import org.ovirt.engine.api.extensions.ExtMap;
import org.ovirt.engine.api.extensions.logger.Logger;
import org.ovirt.engine.core.extensions.mgr.ExtensionProxy;
import org.ovirt.engine.core.extensions.mgr.ExtensionsManager;
import org.ovirt.engine.core.uutils.cli.parser.ArgumentsParser;
import org.ovirt.engine.exttool.core.ExitException;
import org.ovirt.engine.exttool.core.ModuleService;
import org.slf4j.LoggerFactory;

public class LoggerServiceImpl implements ModuleService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(LoggerServiceImpl.class);

    private interface Logic {
        void execute(ExtMap context, Map<String, Object> argMap);
    }

    private enum Action {
        LOG_RECORD(
            new Logic() {
                @Override
                public void execute(ExtMap context, Map<String, Object> argMap) {
                    ExtensionProxy proxy = getExtensionManager(context).getExtensionByName((String) argMap.get("extension-name"));

                    LogRecord logRecord = new LogRecord(
                        (Level) argMap.get("level"),
                        (String) argMap.get("message")
                    );
                    logRecord.setLoggerName((String) argMap.get("logger-name"));

                    log.info("API: -->Logger.InvokeCommands.PUBLISH level={}, name={}", logRecord.getLevel(), logRecord.getLoggerName());
                    proxy.invoke(
                        new ExtMap().mput(
                            Base.InvokeKeys.COMMAND,
                            Logger.InvokeCommands.PUBLISH
                        ).mput(
                            Logger.InvokeKeys.LOG_RECORD,
                            logRecord
                        )
                    );
                    log.info("API: <--Logger.InvokeCommands.PUBLISH");

                    log.info("API: -->Logger.InvokeCommands.FLUSH");
                    proxy.invoke(
                        new ExtMap().mput(
                            Base.InvokeKeys.COMMAND,
                            Logger.InvokeCommands.FLUSH
                        )
                    );
                    log.info("API: <--Logger.InvokeCommands.FLUSH");

                    log.info("API: -->Logger.InvokeCommands.CLOSE");
                    proxy.invoke(
                        new ExtMap().mput(
                            Base.InvokeKeys.COMMAND,
                            Logger.InvokeCommands.CLOSE
                        )
                    );
                    log.info("API: <--Logger.InvokeCommands.CLOSE");
                }
            }
        );

        private Logic logic;

        private Action(Logic logic) {
            this.logic = logic;
        }

        Map<String, Object> parse(Map<String, String> substitutions, Properties props, List<String> moduleArgs) {
            ArgumentsParser parser = new ArgumentsParser(props, moduleArgs.remove(0));
            parser.getSubstitutions().putAll(substitutions);
            parser.parse(moduleArgs);
            Map<String, Object> argMap = parser.getParsedArgs();

            if((Boolean)argMap.get("help")) {
                System.out.format("Usage: %s", parser.getUsage());
                throw new ExitException("Help", 0);
            }
            if(!parser.getErrors().isEmpty()) {
                for(Throwable t : parser.getErrors()) {
                    System.err.format("FATAL: %s%n", t.getMessage());
                }
                throw new ExitException("Parsing error", 1);
            }

            return argMap;
        }

        void execute(ExtMap context, Map<String, Object> argMap) {
            logic.execute(context, argMap);
        }
    }

    private ExtMap context;
    private Action action;
    private Map<String, Object> argMap;

    private static ExtensionsManager getExtensionManager(ExtMap context) {
        return (ExtensionsManager)context.get(EXTENSION_MANAGER);
    }

    @Override
    public String getName() {
        return "logger";
    }

    @Override
    public String getDescription() {
        return "Logger module test logger extension configuration.";
    }

    @Override
    public void setContext(ExtMap context) {
        this.context = context;
    }

    @Override
    public ExtMap getContext() {
        return context;
    }

    @Override
    public void parseArguments(List<String> args) throws Exception {
        final Map<String, String> substitutions = new HashMap<>();
        substitutions.put("@PROGRAM_NAME@", (String) context.get(PROGRAM_NAME));

        args.remove(0);

        Properties props = new Properties();
        try (
            InputStream in = LoggerServiceImpl.class.getResourceAsStream("arguments.properties");
            Reader reader = new InputStreamReader(in);
        ) {
            props.load(reader);
        }
        ArgumentsParser parser = new ArgumentsParser(props, "module");
        parser.getSubstitutions().putAll(substitutions);
        parser.parse(args);
        Map<String, Object> moduleArgs = parser.getParsedArgs();

        if((Boolean)moduleArgs.get("help")) {
            System.out.format("Usage: %s", parser.getUsage());
            throw new ExitException("Help", 0);
        }
        if(!parser.getErrors().isEmpty()) {
            for(Throwable t : parser.getErrors()) {
                System.err.format("FATAL: %s%n", t.getMessage());
            }
            throw new ExitException("Parsing error", 1);
        }

        if (args.size() < 1) {
            System.err.println("Action not provided");
            throw new ExitException("Action not provided", 1);
        }

        try {
            action = Action.valueOf(args.get(0).toUpperCase().replace("-", "_"));
        } catch(IllegalArgumentException e) {
            System.err.printf("Invalid action '%s'%n", args.get(0));
            throw new ExitException("Invalid action", 1);
        }

        argMap = action.parse(substitutions, props, args);
    }

    @Override
    public void run() throws Exception {
        action.execute(context, argMap);
    }
}