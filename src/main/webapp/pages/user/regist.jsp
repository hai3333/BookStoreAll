<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%-- 静态标签   base标签 css jquery--%>
   <%@include file="/pages/common/head.jsp"%>
    
    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {
            // 给注册单击事件
            $("#sub_btn").click(function () {
                // 验证用户名 ：必须是字面 下划线 组成 并且长度为5-12
                //1 获取用户输入框里面的内容
                var usernameText = $("#username").val();
                // 创建正则对象
                var usernamePatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4提示用户结果
                    $("span.errorMsg").text("用户名不合法");

                    return false;
                }
                // 验证密码
                //1 获取密码输入框里面的内容
                var passwordText = $("#password").val();
                // 创建正则对象
                var passwordPatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4提示用户结果
                    $("span.errorMsg").text("密码不合法");

                    return false;
                }
                //确认密码和一开始输入的密码相同
                //1 获取前后面比较
                var repwdText = $("#repwd").val();
                //比较
                if (repwdText != passwordText) {
                    //提示用户
                    $("span.errorMsg").text("前后密码不一致");
                    return false;
                }

                //邮箱的验证
                //1 获取邮箱的值
                var emailText = $("#email").val();
                //2 创建正则表达式对象
                var emailPatt =/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                //3 使用test方法验
                if(!emailPatt.test(emailText)){
                    //4 告诉用户出错
                    $("span.errorMsg").text("邮箱格式不合法！");
                    return false;
                }
                //验证码 目前只验证有输入
                var codeText = $("#code").val();
                // 去掉验证码前后空格
                 codeText = $.trim(codeText);
                if(codeText==null || codeText==""){
                    $("span.errorMsg").text("验证码不能为空！");
                    return false;
                }



                    //取消错误的提交信息
                    $("span.errorMsg").text("");
            })
        })

    </script>

    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">
                        <%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>

                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"
                               autocomplete="off" tabindex="1"
                               name="username" id="username"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
                               value="<%=request.getAttribute("email")==null? "":request.getAttribute("email")%>"
                               autocomplete="off" tabindex="1"
                               name="email" id="email"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 150px;"name="code" id="code"/>
                        <img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%--静态包含页脚代码--%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>