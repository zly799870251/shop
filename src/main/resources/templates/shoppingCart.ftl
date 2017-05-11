<html>
<head>
    <title>购物车</title>
<#include "public/classform.ftl">
    <link href="${request.contextPath}/templates/css/cart.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<#include "public/header.ftl">

<div class="container cart">
    <div class="span24">
        <div class="step step1">

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
        <#--<em>-->
        <#--登录后确认是否享有优惠-->
        <#--</em>-->
            赠送积分: <em id="effectivePoint">${Request.order.price}</em>
            商品金额: <strong id="effectivePrice">￥${Request.order.price}元</strong>
        </div>
        <div class="bottom">
            <a href="${request.contextPath}/shoppingCart/clearShoppingCart.action?orderId=${Request.order.id}"
               id="clear" class="clear">清空购物车</a>
            <a href="userLogin.ftl" id="submit" class="submit">提交订单</a>
        </div>
    </div>
</div>

<#include "public/footer.ftl">
</body>
</html>