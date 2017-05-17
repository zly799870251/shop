<html>
<head>
    <title>订单页面</title>
    <#include "public/classform.ftl">
    <link href="${request.contextPath}/templates/css/cart.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<#include "public/header.ftl">

<div class="container cart">

    <div class="span24">

        <div class="step step1">
            <ul>

                <li class="current"></li>
                <li>生成订单成功</li>
            </ul>
        </div>

        <table>
            <tbody>
            <tr>
                <th>图片</th>
                <th>商品</th>
                <th>价格</th>
                <th>数量</th>
                <th>小计</th>
                <th>操作</th>
            </tr>
            <#if Request.order.orderItem??>
                <#list Request.order.orderItem as oc>
                <tr>
                    <td width="60">
                        <input type="hidden" name="id" value="${oc.id}">
                        <#list oc.commodity.images as image>
                            <#if image_index == 0>
                                <img src="${request.contextPath}/templates/image/${image.path}">
                            </#if>
                        </#list>
                    </td>
                    <td>
                        <a target="_blank">${oc.commodity.name}</a>
                    </td>
                    <td>
                        ￥${oc.commodity.mallPrice}
                    </td>
                    <td class="quantity" width="60">
                    ${oc.number}
                    </td>
                    <td width="140">
                        <span class="subtotal">￥${oc.price}</span>
                    </td>
                    <td>
                        <a href="${request.contextPath}/shoppingCart/deleteShopingCart.action?id=${oc.id}" class="delete">删除</a>
                    </td>
                </tr>
                </#list>
            </#if>
            </tbody>
        </table>

        <dl id="giftItems" class="hidden" style="display: none;">
        </dl>
        <div class="total">
            <em id="promotion"></em>
            商品金额: <strong id="effectivePrice">￥${Request.order.price}元</strong>
        </div>
        <form id="orderForm" action="${request.contextPath}/order/order_payOrder.action" method="post">
            <input type="hidden" name="orderId" value="${Request.order.id}"/>
            <#if Request.processInstanceId??>
                <input type="hidden" name="processInstanceId" value="${Request.processInstanceId}"/>
            </#if>
            <div class="span24">
                <p>
                    收货地址：<input name="address" type="text" value="${Request.order.user.address}" style="width:350px"/>
                    <br/>
                    收货人&nbsp;&nbsp;&nbsp;：<input name="consignee" type="text" value="${Request.order.user.username}" style="width:150px"/>
                    <br/>
                    联系方式：<input name="phoneNumber" type="text" value="${Request.order.user.phoneNumber}" style="width:150px"/>
                </p>
                <hr/>
                <p>
                    选择银行：<br/>
                    <input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>工商银行
                    <img src="${request.contextPath}/templates/bank_img/icbc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行
                    <img src="${request.contextPath}/templates/bank_img/bc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
                    <img src="${request.contextPath}/templates/bank_img/abc.bmp" align="middle"/>
                    <br/>
                    <input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
                    <img src="${request.contextPath}/templates/bank_img/bcc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="PINGANBANK-NET"/>平安银行
                    <img src="${request.contextPath}/templates/bank_img/pingan.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
                    <img src="${request.contextPath}/templates/bank_img/ccb.bmp" align="middle"/>
                    <br/>
                    <input type="radio" name="pd_FrpId" value="CEB-NET-B2C"/>光大银行
                    <img src="${request.contextPath}/templates/bank_img/guangda.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>招商银行
                    <img src="${request.contextPath}/templates/bank_img/cmb.bmp" align="middle"/>
                </p>
                <hr/>
                <p style="text-align:right">
                    <a href="javascript:document.getElementById('orderForm').submit();">
                        <img src="${request.contextPath}/templates/images/finalbutton.gif" width="204" height="51"
                             border="0"/>
                    </a>
                </p>
            </div>
        </form>
    </div>

</div>

<#include "public/footer.ftl">
</body>
</html>