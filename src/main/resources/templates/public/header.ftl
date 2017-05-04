<div class="container header">
    <div class="span5">
        <div class="logo">
            <a href="#">
                <img src="${request.contextPath}/templates/image/r___________renleipic_01/logo.gif" alt="传智播客"/>
            </a>
        </div>
    </div>
    <div class="span9">
        <div class="headerAd">
            <img src="${request.contextPath}/templates/image/header.jpg" width="320" height="50" alt="正品保障"
                 title="正品保障"/>
        </div>
    </div>
    <div class="span10 last">
        <div class="topNav clearfix">
            <ul>
            <#if Session.user?exists>
                <li id="headerUsername">
                    欢迎，尊敬的会员 ${Session.user.name}
                </li>
                <li id="headerLogout">
                    <a href="${request.contextPath}/user/loginOut.action?id=${Session.user.id}">[退出]</a>|
                </li>
            <#else>
                <li id="headerLogin" class="headerLogin" style="display: list-item;">
                    <a href="${request.contextPath}/user/loginUI.action">登录</a>|
                </li>
                <li id="headerRegister" class="headerRegister" style="display: list-item;">
                    <a href="${request.contextPath}/user/registerUI.action">注册</a>|
                </li>
            </#if>
                <li>
                    <a>会员中心</a>
                    |
                </li>
                <li>
                    <a>购物指南</a>
                    |
                </li>
                <li>
                    <a>关于我们</a>

                </li>
            </ul>
        </div>
        <div class="cart">
            <a href="shoppingCart.ftl">购物车</a>
        </div>
        <div class="phone">
            客服热线:
            <strong>96008/53277764</strong>
        </div>
    </div>
    <div class="span24">
        <ul class="mainNav">
            <li>
                <a href="index.ftl">首页</a>
                |
            </li>
            <li>
                <a href="vegetableClass.ftl">定制套餐</a>
                |
            </li>
            <li>
                <a>安全频道</a>
                |
            </li>
            <li>
                <a>商城卡</a>
                |
            </li>
            <li>
                <a>蔬菜基地</a>
                |
            </li>
            <li>
                <a>节气养生</a>
                |
            </li>
            <li>
                <a>便民服务</a>
                |
            </li>

        </ul>
    </div>


</div>