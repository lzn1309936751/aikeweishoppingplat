<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Basic Table</title>
		<link href="/static/css/bootstrap.min.css" rel="stylesheet">
		<link href="/static/css/bestyle.css" rel="stylesheet">
		<script src="/static/js/jquery-3.3.1.min.js"></script>
		
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
				<div>
					<div class="jumbotron">
						<table class="table table-bordered table-hover">
							<thead>
							<tr>
								<th>商品名称</th>
								<th>生产许可证编号</th>
								<th>厂名</th>
								<th>厂址</th>
								<th>厂家联系方式</th>
								<th>生产日期</th>
								<th>保质期</th>
								<th>配送地区</th>
								<th>操作</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${infoEntities}" var="info">
								<tr>
									<td>${info.pro_name }</td>
									<td>${info.info_code }</td>
									<td>${info.factory_name }</td>
									<td>${info.factory_address }</td>
									<td>${info.factory_phone }</td>
									<td>${info.product_time }</td>
									<td>${info.keep_time }</td>
									<td>${info.delivery_address }</td>
									<td><a href="/admin/productInfo/edit?pid=${info.info_id}" class="btn btn-info">编辑</a></td>
								</tr>
							</c:forEach>
							</tbody>
							<tfoot>
							<ul class="am-pagination am-pagination-right">
								<li class="am-disabled"><a href="/products?pageNum=${pageInfo.prePage}">&laquo;</a></li>
								<c:forEach items="${pageInfo.navigatepageNums}" var="page">
									<li><a href="/products?pageNum=${page}"> ${page}</a></li>
								</c:forEach>
								<li><a href="/products?pageNum=${pageInfo.nextPage}">&raquo;</a></li>
							</ul>
							</tfoot>
						</table>
					</div>
				</div>
			</section>
		</section>
		<input type="hidden" id="userId" value="${admin.admin_id}">
		<script src="/static/js/bootstrap.min.js"></script>
		<script src="/static/js/common-scripts.js"></script>
		<script type="text/javascript" src="/static/js/menu.js"></script>
	</body>
</html>
