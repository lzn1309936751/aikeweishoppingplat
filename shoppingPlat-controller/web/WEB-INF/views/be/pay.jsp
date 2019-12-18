<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0 ,
        minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>结算页面</title>

    <link href="static/css/amazeui.css" rel="stylesheet" type="text/css" />

    <link href="static/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="static/css/cartstyle.css" rel="stylesheet" type="text/css" />

    <link href="static/css/jsstyle.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="static/js/address.js"></script>

    <style>
        img{
            width: 80px;
            height: 80px;
        }
    </style>
</head>

<body>

<!--顶部导航条 -->
<div class="am-container header">
    <ul class="message-l">
        <div class="topMessage">
            <div class="menu-hd">
                <a href="/login" target="_top" class="h">亲，请登录</a>&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/register" target="_top">免费注册</a>
            </div>
        </div>
    </ul>
    <ul class="message-r">
        <div class="topMessage home">
            <div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div>
        </div>
        <div class="topMessage my-shangcheng">
            <div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
        </div>
        <div class="topMessage mini-cart">
            <div class="menu-hd"><a id="mc-menu-hd" href="/showMyCart" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
        </div>
        <div class="topMessage favorite">
            <div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
    </ul>
</div>

<!--悬浮搜索框-->

<div class="nav white">
    <div class="logo"><img src="static/images/logo.png" /></div>
    <div class="logoBig">
        <li><img src="static/images/logobig.png" /></li>
    </div>

    <div class="search-bar pr">
        <a name="index_none_header_sysc" href="#"></a>
        <form>
            <input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
            <input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
        </form>
    </div>
</div>

