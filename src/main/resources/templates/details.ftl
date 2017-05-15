<html>
<head>
    <title>网上商城</title>
<#include "public/classform.ftl">
    <link href="${request.contextPath}/templates/css/product.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<#include "public/header.ftl">

<div class="container productContent">

<#include "public/leftmenu.ftl">

    <div class="span18 last" style="padding-top: 20px;">

        <div class="productImage">
            <div class="zoomPad">
                <div>
                    <#list Request.commodity.images as images>
                        <#if images_index == 0>
                            <img style="opacity: ${images.id};" title="" class="medium" src="${request.contextPath}/templates/image/${images.path}">
                        </#if>
                    </#list>
                </div>
            </div>
        </div>
        <div class="name">${Request.commodity.name}</div>
        <div class="sn">
            <div>编号：${Request.commodity.id}</div>
        </div>
        <div class="info">
            <dl>
                <dt>惊爆价:</dt>
                <dd>
                    <strong>￥：${Request.commodity.mallPrice}元/份</strong>
                    参 考 价：
                    <span class="markprice">￥${Request.commodity.markPrice}元/份</span>
                </dd>
            </dl>
        <#if Request.commodity.commtags??>
            <dl>
                <dt>促销:</dt>
                <#list Request.commodity.commtags as tag>
                    <dd>
                        <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)">${tag.title}</a>
                    </dd>
                </#list>
            </dl>
        </#if>
        </div>
        <div class="action" ng-app="shoppingform" ng-controller="numberCtrl">
            <form action="${request.contextPath}/shoppingCart/addShoppingCart.action" method="post">
                <input id="commodityId" name="commodityId" ng-model="commodityId" type="hidden" value="${Request.commodity.id}">
                <dl class="quantity">
                    <dt>购买数量:</dt>
                    <dd>
                        <input id="number" name="number" ng-model="number"
                               value="1" maxlength="2" type="number" min="1" max="99">
                        <div>
                            <span id="increase" class="increase" ng-click="increase()">&nbsp;</span>
                            <span id="decrease" class="decrease" ng-click="decrease()">&nbsp;</span>
                        </div>
                    </dd>
                    <dd>
                        件
                    </dd>
                </dl>
                <div class="buy">
                    <span id="addCart" class="addCart" onclick="submitshop()">&nbsp;&nbsp;加入购物车</span>
                </div>
            </form>
        </div>
        <script>
            var app = angular.module('shoppingform', []);
            app.controller('numberCtrl', function($scope) {
                $scope.number = 1,
                $scope.increase = function() {
                    $scope.number = $scope.number + 1;
                };
                $scope.decrease = function() {
                    $scope.number = $scope.number - 1;
                }
            });
            function submitshop() {
                $.post(
                        '${request.contextPath}/shoppingCart/addShoppingCart.action',
                        {commodityId:$("#commodityId").val(),number:$("#number").val()},
                        function (data) {
                            if (data.eq("error")){
                                alert("尚未登录，请登陆后重试！");
                            }else {
                                alert('商品已成功加入购物车!');
                            }
                        }
                );
            }
        </script>
        <div id="bar" class="bar">
            <ul>
                <li id="introductionTab">
                    <a href="#introduction">商品介绍</a>
                </li>
            </ul>
            <ol>
                <li style="width: 100%;">
                    <pre>${Request.commodity.description}</pre>
                </li>
            </ol>
        </div>

        <div id="introduction" name="introduction" class="introduction">
            <div class="title">
                <strong>商品介绍</strong>
            </div>
        <#list Request.commodity.introduces as introduce>
            <div>
                <img src="${request.contextPath}/templates/image/${introduce.path}" width="700px">
            </div>
        </#list>
        </div>


    </div>
</div>

<#include "public/footer.ftl">
</body>
</html>