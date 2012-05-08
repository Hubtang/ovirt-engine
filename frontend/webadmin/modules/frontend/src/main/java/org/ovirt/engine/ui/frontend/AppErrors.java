package org.ovirt.engine.ui.frontend;

import com.google.gwt.i18n.client.ConstantsWithLookup;

public interface AppErrors extends ConstantsWithLookup {
    String DIRECTORY_GROUP_CANNOT_REMOVE_DIRECTORY_GROUP_ATTACHED_TO_VM_POOL();

    String IO_CD_IMAGE_FILE_ALREADY_EXIST();

    String IO_CD_IMAGE_FILE_NOT_EXIST();

    String IO_INVALID_CD_IMAGE_EXTENSION();

    String IO_ISO_DIRECTORY_NOT_EXIST();

    String IRS_FAILED_CREATING_SNAPSHOT();

    String IRS_FAILED_RETRIEVING_SNAPSHOT_INFO();

    String IRS_NETWORK_ERROR();

    String IRS_PROTOCOL_ERROR();

    String IRS_RESPONSE_ERROR();

    String MAC_POOL_NOT_ENOUGH_MAC_ADDRESSES();

    String VMT_CANNOT_REMOVE_DETECTED_DERIVED_VM();

    String VMT_CANNOT_REMOVE_DOMAINS_LIST_MISMATCH();

    String ACTION_TYPE_FAILED_VM_IMAGE_DOES_NOT_EXIST();

    String ACTION_TYPE_FAILED_VM_SNAPSHOT_DOES_NOT_EXIST();

    String ACTION_TYPE_FAILED_VM_SNAPSHOT_HAS_NO_CONFIGURATION();

    String ACTION_TYPE_FAILED_VM_SNAPSHOT_IS_BROKEN();

    String IMAGE_REPOSITORY_NOT_FOUND();

    String VM_TEMPLATE_IMAGE_IS_LOCKED();

    String VM_TEMPLATE_IMAGE_IS_ILLEGAL();

    String VM_TEMPLATE_IMAGE_LAST_DOMAIN();

    String VM_NAME_CANNOT_BE_EMPTY();

    String VM_CANNOT_UPDATE_ILLEGAL_FIELD();

    String VM_CANNOT_RUN_FROM_NETWORK_WITHOUT_NETWORK();

    String VM_CANNOT_RUN_FROM_CD_WITHOUT_ACTIVE_STORAGE_DOMAIN_ISO();

    String VM_CANNOT_RUN_FROM_DISK_WITHOUT_DISK();

    String VM_CANNOT_RUN_STATELESS_WHILE_IN_PREVIEW();

    String VM_CANNOT_RUN_STATELESS_HA();

    String RESOURCE_MANAGER_FAILED_ATTACHING_VM_TO_USERS();

    String RESOURCE_MANAGER_MIGRATING_VM_IS_NOT_UP();

    String RESOURCE_MANAGER_VM_NOT_FOUND();

    String SEARCH();

    String SEARCH_ERRORNOUS_SEARCH_TEXT();

    String SEARCH_INVALID_SEARCH_TEXT();

    String SEARCH_UNSUPPORTED_BUSINESS_OBJECT();

    String TEMPLATE_IMAGE_LOCKED();

    String USER_CANNOT_ATTACH_TO_VM_IN_POOL();

    String USER_CANNOT_REMOVE_USER_ATTACHED_POOL();

    String USER_CANNOT_REMOVE_USER_NOT_ATTACHED_POOL();

    String USER_CANNOT_REMOVE_USER_DETECTED_RUNNING_VM();

    String USER_CANNOT_REMOVE_HIMSELF();

    String USER_FAILED_POPULATE_DATA();

    String USER_FAILED_SET_USER_ROLE();

    String VDS_CANNOT_MAINTENANCE_VDS_IS_NOT_RESPONDING_WITH_VMS();

    String VDS_CANNOT_MAINTENANCE_VDS_IS_NOT_RESPONDING_AND_SPM();

    String VDS_CANNOT_MAINTENANCE_VDS_IS_NOT_OPERATIONAL();

    String VDS_CANNOT_MAINTENANCE_VDS_IS_IN_MAINTENANCE();

    String VDS_CANNOT_MAINTENANCE_SPM_WITH_RUNNING_TASKS();

    String VDS_CANNOT_MAINTENANCE_SPM_CONTENDING();

    String VDS_CANNOT_MAINTENANCE_IT_INCLUDES_NON_MIGRATABLE_VM();

    String VDS_CANNOT_REMOVE_DEFAULT_VDS_GROUP();

    String VDS_CANNOT_REMOVE_VDS_DETECTED_RUNNING_VM();

    String VDS_CANNOT_REMOVE_VDS_GROUP_VDS_DETECTED();

    String VDS_CANNOT_REMOVE_VDS_STATUS_ILLEGAL();

    String VDS_NOT_EXIST();

    String VDS_PROTOCOL_ERROR();

    String VDS_RESPONSE_ERROR();

    String VDS_STATUS_NOT_VALID_FOR_STOP();

    String VDS_STATUS_NOT_VALID_FOR_START();

    String VDS_NO_VDS_PROXY_FOUND();

    String VDS_FAILED_FENCE_VIA_PROXY_CONNECTION();

    String VDS_STATUS_NOT_VALID_FOR_UPDATE();

    String VDS_CANNOT_ACTIVATE_VDS_ALREADY_UP();

    String VDS_CANNOT_ACTIVATE_VDS_NOT_EXIST();

    String VDS_INVALID_SERVER_ID();

    String VDS_TRY_CREATE_WITH_EXISTING_PARAMS();

    String VDS_EMPTY_NAME();

    String VDS_CANNOT_INSTALL_EMPTY_PASSWORD();

    String VDS_CANNOT_INSTALL_STATUS_ILLEGAL();

    String VDS_PORT_CHANGE_REQUIRE_INSTALL();

    String VDS_PORT_IS_NOT_LEGAL();

    String VDS_TRY_CREATE_SECURE_CERTIFICATE_NOT_FOUND();

    String VDS_FENCING_DISABLED();

    String VDS_FENCE_DISABLED_AT_SYSTEM_STARTUP_INTERVAL();

    String VDS_FENCE_DISABLED_AT_QUIET_TIME();

    String TEMPLATE_IMAGE_NOT_EXIST();

    String VM_CANNOT_REMOVE_VDS_GROUP_VMS_DETECTED();

