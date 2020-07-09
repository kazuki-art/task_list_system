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
        <h2>タスク 一覧</h2>
        <table id="task_list">
            <tbody>
                <tr>
                    <th class="task_name">氏名</th>

                    <th class="task_title">タイトル</th>
                    <th class="task_limit">締切日</th>
                    <th class="task_action">操作</th>
                </tr>
                <c:forEach var="task" items="${tasks}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="task_name"><c:out value="${task.user.name}" /></td>

                        <td class="task_title">${task.title}</td>
                        <td class="task_limit">${task.limit}</td>
                        <td class="task_action"><a href="<c:url value='/tasks/show?id=${task.id}' />">詳細を見る</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${tasks_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((tasks_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/tasks/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/tasks/new' />">新規タスクの登録</a></p>

    </c:param>
</c:import>