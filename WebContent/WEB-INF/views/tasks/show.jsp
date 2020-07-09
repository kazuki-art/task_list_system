<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${task != null}">
                <h2>タスク 詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>氏名</th>
                            <td><c:out value="${task.user.name}" /></td>
                        </tr>

                        <tr>
                            <th>内容</th>
                            <td>
                                <pre><c:out value="${task.content}" /></pre>
                            </td>
                        </tr>

                        <tr>
                            <th>着手日</th>
                            <td>
                                <pre><c:out value="${task.start}" /></pre>
                            </td>
                        </tr>

                        <tr>
                            <th>終了日</th>
                            <td>
                                <pre><c:out value="${task.finish}" /></pre>
                            </td>
                        </tr>


                    </tbody>
                </table>

                <c:if test="${sessionScope.login_user.id == task.user.id}">
                    <p><a href="<c:url value="/tasks/edit?id=${task.id}" />">このタスクを編集する</a></p>
                </c:if>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/tasks/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>