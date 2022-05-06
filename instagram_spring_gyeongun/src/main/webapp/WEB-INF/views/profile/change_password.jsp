<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/gyeongun/static/css/change_password.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
    <div class="wrap">
        <div class="input-box">
            <label for="newPassword">새 비밀번호</label>
            <input type="password" class="newPassword" name="newPassword" placeholder="new-password">
        </div>
        <div class="input-box">
            <label for="reNewPassword">새 비밀번호 확인</label>
            <input type="password" class="reNewPassword" name="reNewPassword" placeholder="password-check">
        </div>
        <button type="button">확인</button>
    </div>
    <script type="text/javascript" src="/gyeongun/static/js/change_password.js"></script>
</body>
</html>