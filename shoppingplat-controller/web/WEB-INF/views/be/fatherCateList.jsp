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
				<div>
					<div class="jumbotron">
						<table class="table table-bordered table-hover">
							<tr>
								<th>编号</th>
								<th>类型</th>
								<th>操作</th>
								<th>详情</th>
							</tr>
							<c:forEach items="${fatherCate}" var="f">
							<tr>
								<td class="fatherId">${f.father_id}</td>
								<td>${f.father_name}</td>
								<td>
									<a href="/admin/father/edit?fid=${f.father_id}" class="btn btn-info">编辑</a>
									<a href="/admin/father/delete?fid=${f.father_id}" class="btn btn-danger" onclick="return confirm('确定要删除吗？')">删除</a>
								</td>
								<td><input type="button" class="btnLook" name="btnLook" value="点击查看" /></td>
							</tr>
							</c:forEach>
						</table>
						<a href="/admin/father/add" class="btn btn-info add">新增</a>
					</div>
					<div>
						<div class="jumbotron showAllChild">


						</div>
					</div>
				</div>
			</section>
		</section>

		<script>
			$(function () {
				//获得选中的子类型
				$(".btnLook").click(function () {
					alert(0)
					var id=$(".fatherId").val();
					$.ajax({
						url:"/admin/child/list",
						method:"post",
						data:{fatherId:id},
						dataType:"json",
						success:function(data){
							alert(1)
							$(".showAllChild").html("");
							var html="";
							html+="<table class='table table-bordered table-hover'>";
							html+="<tr><th>编号</th><th>类型</th><th>操作</th></tr>";
							html+="<c:forEach items='${data.date}' var='c'>";
							html+="<tr><td>${c.child_id}</td>";
							html+="<td>${c.child_name}</td><td>";
							html+="<a href='/admin/child/edit?cid=${c.child_id} class='btn btn-info'>编辑</a>";
							html+="<a href='/admin/child/delete?cid=${c.child_id} class='btn btn-danger' onclick='return confirm('确定要删除吗？')'>删除</a>";
							html+="</td></tr>";
							html+="</c:forEach></table>";
							$(".showAllChild").append(html);
						}
					})
				});
			})
		</script>

<%--		<section id="main-content">--%>
<%--			<section class="wrapper">--%>
<%--				<div>--%>
<%--					<div class="jumbotron">--%>
<%--						<table class="table table-bordered table-hover">--%>
<%--							<thead>--%>
<%--							<tr>--%>
<%--								<th>编号</th>--%>
<%--								<th>类型</th>--%>
<%--								<th>详情</th>--%>
<%--								<th>操作</th>--%>
<%--							</tr>--%>
<%--							</thead>--%>
<%--							<tbody>--%>
<%--							<c:forEach items="${productList}" var="p">--%>
<%--								<tr>--%>
<%--									<td>${p.pro_id }</td>--%>
<%--									<td>${p.pro_code }</td>--%>
<%--									<td><a href="/admin/product/edit?pid=${p.pro_id }" class="btn btn-info">编辑</a>--%>
<%--										<a href="/admin/product/delete?pid=${p.pro_id }" class="btn btn-danger" onclick="return confirm('确定要删除吗？')">删除</a></td>--%>
<%--								</tr>--%>
<%--							</c:forEach>--%>
<%--							</tbody>--%>
<%--							<tfoot>--%>
<%--							<ul class="am-pagination am-pagination-right">--%>
<%--								<li class="am-disabled"><a href="/products?pageNum=${pageInfo.prePage}">&laquo;</a></li>--%>
<%--								<c:forEach items="${pageInfo.navigatepageNums}" var="page">--%>
<%--									<li><a href="/products?pageNum=${page}"> ${page}</a></li>--%>
<%--								</c:forEach>--%>
<%--								<li><a href="/products?pageNum=${pageInfo.nextPage}">&raquo;</a></li>--%>
<%--							</ul>--%>
<%--							</tfoot>--%>
<%--						</table>--%>
<%--						<a href="/admin/product/add" class="btn btn-info add">新增</a>--%>
<%--					</div>--%>
<%--				</div>--%>
<%--			</section>--%>
<%--		</section>--%>
		<input type="hidden" id="userId" value="${admin.admin_id}">
		<script src="/static/js/bootstrap.min.js"></script>
		<script src="/static/js/common-scripts.js"></script>
		<script type="text/javascript" src="/static/js/menu.js"></script>
	</body>
</html>
