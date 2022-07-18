
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    <script>--%>
<%--        // window.onload=function(){--%>
<%--        //     document.getElementById("button").onclick = function () {--%>
<%--        //         let xml = new XMLHttpRequest();--%>
<%--        //         xml.open("post","test.do",true);--%>
<%--        //         //  2.1如果想要发送的是json形式 告知浏览器解析的时候规则--%>
<%--        //         xml.setRequestHeader("Content-type","application/json;charset=UTF-8")--%>
<%--        //         xml.onreadystatechange = function(){--%>
<%--        //             if(xml.readyState==4&&xml.status==200){--%>
<%--        //                 let data = xml.responseText;--%>
<%--        //                 alert(data);--%>
<%--        //             }--%>
<%--        //         }--%>
<%--        //         xml.send('{"name":"zzt","age":18}');--%>
<%--        //--%>
<%--        //     }--%>
<%--        // }--%>

<%--    </script>--%>
</head>
<body>
<h1><a href="testOne.do">测试一</a></h1>
<h1><a href="testTwo.do">测试二</a></h1>
<h1><a href="testThree.do">测试三</a></h1>
<%--<form action="testThree.do" method="post">--%>
<%--&lt;%&ndash;    user :<input name="name" type="text">&ndash;%&gt;--%>
<%--&lt;%&ndash;    age  :<input name="age" type="text">&ndash;%&gt;--%>
<%--&lt;%&ndash;    sex  :<input name="sex" type="text">&ndash;%&gt;--%>
<%--&lt;%&ndash;    size :<input name="computer.size" type="text">&ndash;%&gt;--%>
<%--&lt;%&ndash;    price: <input  type="text" name="computer.price" >&ndash;%&gt;--%>
<%--&lt;%&ndash;    birth: <input name="birth" type="text">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <button>提交</button>&ndash;%&gt;--%>
<%--</form>--%>

<form action="upload.do" method="post" enctype="multipart/form-data">
    输入文件名字<input type="text" name="text">
    输入性别 <input type="text" name="sex">
    <input type="file" name="upload" >
    <button>提交</button>
</form>
<a href="download.do?fileName=springmvc资料(6-12).zip">文件下载测试</a>
<button id="button">按钮</button>
<a href="excetion.do">异常测试</a>
<a href="inter.do">拦截器测试</a>
</body>
</html>
