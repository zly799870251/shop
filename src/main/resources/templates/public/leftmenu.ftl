<div class="span6">
    <div class="hotProductCategory">
    <#list Application.topClassificationList as classification>
        <dl>
            <dt>
                <a href="${request.contextPath}/classification/commoditylist.action?classId=${classification.id}">${classification.name}</a>
            </dt>
            <#list classification.children as children>
                <dd>
                    <a href="${request.contextPath}/classification/commoditylist.action?classId=${children.id}">${children.name}</a>
                </dd>
            </#list>
        </dl>
    </#list>
    </div>
</div>