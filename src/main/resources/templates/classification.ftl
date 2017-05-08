<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>传智网上商城</title>
<#include "public/classform.ftl">
    <link href="${request.contextPath}/templates/css/product.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<#include "public/header.ftl">

<div class="container productList">

    <#include "public/leftmenu.ftl">

    <div class="span18 last">

        <form id="productForm" action="${request.contextPath}/templates/image/蔬菜 - Powered By Mango Team.htm"
              method="get">
            <input type="hidden" id="brandId" name="brandId" value="">
            <input type="hidden" id="promotionId" name="promotionId" value="">
            <input type="hidden" id="orderType" name="orderType" value="">
            <input type="hidden" id="pageNumber" name="pageNumber" value="1">
            <input type="hidden" id="pageSize" name="pageSize" value="20">

            <div id="result" class="result table clearfix">
                <ul>
                <#if Request.commodityList??>
                    <#list Request.commodityList as commodity>
                        <li>
                            <a href="${request.contextPath}/commodity/details.action?${commodity.id}">
                                <#list commodity.images as image>
                                    <#if image_index == 0>
                                        <img src="${request.contextPath}/templates/image/${image.path}" width="170"
                                             height="170" style="display: inline-block;">
                                    </#if>
                                </#list>
                                <span style='color:green'>${commodity.name}</span>
                                <span class="price">商城价： ￥${commodity.mallPrice}/份</span>
                                <span class="markprice">市场价： ￥${commodity.markPrice}/份</span>
                            </a>
                            <br/>
                        </li>
                    </#list>
                </#if>
                </ul>
            </div>
            <div class="pagination">
                <span class="firstPage">&nbsp;</span>
                <span class="previousPage">&nbsp;</span>
                <span class="currentPage">1</span>
                <a href="javascript: $.pageSkip(2);">2</a>
                <a class="nextPage" href="javascript: $.pageSkip(2);">&nbsp;</a>

                <a class="lastPage" href="javascript: $.pageSkip(2);">&nbsp;</a>
            </div>
        </form>
    </div>
</div>

<#include "public/footer.ftl">
</body>
</html>