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

        //查询用户
        function searchUser() {
            $('#dg').datagrid('load', {"userName": $('#s_userName').val()})
        }

        //编辑用户
        function openUserModifyDialog() {
            var selectedRows = $('#dg').datagrid('getSelections');
            if (selectedRows.length != 1) {
                $.messager.alert("系统提示", "请选择一条要编辑的数据！");
                return;
            }
            var row = selectedRows[0];
            $('#dlg').dialog("open").dialog("setTitle", "编辑用户信息");
            $('#dlg').form('load', row);
            $('#password').val("******");
            url = "${pageContext.request.contextPath}/user/save.do?id=" + row.id;
        }

        //保存用户
        function saveUser() {
            console.log(url);
            $('#fm').form("submit", {
                url: url,
                onSubmit: function () {
                    return $(this).form("validate");
                },
                success: function (result) {
                    console.log(result);
                    $.messager.alert("系统提示", "保存成功");
                    resetValue();
                    $("#dlg").dialog("close");
                    $("#dg").datagrid("reload");
                }
            });
        }

        //重制
        function resetValue() {
            $('#userName').val("");
            $('#password').val("");
        }

        //关闭对话框
        function closeUserDialog() {
            $('#dlg').dialog("close");
            resetValue();
        }

        //删除用户
        function deleteUser() {
            var selectRows = $('#dg').datagrid("getSelections");
            if (selectRows.length != 1) {
                $.messager.alert("系统提示", "请选择要删除的数据!");
            }
            var strIds = [];
            for (var i = 0; i < selectRows.length; i++) {
                strIds.push(selectRows[i].id);
            }
            var ids = strIds.join(",");
            $.messager.confirm("系统提示","您确认要删除这<font color=red>"
                + selectRows.length + "</font>条数据吗？",function (r) {
                if(r){
                    $.post("${pageContext.request.contextPath}/user/delete.do",{
                        ids:ids
                    },function (result) {
                        if(result.success){
                            $.messager.alert("系统提示", "数据已成功删除！");
                            $("#dg").datagrid("reload");
                        }else{
                            $.messager.alert("系统提示", "数据删除失败！");
                        }
                    });
                }
            });


        }
        
        //新增用户
        function openUserAddDialog() {
            $('#dlg').dialog("open").dialog("setTitle","添加用户信息");
            url = "${pageContext.request.contextPath}/user/save.do";
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

<div id="dlg" class="easyui-dialog" closed="true" style="width: 620px;height:250px;padding: 10px 20px"
     buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>用户名：</td>
                <td>
                    <input type="text" id="userName" name="userName" class="easyui-validatebox"
                           required="true">&nbsp;<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <input type="text" id="password" name="password" class="easyui-validatebox"
                           required="true"/>&nbsp;<font
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
