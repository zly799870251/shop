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

        <#-- 商品信息 -->
        <div id="result" class="result table clearfix">
            <ul>
            <#if Request.pageBean??>
                <#list Request.pageBean.recodeList as commodity>
                    <li>
                        <a href="${request.contextPath}/commodity/details.action?id=${commodity.id}">
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

        <#-- 分页信息 -->
        <div class="pagination">
        <#if Request.pageBean??>
            <span class="firstPage">
                <#if Request.pageBean.pageNum != 1>
                    <a href="${request.contextPath}/classification/commoditylist.action?pageNum=1&classId=${Request.classId}" style="width: 100%;">&nbsp;</a>
                </#if>
                </span>
            <span class="previousPage">
                <#if Request.pageBean.pageNum != 1>
                    <a href="${request.contextPath}/classification/commoditylist.action?pageNum=${Request.pageBean.pageNum-1}&classId=${Request.classId}" style="width: 100%;">&nbsp;</a>
                </#if>
                </span>
            <#list 1..Request.pageBean.pageCount as num>
                <#if num == Request.pageBean.pageNum>
                    <span class="currentPage">${num}</span>
                <#else>
                    <a href="${request.contextPath}/classification/commoditylist.action?pageNum=${num}&classId=${Request.classId}" style="width: 100%;">${num}</a>
                </#if>
            </#list>
            <span class="nextPage">
                <#if Request.pageBean.pageNum != Request.pageBean.pageCount>
                    <a href="${request.contextPath}/classification/commoditylist.action?pageNum=${Request.pageBean.pageNum+1}&classId=${Request.classId}" style="width: 100%;">&nbsp;</a>
                </#if>
                </span>
            <span class="lastPage">
                <#if Request.pageBean.pageNum != Request.pageBean.pageCount>
                    <a href="${request.contextPath}/classification/commoditylist.action?pageNum=${Request.pageBean.pageCount}&classId=${Request.classId}" style="width: 100%;">&nbsp;</a>
                </#if>
                </span>
        </#if>
        </div>

    </div>

</div>

<#include "public/footer.ftl">
</body>
</html>