    String VMT_CANNOT_REMOVE_VDS_GROUP_VMTS_DETECTED();

    String VDS_GROUP_CANNOT_REMOVE_HAS_VM_POOLS();

    String VM_IMAGE_LOCKED();

    String VM_POOL_CANNOT_ADD_VM_WITH_USERS_ATTACHED_TO_POOL();

    String ACTION_TYPE_FAILED_USER_ATTACHED_TO_POOL();

    String VM_POOL_CANNOT_ADD_VM_ATTACHED_TO_POOL();

    String VM_POOL_CANNOT_DETACH_VM_NOT_ATTACHED_TO_POOL();

    String VM_POOL_CANNOT_ADD_VM_DIFFERENT_CLUSTER();

    String VM_POOL_CANNOT_REMOVE_VM_POOL_WITH_ATTACHED_DIRECTORY_GROUPS();

    String VM_POOL_CANNOT_REMOVE_VM_POOL_WITH_ATTACHED_USERS();

    String VM_POOL_CANNOT_REMOVE_VM_POOL_WITH_VMS();

    String VM_POOL_CANNOT_REMOVE_RUNNING_VM_FROM_POOL();

    String VM_POOL_CANNOT_ADD_RUNNING_VM_TO_POOL();

    String VM_INVALID_SERVER_CLUSTER_ID();

    String VMT_CANNOT_CREATE_TEMPLATE_FROM_DOWN_VM();

    String VMT_CANNOT_REMOVE_BLANK_TEMPLATE();

    String VMT_CANNOT_EDIT_BLANK_TEMPLATE();

    String VMT_CANNOT_EXPORT_BLANK_TEMPLATE();

    String VMT_CANNOT_UPDATE_ILLEGAL_FIELD();

    String DIRECTORY_GROUP_CANNOT_REMOVE_DIRECTORY_GROUP_ATTACHED_TO_VM();

    String DIRECTORY_COMPUTER_WITH_THE_SAME_NAME_ALREADY_EXITS();

    String VM_NOT_FOUND();

    String ACTION_TYPE_FAILED_VM_IN_PREVIEW();

    String ACTION_TYPE_FAILED_STOARGE_DOMAIN_IS_WRONG();

    String ACTION_TYPE_FAILED_VM_IMAGE_IS_LOCKED();

    String ACTION_TYPE_FAILED_VM_DURING_EXPORT();

    String ACTION_TYPE_FAILED_VM_IMAGE_IS_ILLEGAL();

    String ACTION_TYPE_FAILED_VM_HAS_NO_DISKS();

    String ACTION_TYPE_FAILED_IMAGE_REPOSITORY_NOT_FOUND();

    String ACTION_TYPE_FAILED_VM_IS_RUNNING();

    String ACTION_TYPE_FAILED_VM_IS_NOT_RUNNING();

    String ACTION_TYPE_FAILED_VM_IS_NOT_UP();

    String ACTION_TYPE_FAILED_VM_IS_NOT_DOWN();

    String ACTION_TYPE_FAILED_VM_IS_SAVING_RESTORING();

    String ACTION_TYPE_FAILED_VM_IS_DURING_SNAPSHOT();

    String ACTION_TYPE_FAILED_VM_STATUS_ILLEGAL();

    String ACTION_TYPE_FAILED_VM_RUNNING_STATELESS();

    String ACTION_TYPE_FAILED_VM_HAS_STATELESS_SNAPSHOT_LEFTOVER();

    String ACTION_TYPE_FAILED_VM_IN_USE_BY_OTHER_USER();

    String ACTION_TYPE_FAILED_VM_NOT_FOUND();

    String ACTION_TYPE_FAILED_VM_IS_NON_MIGRTABLE_AND_IS_NOT_FORCED_BY_USER_TO_MIGRATE();

    String ACTION_TYPE_FAILED_VM_IS_PINNED_TO_HOST();

    String VM_PINNED_TO_HOST_CANNOT_RUN_ON_THE_DEFAULT_VDS();

    String ACTION_TYPE_FAILED_VM_NOT_EXIST();

    String ACTION_TYPE_FAILED_VM_ALREADY_EXIST();

    String ACTION_TYPE_FAILED_VM_CANNOT_BE_HIGHLY_AVAILABLE_AND_PINNED_TO_HOST();

    String ACTION_TYPE_FAILED_VM_GUID_ALREADY_EXIST();

    String ACTION_TYPE_FAILED_VM_ATTACHED_TO_POOL();

    String ACTION_TYPE_FAILED_NO_AVAILABLE_POOL_VMS();

    String ACTION_TYPE_FAILED_VM_FROM_POOL_CANNOT_BE_STATELESS();

    String ACTION_TYPE_FAILED_PRESTARTED_VMS_CANNOT_EXCEED_VMS_COUNT();

    String ACTION_TYPE_FAILED_VM_WITH_BLANK_TEMPLATE();

    String ACTION_TYPE_FAILED_DISK_SPACE_LOW();

    String ACTION_TYPE_FAILED_DEDICATED_VDS_NOT_IN_SAME_CLUSTER();

    String ACTION_TYPE_FAILED_DISK_CONFIGURATION_NOT_SUPPORTED();

    String ACTION_TYPE_FAILED_MIGRATION_IN_PROGRESS();

    String ACTION_TYPE_FAILED_MIGRATION_TO_SAME_HOST();

    String ACTION_TYPE_FAILED_INVALID_CUSTOM_VM_PROPERTIES_INVALID_SYNTAX();

    String ACTION_TYPE_FAILED_INVALID_CUSTOM_VM_PROPERTIES_INVALID_KEYS();

    String ACTION_TYPE_FAILED_INVALID_CUSTOM_VM_PROPERTIES_INVALID_VALUES();

    String ACTION_TYPE_FAILED_VDS_VM_CLUSTER();

    String ACTION_TYPE_FAILED_VDS_VM_MEMORY();

    String ACTION_TYPE_FAILED_VDS_VM_CPUS();

    String CANNOT_MAINTANANCE_VDS_RUN_VMS_NO_OTHER_RUNNING_VDS();

    String ACTION_TYPE_FAILED_VDS_VM_VERSION();

    String ACTION_TYPE_FAILED_VDS_VM_SWAP();

    String ACTION_TYPE_FAILED_NO_VDS_AVAILABLE_IN_CLUSTER();

    String ACTION_TYPE_FAILED_CANNOT_REMOVE_IMAGE_TEMPLATE();

