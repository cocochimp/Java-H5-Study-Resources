# 一、HTML5

## 1、什么是HTML

>  基本概念

~~~HTML
1、什么是HTML？
Hyper Text MarkUp Language(超文本标记语言)

2、W3C标准
World Wide Web Consortium(万维网联盟)
结构化标准语言(HTML、XML)
表现标准语言(CSS)
行为标准(DOM、ECMAScript)
~~~



>  开发第一个网页

~~~html
<!--DOCTYPE:告诉浏览器，我们要使用的规范-->
<!DOCTYPE html>

<html lang="en">
<!--head标签代表网页头部-->
<head>
    <!--meta描述性标签，用来描述网站的一些信息-->
    <meta charset="UTF-8">
    <!--title网页标题-->
    <title>我的第一个网页</title>
</head>

<!--body标签代表网页主题-->
<body>
Hello,world
</body>
</html>
~~~



## 2、网页的基本标签

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>基本标签</title>
</head>

<body>

<!--1、标题标签-->
<h1>一级标签</h1>
<h2>二级标签</h2>
<h3>三级标签</h3>
<h4>四级标签</h4>
<h5>五级标签</h5>
<h6>六级标签</h6>

<!--2、段落标签-->
<p>你好</p>
<p>hello</p>
<p>world</p>

<!--3、水平线标签-->
<hr/>

<!--4、换行标签-->
你好<br/>
hello <br/>
world <br/>

<!--5、粗体，斜体-->
粗体： <strong>helloworld</strong>
斜体： <em>helloworld</em>

<!--6、特殊符号-->
空格： 你&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好
大于号： &gt;
小于号： &lt;
版权符号: &copy;

</body>
</html>
~~~

![image-20211114113440853](https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114113440853.png)



## 3、图像标签

【文件样式】

![image-20211111214202850](https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211111214202850.png)

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图像标签学习</title>
</head>


<body>
<!--img学习-->
<!--../上级目录-->
<img src="../resources/image/小樱.jpg" alt="小樱图片" title="悬停文字" width=""300 height="300">

</body>

</html>
~~~

<img src="https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114113544821.png" alt="image-20211114113544821" style="zoom: 67%;" />



## 4、超链接(*)

### 4-1、页面间链接

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>链接标签</title>
</head>

<body>

<!--a标签
href:表示要跳转到的页面
target:表示窗口要在哪里打开
    _blank:在新标签中打开
    _self:在自己的网页中打开
-->

<a href="T.我的第一个网页.html" target="_blank">点击我跳转到页面一</a>
<a href="http://www.baidu.com" target="_self">点击我跳转到百度</a>

<a href="T.我的第一个网页.html">
    <img src="../resources/image/小樱.jpg" alt="小樱图片" title="悬停文字" width=""300 height="300">
</a>

</body>

</html>
~~~



### 4-2、锚链接

~~~html
//1、页面内跳转
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>链接标签</title>
</head>

<body>

<!--第一步-->
<a name="top">顶部</a>
    
<!--第二步-->
<a href="#top">回到顶部</a>
    
</body>

</html>   

//2、页面间跳转
页面一：
<a href="4、链接标签.html#down">跳转</a>

页面二：
<a name="down">down</a>
~~~



### 4-3、功能性链接

~~~html
//可使用到邮箱、QQ等....
<!--功能性链接-->
<a href="mailto:2427886409@qq.com">点击联系我</a>
~~~



## 5、行内元素和块元素

~~~html
1、块元素：
	无论内容多少，该元素独占一行
	(p、h1-h6....)

2、行内元素
	内容撑开宽度，左右都是行内元素的可以排在一行
	(a、strong、em....)
~~~



## 6、列表

~~~html
<!--1、有序列表-->
<ol>
    <li>Java</li>
    <li>C++</li>
    <li>Python</li>
    <li>MySQL</li>
</ol>

<!--2、无序列表-->
<ul>
    <li>Java</li>
    <li>C++</li>
    <li>Python</li>
    <li>MySQL</li>
</ul>

<!--3、自定义列表
dl:标签
dt:列表名称
dd:列表内容
-->
<dl>
    <dt>学科</dt>

    <dd>Java</dd>
    <dd>Python</dd>
    <dd>Linux</dd>
    <dd>C++</dd>

</dl>
~~~

![image-20211114085626920](https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114085626920.png)





## 7、表格

~~~html
<body>
<!--表格table
行  tr  rows
列  td
-->

<table border="1px">
    <tr>
        <!--colspan 跨列-->
        <td colspan="4" align="center">1-1</td>
    </tr>
    <tr>
        <!--rowspan 跨行-->
        <td rowspan="2">2-1</td>
        <td>2-2</td>
        <td>2-3</td>
        <td>2-4</td>
    </tr>
    <tr>
        <td>3-2</td>
        <td>3-3</td>
        <td>3-4</td>
    </tr>
</table>


</body>
~~~

![image-20211114090757715](https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114090757715.png)





## 8、媒体元素

~~~html
<body>

<!--音频和视频
src:资源路径
controls:控制条
autoplay:自动播放

-->

<video src="../resources/video/电影片尾.mp4" controls autoplay></video>

