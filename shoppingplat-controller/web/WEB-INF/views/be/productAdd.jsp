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
				<a href="#" class="logo">爱克威 <span>后台管理系统</span></a>
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
					<div class="col-md-6 column">
						<h3 class="text-center">
							添加商品信息
						</h3>
					</div>
					<div class="form-group">
						<label for="pname" class="col-sm-6 control-label">商品名称</label>
						<div class="col-md-pull-5 col-sm-6">
							<input type="text" class="form-control" id="pname" name="pname"/>
						</div>
					</div>
					<div class="form-group">
						<label for="pcode" class="col-sm-6 control-label">商品货号</label>
						<div class="col-md-pull-5 col-sm-6">
							<input type="text"  multiple="multiple" name="pcode" id="pcode" class="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<label for="pnum" class="col-sm-6 control-label">商品数量</label>
						<div class="col-md-pull-5 col-sm-6">
							<input type="text"  multiple="multiple" name="pnum" id="pnum" class="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<label for="pdiscount" class="col-sm-6 control-label">商品折扣</label>
						<div class="col-md-pull-5 col-sm-6">
							<input type="text"  multiple="multiple" name="pdiscount" id="pdiscount" class="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<label for="price" class="col-sm-6 control-label">商品价格</label>
						<div class="col-md-pull-5 col-sm-6">
							<input type="text"  multiple="multiple" name="price" id="price" class="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<label for="pdesc" class="col-sm-6 control-label">商品描述</label>
						<div class="col-md-pull-5 col-sm-6">
							<input type="text"  multiple="multiple" name="pdesc" id="pdesc" class="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<label for="cid" class="col-sm-6 control-label">商品类型</label>
						<div class="col-md-pull-5 col-sm-6">
							<select class="form-control" id="cid" name="cid">
								<c:forEach items="${childCateList}" var="c" >
									<option  value="${c.child_id}">${c.child_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-1 col-sm-6">
							<button type="button" id="btnInsert" class="btn btn-default">保存</button>
							<button type="button" id="btnEsc" class="btn btn-default">取消</button>
						</div>
					</div>
			</section>
		</section>

<%--		<script>--%>
<%--			$(function () {--%>
<%--				$("#btnInsert").click(function(){--%>
<%--					var num=$(".MyNumber").val();--%>
<%--					var pid=$(this).closest("div").find("input:first").val();--%>
<%--					$.ajax({--%>
<%--						url:"/admin/product/insert",--%>
<%--						method:"post",--%>
<%--						// data:{pro_name:,pro_code:,--%>
<%--						// 	pro_num:,pro_discount:,pro_iPrice:,--%>
<%--						// 	pro_Desc:,child_id:},--%>
<%--						dataType:"json"--%>
<%--					}).done(function (data) {--%>

<%--					})--%>
<%--				});--%>
<%--			})--%>
<%--		</script>--%>

		<input type="hidden" id="userId" value="${admin.admin_id}">
		<script src="/static/js/bootstrap.min.js"></script>
		<script src="/static/js/common-scripts.js"></script>
		<script type="text/javascript" src="/static/js/menu.js"></script>
	</body>
</html>
