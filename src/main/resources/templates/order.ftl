<html>
<head>
    <title>订单页面</title>
    <#include "public/classform.ftl">
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

            <tr>
                <td width="60">
                    <input type="hidden" name="id" value="22"/>
                    <img src=""/>
                </td>
                <td>
                    <a target="_blank">
                        <s:property value="product.pname"/>
                    </a>
                </td>
                <td>
                    100
                </td>
                <td class="quantity" width="60">
                    <input type="text" name="count" value="1" maxlength="4" onpaste="return false;"/>
                    <div>
                        <span class="increase">&nbsp;</span>
                        <span class="decrease">&nbsp;</span>
                    </div>
                </td>
                <td width="140">
                    <span class="subtotal">￥100</span>
                </td>
                <td>
                    <a href="${request.contextPath}/templates/cart_removeCart.action?pid=1" class="delete">删除</a>
                </td>
            </tr>

            </tbody>
        </table>
        <dl id="giftItems" class="hidden" style="display: none;">
        </dl>
        <div class="total">
            <em id="promotion"></em>
            商品金额: <strong id="effectivePrice">￥100元</strong>
        </div>
        <form id="orderForm" action="${request.contextPath}/templates/order_payOrder.action" method="post">
            <input type="hidden" name="order.oid" value=""/>
            <div class="span24">
                <p>
                    收货地址：<input name="order.user.addr" type="text" value="" style="width:350px"/>
                    <br/>
                    收货人&nbsp;&nbsp;&nbsp;：<input name="order.user.username" type="text" value="" style="width:150px"/>
                    <br/>
                    联系方式：<input name="order.user.phone" type="text" value="" style="width:150px"/>

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