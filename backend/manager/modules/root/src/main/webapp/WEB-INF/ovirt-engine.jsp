<%@ page pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="obrand" uri="obrand" %>
<fmt:setBundle basename="languages" var="lang" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <obrand:favicon />
    <title><fmt:message key="obrand.welcome.title" /></title>
    <obrand:stylesheets />
    <script src="splash.js" type="text/javascript"></script>
</head>
<body onload="pageLoaded()">
    <div>
        <div class="obrand_left">
            <div class="obrand_header_nav">
                <fmt:message key="obrand.welcome.header.main" />
            </div>
        </div>
           <a href="http://www.ovirt.org/Console_Client_Resources" target="_blank">
            <div class="obrand_right">
            </div>
           </a>
        <div class="obrand_center">
        </div>
    </div>
    <div class="obrand_main">
        <noscript id="warningMessage" class="obrand_warningMessage">
            <b><fmt:message key="obrand.welcome.browser.javascript1" /></b>
            <fmt:message key="obrand.welcome.browser.javascript2" />
        </noscript>
        <div id='dynamicLinksSection' style="display: none;">
            ${requestScope['sections'].toString()}
        </div>
        <div class="obrand_locale_select_panel">
            <select class="gwt-ListBox obrand_locale_list_box" onchange="localeSelected(this)">
            <c:forEach items="${requestScope['localeKeys']}" var="localeKey">
                <c:choose>
                <c:when test="${requestScope['locale'].toString() == localeKey}">
                    <c:set var="selectedLocale" value="${localeKey}"/>
                    <option value="${localeKey}" selected="selected"><fmt:message key="${localeKey}" bundle="${lang}"/></option>
                </c:when>
                <c:otherwise>
                    <option value="${localeKey}"><fmt:message key="${localeKey}" bundle="${lang}"/></option>
                </c:otherwise>
                </c:choose>
            </c:forEach>
            </select>
            <div class="gwt-Label obrand_locale_selected"><fmt:message key="${selectedLocale}" bundle="${lang}"/></div>
        </div>
    </div>
</body>
</html>
