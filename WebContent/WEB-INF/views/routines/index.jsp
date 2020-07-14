<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>ルーティン 一覧</h2>
        <table id="routine_list">
            <tbody>
                <tr>
                    <th class="routine_name">氏名</th>
                    <th class="routine_date">日付</th>
                    <th class="routine_title">タイトル</th>
                    <th class="routine_action">操作</th>
                </tr>
                <c:forEach var="routine" items="${routines}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="routine_name"><c:out value="${routine.user.name}" /></td>
                        <td class="routine_date">${routine.routine_date}</td>
                        <td class="routine_title">${routine.title}</td>
                        <td class="routine_action"><a href="<c:url value='/routines/show?id=${routine.id}' />">詳細を見る</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${routines_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((routines_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/routines/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/routines/new' />">新規ルーティンの登録</a></p>

    </c:param>
</c:import>