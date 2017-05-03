<html>
<head>
    <title>会员注册</title>
<#include "public/classform.ftl">
    <link href="${request.contextPath}/templates/css/login.css" rel="stylesheet" type="text/css"/>
    <script>
        function change() {
            var img1 = document.getElementById("checkImage");
            img1.src = "${request.contextPath}/getVerificationCode.action" + new Date().getTime();
        }

        var app = angular.module("loginform", []);

        // 验证码的校验
        app.directive('checkcodeValidate', function($http) {
            return {
                require : 'ngModel',
                link : function($scope, elm, attrs, ctrl) {
                    elm.bind('blur', function() {
                        $http({method: 'GET', url: '${request.contextPath}/user/checkcodeValidate.action?checkcode=' + $scope.datacheckcode}).
                        success(function(data, status, headers, config) {
                            // 当值为空时，通过验证，因为有required
                            if (ctrl.$isEmpty($scope.datacheckcode)) {
                                return true;
                            }
                            if(parseInt(data)==0){
                                ctrl.$setValidity('checkcodeValidate',true);
                            }else{
                                ctrl.$setValidity('checkcodeValidate',false);
                            }
                        });
                    });
                }
            };
        });
    </script>
</head>
<body>
<#include "public/header.ftl">

<div class="container login">
    <div class="span12">
        <div class="ad">
            <img src="${request.contextPath}/templates/image/login.jpg" width="500" height="330" alt="会员登录"
                 title="会员登录">
        </div>
    </div>
    <div class="span12 last">
        <div class="wrap">
            <div class="main">
                <div class="title">
                    <strong>会员登录</strong>USER LOGIN
                </div>
                <form id="loginForm" name="loginform" method="post" novalidate="novalidate"
                      action="${request.contextPath}/user/login.action"
                      ng-app="loginform">
                    <table>
                        <tbody>
                        <tr>
                            <th>
                                用户名/E-mail:
                            </th>
                            <td>
                                <input type="text" id="username" name="username" class="text" maxlength="20">

                            </td>
                        </tr>
                        <tr>
                            <th>
                                密&nbsp;&nbsp;码:
                            </th>
                            <td>
                                <input type="password" id="password" name="password" class="text" maxlength="20"
                                       autocomplete="off">
                            </td>
                        </tr>
                        <tr>
                            <th><span class="requiredField">*</span>验证码:</th>
                            <td>
                                <span class="fieldSet">
                                    <input type="text" id="checkcode" name="checkcode" ng-model="datacheckcode"
                                           class="text captcha" maxlength="4" autocomplete="off" required checkcode-validate>
                                    <img id="checkImage" class="checkImage"
                                         src="${request.contextPath}/getVerificationCode.action" onclick="change()"
                                         title="点击更换验证码">
                                    <span style="color: red;">
                                        <span ng-show="loginform.checkcode.$error.required && loginform.checkcode.$touched">请输入验证码</span>
                                        <span ng-show="loginform.checkcode.$error.checkcodeValidate && loginform.checkcode.$touched">验证码错误</span>
                                    </span>
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <th>&nbsp;

                            </th>
                            <td>
                                <label>
                                    <input type="checkbox" id="isRememberUsername" name="isRememberUsername"
                                           value="true">记住用户名
                                </label>
                                <label>
                                    &nbsp;&nbsp;<a>找回密码</a>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>&nbsp;</th>
                            <td>
                                <input type="submit" class="submit" value="登 录"
                                       ng-disabled="loginform.checkcode.$error.required || loginform.checkcode.$error.checkcodeValidate">
                            </td>
                        </tr>
                        <tr class="register">
                            <th>&nbsp;

                            </th>
                            <td>
                                <dl>
                                    <dt>还没有注册账号？</dt>
                                    <dd>
                                        立即注册即可体验在线购物！
                                        <a href="${request.contextPath}/user/registerUI.action">立即注册</a>
                                    </dd>
                                </dl>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>

<#include "public/footer.ftl">
</body>
</html>