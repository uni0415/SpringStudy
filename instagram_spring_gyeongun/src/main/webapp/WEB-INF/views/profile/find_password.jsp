<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/gyeongun/static/css/find_password.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
    <div class="wrap">
        <div class="input-box">
            <label for="username">username 입력</label>
            <input type="text" class="username" name="username" placeholder="username">
        </div>
        <div class="input-box">
            <label for="emailOrPhone">email 또는 phone 입력</label>
            <input type="text" class="emailOrPhone" name="emailOrPhone" placeholder="emailOrPhone">
        </div>
        <button type="button">비밀번호 찾기</button>
    </div>
    <script type="text/javascript" src="/gyeongun/static/js/find_password.js"></script>
</body>
</html>