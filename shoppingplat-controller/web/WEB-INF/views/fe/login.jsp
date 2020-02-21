<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>登录</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="static/css/amazeui.css" />
    <link rel="stylesheet" href="static/css/dlstyle.css" />
    <script src="static/js/jquery-3.3.1.min.js" type="text/javascript"></script>
</head>

<body>

<div class="login-boxtitle">
    <a href="home.html"><img alt="logo" src="static/images/logobig.png" /></a>
</div>

<div class="login-banner">
    <div class="login-main">
        <div class="login-banner-bg"><span></span><img src="static/images/big.jpg" /></div>
        <div class="login-box">
            <h3 class="title">登录商城</h3>

            <div class="clear"></div>

            <div class="login-form">
                <form>
                    <div class="user-name">
                        <label for="user"><i class="am-icon-user"></i></label>
                        <input type="text" name="" id="user" placeholder="邮箱/手机/用户名">
                    </div>
                    <div class="user-pass">
                        <label for="password"><i class="am-icon-lock"></i></label>
                        <input type="password" name="" id="password" placeholder="请输入密码">
                    </div>
                </form>
            </div>

            <div class="login-links">
                <label for="remember-me"><input id="remember-me" type="checkbox">记住密码</label>
                <a href="#" class="am-fr">忘记密码</a>
                <a href="register.html" class="zcnext am-fr am-btn-default">注册</a>
                <br />
            </div>
            <div class="am-cf">
                <input type="submit" id="myLogin" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm">
            </div>
        </div>
    </div>
</div>

<script>
    $(function () {
        $("#myLogin").click(function () {
            var username=$("#user").val();
            var password=$("#password").val();
            $.ajax({
                url:"/getUserAndPwd",
                method:"get",
                data:{username:username,password:password},
                dataType:"json"
            }).done(function (data) {
                console.log(data);
                if(data.data == 'no'){
                    location.href="/login";
                }else {
                    location.href="/home";
                }
            })
        })
    })
</script>


<div class="footer ">
    <div class="footer-hd ">
        <p>
            <a href="# ">爱克威购物分享平台</a>
            <b>|</b>
            <a href="# ">商城首页</a>
            <b>|</b>
            <a href="# ">支付宝</a>
            <b>|</b>
            <a href="# ">物流</a>
        </p>
    </div>
    <div class="footer-bd ">
        <p>
            <a href="# ">关于爱克威购物分享平台</a>
            <a href="# ">合作伙伴</a>
            <a href="# ">联系我们</a>
            <a href="# ">网站地图</a>
        </p>
    </div>
</div>
</body>

</html>