<div class="clear"></div>
<div class="concent">
    <!--地址 -->
    <div class="paycont">
        <div class="address">
            <h3>确认收货地址 </h3>
            <div class="control">
                <div class="tc-btn createAddr theme-login am-btn am-btn-danger">使用新地址</div>
            </div>
            <div class="clear"></div>
            <ul>
                <c:forEach items="${receiptAll}" var="re">
                    <div class="per-border"></div>
                    <li class="user-addresslist defaultAddr getSelectId">
                        <div class="address-left">
                            <input class="getById" hidden="hidden" value="${re.receipt_id}"/>
                            <div class="user DefaultAddr">
										<span class="buy-address-detail">
                                        <span class="buy-user">${re.receipt_name}</span>
										<span class="buy-phone">${re.receipt_phone}</span>
										</span>
                            </div>
                            <div class="default-address DefaultAddr">
                                <span class="buy-line-title buy-line-title-type">收货地址：</span>
                                <span class="buy--address-detail">
                                    <span class="province">${re.province_id}</span>
                                    <span class="city">${re.city_id}</span>
                                    <span class="dist">${re.county_id}</span>
                                    <span class="street">${re.receipt_detail}</span>
                                </span>
                            </div>
                            <ins class="deftip">默认地址</ins>
                        </div>
                        <div class="address-right">
                            <a href="static/person/address.html">
                                <span class="am-icon-angle-right am-icon-lg"></span>
                            </a>
                        </div>
                        <div class="clear"></div>

                        <div class="new-addr-btn">
                            <a href="#" class="hidden">设为默认</a>
                            <span class="new-addr-bar hidden">|</span>
                            <a href="#">编辑</a>
                            <span class="new-addr-bar">|</span>
                            <a href="javascript:void(0);" onclick="delClick(this);">删除</a>
                        </div>

                    </li>
                </c:forEach>
            </ul>
            <div class="clear"></div>
        </div>
        
        <script>
            $(function () {
                $(".getSelectId").click(function () {
                    alert(0)
                    var id=$(".getById").val();
                    alert(id)
                    $.ajax({
                        url:"/getReceiptUser",
                        method:"post",
                        data:{id:id},
                        dataType:"json",
                        success:function(data){
                            var html="";
                            html+="<span class='province'>"+data.data.province_id+"</span>";
                            html+="<span class='city'>"+data.data.city_id+"</span>";
                            html+="<span class='dist'>"+data.data.county_id+"</span>";
                            html+="<span class='street'>"+data.data.receipt_detail+"</span>";
                            var html2="";
                            html2+="<span class='buy-user'>"+data.data.receipt_name+"</span>";
                            html2+="<span class='buy-phone'>"+data.data.receipt_phone+"</span>";
                            $("#deliveryTo").append(html);
                            $("#deliverUser").append(html2);
                        }
                    })
                })
            })
        </script>
        
        <!--物流 -->
        <div class="logistics">
            <h3>选择物流方式</h3>
            <ul class="op_express_delivery_hot">
                <li data-value="yuantong" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -468px"></i>圆通<span></span></li>
                <li data-value="shentong" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -1008px"></i>申通<span></span></li>
                <li data-value="yunda" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -576px"></i>韵达<span></span></li>
                <li data-value="zhongtong" class="OP_LOG_BTN op_express_delivery_hot_last "><i class="c-gap-right" style="background-position:0px -324px"></i>中通<span></span></li>
                <li data-value="shunfeng" class="OP_LOG_BTN  op_express_delivery_hot_bottom"><i class="c-gap-right" style="background-position:0px -180px"></i>顺丰<span></span></li>
            </ul>
        </div>
        <div class="clear"></div>

        <!--支付方式-->
        <div class="logistics">
            <h3>选择支付方式</h3>
            <ul class="pay-list">
                <li class="pay card"><img src="static/images/wangyin.jpg" />银联<span></span></li>
                <li class="pay qq"><img src="static/images/weizhifu.jpg" />微信<span></span></li>
                <li class="pay taobao"><img src="static/images/zhifubao.jpg" />支付宝<span></span></li>
            </ul>
        </div>
        <div class="clear"></div>

        <!--订单 -->
        <div class="concent">
            <div id="payTable">
                <h3>确认订单信息</h3>
                <div class="cart-table-th">
                    <div class="wp">

                        <div class="th th-item">
                            <div class="td-inner">商品信息</div>
                        </div>
                        <div class="th th-price">
                            <div class="td-inner">单价</div>
                        </div>
                        <div class="th th-amount">
                            <div class="td-inner">数量</div>
                        </div>
                        <div class="th th-sum">
                            <div class="td-inner">金额</div>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>

                <tr class="item-list">
                    <div class="bundle  bundle-last">

                        <div class="bundle-main">
                                <ul class="item-content clearfix">
                                        <div class="pay-phone">
                                            <li class="td td-item">
                                                <div class="item-pic">
                                                    <a href="#" class="J_MakePoint">
                                                        <img src="${photo.get(0).img_path}" class="itempic J_ItemImg"></a>
                                                </div>
                                                <div class="item-info">
                                                    <div class="item-basic-info">
                                                        <a href="#" class="item-title J_MakePoint" data-point="tbcart.8.11">${proInfos.pro_name}</a>
                                                    </div>
                                                </div>
                                            </li>
                                            <li class="td td-info">
                                                <div class="item-props">
                                                    <span class="sku-line"></span>
                                                    <span class="sku-line"></span>
                                                </div>
                                            </li>
                                            <li class="td td-price">
                                                <div class="item-price price-promo-promo">
                                                    <div class="price-content">
                                                        <em class="J_Price price-now">${proInfos.compute}</em>
                                                    </div>
                                                </div>
                                            </li>
                                        </div>
                                        <li class="td td-amount">
                                            <div class="amount-wrapper ">
                                                <div class="item-amount ">
                                                    <span class="phone-title">购买数量</span>
                                                    <div class="sl">
                                                    <input class="min am-btn" name="" type="button" value="-" />
                                                    <input class="text_box" name="" type="text" value="${num}" style="width:30px;" />
                                                    <input class="add am-btn" name="" type="button" value="+" />
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="td td-sum">
                                        <div class="td-inner">
                                            <em tabindex="0" class="J_ItemSum number">${total}</em>
                                        </div>
                                    </li>
                                </ul>
                                <div class="clear"></div>
                        </div>
                    </div>
                </tr>
                <div class="clear"></div>
                <div class="pay-total">
                    <!--留言-->
                    <div class="order-extra">
                        <div class="order-user-info">
                            <div id="holyshit257" class="memo">
                                <label>买家留言：</label>
                                <input type="text" title="选填,对本次交易的说明（建议填写已经和卖家达成一致的说明）" placeholder="选填,建议填写和卖家达成一致的说明" class="memo-input J_MakePoint c2c-text-default memo-close">
                                <div class="msg hidden J-msg">
                                    <p class="error">最多输入500个字符</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--优惠券 -->
                    <div class="buy-agio">
                        <li class="td td-bonus">
                            <span class="bonus-title">红包</span>
                            <select data-am-selected>
                                <option value="a">
                                    <div class="item-info">
                                        ￥${couponEntity.coupon_name}<span>元</span>
                                    </div>
                                </option>
                            </select>
                        </li>
                    </div>
                    <div class="clear"></div>
                </div>
                <!--含运费小计 -->
                <div class="buy-point-discharge ">
                    <p class="price g_price ">
                        合计（含运费） <span>¥</span><em class="pay-sum">${result}</em>
                    </p>
                </div>

                <!--信息 -->
                <div class="order-go clearfix">
                    <div class="pay-confirm clearfix">
                        <div class="box">
                            <div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
                                <span class="price g_price ">
                                    <span>¥</span> <em class="style-large-bold-red " id="J_ActualFee">${result}</em>
                                </span>
                            </div>

                            <div id="holyshit268" class="pay-address">

                                <p class="buy-footer-address">
                                    <span class="buy-line-title buy-line-title-type">寄送至：</span>
                                        <span class="buy--address-detail" id="deliveryTo">


                                        </span>
                                    </span>
                                </p>
                                <p class="buy-footer-address">
                                    <span class="buy-line-title">收货人：</span>
                                    <span class="buy-address-detail" id="deliverUser">


                                    </span>
                                </p>
                            </div>
                        </div>

                        <div id="holyshit269" class="submitOrder">
                            <div class="go-btn-wrap">
                                <a id="J_Go" href="success.html" class="btn-go" tabindex="0" title="点击此按钮，提交订单">提交订单</a>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>

            <div class="clear"></div>
        </div>
    </div>
    <div class="footer">
        <div class="footer-hd">
            <p>
                <a href="#">爱克威购物分享平台</a>
                <b>|</b>
                <a href="#">商城首页</a>
                <b>|</b>
                <a href="#">支付宝</a>
                <b>|</b>
                <a href="#">物流</a>
            </p>
        </div>
        <div class="footer-bd">
            <p>
                <a href="#">关于爱克威购物分享平台</a>
                <a href="#">合作伙伴</a>
                <a href="#">联系我们</a>
                <a href="#">网站地图</a>
            </p>
        </div>
    </div>
