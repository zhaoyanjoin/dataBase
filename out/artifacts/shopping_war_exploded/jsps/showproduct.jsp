<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 18032808537
  Date: 2020/6/12
  Time: 6:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        a{
            text-decoration:none;
        }

        #img5{
            margin-left:275px;
        }
    </style>

    <script>
        onload=function(){

            //定时操作
            var i = 8;

            setInterval(function(){
                i++;
                document.getElementById('lunbo').src="${pageContext.request.contextPath}/img/img"+i+".jpg";

                if(i==9){
                    i=7;
                }

            },1500);
        }
    </script>
</head>
<body>
<!-- 最外层的table来做整个页面的布局-->
<table width="100%">
    <!-- 第一行  放logo信息      嵌套一个三列的表格-->
    <tr>
        <td>
            <table width="100%">
                <tr>
                    <td>
                        <img src="${pageContext.request.contextPath}/img/logo.jpg"  />
                    </td>
                    <td>
                        <img id="img5" src="${pageContext.request.contextPath}/img/img5.jpg"  />
                        <img src="${pageContext.request.contextPath}/img/img6.jpg"  />
                        <img src="${pageContext.request.contextPath}/img/img7.jpg"  />
                        <img src="${pageContext.request.contextPath}/img/img4.jpg"  />
                    </td>
                    <c:choose>
                        <c:when test="${sessionScope.user!=null}">
                            <td align="center">
                                您好,${sessionScope.user.name} &nbsp;
                                <a href="${pageContext.request.contextPath}/UserServlet?method=exitLogin">退出登录</a>
                                <a href="${pageContext.request.contextPath}/jsps/cart.jsp">购物车</a>
                            </td>

                        </c:when>
                        <c:otherwise>
                            <td>
                                <a href="${pageContext.request.contextPath}/jsps/login.jsp"><font color="#337AB7">登录</font></a>&nbsp;&nbsp;
                                <a href="${pageContext.request.contextPath}/jsps/register.jsp"><font color="#337AB7">注册</font></a>&nbsp;&nbsp;
                                <a href="${pageContext.request.contextPath}/jsps/cart.jsp"><font color="#337AB7">购物车</font></a>&nbsp;&nbsp;
                            </td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </table>
        </td>
    </tr>

    <!--第二行：存放菜单信息  背景黑色 超链接颜色为白色-->
    <tr bgcolor="#808080" height="50px">
        <td>
            <a href=""><font color="white">首页</font></a>&nbsp;&nbsp;&nbsp;
            <a href=""><font color="white">精品手机</font></a>&nbsp;&nbsp;&nbsp;
            <a href=""><font color="white">数码时尚</font></a>&nbsp;&nbsp;&nbsp;
            <a href=""><font color="white">办公设备</font></a>&nbsp;&nbsp;&nbsp;
            <a href=""><font color="white">主板显卡</font></a>&nbsp;&nbsp;&nbsp;
            <a href=""><font color="white">智能设备</font></a>&nbsp;&nbsp;&nbsp;
            <a href=""><font color="white">MacBook</font></a>&nbsp;&nbsp;&nbsp;
        </td>
    </tr>

    <!--第三行    轮播图片 -->
    <tr>
        <td>
            <p>
                <img src="${pageContext.request.contextPath}/img/img8.jpg" width="100%" height="350px" id="lunbo" />
            </p>
        </td>
    </tr>

    <!-- 第四行 存放热门商品信息  包含一个3行5列的表格  这里会用到表格的合并-->
    <tr>
        <td>
            <table width="100%">
                <tr>
                    <td colspan="5">
                        <font size="5">热门商品</font>
                        <img src="${pageContext.request.contextPath}/img/title2.jpg"  />
                    </td>
                </tr>

                <tr align="center">
                    <!-- 热门商品第一行 -->
                    <c:forEach items="${requestScope.reMenProduct}" begin="0" end="4" var="rp">
                        <td>
                            <a href="${pageContext.request.contextPath}/ProductServlet?method=showproductbyid&productid=${rp.pro_id}">
                                <img src="${pageContext.request.contextPath}/${rp.pro_min_img}" width="70%" /><br/>
                                <font color="red">￥：${rp.shop_price}</font><br/>
                                <span>${rp.pro_name}</span>
                            </a>
                        </td>
                    </c:forEach>
                </tr>
                    <!-- 热门商品第2行 -->
                <tr align="center">
                    <c:forEach items="${requestScope.reMenProduct}" begin="5" end="9" var="rp">
                        <td>
                            <a href="${pageContext.request.contextPath}/ProductServlet?method=showproductbyid&productid=${rp.pro_id}">
                                <img src="${pageContext.request.contextPath}/${rp.pro_min_img}" width="70%" /><br/>
                                <font color="red">￥：${rp.shop_price}</font><br/>
                                <span>${rp.pro_name}</span>
                            </a>
                        </td>
                    </c:forEach>
                </tr>
                    <!-- 热门商品第3行 -->
                <tr align="center">
                    <c:forEach items="${requestScope.reMenProduct}" begin="10" end="14" var="rp">
                        <td>
                            <a href="${pageContext.request.contextPath}/ProductServlet?method=showproductbyid&productid=${rp.pro_id}">
                                <img src="${pageContext.request.contextPath}/${rp.pro_min_img}" width="70%" /><br/>
                                <font color="red">￥：${rp.shop_price}</font><br/>
                                <span>${rp.pro_name}</span>
                            </a>
                        </td>
                    </c:forEach>
                </tr>
            </table>
        </td>
    </tr>

    <!-- 第五行   广告图片-->
    <tr >
        <td>
            <img src="${pageContext.request.contextPath}/img/img2.webp"   width="100%"  />
        </td>
    </tr>

    <!-- 第六行  优选商品   嵌套一个3行5列的表格-->
    <tr>
        <td>
            <table width="100%">
                <tr>
                    <td colspan="5">
                        <font size="5">优选商品</font>
                        <img src="${pageContext.request.contextPath}/img/title2.jpg" />
                    </td>
                </tr>
                <!-- 优选商品第一行-->
                <tr align="center">
                    <c:forEach items="${requestScope.youXuanProduct}" var="yp" begin="0" end="4">
                        <td>
                            <a href="${pageContext.request.contextPath}/ProductServlet?method=showproductbyid&productid=${yp.pro_id}">
                                 <img src="${pageContext.request.contextPath}/${yp.pro_min_img}" width="70%"><br/>
                                <font color="red">￥：${yp.shop_price}</font><br/>
                                <span>${yp.pro_name}</span>
                            </a>
                        </td>
                    </c:forEach>
                </tr>
                <!--优选商品第二行-->
                <tr align="center">
                    <c:forEach items="${requestScope.youXuanProduct}" var="yp" begin="5" end="9">
                        <td>
                            <a href="${pageContext.request.contextPath}/ProductServlet?method=showproductbyid&productid=${yp.pro_id}">
                                <img src="${pageContext.request.contextPath}/${yp.pro_min_img}" width="70%"><br/>
                                <font color="red">￥：${yp.shop_price}</font><br/>
                                <span>${yp.pro_name}</span>
                            </a>
                        </td>
                    </c:forEach>
                </tr>
            </table>
        </td>
    </tr>

    <!--第七行  广告图片2-->
    <tr>
        <td>
            <img src="${pageContext.request.contextPath}/img/img1.webp"   width="100%"  />
        </td>
    </tr>

    <!-- 第八行  版权信息 友情链接-->
    <tr>
        <td>
            <p align="center">
                <a href=""><font color="#337AB7">关于我们</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">联系我们</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">联系客服</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">合作招商</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">商家帮助</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">营销中心</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">手机帮助</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">销售联盟</font></a>&nbsp;&nbsp;
            </p>

            <p align="center">
                &copy; 2005-2020 东易买 版权所有，并保留所有权利
            </p>
        </td>
    </tr>
</table>
</body>
</html>

