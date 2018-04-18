<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>articleManage</title>
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
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/common.js"></script>
</head>
<body style="margin: 1px;" id="ff">
    <table title="文本信息管理" id="dg" class="easyui-datagrid" pagination="true" rownumbers="true"
        fit="true" data-options="pageSize=10" url="${pageContext.request.contextPath}/article/list.do" toolbar="#tb">
        <thead>
            <tr>
                <th field="cb" checkbox="true" align="center"></th>
                <th field="id" width="10%" align="center" hidden="true">编号</th>
                <th field="articleTitle" width="200" align="center">标题</th>
                <th field="articleCreateDate" width="150" align="center">创建时间</th>
                <th field="addName" width="150" align="center">添加人</th>
                <th field="content" width="70" align="center"
                    formatter="formatHref">操作
                </th>
            </tr>
        </thead>
    </table>

    <div id="tb">
        <div>
            <a href="javascript:openArticleAddDialog()" class="easyui-linkbutton"
            iconCls="icon-add" plain="true">添加</a>
            <a href="javascript:openArticleModifyDialog()"
                    class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a> <a
                href="javascript:deleteArticle()" class="easyui-linkbutton"
                iconCls="icon-remove" plain="true">删除</a>
        </div>
        <div>
            &nbsp;标题：&nbsp;<input type="text" id="articleTitle" size="20"
                                  onkeydown="if(event.keyCode==13) searchArticle()"/>&nbsp; <a
                href="javascript:searchArticle()" class="easyui-linkbutton"
                iconCls="icon-search" plain="true">搜索</a>
        </div>
    </div>

</body>
</html>