    String ACTION_TYPE_FAILED_CANNOT_REMOVE_ACTIVE_IMAGE();

    String ACTION_TYPE_FAILED_PROBLEM_WITH_CANDIDATE_INFO();

    String ACTION_TYPE_FAILED_TEMPLATE_DOES_NOT_EXIST();

    String ACTION_TYPE_FAILED_IMAGE_ALREADY_EXISTS();

    String ACTION_TYPE_FAILED_TEMPLATE_NAME_ALREADY_EXISTS();

    String ACTION_TYPE_FAILED_TEMPLATE_GUID_ALREADY_EXISTS();

    String ACTION_TYPE_FAILED_CANDIDATE_ALREADY_EXISTS();

    String ACTION_TYPE_FAILED_ROLE_IS_READ_ONLY();

    String ACTION_TYPE_FAILED_STORAGE_POOL_NOT_MATCH();

    String ACTION_TYPE_FAILED_MISSED_STORAGES_FOR_SOME_DISKS();

    String ACTION_TYPE_FAILED_STORAGE_DOMAIN_ALREADY_CONTAINS_DISK();

    String ACTION_TYPE_FAILED_STORAGE_DOMAIN_NAME_ALREADY_EXIST();

    String ACTION_TYPE_FAILED_STORAGE_DOMAIN_ALREADY_EXIST();

    String ACTION_TYPE_FAILED_STORAGE_POOL_NAME_ALREADY_EXIST();

    String ACTION_TYPE_FAILED_TEMPLATE_NOT_FOUND_ON_DESTINATION_DOMAIN();

    String VM_CANNOT_UPDATE_DEFAULT_VDS_NOT_VALID();

    String ACTION_TYPE_FAILED_NO_VDS_IN_POOL();

    String VAR__TYPE__HOST();

    String VAR__TYPE__NETWORK();

    String VAR__TYPE__VM();

    String VAR__TYPE__COMPUTER_ACCOUNT();

    String VAR__TYPE__VM_TEMPLATE();

    String VAR__TYPE__SNAPSHOT();

    String VAR__TYPE__DESKTOP_POOL();

    String VAR__TYPE__VM_FROM_VM_POOL();

    String VAR__TYPE__CLUSTER();

    String VAR__TYPE__ROLE();

    String VAR__TYPE__QUOTA();

    String VAR__TYPE__INTERFACE();

    String VAR__TYPE__VM_DISK();

    String VAR__TYPE__BOOKMARK();

    String VAR__TYPE__VM_TICKET();

    String VAR__TYPE__STORAGE__CONNECTION();

    String VAR__TYPE__STORAGE__DOMAIN();

    String VAR__TYPE__STORAGE__POOL();

    String VAR__TYPE__USER_FROM_VM();

    String VAR__ACTION__RUN();

    String VAR__ACTION__REMOVE();

    String VAR__ACTION__ADD();

    String VAR__ACTION__CREATE();

    String VAR__ACTION__PAUSE();

    String VAR__ACTION__HIBERNATE();

    String VAR__ACTION__MIGRATE();

    String VAR__ACTION__CANCEL_MIGRATE();

    String VAR__ACTION__ATTACHE_DESKTOP_TO();

    String VAR__ACTION__REVERT_TO();

    String VAR__ACTION__PREVIEW();

    String VAR__ACTION__STOP();

    String VAR__ACTION__START();

    String VAR__ACTION__RESTART();

    String VAR__ACTION__SHUTDOWN();

    String VAR__ACTION__EXPORT();

    String VAR__ACTION__EXTEND();

    String VAR__ACTION__IMPORT();

    String VAR__ACTION__ATTACH_ACTION_TO();

    String VAR__ACTION__DETACH_ACTION_TO();

    String VAR__ACTION__MOVE();

    String VAR__ACTION__COPY();

    String VAR__ACTION__CHANGE_CD();

    String VAR__ACTION__EJECT_CD();

    String VAR__ACTION__ALLOCATE_AND_RUN();

    String VAR__ACTION__MANUAL_FENCE();

    String VAR__ACTION__SET();

    String VAR__ACTION__UPDATE();

    String VAR__ACTION__ATTACH();

    String VAR__ACTION__DETACH();

    String VAR__ACTION__ACTIVATE();

    String VAR__ACTION__DEACTIVATE();

    String VAR__ACTION__RECONSTRUCT_MASTER();

    String VAR__ACTION__RECOVER_POOL();

    String VAR__ACTION__DESTROY_DOMAIN();

    String VAR__ACTION__HOT_PLUG();

    String VAR__ACTION__HOT_UNPLUG();

    String VAR__ACTION__LOGON();

    String VAR__ACTION__LOGOFF();

    String ACTION_TYPE_FAILED_DISK_LETTER_ALREADY_IN_USE();

    String ACTION_TYPE_FAILED_DISK_LIMITATION_EXCEEDED();

    String ACTION_TYPE_FAILED_DISK_ALREADY_ATTACHED();

    String ACTION_TYPE_FAILED_DISK_ALREADY_DETACHED();

    String ACTION_TYPE_FAILED_VM_MAX_RESOURCE_EXEEDED();

    String ACTION_TYPE_FAILED_CPU_NOT_FOUND();

    String ACTION_TYPE_FAILED_EXCEEDED_MAX_PCI_SLOTS();

    String ACTION_TYPE_FAILED_EXCEEDED_MAX_IDE_SLOTS();

    String USER_CANNOT_ATTACH_TO_VM_ALREADY_ATTACHED();

    String USER_CANNOT_ATTACH_TO_VM_NOT_ATTACHED();

    String USER_FAILED_TO_AUTHENTICATE();

    String USER_FAILED_TO_AUTHENTICATION_WRONG_AUTHENTICATION_METHOD();

    String VMT_CANNOT_CREATE_DUPLICATE_NAME();

    String VMT_CLUSTER_IS_NOT_VALID();

    String USER_ACCOUNT_DISABLED();

    String USER_PERMISSION_DENIED();

    String USER_CANNOT_LOGIN_SESSION_MISSING();

    String USER_CANNOT_REMOVE_ADMIN_USER();

    String USER_MUST_EXIST_IN_DB();

    String USER_MUST_EXIST_IN_DIRECTORY();

    String USER_IS_ALREADY_LOGGED_IN();

    String USER_IS_NOT_LOGGED_IN();

