<%--
  Created by IntelliJ IDEA.
  User: indrave
  Date: 2018/3/18
  Time: 下午5:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
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
        var url;

        function searchUser() {
            $('#dg').datagrid('load',{"userName":$('#s_userName').val()})
        }






    </script>
</head>
<body style="margin: 1px">
    <table id="dg" title="用户管理" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true"
           url="${pageContext.request.contextPath}/user/list.do" fit="true" toolbar="#tb">
        <thead>
            <tr>
                <th field="cb" checkbox="true" align="center"></th>
                <th field="id" width="50" align="center">编号</th>
                <th field="userName" width="100" align="center">用户名</th>
            </tr>
        </thead>
    </table>
    <div id="tb">
        <div>
            <a class="easyui-linkbutton" iconCls="icon-add" plain="true" href="javascript:openUserAddDialog()">添加</a>
            <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" href="javascript:openUserModifyDialog()">修改</a>
            <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" href="javascript:deleteUser()">删除</a>
        </div>
        <div>
            <label>用户名：</label>
            <input type="text" id="s_userName" size="20" onkeydown="if(event.keyCode==13) searchUser()">
            <a href="javascript:searchUser()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
        </div>
    </div>

    <div id="dlg" class="easyui-dialog" closed="true" style="width: 620px;height:250px;padding: 10px 20px" buttons="#dlg-buttons">
        <form id="fm" method="post">
            <table cellspacing="8px">
                <tr>
                    <td>用户名：</td>
                    <td>
                        <input type="text" id="userName" name="userName" class="easyui-validatebox" required="true">&nbsp;<font color="red">*</font>
                    </td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td>
                        <input type="text" id="password" name="password" class="easyui-validatebox" required="true"/>&nbsp;<font
                            color="red">*</font>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <div id="dlg-buttons">
        <a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveUser()">保存</a>
        <a href="javascript:closeUserDialog()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>

</body>
</html>
