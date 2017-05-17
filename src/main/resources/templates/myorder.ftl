<html>
<head>
    <title>我的订单</title>
<#include "public/classform.ftl">
    <link href="${request.contextPath}/templates/css/cart.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<#include "public/header.ftl">

<div class="container cart">

    <div class="span24">

        <if Request.orderList??>
        <#list Request.orderList as order>
            <table>
                <tbody>
                <tr>
                    <th>图片</th>
                    <th>商品</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>小计</th>
                </tr>

                    <#if order.orderItem??>
                        <#list order.orderItem as item>
                        <tr>
                            <td width="60">
                                <input type="hidden" name="id" value="${item.id}"/>
                                <#list item.commodity.images as image>
                                    <#if image_index == 0>
                                        <img src="${request.contextPath}/templates/image/${image.path}">
                                    </#if>
                                </#list>
                            </td>
                            <td>
                                <a target="_blank">${item.commodity.name}</a>
                            </td>
                            <td>
                                ￥${item.commodity.mallPrice}
                            </td>
                            <td class="quantity" width="60">
                            ${item.number}
                            </td>
                            <td>
                                <span class="subtotal">￥${item.price}</span>
                            </td>
                        </tr>
                        </#list>
                    </#if>
                </tbody>
            </table>
            <dl id="giftItems" class="hidden" style="display: none;">
            </dl>
            <div class="total">
                <em id="promotions">
                    <a href="${request.contextPath}/order/deleteOrder.action?orderId=${order.id}">删除订单</a>
                </em>
                <#if order.state == "pending">
                <em id="promotions">
                    待支付
                </em>
                <em id="promotion"><a href="${request.contextPath}/order/doPayUI.action?orderId=${order.id}">去付款</a></em>
                <#elseif order.state == "already">
                    <em id="promotions" style="color: greenyellow;">已支付,请耐心等待发货</em>
                    <em id="promotion">
                        <a href="${request.contextPath}/order/confirmReceipt.action?orderId=${order.id}">确认收货</a>
                    </em>
                <#elseif order.state == "completed">
                    <em id="promotions" style="color: greenyellow;">已完成交易</em>
                </#if>
                商品金额: <strong id="effectivePrice">￥${order.price}元</strong>
            </div>
        </#list>
        </if>
    </div>

</div>

<#include "public/footer.ftl">
</body>
</html>