    String USER_DOES_NOT_HAVE_A_VALID_EMAIL();

    String VM_POOL_CANNOT_CREATE_DUPLICATE_NAME();

    String VM_POOL_CANNOT_CREATE_FROM_BLANK_TEMPLATE();

    String VM_POOL_CANNOT_UPDATE_POOL_NOT_FOUND();

    String ACTION_TYPE_FAILED_VM_TASKS_ARE_ALREADY_RUNNING();

    String VM_CANNOT_SUSPENDE_HAS_RUNNING_TASKS();

    String VM_CANNOT_SUSPEND_STATELESS_VM();

    String VM_CANNOT_SUSPEND_VM_FROM_POOL();

    String USER_NOT_AUTHORIZED_TO_PERFORM_ACTION();

    String ERROR_CANNOT_REMOVE_ROLE_ATTACHED_TO_PERMISSION();

    String ERROR_CANNOT_REMOVE_ROLE_INVALID_ROLE_ID();

    String ERROR_CANNOT_UPDATE_ROLE_NAME();

    String ERROR_CANNOT_UPDATE_ROLE_ID();

    String ERROR_CANNOT_UPDATE_ROLE_TYPE();

    String VDS_APPROVE_WRONG_VDS_TYPE();

    String VDS_APPROVE_VDS_IN_WRONG_STATUS();

    String VDS_SHUTDOWN_VDS_NOT_FOUND();

    String VDS_SHUTDOWN_NO_RESPONSE();

    String VDS_NEW_CLUSTER_ILLEGAL();

    String VDS_CLUSTER_IS_NOT_VALID();

    String VDS_GROUP_CANNOT_UPDATE_CPU_ILLEGAL();

    String VDS_GROUP_CANNOT_UPDATE_CPU_WITH_LOWER_HOSTS();

    String VDS_GROUP_CANNOT_UPDATE_COMPATIBILITY_VERSION_WITH_LOWER_HOSTS();

    String VDS_GROUP_CANNOT_ADD_COMPATIBILITY_VERSION_WITH_LOWER_STORAGE_POOL();

    String VDS_GROUP_CANNOT_DO_ACTION_NAME_IN_USE();

    String NETWROK_NAME_ALREADY_EXISTS();

    String ACTION_TYPE_FAILED_STORAGE_CONNECTION();

    String ACTION_TYPE_FAILED_STORAGE_CONNECTION_NOT_EXIST();

    String ACTION_TYPE_FAILED_STORAGE_DOMAIN_NOT_EXIST();

    String ACTION_TYPE_FAILED_CANNOT_CHANGE_STORAGE_DOMAIN_TYPE();

    String ACTION_TYPE_FAILED_STORAGE_CONNECTION_WRONG_PARAMETERS_FOR_STORAGE_TYPE();

    String ACTION_TYPE_FAILED_STORAGE_DOMAIN_STATUS_ILLEGAL();

    String ACTION_TYPE_FAILED_STORAGE_DOMAIN_STATUS_ILLEGAL2();

    String STORAGE_POOL_REINITIALIZE_WITH_MORE_THAN_ONE_DATA_DOMAIN();

    String ACTION_TYPE_FAILED_STORAGE_POOL_NOT_EXIST();

    String ACTION_TYPE_FAILED_STORAGE_DOMAIN_NOT_IN_STORAGE_POOL();

    String ERROR_CANNOT_DETACH_STORAGE_DOMAIN_WITH_IMAGES();

    String ERROR_CANNOT_REMOVE_STORAGE_POOL_WITH_IMAGES();

    String ERROR_CANNOT_REMOVE_STORAGE_POOL_WITH_VMS();

    String ERROR_CANNOT_REMOVE_STORAGE_DOMAIN_DO_FORMAT();

    String ACTION_TYPE_FAILED_STORAGE_POOL_STATUS_ILLEGAL();

    String NETWORK_BOND_NAME_EXISTS();

    String NETWORK_BOND_NOT_EXISTS();

    String NETWORK_CHECK_CONNECTIVITY();

    String NETWORK_BOND_PARAMETERS_INVALID();

    String NETWORK_DEFAULT_UPDATE_NAME_INVALID();

    String NETWORK_INTERFACE_ALREADY_IN_BOND();

    String NETWORK_INVALID_BOND_NAME();

    String NETWORK_INTERFACE_NOT_EXISTS();

    String ERROR_CANNOT_ATTACH_MORE_THAN_ONE_ISO_DOMAIN();

    String ERROR_CANNOT_ATTACH_MORE_THAN_ONE_EXPORT_DOMAIN();

    String ERROR_CANNOT_ATTACH_STORAGE_DOMAIN_STORAGE_TYPE_NOT_MATCH();

    String ERROR_CANNOT_CHANGE_STORAGE_POOL_TYPE_WITH_DOMAINS();

    String NETWORK_INTERFACE_ALREADY_HAVE_NETWORK();

    String NETWROK_ALREAY_ATTACH_TO_INTERFACE();

    String NETWROK_NOT_EXISTS();

    String ERROR_CANNOT_RECOVERY_STORAGE_POOL_THERE_IS_ACTIVE_DATA_DOMAINS();

    String ERROR_CANNOT_RECOVERY_STORAGE_POOL_STORAGE_TYPE_MISSMATCH();

    String ERROR_CANNOT_DETACH_LAST_STORAGE_DOMAIN();

    String ERROR_CANNOT_DESTROY_LAST_STORAGE_DOMAIN();

    String ERROR_CANNOT_DESTROY_LAST_STORAGE_DOMAIN_HOST_NOT_ACTIVE();

    String NETWROK_VLAN_OUT_OF_RANGE();

    String ERROR_CANNOT_ADD_STORAGE_POOL_WITHOUT_DATA_DOMAIN();

    String ERROR_CANNOT_REMOVE_POOL_WITH_ACTIVE_DOMAINS();

    String VDS_GROUP_CANNOT_CHANGE_STORAGE_POOL();

    String NETWROK_IN_USE();

    String ERROR_CANNOT_CREATE_STORAGE_DOMAIN_WITHOUT_VG_LV();

    String NETWORK_INTERFACE_TEMPLATE_CANNOT_BE_SET();

    String NETWORK_INTERFACE_VM_CANNOT_BE_SET();

    String NETWORK_INTERFACE_NAME_ALREAY_IN_USE();

    String EN_UNKNOWN_NOTIFICATION_METHOD();

