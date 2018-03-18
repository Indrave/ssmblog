<%--
  Created by IntelliJ IDEA.
  User: indrave
  Date: 2018/3/18
  Time: 上午11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ssmblog系统主页</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">

    </script>
    <jsp:include page="login_chk.jsp"></jsp:include>
</head>
<body class="easyui-layout">
    <div region="north" style="height: 78px;background-color: #ffff">
        <table width="100%">
            <tr>
                <td width="50%"></td>
                <td valign="bottom" style="font-size: 20px;color:#8B8B8B;font-family: '楷体';" align="right" width="50%">
                    <font size="3">&nbsp;&nbsp;<strong>当前管理员：</strong>${currentUser.userName}</font>【管理员】
                </td>
            </tr>
        </table>
    </div>
    <div region="center">
        <div class="easyui-tabs" fit="true" border="false" id="tabs">
            <div title="首页" data-options="iconCls:'icon-home'">
                <%--<div align="center" style="padding-top: 20px">--%>
                    <%--<a href="https://git.oschina.net/zhenfeng13/ssm-demo" target="_blank" style="font-size: 20px;">开源中国仓库地址</a>--%>
                <%--</div>--%>
                <%--<div align="center" style="padding-top: 20px;">--%>
                    <%--<a href="https://github.com/ZHENFENG13/ssm-demo" target="_blank" style="font-size: 20px;">Gitub仓库地址</a></div>--%>
                <%--<div align="center" style="padding-top: 50px;">--%>
                    <%--<a href="http://download.csdn.net/detail/zhenfengshisan/9813721" target="_blank" style="font-size: 20px;">项目源码下载(最新代码)</a>--%>
                <%--</div>--%>
                <%--<div align="center" style="padding-top: 20px;">--%>
                    <%--<a href="http://download.csdn.net/detail/zhenfengshisan/9765855" target="_blank" style="font-size: 20px;">项目源码下载(非maven)</a>--%>
                <%--</div>--%>
                <%--<div align="center" style="padding-top: 50px">--%>
                    <%--<font color="grey" size="10">ssm demo</font>--%>
                <%--</div>--%>
                <div align="center" style="padding-top: 50px">
                    <font color="grey" size="10">此项目参考ZHENFENG13开发，十分感谢～</font>
                </div>
            </div>
        </div>
    </div>
    <div region="west" style="width: 200px;height:500px;" title="导航菜单" split="true">

    </div>
</body>
</html>
