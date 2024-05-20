<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>

    <script>
        $(function () {
            $("#btn").click(function () {
                /*
                    $.post(url,param[可以省略],success)
                 */
                $.post("${pageContext.request.contextPath}/a2",function (data) {
                    console.log(data)
                    let html="";
                    for (let i = 0; i <data.length ; i++) {
                        html+= "<tr>" +
                            "<td>" + data[i].name + "</td>" +
                            "<td>" + data[i].age + "</td>" +
                            "<td>" + data[i].sex + "</td>" +
                            "</tr>"
                    }
                    $("#content").html(html);
                });
            })
        })
    </script>

</head>
<body>

<input type="button" id="btn" value="获取数据"/>
<table width="80%" align="center">
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tbody id="content">
    </tbody>
</table>

</body>
</html>