    String EN_UNSUPPORTED_NOTIFICATION_EVENT();

    String EN_EVENT_UP_SUBJECT_TEXT();

    String EN_EVENT_DOWN_SUBJECT_TEXT();

    String EN_ALREADY_SUBSCRIBED();

    String EN_NOT_SUBSCRIBED();

    String ACTION_TYPE_FAILED_STORAGE_DOMAIN_TYPE_ILLEGAL();

    String ACTION_TYPE_FAILED_STORAGE_DOMAIN_FORMAT_ILLEGAL();

    String ACTION_TYPE_FAILED_STORAGE_DOMAIN_FORMAT_ILLEGAL_HOST();

    String ERROR_CANNOT_EXTEND_NON_DATA_DOMAIN();

    String ERROR_CANNOT_EXTEND_CONNECTION_FAILED();

    String ERROR_CANNOT_CHANGE_STORAGE_DOMAIN_FIELDS();

    String ERROR_CANNOT_UPDATE_STORAGE_POOL_COMPATIBILITY_VERSION_BIGGER_THAN_CLUSTERS();

    String ERROR_CANNOT_ADD_EXISTING_STORAGE_DOMAIN_CONNECTION_DATA_ILLEGAL();

    String ERROR_CANNOT_ADD_EXISTING_STORAGE_DOMAIN_LUNS_PROBLEM();

    String NETWORK_MAC_ADDRESS_IN_USE();

    String NETWORK_INVALID_MAC_ADDRESS();

    String NETWORK_INTERFACE_IN_USE_BY_VM();

    String NETWORK_CLUSTER_NETWORK_IN_USE();

    String ERROR_CANNOT_DEACTIVATE_MASTER_WITH_NON_DATA_DOMAINS();

    String ERROR_CANNOT_DEACTIVATE_DOMAIN_WITH_TASKS();

    String ERROR_CANNOT_REMOVE_LAST_SUPER_USER_ROLE();

    String VM_CANNOT_REMOVE_VM_WHEN_STATUS_IS_NOT_DOWN();

    String ACTION_TYPE_FAILED_MASTER_STORAGE_DOMAIN_NOT_ACTIVE();

    String TAGS_SPECIFY_TAG_IS_NOT_EXISTS();

    String NETWORK_CANNOT_REMOVE_NETWORK_IN_USE_BY_TEMPLATE();

    String NETWORK_CANNOT_CHANGE_STATUS_WHEN_NOT_DOWN();

    String NETWORK_CANNOT_ADD_INTERFACE_WHEN_VM_STATUS_NOT_UP_DOWN_LOCKED();

    String NETWROK_VLAN_IN_USE();

    String NETWORK_CLUSTER_HAVE_NOT_EXISTING_DATA_CENTER_NETWORK();

    String NETWORK_NOT_EXISTS_IN_CURRENT_CLUSTER();

    String CANNOT_PREIEW_CURRENT_IMAGE();

    String CONFIG_UNKNOWN_KEY();

    String TAGS_SPECIFIED_TAG_CANNOT_BE_THE_PARENT_OF_ITSELF();

    String VM_CANNOT_MOVE_TO_CLUSTER_IN_OTHER_STORAGE_POOL();

    String VM_CLUSTER_IS_NOT_VALID();

    String NETWORK_CANNOT_REMOVE_MANAGEMENT_NETWORK();

    String NETWROK_OLD_NETWORK_NOT_SPECIFIED();

    String NETWORK_INTERFACE_EXITED_MAX_INTERFACES();

    String ACTION_TYPE_FAILED_DETECTED_RUNNING_VMS();

    String ACTION_TYPE_FAILED_HOST_NOT_EXIST();

    String ACTION_TYPE_FAILED_VM_SNAPSHOT_NOT_IN_PREVIEW();

    String TAGS_SPECIFY_TAG_IS_IN_USE();

    String NETWROK_NET_EXISTS_IN_CLUSTER();

    String ACTION_LIST_CANNOT_BE_EMPTY();

    String ACTION_TYPE_FAILED_BOOKMARK_NAME_ALREADY_EXISTS();

    String ACTION_TYPE_FAILED_BOOKMARK_INVALID_ID();

    String ACTION_TYPE_FAILED_VDS_STATUS_ILLEGAL();

    String ACTION_TYPE_FAILED_MIGRATE_BETWEEN_TWO_CLUSTERS();

    String VDS_CANNOT_CHECK_VERSION_HOST_NON_RESPONSIVE();

    String ACTION_TYPE_FAILED_VDS_INTERMITENT_CONNECTIVITY();

    String ACTION_TYPE_FAILED_PM_ENABLED_WITHOUT_AGENT();

    String ACTION_TYPE_FAILED_PM_ENABLED_WITHOUT_AGENT_CREDENTIALS();

    String ACTION_TYPE_FAILED_AGENT_NOT_SUPPORTED();

    String NETWORK_BOND_NOT_ATTACCH_TO_NETWORK();

    String NETWORK_INTERFACE_NOT_ATTACCH_TO_NETWORK();

    String NETWORK_INTERFACE_IN_USE_BY_VLAN();

    String NETWROK_ALREADY_ATTACHED_TO_CLUSTER();

    String ACTION_TYPE_FAILED_VDS_WITH_SAME_HOST_EXIST();

    String ACTION_TYPE_FAILED_ILLEGAL_MEMORY_SIZE();

    String ACTION_TYPE_FAILED_ILLEGAL_NUM_OF_MONITORS();

    String ACTION_TYPE_FAILED_ILLEGAL_DOMAIN_NAME();

    String ACTION_TYPE_FAILED_CANNOT_DECREASE_COMPATIBILITY_VERSION();

    String ACTION_TYPE_FAILED_GIVEN_VERSION_NOT_SUPPORTED();

    String NETWROK_ADDR_MANDATORY_IN_STATIC_IP();

    String ACTION_TYPE_FAILED_OBJECT_LOCKED();

    String NETWORK_BOND_HAVE_ATTACHED_VLANS();

    String NETWORK_INTERFACE_CONNECT_TO_VLAN();

    String NETWORK_CANNOT_REMOVE_NETWORK_IN_USE_BY_VM();

    String ACTION_TYPE_FAILED_DISK_MAX_SIZE_EXCEEDED();

    String NETWROK_HOST_IS_BUSY();

    String VMT_CANNOT_CHANGE_IMAGES_TEMPLATE();

