<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
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

                    <th>氏名</th>
                    <th>タイトル</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="task" items="${tasks}" varStatus="status">
                    <tr class="row${status.count % 2}">
                    <td><c:out value="${task.name}" /></td>
                    <td><c:out value="${task.title}" /></td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>


        <p><a href="<c:url value='/tasks/new' />">新規タスクの登録</a></p>

    </c:param>
</c:import>