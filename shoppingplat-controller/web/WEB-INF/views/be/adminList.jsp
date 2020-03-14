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
					    <a class="" href="/home">
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

				<div class="form-group">
					<div class="col-sm-3">
						<input type="text" class="form-control" id="getByName" placeholder="通过员工名字搜索员工">
					</div>
					<div class="col-sm-3">
						<button class="btn btn-primary" id="queryUser"  data-toggle="modal" data-target="#myModal">搜索</button>
					</div>
					<div class="col-md-push-5 col-sm-4">
						<button class="btn btn-primary" id="addUser"  data-toggle="modal" data-target="#myModal">添加用户</button>
					</div>
				</div>

				<table class="table table-striped table-advance table-hover">
					<thead>
						<tr>
							<th>编号</th>
							<th>用户名</th>
							<th>角色</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allAdmin}" var="a">
							<tr>
								<td>${a.admin_id}</td>
								<td>${a.admin_name }</td>
								
								<td>${a.name }</td>
								<td>
									<a href="/be/product/edit?pid=${p.pro_id }" class="btn btn-info">编辑</a>
									<a href="/be/product/delete?pid=${p.pro_id }" class="btn btn-danger" onclick="return confirm('确定要删除吗？')">删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
		</section>
		
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">权限分配</h4>
		            </div>
		            <div class="modal-body">
		            <form role="form">
						  <div class="form-group">
						    <label for="userName">名称</label>
						    <input type="text" class="form-control" id="userName" placeholder="请输入名称">
						  </div> 
						  <div class="form-group">
						    <label for="password">密码</label>
						    <input type="text" class="form-control" id="password" placeholder="请输入密码">
						  </div>

<%--						<div class="form-group">--%>
<%--							<label for="pname" class="col-sm-6 control-label">姓名：</label>--%>
<%--							<div class="col-md-pull-5 col-sm-6">--%>
<%--								<input type="text" placeholder="请输入员工姓名" class="form-control" id="pname" name="pname"/>--%>
<%--							</div>--%>
<%--						</div>--%>
<%--						<div class="form-group">--%>
<%--							<label for="pwd" class="col-sm-6 control-label">密码：</label>--%>
<%--							<div class="col-md-pull-5 col-sm-6">--%>
<%--								<input type="text" placeholder="请输入登入密码" class="form-control" id="pwd" name="pwd"/>--%>
<%--							</div>--%>
<%--						</div>--%>

<%--						<div class="form-group">--%>
<%--							<label for="pcode" class="col-sm-6 control-label">身份证号码</label>--%>
<%--							<div class="col-md-pull-5 col-sm-6">--%>
<%--								<input type="text" placeholder="请输入员工身份证件号"  multiple="multiple" name="pcode" id="pcode" class="form-control"/>--%>
<%--							</div>--%>
<%--						</div>--%>
<%--						<div class="form-group">--%>
<%--							<label for="parea" class="col-sm-6 control-label">住址</label>--%>
<%--							<div class="col-md-pull-5 col-sm-6">--%>
<%--								<input type="text" placeholder="请输入员工的详细住址" multiple="multiple" name="parea" id="parea" class="form-control"/>--%>
<%--							</div>--%>
<%--						</div>--%>
<%--						<div class="form-group">--%>
<%--							<label for="phone" class="col-sm-6 control-label">联系电话</label>--%>
<%--							<div class="col-md-pull-5 col-sm-6">--%>
<%--								<input type="text" placeholder="请输入员工的联系方式" multiple="multiple" name="phone" id="phone" class="form-control"/>--%>
<%--							</div>--%>
<%--						</div>--%>
<%--						&lt;%&ndash;				<div class="form-group">&ndash;%&gt;--%>
<%--						&lt;%&ndash;					<label for="pdesc" class="col-sm-6 control-label">员工工资</label>&ndash;%&gt;--%>
<%--						&lt;%&ndash;					<div class="col-md-pull-5 col-sm-6">&ndash;%&gt;--%>
<%--						&lt;%&ndash;						<input type="text"  multiple="multiple" name="pdesc" id="pdesc" class="form-control"/>&ndash;%&gt;--%>
<%--						&lt;%&ndash;					</div>&ndash;%&gt;--%>
<%--						&lt;%&ndash;				</div>&ndash;%&gt;--%>
<%--						<div class="form-group">--%>
<%--							<label class="col-sm-6 control-label">性别：</label>--%>
<%--							<div class="col-md-pull-5 col-sm-1">--%>
<%--								<input type="radio" class="form-control" class="psex" name="psex" value="男"/>男--%>
<%--							</div>--%>
<%--							<div class="col-md-pull-5 col-sm-1">--%>
<%--								<input type="radio" class="form-control" class="psex" name="psex" value="男"/>女--%>
<%--							</div>--%>
<%--						</div>--%>
<%--						<div class="form-group">--%>
<%--							<div class="col-sm-offset-1 col-sm-6">--%>
<%--								<button type="button" id="btnInsert" class="btn btn-default">保存</button>--%>
<%--								<button type="button" id="btnEsc" class="btn btn-default">取消</button>--%>
<%--							</div>--%>
<%--						</div>--%>
						  
						  
						  <div class="form-group">
						    <label for="password">角色</label>
						     <select name="role" id="role">
						      <c:forEach items="${roles}" var="r">
									<option value="${r.id }" class="role" >${r.name }</option>
							  </c:forEach>
							  </select>
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


		<input type="hidden" id="userId" value="${admin.admin_id}">
		<script src="/static/js/bootstrap.min.js"></script>
		<script src="/static/js/common-scripts.js"></script>
		<script type="text/javascript" src="/static/js/menu.js"></script>
		<script type="text/javascript">
			$("#submit").click(function(){

				$.post("/admin/user/insert",{"userName":$("#userName").val(),"password":$("#password").val(),"roleId":$("#role").find("option:selected").val()},function(result){

        			window.location.reload();
        			
        		})
			})
		</script>
	</body>
</html>