    String VMT_CANNOT_IMPORT_RAW_IMAGE_WITH_SNAPSHOTS();

    String VMT_CANNOT_IMPORT_RAW_IMAGE_WITH_TEMPLATE();

    String VM_CANNOT_EXPORT_RAW_FORMAT();

    String ACTION_TYPE_FAILED_VM_NOT_FOUND_ON_EXPORT_DOMAIN();

    String ACTION_NOT_SUPPORTED_FOR_CLUSTER_POOL_LEVEL();

    String ACTION_TYPE_FAILED_MAX_CPU_PER_SOCKET();

    String ACTION_TYPE_FAILED_MAX_NUM_CPU();

    String ACTION_TYPE_FAILED_MAX_NUM_SOCKETS();

    String VMT_CANNOT_IMPORT_TEMPLATE_EXISTS();

    String VM_CANNOT_IMPORT_TEMPLATE_NAME_EXISTS();

    String VM_CANNOT_IMPORT_VM_EXISTS();

    String VM_CANNOT_IMPORT_VM_NAME_EXISTS();

    String TAGS_CANNOT_EDIT_READONLY_TAG();

    String VM_CANNOT_REMOVE_HAS_RUNNING_TASKS();

    String ACTION_TYPE_FAILED_IMPORTED_TEMPLATE_IS_MISSING();

    String VM_POOL_CANNOT_CREATE_WITH_NO_VMS();

    String ACTION_TYPE_FAILED_DISK_BOOT_IN_USE();

    String VDS_GROUP_CANNOT_UPDATE_CPU_WHEN_RUNNING_VMS();

    String VM_OR_TEMPLATE_ILLEGAL_PRIORITY_VALUE();

    String ACTION_TYPE_FAILED_MIN_CPU_PER_SOCKET();

    String ACTION_TYPE_FAILED_MIN_NUM_SOCKETS();

    String ACTION_TYPE_FAILED_SPECIFY_DOMAIN_IS_NOT_EXPORT_DOMAIN();

    String NETWROK_ADDR_IN_STATIC_IP_BAD_FORMAT();

    String NETWROK_ADDR_IN_GATEWAY_BAD_FORMAT();

    String NETWROK_ADDR_IN_SUBNET_BAD_FORMAT();

    String NETWORK_CANNOT_CONTAIN_BOND_NAME();

    String RHEVH_LOCALFS_WRONG_PATH_LOCATION();

    String ACTION_TYPE_FAILED_STORAGE_POOL_IS_NOT_LOCAL();

    String ACTION_TYPE_FAILED_VDS_IS_NOT_IN_STORAGE_POOL();

    String VDS_CANNOT_ADD_MORE_THEN_ONE_HOST_TO_LOCAL_STORAGE();

    String VDS_CANNOT_REMOVE_HOST_WITH_LOCAL_STORAGE();

    String VDS_CANNOT_ADD_LOCAL_STORAGE_TO_NON_LOCAL_HOST();

    String VDS_CANNOT_REMOVE_LOCAL_STORAGE_ON_NON_LOCAL_HOST();

    String VDS_GROUP_CANNOT_ADD_MORE_THEN_ONE_HOST_TO_LOCAL_STORAGE();

    String VDS_GROUP_SELECTION_ALGORITHM_MUST_BE_SET_TO_NONE_ON_LOCAL_STORAGE();

    String VDS_GROUP_CANNOT_DETACH_DATA_DOMAIN_FROM_LOCAL_STORAGE();

    String DATA_CENTER_LOCAL_STORAGE_NOT_SUPPORTED_IN_CURRENT_VERSION();

    String DATA_CENTER_POSIX_STORAGE_NOT_SUPPORTED_IN_CURRENT_VERSION();

    String VDS_CANNOT_UPDATE_CLUSTER();

    String VM_CANNOT_UPDATE_CLUSTER();

    String VM_STATUS_NOT_VALID_FOR_UPDATE();

    String PERMISSION_ADD_FAILED_PERMISSION_NOT_SENT();

    String PERMISSION_ADD_FAILED_INVALID_ROLE_ID();

    String PERMISSION_ADD_FAILED_INVALID_OBJECT_ID();

    String PERMISSION_ADD_FAILED_USER_ID_MISMATCH();

    String PERMISSION_ADD_FAILED_ONLY_SYSTEM_SUPER_USER_CAN_GIVE_ADMIN_ROLES();

    String PERMISSION_REMOVE_FAILED_ONLY_SYSTEM_SUPER_USER_CAN_REMOVE_ADMIN_ROLES();

    String PERMISSION_ADD_FAILED_VM_IN_POOL();

    String ROLE_WITH_ROLE_ID_DO_NOT_EXIST();

    String VDS_GROUP_CPU_UTILIZATION_MUST_BE_IN_VALID_RANGE();

    String VDS_GROUP_CPU_LOW_UTILIZATION_PERCENTAGE_MUST_BE_LOWER_THAN_HIGH_PERCENTAGE();

    String VDS_GROUP_CPU_HIGH_UTILIZATION_PERCENTAGE_MUST_BE_DEFINED_WHEN_USING_EVENLY_DISTRIBUTED();

    String VDS_GROUP_BOTH_LOW_AND_HIGH_CPU_UTILIZATION_PERCENTAGE_MUST_BE_DEFINED_WHEN_USING_POWER_SAVING();

    String NETWORK_ATTACH_ILLEGAL_GATEWAY();

    String MISSING_DIRECTORY_ELEMENT_ID();

    String NETWORK_ILEGAL_NETWORK_NAME();

    String STORAGE_OPERATION_FAILED_SPM_NETWORK_PROBLEMS();

    String VALIDATION_TAGS_INVALID_TAG_NAME();

    String VALIDATION_VM_POOLS_NAME_NOT_NULL();

    String VALIDATION_ROLES_NAME_NOT_NULL();

    String VALIDATION_ROLES_ID_NOT_NULL();

    String VALIDATION_ROLES_NAME_MAX();

    String VALIDATION_ROLES_NAME_INVALID();

    String VALIDATION_BOOKMARKS_ID_NOT_NULL();

    String VALIDATION_BOOKMARKS_NAME_NOT_NULL();

    String VALIDATION_QUOTA_NAME_INVALID();

    String VALIDATION_VDS_GROUP_NAME_NOT_NULL();

    String VALIDATION_VDS_GROUP_NAME_MAX();

    String VALIDATION_VDS_GROUP_NAME_INVALID();