<!--没有MP3格式的音乐，不做展示！-->
<audio src="../resources/video/音乐.mp3"> controls autoplay</audio>
    
</body>
~~~

<img src="https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114092139832.png" alt="image-20211114092139832" style="zoom:50%;"/>







## 9、页面结构分析

~~~html
<header>
    <h2>网页头部</h2>
</header>

<section>
    <h2>网页主题</h2>
</section>

<footer>
    <h2>网页脚部</h2>
</footer>
~~~

![image-20211114092910524](https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114092910524.png)





## 10、内联框架

~~~html
<body>

<!--iframe内联框架
scr:地址
-->

<iframe src="" name="hello" frameborder="0" width="1000px" height="800px"></iframe>

<a href="https://bilibili.com" target="hello">点击进入bilibili</a>

</body>
~~~

![image-20211114093923089](https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114093923089.png)



## 11、表单(*)

### 1、表单基本框架

~~~html
<!--表单基本框架-->

<h1>注册</h1>

<!--表单form
action:表单提交的位置，可以是网站，也可以是一个请求处理地址
method：post，get 提交方式
    get：不安全，但高效
    post：比较安全，传输大文件
-->

<form action="3、图像标签.html" method="post">
	......    
 	......   
</form>
~~~



### 2、文本输入框和密码框

~~~html
 <!--文本输入框：input type:"text"
    value="你好"： 默认初始值
    maxlength="8": 最长能写的字符数
    size="30": 文本框的长度
    -->
    <p>姓名： <input type="text" name="username" value="你好" maxlength="8" size="30"></p>

    <!--密码框：input type:"password"-->
    <p>密码：<input type="password" name="pwd"></p>
~~~

![image-20211114114103111](https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114114103111.png)



### 3、单选/多选框标签

~~~html
<!--默认值
checked：设置默认值
-->

<!--单选框标签-->
    <p>性别：
        <input type="radio" value="boy" name="sex" checked/>男
        <input type="radio" value="girl" name="sex"/>女
    </p>


<!--多选框标签-->
    <p>
        <input type="checkbox" value="sleep" name="hobby">睡觉
        <input type="checkbox" value="code" name="hobby" checked>敲代码
        <input type="checkbox" value="chat" name="hobby">聊天
        <input type="checkbox" value="game" name="hobby">游戏
    </p>
~~~

![image-20211114114136860](https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114114136860.png)



### 4、按钮选项

~~~html
<!--按钮
    input type="button":普通按钮
    input type="image":图像按钮
    input type="submit"：提交按钮
    input type="reset"：重置按钮
-->
    <p>
        <input type="button" name="btn1" value="点击变长">
        <input type="image" src="../resources/image/小樱.jpg" width="100px" height="100px">
    </p>

	<p>
        <input type="submit">
        <input type="reset" value="清空">
    </p>
~~~

![image-20211114114404051](https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114114404051.png)



### 5、下拉框

~~~html
<!--selected
默认为某个选项
-->

<!--下拉框-->
    <p>国家：
        <select name="列表名称">
            <option value="China">中国</option>
            <option value="American">美国</option>
            <option value="Swiss" selected>瑞士</option>
            <option value="India">印度</option>
        </select>
    </p>
~~~

![image-20211114114504252](https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114114504252.png)



### 6、文本域/文件域

~~~html
	<!--文本域-->
    <p>反馈：
        <textarea name="textarea" cols="10" rows="10">文本内容</textarea>
    </p>

    <!--文件域-->
    <p>
        <input type="file" name="files">
        <input type="button" value="上传" name="upload">
    </p>
~~~

![image-20211114114716883](https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114114716883.png)



### 7、待验证数据

~~~html
 <!--待验证数据-->
    <p>邮箱：
        <input type="email" name="email">
    </p>
<!--还未对邮箱格式进行判断-->

 <!--输入网络地址-->
    <p>URL:
        <input type="url" name="url">
    </p>
~~~

![image-20211114114848847](https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114114848847.png)



### 8、滑块/搜索框

~~~html
<!--滑块-->
    <p>音量：
        <input type="range" name="volumn" min="0" max="100" step="2">
    </p>

<!--搜索框-->
    <p>搜索：
        <input type="search" name="search">
    </p>
<!--比文本输入框多一个x-->
~~~

![image-20211114114951769](https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114114951769.png)



### 9、表单的应用

~~~html
 <!--表单的应用
    隐藏域：hidden
    只读：readonly
    禁用：disabled
-->

    <p>密码：<input type="password" name="pwd" hidden value="123456"></p>
    <p>密码：<input type="password" name="pwd" readonly value="123456"></p>
    <p>密码：<input type="password" name="pwd" disabled value="123456"></p>
~~~

![image-20211114112202307](https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114112202307.png)



### 10、表单的初级验证

~~~html
<!--表单初级验证
    placeholder:提示信息
    required：非空判断
    pattern：正则表达式
-->

    <p>姓名： <input type="text" name="username" placeholder="请输入用户名" required></p>
    <p>自定义邮箱：
    <!--正则表达式可以自己去查！-->
        <input type="text" name="diymail" pattern="\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*">
    </p>
~~~

![image-20211114112022132](https://gitee.com/cocochimp/markdown_img/raw/master/01_HTML5/image-20211114112022132.png)

