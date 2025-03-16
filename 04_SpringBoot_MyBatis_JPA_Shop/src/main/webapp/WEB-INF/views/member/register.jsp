<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2024-08-24-0024
  Time: 오전 1:57
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html> 
    <head> 
        <meta charset="utf-8">
        <title>회원가입</title>
    </head> 
    <body>
        <h1>회원가입</h1>
        <form action="/member/register" method="post">
            <label for="id">아이디
            <input type="text" name="id" id="id">
            <label for="password">비밀번호
            <input type="text" name="password" id="password">
            <label for="name">이름
            <input type="text" name="name" id="name">
            <input type="submit" value="등록">
        </form>
    </body>
</html>