    String VALIDATION_VDS_GROUP_MigrateOnError_NOT_NULL();

    String VALIDATION_STORAGE_POOL_ID_NOT_NULL();

    String VALIDATION_VDS_HOSTNAME_HOSTNAME_OR_IP();

    String VALIDATION_VDS_POWER_MGMT_ADDRESS_HOSTNAME_OR_IP();

    String VALIDATION_VM_NUM_OF_MONITORS_EXCEEDED();

    String VALIDATION_STORAGE_DOMAIN_NAME_INVALID();

    String VALIDATION_VM_TEMPLATE_NAME_MAX();

    String VALIDATION_DISK_INTERFACE_NOT_NULL();

    String VALIDATION_VOLUME_TYPE_NOT_NULL();

    String VALIDATION_DISK_TYPE_NOT_NULL();

    String VALIDATION_DISK_ALIAS_INVALID();

    String VALIDATION_VOLUME_FORMAT_NOT_NULL();

    String VALIDATION_DISK_IMAGE_DESCRIPTION_NOT_EMPTY();

    String VALIDATION_DATA_CENTER_NAME_INVALID();

    String VALIDATION_DATA_CENTER_DESCRIPTION_INVALID();

    String VALIDATION_EVENTS_EMAIL_FORMAT();

    String VALIDATION_VDS_NAME_INVALID();

    String ERROR_CANNOT_FIND_ISO_IMAGE_PATH();

    String ERROR_CANNOT_FIND_FLOPPY_IMAGE_PATH();

    String VDS_ADD_STORAGE_SERVER_STATUS_MUST_BE_UP();

    String USER_FAILED_TO_AUTHENTICATE_WRONG_USERNAME_OR_PASSWORD();

    String VDS_GROUP_CANNOT_UPDATE_CPU_WITH_SUSPENDED_VMS();

    String VDS_GROUP_CANNOT_LOWER_CPU_LEVEL();

    String VDS_GROUP_CANNOT_UPDATE_COMPATIBILITY_VERSION_WITH_RUNNING_VMS();

    String CUSTOM_VM_PROPERTIES_INVALID_VALUES_NOT_ALLOWED_IN_CURRENT_CLUSTER();

    String USER_FAILED_TO_AUTHENTICATE_ACCOUNT_IS_LOCKED_OR_DISABLED();

    String USER_FAILED_TO_AUTHENTICATE_DNS_ERROR();

    String USER_FAILED_TO_AUTHENTICATE_NO_KDCS_FOUND();

    String USER_FAILED_TO_AUTHENTICATE_CLOCK_SKEW_TOO_GREAT();

    String USER_FAILED_TO_AUTHENTICATE_CONNECTION_TIMED_OUT();

    String USER_FAILED_TO_AUTHENTICATE_WRONG_REALM();

    String ACTION_TYPE_FAILED_INVALID_CUSTOM_VM_PROPERTIES_DUPLICATE_KEYS();

    String ACTION_TYPE_FAILED_HOSNAME_CANNOT_CHANGE();

    String CAN_DO_ACTION_DATABASE_CONNECTION_FAILURE();

    String ACTION_TYPE_FAILED_DESCRIPTION_MAY_NOT_CONTAIN_SPECIAL_CHARS();

    String ACTION_TYPE_FAILED_NAME_LENGTH_IS_TOO_LONG();

    String ACTION_TYPE_FAILED_NAME_MAY_NOT_BE_EMPTY();

    String ACTION_TYPE_FAILED_NAME_MAY_NOT_CONTAIN_SPECIAL_CHARS();

    String ACTION_TYPE_FAILED_NAME_MAY_NOT_CONTAIN_SPECIAL_CHARS_OR_DASH();

    String ACTION_TYPE_FAILED_INVALID_VDS_HOSTNAME();

    String VM_CANNOT_RUN_ONCE_WITH_ILLEGAL_SYSPREP_PARAM();

    String ACTION_TYPE_FAILED_CANNOT_REMOVE_BUILTIN_GROUP_EVERYONE();

    String ACTION_TYPE_FAILED_IMPORT_DATA_DOMAIN_PROHIBITED();

    String ACTION_TYPE_FAILED_VDS_NOT_MATCH_VALID_STATUS();

    String CANNOT_REMOVE_STORAGE_DOMAIN_INVALID_HOST_ID();

    String ERROR_CANNOT_DEACTIVATE_MASTER_WITH_LOCKED_DOMAINS();

    String TAGS_CANNOT_REMOVE_TAG_NOT_EXIST();

    String VAR__TYPE__VM__CLUSTER();

    String VDS_FENCING_OPERATION_FAILED();

    String VM_CANNOT_WITHOUT_ACTIVE_STORAGE_DOMAIN_ISO();

    String USER_CANNOT_RUN_QUERY_NOT_PUBLIC();

    String ERROR_CANNOT_ATTACH_ACTION_GROUP_TO_ROLE_ATTACHED();

    String ERROR_CANNOT_ATTACH_ACTION_GROUP_TO_ROLE_INVALID_ACTION();

    String ERROR_CANNOT_DETACH_ACTION_GROUP_TO_ROLE_NOT_ATTACHED();

    String ERROR_LICENSE_NO_LICENSE();

    String ERROR_LICENSE_ILLEGAL();

    String ERROR_LICENSE_SYSTEM_CLOCK_MODIFIED();

    String ERROR_LICENSE_EXPIRED();

    String MESSAGE_LICENSE_EVALUATION__PARAM_DAYS_LEFT();

    String VDS_REGISTER_NO_HOSTNAME_INPUT();

    String VDS_REGISTER_UNIQUE_ID_DIFFERENT_TYPE();

    String VDS_REGISTER_UNIQUE_ID_AMBIGUOUS();

    String VDS_CANNOT_CONNECT_TO_SERVER();

    String AUTO_MIGRATE_DISABLED();

    String AUTO_MIGRATE_VDS_NOT_FOUND();

    String AUTO_MIGRATE_POWERCLIENT_NOT_FOUND();

    String AUTO_MIGRATE_ALREADY_ON_POWERCLIENT();

    String AUTO_MIGRATE_ALREADY_RUNNING_ON_VDS();

    String AUTO_MIGRATE_UNSUCCESSFUL();

    String APPROVE_VDS_VDS_NOT_FOUND();

    String VDS_GROUP_CLUSTER_IS_NOT_VALID();

    String NETWORK_INTERFACE_NAME_ALREAY_EXISTS();