</div>
<div class="theme-popover-mask"></div>
<div class="theme-popover">

    <!--标题 -->
    <div class="am-cf am-padding">
        <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add address</small></div>
    </div>
    <hr/>

    <div class="am-u-md-12">
        <form class="am-form am-form-horizontal">

            <div class="am-form-group">
                <label for="user-name" class="am-form-label">收货人</label>
                <div class="am-form-content">
                    <input type="text" id="user-name" placeholder="收货人">
                </div>
            </div>

            <div class="am-form-group">
                <label for="user-phone" class="am-form-label">手机号码</label>
                <div class="am-form-content">
                    <input id="user-phone" placeholder="手机号必填" type="email">
                </div>
            </div>

            <div class="am-form-group">
                <label for="user-phone" class="am-form-label">所在地</label>
                <div class="am-form-content address">
                    <select data-am-selected>
                        <option value="a">浙江省</option>
                        <option value="b">湖北省</option>
                    </select>
                    <select data-am-selected>
                        <option value="a">温州市</option>
                        <option value="b">武汉市</option>
                    </select>
                    <select data-am-selected>
                        <option value="a">瑞安区</option>
                        <option value="b">洪山区</option>
                    </select>
                </div>
            </div>

            <div class="am-form-group">
                <label for="user-intro" class="am-form-label">详细地址</label>
                <div class="am-form-content">
                    <textarea class="" rows="3" id="user-intro" placeholder="输入详细地址"></textarea>
                    <small>100字以内写出你的详细地址...</small>
                </div>
            </div>

            <div class="am-form-group">
                <label for="user-intro" class="am-form-label">是否设为默认地址：</label>
                <div class="am-form-content">
                    <input type="radio" class="yes-default" value="是"/>是
                    <input type="radio" class="no-default" value="否"/>否
                </div>
            </div>

            <div class="am-form-group theme-poptit">
                <div class="am-u-sm-9 am-u-sm-push-3">
                    <div class="am-btn am-btn-danger">保存</div>
                    <div class="am-btn am-btn-danger close">取消</div>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="clear"></div>
</body>

</html>