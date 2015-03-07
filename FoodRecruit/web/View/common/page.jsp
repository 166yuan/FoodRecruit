<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 当只有1页时，不显示分页-->
<c:choose>
    <c:when test="${pageBean.maxPage<=1}"> <ul class="pagination" style="display: none"></c:when>
    <c:otherwise>
        <ul class="pagination">
    </c:otherwise>
</c:choose>
<!-- 下面是显示页面了-->
<c:choose>
    <c:when test="${param.get('page')==1}">
        <li class="prev disabled"><a href="#">
            <i class="fa fa-angle-double-left"></i>
        </a></li>
        <li class="prev disabled"><a href="#">
            <i class="fa fa-angle-left"></i>
        </a></li>
    </c:when>
    <c:otherwise>
        <li class="prev"><a id="tohead" href="${pageBean.classPath}${pageBean.methodPath}?<c:forEach items="${param}" var="ca">
<c:choose><c:when test="${ca.key.equals('page')}"><c:out value="${ca.key}" />=<c:out value="1"/>&</c:when><c:otherwise><c:out value="${ca.key}" />=<c:out value="${ca.value}"/>&</c:otherwise></c:choose>
                                        </c:forEach>">
            <i class="fa fa-angle-double-left"></i>
        </a></li>
        <li class="prev"><a id="topre" href="${pageBean.classPath}${pageBean.methodPath}?<c:forEach items="${param}" var="ca">
<c:choose><c:when test="${ca.key.equals('page')}"><c:out value="${ca.key}" />=<c:out value="${ca.value-1}"/>&</c:when><c:otherwise><c:out value="${ca.key}" />=<c:out value="${ca.value}"/>&</c:otherwise></c:choose>
                                        </c:forEach>">
            <i class="fa fa-angle-left"></i>
        </a></li>
    </c:otherwise>
</c:choose>
<c:forEach var="i" begin="1" end="${pageBean.maxPage}">
    <c:choose>
        <c:when test="${pageBean.curPage==i}">
            <li class="active"><a href="#"><c:out value="${i}"/></a></li>
        </c:when>
        <c:otherwise>
            <li> <a href="${pageBean.classPath}${pageBean.methodPath}?<c:forEach items="${param}" var="ca">
<c:choose><c:when test="${ca.key.equals('page')}"><c:out value="${ca.key}" />=<c:out value="${i}"/></c:when><c:otherwise><c:out value="${ca.key}" />=<c:out value="${ca.value}"/></c:otherwise></c:choose>
                                        </c:forEach>
                                        "><c:out value="${i}"/></a></li>
        </c:otherwise>
    </c:choose>
</c:forEach>
<c:choose>
    <c:when test="${param.get('page')==pageBean.maxPage}">
        <li class="next disabled"><a href="#">
            <i class="fa fa-angle-double-right"></i>
        </a></li>
        <li class="next disabled"><a href="#">
            <i class="fa fa-angle-right"></i>
        </a></li>
    </c:when>
    <c:otherwise>
        <li class="next"><a href="${pageBean.classPath}${pageBean.methodPath}?<c:forEach items="${param}" var="ca">
<c:choose><c:when test="${ca.key.equals('page')}"><c:out value="${ca.key}" />=<c:out value="${ca.value+1}"/>&</c:when><c:otherwise><c:out value="${ca.key}" />=<c:out value="${ca.value}"/>&</c:otherwise></c:choose>
                                        </c:forEach>">
            <i class="fa fa-angle-right"></i>
        </a></li>

        <li class="next"><a href="${pageBean.classPath}${pageBean.methodPath}?<c:forEach items="${param}" var="ca">
<c:choose><c:when test="${ca.key.equals('page')}"><c:out value="${ca.key}" />=<c:out value="${pageBean.maxPage}"/>&</c:when><c:otherwise><c:out value="${ca.key}" />=<c:out value="${ca.value}"/>&</c:otherwise></c:choose>
                                        </c:forEach>">
            <i class="fa fa-angle-double-right"></i>
        </a></li>
    </c:otherwise>
</c:choose>
</ul>