    String STORAGE_DOMAIN_TYPE_ILLEGAL_FOR_ADDING_EXISTING();

    String NETWORK_INTERFACE_NOT_HAVE_DISPLAY_FLAG();

    String ERROR_CANNOT_ADD_STORAGE_POOL_WITHOUT_DATA_AND_ISO_DOMAINS();

    String ERROR_CANNOT_ADD_STORAGE_POOL_WITH_DIFFERENT_STORAGE_FORMAT();

    String ACTION_TYPE_FAILED_VMS_IN_STORAGE_POOL();

    String ERROR_CANNOT_CHANGE_STORAGE_POOL_VDSS_UP();

    String NETWROK_STORAGE_POOL_MUST_BE_SPECIFY();

    String EN_UNKNOWN_TAG_NAME();

    String ERROR_CANNOT_ATTACH_STORAGE_DOMAIN_SHARED_NOT_SUPPORTED_IN_THIS_POOL();

    String ERROR_CANNOT_ATTACH_STORAGE_DOMAIN_SHARED_NOT_SUPPORTED_IN_OTHER_POOL();

    String ERROR_CANNOT_REMOVE_POOL_WITH_NETWORKS();

    String ACTION_TYPE_FAILED_UP_VDSS_IN_CLUSTER();

    String TAGS_DIRECTORY_ELEMENT_TAG_IS_MISSING();

    String DIRECTORY_GROUP_CANNOT_ATTACH_TO_VM_ALREADY_ATTACHED();

    String DIRECTORY_GROUP_NOT_ATTACH_TO_VM();

    String ERROR_CANNOT_DEFAULT_DIRECTORY_ELEMENT_TAG();

    String ACTION_TYPE_FAILED_NO_VDS_SUPPLIED();

    String NETWORK_CAN_NOT_REMOVE_DEFAULT_NETWORK();

    String NETWORK_CAN_NOT_UPDATE_DEFAULT_NETWORK();

    String TAGS_CANNOT_ASSING_TAG();

    String ACTION_TYPE_FAILED_XP_MEMORY_ERROR();

    String NETWORK_INTERFACE_CANNOT_UPDATE_INTERFACE_VLAN();

    String ILLEAGAL_USER_PROVIDED();

    String USER_CANNOT_BE_ADDED_TO_VM();

    String USER_CANNOT_BE_ADDED_TO_VM_POOL();

    String ACTION_TYPE_FAILED_DETECTED_PINNED_VMS();

    String USER_PASSWORD_EXPIRED();

    String USER_CANNOT_LOGIN_DOMAIN_NOT_SUPPORTED();

    String VM_POOL_CANNOT_DECREASE_VMS_FROM_POOL();

    String MOVE_VM_CLUSTER_MISSING_NETWORK();

    String ACTION_TYPE_FAILED_STORAGE_POOL_WITH_DEFAULT_VDS_GROUP_CANNOT_BE_LOCALFS();

    String DEFAULT_CLUSTER_CANNOT_BE_ON_LOCALFS();

    String VM_CANNOT_CANCEL_MIGRATION_WHEN_VM_IS_NOT_MIGRATING();

    String ACTION_TYPE_FAILED_QUOTA_NOT_EXIST();

    String ACTION_TYPE_FAILED_QUOTA_IS_NOT_VALID();

    String ACTION_TYPE_FAILED_QUOTA_LIMIT_IS_SPECIFIC_AND_GENERAL();

    String ACTION_TYPE_FAILED_QUOTA_LIMIT_IS_NOT_SPECIFIC_OR_GENERAL();

    String ACTION_TYPE_FAILED_QUOTA_NAME_ALREADY_EXISTS();

    String ACTION_TYPE_FAILED_QUOTA_NAME_RESERVED_FOR_DEFAULT();

    String ACTION_TYPE_FAILED_QUOTA_CAN_NOT_HAVE_DEFAULT_INDICATION();

    String ACTION_TYPE_FAILED_DATA_CENTER_MUST_HAVE_AT_LEAST_ONE_QUOTA();

    String ACTION_TYPE_FAILED_QUOTA_STORAGE_LIMIT_EXCEEDED();

    String ACTION_TYPE_FAILED_QUOTA_VDS_GROUP_LIMIT_EXCEEDED();

    String CAN_DO_ACTION_GENERAL_FAILURE();

    String ERROR_CANNOT_REMOVE_ACTIVE_STORAGE_POOL();

    String ROLE_TYPE_CANNOT_BE_EMPTY();

    String CANNOT_ADD_ACTION_GROUPS_TO_ROLE_TYPE();

    String STORAGE_DOMAIN_NOT_ATTACHED_TO_STORAGE_POOL();

    String VDS_APPROVE_VDS_NOT_FOUND();

    String VDS_CANNOT_UPGRADE_BETWEEN_MAJOR_VERSION();

    String VDS_CANNOT_INSTALL_MISSING_IMAGE_FILE();

    String HOT_PLUG_IS_NOT_SUPPORTED();

    String ACTION_TYPE_FAILED_GUEST_OS_VERSION_IS_NOT_SUPPORTED();

    String HOT_PLUG_DISK_IS_NOT_VIRTIO();

    String HOT_PLUG_DISK_IS_NOT_UNPLUGGED();

    String HOT_UNPLUG_DISK_IS_NOT_PLUGGED();

    String VM_CANNOT_RUN_FROM_DISK_WITHOUT_PLUGGED_DISK();

    String VALIDATION_INVALID_CORRELATION_ID();

    String ACTION_TYPE_FAILED_DISK_NOT_EXIST();

    String ACTION_TYPE_FAILED_DISK_IS_NOT_TEMPLATE_DISK();

    String ACTION_TYPE_FAILED_SOURCE_AND_TARGET_SAME();

    String ACTION_TYPE_FAILED_CANNOT_MOVE_TEMPLATE_DISK();

    String NON_VM_NETWORK_NOT_SUPPORTED_FOR_POOL_LEVEL();

    String VALIDATION_DISK_IMAGE_DESCRIPTION_NOT_ASCII();

    String VALIDATION_STORAGE_CONNECTION_INVALID();

    String VMPAYLOAD_INVALID_PAYLOAD_TYPE();

    String VMPAYLOAD_SIZE_EXCEEDED();

    String VMPAYLOAD_CDROM_EXCEEDED();

    String VMPAYLOAD_FLOPPY_EXCEEDED();
}
