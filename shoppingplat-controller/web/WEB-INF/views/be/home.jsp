<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/bestyle.css" rel="stylesheet">
    <script src="static/js/jquery-3.3.1.min.js"></script>

</head>
<body>
<section id="container" class="">
    <header class="header white-bg">
        <a href="#" class="logo">爱克威 <span>后台管理系统</span></a>
    </header>

    <div id="sidebar" class="nav-collapse">
        <ul class="sidebar-menu">
            <li class="active">
                <a class="" href="/beHome">
                    <span>首页</span>
                </a>
            </li>
            <li class="sub-menu  conceal">
                <a class="" href="#">
                    <span>商品管理</span><span class="arrow"></span>
                </a>
                <ul class="sub">
                    <li class=" conceal">
                        <a href="/admin/product/list">商品信息</a>
                    </li>
                    <li class="conceal">
                        <a href="/admin/product/insert">添加商品</a>
                    </li>
                    <li class="conceal">
                        <a href="/admin/product/update">修改商品</a>
                    </li>
                </ul>
            </li>
            <li class="sub-menu  conceal">
                <a class="" href="#">
                    <span>分类管理</span><span class="arrow"></span>
                </a>
                <ul class="sub">
                    <li class=" conceal">
                        <a href="/admin/father_cate/list">一级分类信息</a>
                    </li>
                    <li class="conceal">
                        <a class="" href="/admin/child_cate/add">二级分类信息</a>
                    </li>
                </ul>
            </li>
            <li class="sub-menu conceal">
                <a href="javascript:;" class="">
                    <span>订单管理</span> <span class="arrow"></span>
                </a>
                <ul class="sub">
                    <li class=" conceal">
                        <a class="" href="/admin/order/list">订单信息</a>
                    </li>
                    <li class="conceal">
                        <a class="" href="/admin/order/update">修改订单</a>
                    </li>
                </ul>
            </li>
            <li class="sub-menu conceal">
                <a href="javascript:;" class="">
                    <span>员工信息</span><span class="arrow"></span>
                </a>
                <ul class="sub">
                    <li class="conceal">
                        <a class="" href="/admin/user/list">员工管理</a>
                    </li>
                    <li class="conceal">
                        <a class="" href="/admin/role/list">角色管理</a>
                    </li>
                </ul>
            </li>
            <li class="sub-menu conceal">
                <a href="javascript:;" class="">
                    <span>商品图片管理</span><span class="arrow"></span>
                </a>
                <ul class="sub">
                    <li class="conceal">
                        <a class="" href="/admin/image/list">图片信息</a>
                    </li>
                    <li class="conceal">
                        <a class="" href="/admin/image/insert">添加图片</a>
                    </li>
                    <li class="conceal">
                        <a class="" href="/admin/image/update">修改图片</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</section>
<section id="main-content">
    <section class="wrapper">
        <h3>欢迎使用爱克威购物分享平台后台管理系统！</h3>
    </section>
</section>
<input type="hidden" id="userId" value="${admin.admin_id}">
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/common-scripts.js"></script>
<script type="text/javascript" src="static/js/menu.js"></script>
</body>
</html>
