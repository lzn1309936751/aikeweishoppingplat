<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/bestyle.css" rel="stylesheet">
    <script src="/static/js/jquery-3.3.1.min.js"></script>

    <style>
        img{
            width:200px;
            height:200px;
            overflow: hidden;
        }
    </style>
</head>
<body>
<section id="container" class="">
    <header class="header white-bg">
        <a href="#" class="logo"><span>后台管理</span></a>
    </header>

    <div id="sidebar" class="nav-collapse">
        <ul class="sidebar-menu">
            <li class="">
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
                        <a href="/admin/productInfo/list">商品详情</a>
                    </li>
                    <li class="conceal">
                        <a href="/admin/coupon/list">优惠劵</a>
                    </li>
                </ul>
            </li>
            <li class="sub-menu  conceal">
                <a class="" href="#">
                    <span>分类管理</span><span class="arrow"></span>
                </a>
                <ul class="sub">
                    <li class=" conceal">
                        <a href="/admin/father/list">一级分类信息</a>
                    </li>
                    <li class="conceal">
                        <a class="" href="/admin/child/add">二级分类信息</a>
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
        <div class="row">
            <div class=" col-sm-4">
                <button class="btn" id="addImage"  data-toggle="modal" data-target="#myModal">添加商品图片</button>
            </div>
        </div>
        <br>
        <div class="row">
            <c:forEach items="${imageList}" var="image">
                <div class="col-md-2">
                    <div class="thumbnail">
                        <img alt="200x200" src="${image.img_path}" />
                        <input type="hidden" name="id" value="${image.img_id}"/>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">添加商品图片</h4>
                    </div>
                    <div class="modal-body">
                        <form role="form">
                            <div class="form-group">
                                <label for="img_name">图片</label>
                                <input type="file" class="form-control" id="img_name">
                            </div>
                            <div class="form-group">
                                <label for="pro_id">商品Id</label>
                                <input type="text" class="form-control" id="pro_id" placeholder="请输入商品id">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="submit">保存</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
    </section>
</section>

<script>
    $(function () {
        $("#submit").click(function () {
            var uploadFile=$("#img_name").val();
            var proId=$("#pro_id").val();
            $.ajax({
                url:"/upload",
                type:"post",
                data:{file:uploadFile,proId:proId},
                processData: false,
                cache:false,
                contentType:false ,
                dataType:"json",
                success:function (data) {
                    if (data == "no"){
                        alert("图片上传失败！！！")
                    }else{
                        alert("图片上传成功！！！")
                    }
                }
            })
        })
    })
</script>

<input type="hidden" id="userId" value="${admin.admin_id}">
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/common-scripts.js"></script>
<script type="text/javascript" src="static/js/menu.js"></script>
</body>
</html>
