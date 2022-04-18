<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%-- 静态标签   base标签 css jquery--%>
    <%@include file="/pages/common/head.jsp" %>
</head>
<body>


<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@include file="/pages/common/login_success_menu.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deleteItem").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗")
            });
            $("#clear").click(function (){
                return confirm("你确定要清空购物车？")
            });
            //给输入框绑定焦点事件=====onchange事件（内容改变事件）
            $(".updateCount").change(function (){
                var name=$(this).parent().parent().find("td:first").text();
                //数量
                var id=$(this).attr("bookId");
                var count=this.value;
                if(confirm("你确定要将"+name+"商品修改数量为"+count+"吗？")){
                    //发起请求给服务器传值
                    location.href="http://localhost:8080/BookStoreAll/cartServlet?action=updateCount&count="+count+"&id="+id;

                }else {
                    //默认的value值
                    this.value=this.defaultValue;
                }
            });
        });

    </script>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>

        <%--空的话提示用户花钱--%>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">亲 你还什么都没有买！</a></td>

            </tr>

        </c:if>
        <%--		非空遍历输出--%>
        <c:if test="${not empty sessionScope.cart.items}">


            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                    <input class="updateCount" bookId="${entry.value.id}"
                           type="text" style="width: 80px" value="${entry.value.count}">
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="deleteItem" href="cartServlet?action=deleteItems&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>

        </c:if>


    </table>
    <c:if test="${ not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clear" href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="pages/cart/checkout.html">去结账</a></span>
        </div>
    </c:if>

</div>

<%--静态包含页脚代码--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>