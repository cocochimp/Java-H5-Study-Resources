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

![image-20211114113440853](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114113440853.png)



## 3、图像标签

【文件样式】

![image-20211111214202850](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211111214202850.png)

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

<img src="https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114113544821.png" alt="image-20211114113544821" style="zoom: 67%;" />



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

![image-20211114085626920](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114085626920.png)





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

![image-20211114090757715](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114090757715.png)





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

<img src="https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114092139832.png" alt="image-20211114092139832" style="zoom:50%;"/>







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

![image-20211114092910524](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114092910524.png)





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

![image-20211114093923089](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114093923089.png)



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

![image-20211114114103111](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114114103111.png)



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

![image-20211114114136860](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114114136860.png)



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

![image-20211114114404051](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114114404051.png)



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

![image-20211114114504252](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114114504252.png)



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

![image-20211114114716883](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114114716883.png)



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

![image-20211114114848847](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114114848847.png)



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

![image-20211114114951769](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114114951769.png)



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

![image-20211114112202307](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114112202307.png)



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

![image-20211114112022132](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114112022132.png)





# 二、CSS3

## 1、什么是CSS

> 基本概念

~~~css
如何学习：
1、CSS是什么
	Cascading Style Sheet(层叠级联样式表)

2、CSS怎么用(快速入门)
	CSS2.1 浮动，定位
	CSS3.0 圆角，阴影，动画.... 	

3、CSS选择器(重点+难点)
4、美化网页(文字，阴影，超链接，列表，渐变....)
5、盒子模型
6、浮动
7、定位
8、网页动画(特效效果)
~~~



> 第一个CSS程序

~~~css
<!--html格式-->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--规范：
    <style>可以编写css的代码，每一个声明最好使用分号给隔开
    语法：
    选择器{
        声明1;
        声明2;
        声明3;
    }
    -->

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<h1>我是标题</h1>

</body>

</html>

<!--css格式-->
h1{
    color:red;
}
~~~

![image-20211114172405730](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211114172405730.png)



> CSS的三种导入方式

~~~css
1、行内样式
2、内部样式
3、外部样式

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--2、内部样式-->
    <style>
        h1{
            color:green;
        }
    </style>

    <!--外部链接-->
    <link rel="stylesheet" href="css/style.css">

</head>

<!--就近原则！-->

<body>

<!--1、行内样式：在标签元素中编写一个style属性，编写样式即可-->
<h1 style="color:red">我是标题</h1>

</body>

</html>


<!--3、外部样式-->
h1{
    color:yellow;
}
~~~





## 2、选择器(*)

### 1、基本选择器(*)

#### 1、标签选择器

~~~css
/*标签选择器，会选择到页面上所有的这个标签的元素*/

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
    /*标签选择器，会选择到页面上所有的这个标签的元素*/
        h1{
            color:#a13d30;
            background:#3cbda6;
            border-radius:24px;
        }

        p{
            font-size:80px;
        }
    </style>
</head>

<body>

<h1>学Java</h1>
<h1>学Java</h1>
<p>听课</p>

</body>
</html>
~~~

![image-20211117213542018](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211117213542018.png)



#### 2、类选择器(*)

~~~css
/*类选择器的格式  .class的名称
  好处：可以多个标签归类，是同一个class，可以复用
*/

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
    /*类选择器的格式  .class的名称
    好处：可以多个标签归类，是同一个class，可以复用
    */
        .hello{
            color:#3748ff;
        }
        .world{
            color:#a24fff;
        }
    </style>

</head>

<body>

<h1 class="hello">标签1</h1>
<h1 class="world">标签2</h1>
<h1 class="hello">标签3</h1>

<p class="hello">p标签</p>

</body>
</html>
~~~

![image-20211117214059051](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211117214059051.png)



#### 3、id选择器

~~~css
/*id选择器：id必须保证全局唯一！
        #id名称{}
        不遵循就近原则，固定的
        id选择器>class选择器>标签选择器
*/

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
    /*id选择器：id必须保证全局唯一！
        #id名称{}
        不遵循就近原则，固定的
        id选择器>class选择器>标签选择器
    */

        #hello{
            color:#ff008a;
        }
        .style1{
            color:#02ff00;
        }
        h1{
            color:#2d1dc1;
        }

    </style>
</head>

<body>
<h1 class="style1" id="hello">标题1</h1>
<h1 class="style1">标题2</h1>
<h1 class="style1">标题3</h1>
<h1>标题4</h1>
<h1>标题5</h1>

</body>
</html>
~~~

![image-20211117214814590](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211117214814590.png)



### 2、层次选择器

#### 1、后代选择器

~~~css
/*后代选择器*/
body p{
        background:red;
    }
~~~

![image-20211117221312288](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211117221312288.png)



#### 2、子选择器

~~~css
/*子选择器*/
body>p{
        background:#a13d30;
    }
~~~

![image-20211117221400526](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211117221400526.png)



#### 3、兄弟选择器

~~~css
/*兄弟选择器(弟弟选择器):下面的第一个同辈标签*/
.active+p{
       background:#a13d30;
   }
~~~

![image-20211117221523099](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211117221523099.png)



#### 4、通用选择器

~~~css
/*通用选择器*/
/*后面所有的兄弟都改变！*/
.active~p{
     background:#02ff00;
    }
~~~

![image-20211117221640008](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211117221640008.png)



附录：body标签中定义

~~~css
<body>
<p>p0</p>
<p class="active">p1</p>
<p>p2</p>
<p>p3</p>
<ul>
    <li>
        <p>p4</p>
    </li>
    <li>
        <p>p5</p>
    </li>
    <li>
        <p>p6</p>
    </li>
</ul>
</body>
~~~



### 3、结构伪类选择器

~~~css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    /*避免使用class，id选择器*/
    <style>
    /*1、ul的第一个元素*/
    ul li:first-child{
        background:#02ff00;
    }

    /*2、ul的最后一个元素*/
    ul li:last-child{
        background:#ff4832;
    }

    /*3、选中父元素下的p元素的第二个*/
    p:nth-of-type(2){
        background:yellow;
    }
    </style>


</head>

<body>

<p>p1</p>
<p>p2</p>
<p>p3</p>
<ul>
    <li>li1</li>
    <li>li2</li>
    <li>li3</li>
</ul>

</body>
</html>
~~~

![image-20211117224140107](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211117224140107.png)



### 4、属性选择器(*)

~~~css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
    /*标签的格式*/
        .demo a{
            float:left;
            display:block;
            height:50px;
            width:50px;
            border-radius:10px;
            background:#2700ff;
            text-align:center;
            color:gainsboro;
            text-decoration:none;
            margin-right:5px;
            font:bold 20px/50px Arial;
        }

    /*属性选择器*/
        /*1、存在id属性的元素*/
        a[id]{
            background:yellow;
        }

        /*2、id为first的元素*/
        a[id=first]{
            background:yellow;
        }

        /*3、class中含有links的元素*/
        a[class*="links"]{
            background:yellow;
        }

        /*4、选中href中以http开头的元素*/
        a[href^=http]{
            background:yellow;
        }

        /*5、选中href中以pdf结尾的元素*/
        a[href$=pdf]{
            background:yellow;
        }
    </style>
</head>

<body>
<p class="demo">
    <a href="http://www.baidu.com" class="links item first" id="first">1</a>
    <a href="" class="links item active" target="_blank" title="test">2</a>
    <a href="images/123.html" class="links item">3</a>
    <a href="images/123.png" class="links item">4</a>
    <a href="images/123.jpg" class="links item">5</a>
    <a href="abc" class="links item">6</a>
    <a href="abc.pdf" class="links item">7</a>
    <a href="abc.doc" class="links item last">8</a>
</p>


</body>
</html>
/*以最后两个为例*/
~~~

![image-20211118085921029](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211118085921029.png)



## 3、美化网页

#### 1、美化网页概述

1、有效地传递页面信息

2、美化网页，页面漂亮才能吸引用户

3、凸显页面的主题

4、提高用户的体验



span标签：重点要突出的字，用span套起来

~~~css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

  <style>
    #title1{
      font-size:50px;
    }

  </style>

</head>
<body>

欢迎学习<span id="title1">Java</span>

</body>
</html>
~~~

![image-20211118092008239](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211118092008239.png)



#### 2、字体样式

~~~css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--
        font-family:字体
        font-size:字体大小
        font-weight:字体粗细
        color:字体颜色    
    -->
    
  <style>
    body{
      font-family:"Arial Black",楷体;
      color:#a13d30;
    }

    h1{
        font-size:50px;
    }

    .p1{
        font-weight:bolder;
    }

  </style>

</head>
<body>

<h1>故事介绍</h1>
<p class="p1">
    在很久很久以前...
</p>
<p>
    long long ago...
</p>

</body>
</html>
~~~

![image-20211118092644676](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211118092644676.png)



#### 3、文本样式

1、颜色 color ：RGB\RGBA

​		*RGB十六进制的六位数，A为透明度*

**2、文本对齐方式：text-align=center**

**3、首行缩进：text-indent:2em**

**4、行高：line-height:单行文字上下居中！line-height=height**

5、装饰 text-decoration

​		*none去下划线(主要是a标签)*

6、文本图片水平对齐：vertical-align:middle

~~~css
/*例6、文本图片水平对齐*/

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
    /*6、水平对齐：参照物*/
        img,span{
            vertical-align:middle;
        }
    </style>
</head>
<body>

<img src="images/abc.jpg" alt="">
<span>abcd</span>

</body>
</html>
~~~

<img src="https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211118095953331.png" alt="image-20211118095953331" style="zoom:50%;" />



#### 4、超链接伪类和阴影

~~~css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
    /*1、默认颜色*/
        a{
            text-decoration:none;
            color:#000;
        }

    /*2、鼠标悬浮的状态*/
        a:hover{
            color:orange;
            font-size:20px;
        }

    /*3、鼠标按住不释放的状态*/
        a:active{
            color:green;
        }

<!--        a:visited{-->
<!--            color:#ff008a;-->
<!--        }-->

    /*4、阴影：颜色，水平偏移，垂直偏移，阴影半径*/
        #price{
            text-shadow:#3cc7f5 10px 10px 2px;
        }

    </style>

</head>

<body>
<a href="#">
    <img src="images/abc.jpg" alt="">
</a>
<p>
    <a href="#">蜡笔小新</a>
</p>
<p>
    <a href="">作者：小明</a>
</p>
<p id="price">
    $99
</p>

</body>
</html>
~~~

<img src="https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211118152856354.png" alt="image-20211118152856354" style="zoom:50%;" />



#### 5、列表

~~~css
/*1、html文件中*/
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="css/style.css" type="text/css"/>

</head>
<body>

<div id="nav">
    <h2>商品</h2>
    <ul>

        <li><a href="#">&nbsp;&nbsp;图书</a><a href="#">&nbsp;&nbsp;手机</a></li>
        <li><a href="#">&nbsp;&nbsp;电脑</a><a href="#">&nbsp;&nbsp;家具</a></li>
        <li><a href="#">&nbsp;&nbsp;平板</a><a href="#">&nbsp;&nbsp;旅行</a></li>
        <li><a href="#">&nbsp;&nbsp;鞋子</a><a href="#">&nbsp;&nbsp;食品</a></li>

    </ul>
</div>

</body>
</html>

/*2、style.css文件中*/
#nav{
    width:300px;
    background:#a0a0a0;
}

.title{
    font-size:18px;
    background:red;
}

ul{
    background:yellow;
}

a{
    text-decoration:none;
    color:#000;
}

a:hover{
    color:orange;
}
~~~

![image-20211118160024937](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211118160024937.png)



#### 6、背景+渐变

~~~css
/*1、背景：在原有的基础上改动*/
.title{
    /*颜色，图片位置，大小，平铺方式*/
    background:red url(../images/d.gif) 270px 10px no-repeat;
}
~~~

![image-20211118161819011](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211118161819011.png)

~~~css
/*2、渐变，网站：https://www.grabient.com/*/
<style>
        body{
            background-color: #4158D0;
            background-image: linear-gradient(43deg, #4158D0 0%, #C850C0 46%, #FFCC70 100%);
        }
</style>
~~~

![image-20211118162824923](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211118162824923.png)



## 4、盒子模型

#### 1、什么是盒子

![image-20211118163110322](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211118163110322.png)

margin：外边距

padding：内边距

border：边框



#### 2、边框

1、边框的粗细

2、边框的样式

3、边框的颜色

~~~css
/*所有浏览器都自定义了margin，padding，border的初值*/
/*格式化*/
h1,ul,li,a,body{
    margin:0;
    padding:0;
    text-decoration:none;
}

/*border:粗细，样式，颜色*/
~~~



![image-20211118164829562](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211118164829562.png)



#### 3、内外边距

~~~css
/*外边距margin*/
margin:0	上下左右
margin:0 1px	上下，左右
margin:0 1px 2px	上，左右，下
margin:0 1px 2px 3px	上，右，下，左
/*其他都一样*/
~~~



盒子的计算方式：你这个元素到底多大？

![image-20211118171037582](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211118171037582.png)

margin+border+padding+内容宽度



#### 4、圆角边框

~~~css
/*边框圆角*/
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        div{
            width:100px;
            height:100px;
            border:10px solid red;
            border-radius:100px 50px 30px 10px;
        }

    </style>

</head>
<body>

<div></div>

</body>
</html>
~~~

![image-20211118172508537](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211118172508537.png)



#### 5、阴影

~~~css
/*margin：0 auto;居中
要求：块元素，且块元素有固定的宽度
*/

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        img{
            border-radius:50px;
            box-shadow:10px 10px 100px yellow;
        }
        
    </style>
  
</head>
<body>
    <div style="width:500px;display:block;text-align:center">
        <img src="images/小樱.jpg" alt="">
    </div>


</body>
</html>
~~~

<img src="https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211118174248358.png" alt="image-20211118174248358" style="zoom:67%;" />



## 5、浮动

#### 1、标准文档流

![image-20211119110930258](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211119110930258.png)

块级元素：独占一行

~~~css
h1~h6  p  div  列表...
~~~

行内元素：不独占一行

~~~css
span  a  img  strong...
~~~

行内元素可以被包含在块级元素中，反之，则不可以~



#### 2、display

~~~css
/*
	block 块元素
	inline 行内元素
	inline-block 是块元素，但是可以内联在一行！！！
*/

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

  <style>
    div{
      width:100px;
      height:100px;
      border:1px solid red;
      display:inline;
    }

    span{
        width:100px;
        height:100px;
        border:1px solid red;
        display:inline-block;
    }
  </style>

</head>
<body>

<div>div块级元素</div>
<span>span行内元素</span>

</body>
</html>
~~~

![image-20211119110622373](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211119110622373.png)

注释：这是一种实现行内元素排列的方式，但是我们很多情况都是用float(因为diplay是作用在标准文档流的操作！)



#### 3、float

1、左右浮动 float

~~~css
float:right;
float:left;
...
~~~



#### 4、父级边框塌陷的四个解决方法(*)

clear

~~~css
/*
clear:right;	右侧不允许有浮动元素
clear:left;		左侧不允许有浮动元素
clear:both;		左侧不允许有浮动元素
clear:none;
*/
~~~



overflow溢出问题

~~~css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        #content{
            width:200px;
            height:150px;
            overflow:scroll;
        }
    </style>

</head>
<body>

<div id="content">
    <p>
        《什么是快乐星球》是张惠民执导，廉洁、傅正监制的少儿科幻电视剧《快乐星球5》第5集中的插曲，由该剧男一号带小帅的饰演者时代少年团队长马嘉祺演唱。2021年3月，"什么是快乐星球"在短视频平台走红，成为流行的网络用语之一，全网播放量破100亿
    </p>

</div>


</body>
</html>
~~~

![image-20211119160000029](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211119160000029.png)



解决方案：

1、增加父级元素的高度

~~~css
#father{
    border:1px #000 solid;
    height:800px;
}
~~~

特点：简单，元素假设有了固定的高度，就会被限制



2、增加一个空的div标签，清除浮动

~~~css
<div class="clear"></div>

.clear{
       clear:both;
       margin:0;
       padding:0;
}
~~~

特点：简单，代码中尽量避免空div



3、overflow 溢出

~~~
在父级元素中增加一个 overflow:hidden;
~~~

特点：简单，下拉的一些场景避免使用



4、父类添加一个伪类：after

~~~css
#father:after{
    content:'';
    display:block;
    clear:both;
}
~~~

特点：写法稍微复杂一点，但是没有副作用，推荐使用！



#### 5、对比display与float

* diplay：

​	方向不可以控制

* float：

​	浮动起来的话会脱离标准文档流，所以要解决父级边框塌陷问题



## 6、定位

###  1、相对定位

~~~css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        body{
            padding:20px;
        }
        div{
            margin:10px;
            padding:5px;
            font-size:12px;
            line-height:25px;
        }
        #father{
            border:1px solid #666;
            padding:0;
        }
        #first{
            background-color:#255099;
            border:1px dashed #b27530;
            position:relative;  /*相对位置*/
            top:-20px;
            left:20px;
        }
        #second{
            background-color:#255099;
            border:1px dashed #255066;
        }
        #third{
            background-color:#1c6699;
            border:1px dashed #1c6615;
            position:relative;
            bottom:-10px;
            right:-20px;
        }
    </style>

</head>
<body>
<div id="father">

    <div id="first">第一个盒子</div>
    <div id="second">第二个盒子</div>
    <div id="third">第三个盒子</div>

</div>
</body>
</html>
~~~

![image-20211119162120942](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211119162120942.png)

相对定位：position：relative；

相对于原来的位置，进行指定的偏移，相对定位的话，它仍然在标准文档流中，原来的位置会被保留

~~~css
top:-20px;
left:20px;
bottom:-10px;
right:-20px;
~~~



### 2、方块定位案例

~~~css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        #box{
            width:300px;
            height:300px;
            padding:10px;
            border:2px solid red;
        }
        a{
            width:100px;
            height:100px;
            text-decoration:none;
            background:#ffa1f2;
            line-height:100px;  /*行内元素和行高必须相等才能居中*/
            text-align:center;  /*居中语法*/
            color:white;
            display:block;  /*必须设计为块元素，否则显示不出块*/
        }
        a:hover{
            background:#47a4ff;
        }
        .a2,.a4{
            position:relative;
            left:200px;
            top:-100px;
        }
        .a5{
            position:relative;
            left:100px;
            top:-300px;
        }
    </style>


</head>
<body>

<div id="box">
    <a class="a1" href="#">链接1</a>
    <a class="a2" href="#">链接2</a>
    <a class="a3" href="#">链接3</a>
    <a class="a4" href="#">链接4</a>
    <a class="a5" href="#">链接5</a>
</div>

</body>
</html>
~~~

![image-20211119163757746](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211119163757746.png)



### 3、绝对定位

绝对定位：基于xxx定位，上下左右~

1、没有父级元素时，相对于浏览器定位

2、有父级元素时，相对于父级元素进行偏移

~~~css
/*在相对定位的基础上*/

#father{
    position:relative;
}

#second{
    position:absolute;
    left:100px;
}
~~~

![image-20211119170347820](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211119170347820.png)



### 4、固定定位

~~~css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        body{
            height:2000px;
        }
        div:nth-of-type(1){
            width:100px;
            height:100px;
            background:red;
            position:absolute;  /*相对位置*/
            right:0;
            bottom:0;
        }
        div:nth-of-type(2){
            width:50px;
            height:50px;
            background:yellow;
            position:fixed;  /*固定位置*/
            right:0;
            bottom:0;
        }
    </style>

</head>
<body>

<div>div1</div>
<div>div2</div>

</body>
</html>
~~~



* 起始位置(没拉滚动条时)

![image-20211119170950844](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211119170950844.png)

* 最终位置(拉了滚动条时)

![image-20211119171125761](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211119171125761.png)



### 5、z-index

![image-20211119173138956](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211119173138956.png)

* 图层~~~

* 背景透明度

  opacity:0.5;	/*背景透明度*/





# 三、JavaScript

## 1、什么是JavaScript

JavaScript是一门世界上最流行的脚本语言

**一个合格的后端人员，必须精通JavaScript**





## 2、快速入门

### 1、引入JavaScript

~~~javascript
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--内部标签-->
    <script>
        alert('helloworld')
    </script>

    <!--外部引入-->
    <script src="js/helloworld.js"></script>
    
</head>
<body>

</body>
</html>
~~~

![image-20211122104035325](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122104035325.png)



### 2、浏览器控制台使用

~~~javascript
    <script>
        //1、定义变量
        var score=71;
        alert(score);

        /*相当于System.out.println()*/
        console.log(score)
    </script>
~~~

![image-20211122104336459](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122104336459.png)



###  3、严格检查模式

~~~JavaScript
    <script>
    
    /*前提：IEDA需要设置支持ES6语法*/

    /*'use strict':严格检查模式，预防JavaScript的随意性导致一些问题*/
    ‘use strict’;

    /*局部变量建议使用let去定义*/
    let i=1;

    </script>
~~~



### 4、基本数据类型

> 【与java相似的省略】



**1、number**

~~~javascript
/*小数和整数*/
NaN //not a number(不是一个数)
Infinity //表示无限大
~~~



**2、比较运算符**

~~~javascript
== 		//等于，但'1'与 1 相同
===		//绝对等于(类型和值都得相等)
这是一个JS的缺陷，坚持不要使用 == 比较    
~~~

浮点数问题

~~~javascript
console.log((1/3)===(1-2/3))
输出：
false
undefined
~~~

尽量避免使用浮点数进行运算，存在精度问题!

~~~javascript
Math.abs(1/3-(1-2/3))<0.000000001
true
~~~



**null与undefined**

* null 空

* undefined 未定义



**3、数组**

JS不需要相同类型的对象~

~~~javascript
//保证代码的可读性，尽量使用[]
var arr=[1,2,3,4,'hello',null,true];
~~~

取数组下标：

~~~JavaScript
console.log(arr[4])
输出：
hello
undefined
~~~



**4、对象**

对象是大括号，数组是中括号

~~~javascript
// 相当于 Person person=new Person(1,2,3,4,5);
var person={
    name:"小明",
    age:3,
    tags:['js','java','web']
}
~~~

~~~javascript
person.tags
输出：
(3) ['js', 'java', 'web']
~~~





## 3、数据类型

> 数值、文本、图形、音频、视频......



### 1、字符串

1、转义字符

~~~JavaScript
\u4e2d		//unicode字符
\x41		//Ascll字符
~~~

2、多行字符串编写

~~~javascript
//tab上面esc键下面
    var msg=`
        hello
        world
        你好
    `;
~~~

![image-20211122163917816](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122163917816.png)

3、模板字符串

~~~javascript
//tab上面esc键下面 
'use strict';

let name="小明";

let msg=`你好呀,${name}`
~~~

![image-20211122164054629](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122164054629.png)

4、字符串操作

~~~JavaScript
//1、大小写操作
var student='student';
console.log(student.toUpperCase());
STUDENT
console.log(student.toLowerCase());
student

//2、索引查找
var helloworld='helloworld';
console.log(helloworld.indexOf('o'));
4

//3、截取字符串 [)
console.log(helloworld.substring(1));
elloworld

console.log(helloworld.substring(1,3))
el
~~~



### 2、数组

**1、截取数组**

slice()截取Array的一部分，返回一个新数组，类似于String中的subString

~~~JavaScript
var arr=[1,2,3,'1','2','3']

arr.slice(2)
(4) [3, '1', '2', '3']

arr.slice(2,4)
(2) [3, '1']

/*不会修改数组*/
~~~

**2、插入与删除**

~~~JavaScript
//1、尾部操作
arr.push('4')
7
arr.pop()
'4'

//2、头部操作
arr.unshift('1')
7

arr.shift()
'1'
~~~

**3、数组操作**

~~~JavaScript
var arr=['B','C','A'];

//1、元素排序
arr.sort()
(3) ['A', 'B', 'C']

//2、元素反转
arr.reverse()
(3) ['C', 'B', 'A']

//3、元素拼接
arr.concat([1,2,3])
(6) ['C', 'B', 'A', 1, 2, 3]

//4、连接符 join
arr.join('-')
'C-B-A'

//5、多维数组
var arr=[[1,2],[3,4],[5,6]]
arr[1][1]
4
~~~



### 3、对象

~~~JavaScript
/*前面已讲述*/

// 相当于 Person person=new Person(1,2,3,4,5);
var person={
    name:'小明',
    age:18
}
~~~

注意：{......}表示一个对象，所有的键都是字符串，值是任意对象！

1、对象赋值

~~~JavaScript
person.name='小红'
'小红'
person.name
'小红'
~~~

2、动态删除属性

~~~javascript
delete person.age
true
person
{name: '小红'}
~~~

3、判断属性值是否在对象中

~~~javascript
name' in person
true
//继承的属性
'toString' in person
true

//对象自身的键
person.hasOwnProperty('toString')
false
person.hasOwnProperty('name')
true
~~~



### 4、流程控制

> 其他都与java相似，略...

1、forEach循环

~~~JavaScript
let age=[12,23,4345,552,34,543,24,13];

    /*循环函数*/
    age.forEach(function(value){
        console.log(value)
    })
~~~

![image-20211122174751916](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122174751916.png)

 

2、for...in循环

~~~JavaScript
/*for(var index in object)*/
    for(var num in age){
        if(age.hasOwnProperty(num)){
            console.log("存在")
            console.log(age[num])
        }
    }
~~~

![image-20211122175021025](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122175021025.png)



### 5、Map和Set

> 注：ES6的新特性

Map：

~~~JavaScript
var map=new Map([['小明',19],['小红',20],['小芳',29]]);
var name=map.get('小明');     //通过key获取value！
	map.set('小刚',12);	//新增或修改！
	map.delete('小明');	//删除！
~~~

![image-20211122181032991](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122181032991.png)



Set：无序不重复的集合

~~~JavaScript
var set=new Set([3,1,1,1]); //set去重
    set.add(2)
    set.delete(1)
console.log(set.has(3))     //是否包含某个元素！
~~~

![image-20211122181148011](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122181148011.png)



### 6、iterator

> es6 新特性

* 遍历数组

~~~JavaScript
//通过for of/ for in 下标
    var arr=[3,4,5]
    for(var x of arr){
        console.log(x)
    }
//区别于for in，遍历的是数组中的数据
~~~

![image-20211122205730811](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122205730811.png)

* 遍历map

~~~JavaScript
var map=new Map([['tom',100],['jack',90],['haha',80]])
    for(let x of map){
        console.log(x)
    }
~~~

![image-20211122205647718](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122205647718.png)

* 遍历set

~~~JavaScript
//通过for of/ for in 下标
    var set=new Set([5,6,7])
    for(var x of set){
        console.log(x)
    }
~~~

![image-20211122205829236](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122205829236.png)





## 4、函数

 ### 1、定义函数

>定义方法一

绝对值函数

~~~javascript
function abs(x){
        if(x>=0){
            return x;
        }else{
            return -x;
        }
    }
~~~



> 定义方法二

~~~JavaScript
var abs = function(x){
        if(x>=0){
            return x;
        }else{
            return -x;
        }
    }
~~~

//输出结果与上述相同

function(x){...}是一个匿名函数。但是可以把结果赋值给abs，通过abs就可以调用函数！



> 调用函数

~~~JavaScript
abs(10)  //10
abs(-10)  //10
abs()  //NaN
abs(10,20,30,40)  //10
~~~

上述出现多个参数的问题！

下面解决：



> argument

代表传递进来的所有参数是个数组！

~~~JavaScript
var abs = function(x){

        console.log("x=>"+x)

        for(let i=0;i<arguments.length;i++){
            console.log(arguments[i]);
        }

        if(x>=0){
            return x;
        }else{
            return -x;
        }
        
    }
~~~

![image-20211122212449817](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122212449817.png)

问题：argument包含所有的参数，我们有时想使用多余的参数进行附加操作，排除已有参数~~~



> rest

以前：

~~~JavaScript
if(arguments.length>2){
    for(var i=2;i<arguments.length;i++){
     	...   
    }
}
~~~

ES6引入新特性，获取除定义的参数之外的所有参数~

~~~JavaScript 
function aaa(a,b,...rest){
        console.log('a=>'+a);
        console.log('b=>'+b);
        console.log(rest);
    }
~~~

![image-20211122213007986](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122213007986.png)



### 2、变量的作用域

> 1、全局作用域

JavaScript只用一个全局作用域，任何变量（函数也可以视为变量），假设没有在函数作用范围内找到，就会向外查找，如果在全局作用域都没找到，就会报错**RefrenceError**



> 规范

在不同的js文件中如果使用了相同的全局变量，就会产生冲突~

—>如何减少冲突？

~~~JavaScript
//唯一全局变量
var happy={};

//定义全局变量
happy.name='happy';
happy.add=function(a,b){
    return a+b;
}
~~~

把代码都放入自己定义的唯一空间名字中，降低全局命名冲突的问题~

jQuery



>  2、局部作用域 let

~~~javascript
//使用var时
function aaa(){
        for(var i=0;i<100;i++){
            console.log(i)
        }
        console.log(i+1);
    }
    aaa();
~~~

![image-20211122221707158](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122221707158.png)

~~~JavaScript
//let关键字，解决局部作用域冲突问题
function aaa(){
        for(let i=0;i<100;i++){
            console.log(i)
        }
        console.log(i+1);
    }
    aaa();
~~~

![image-20211122221813019](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122221813019.png)



> 常量const

~~~JavaScript
//ES6中引入了常量关键字 const
	const PI='3.14'
    console.log(PI);
    PI='123'
    console.log(PI);
~~~

![image-20211122222031695](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211122222031695.png)



### 3、方法

> 定义方法

方法就是把函数放在对象的里面，对象只有两个东西：属性和方法

~~~JavaScript
var hello={
      name:'小明',
      birth:2000,

      age:function(){
        var now=new Date().getFullYear();
        return now-this.birth;
      }
}
~~~

![image-20211123210440551](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211123210440551.png)



> 改进方法

~~~javascript
function getAge(){
        var now=new Date().getFullYear();
        return now-this.birth;
      }

    var hello={
      name:'小明',
      birth:2000,
      age:getAge
    }
~~~

this是无法指向的，是默认指向调用它的那个对象；



> apply

在js中可以控制this指向！

~~~JavaScript
function getAge(){
        var now=new Date().getFullYear();
        return now-this.birth;
      }

    var hello={
      name:'小明',
      birth:2000,
      age:getAge
    }

    var world={
      name:'小白',
      birth:2000,
      age:getAge
    }
~~~

![image-20211123211322728](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211123211322728.png)





## 5、内部对象

> 标准对象

~~~JavaScript
typeof 123
'number'
typeof "123"
'string'
typeof true
'boolean'
typeof NaN
'number'
typeof []
'object'
typeof {}
'object'
typeof Math.abs
'function'
typeof undefined
'undefined'
~~~



### 1、Date

**基本使用**

~~~JavaScript
var now=new Date(); //Tue Nov 23 2021 21:17:31 GMT+0800 (中国标准时间)
      now.getFullYear();  //年
      now.getMonth();   //月 0~11
      now.getDate();    //日
      now.getDay();   //星期几
      now.getHours();   //时
      now.getMinutes(); //分
      now.getSeconds();  //秒

      //时间戳 1970 1.1 0：00：00
      now.getTime()  //1637673728690毫秒

      console.log(new Date(1637673728690)) //时间戳转为时间
      //Tue Nov 23 2021 21:22:08 GMT+0800 (中国标准时间)
~~~

转换

~~~JavaScript
now.toLocaleString()
'2021/11/23 下午9:23:51'

now.toGMTString()
'Tue, 23 Nov 2021 13:23:51 GMT'
~~~



### 2、JSON

> json是什么

早期，所有数据传输习惯使用XML文件！

* Json(JavaScript Object Notation,JS对象简谱)是一种轻量化的数据交换格式



在JavaScript中，一切皆为对象，任何js支持的类型都可以用JSON来表示；number，string....

格式：

* 对象用{}
* 数组用[]
* 所有的键值对用key：value



JSON字符串和JS对象的转换

~~~JavaScript
var user={
      name:"小明",
      age:3,
      sex:'男'
    }

//对象转换为json字符串
var jsonUser=JSON.stringify(user);

//json字符串转换为对象
var obj=JSON.parse('{"name":"小明","age":3,"sex":"男"}');
~~~

![image-20211123213410055](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211123213410055.png)



### 3、Ajax

* 原生的js写法	xhr异步请求
* jQuey 封装好的方法  $("#name").ajax("")
* axios  请求



## 6、面向对象编程

> 原型对象

* 类：模板
* 对象：具体的实例

原型:

~~~javascript
var Student={
      name:"小明",
      age:3,
      sex:'男',
      run:function(){
        console.log(this.name+"run....")
      }
    };

    var xiaoming={
        name:"xiaoming"
    };

    xiaoming.__proto__=Student;
~~~

![image-20211123214537883](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211123214537883.png)

~~~javascript
 //不需要记，旧特性
function Student(name){
        this.name=name;
    }

Student.prototype.hello=function(){
        alert('hello')
    };
~~~



> class继承

* class为关键字，ES6引入的

**1、定义一个类，属性，方法**

~~~JavaScript
//定义一个类
    class Student{
        //构造函数
        constructor(name){
            this.name=name;
        }

        hello(){
            alert('hello')
        }
    }

    var xiaoming=new Student("xiaoming")
~~~

![image-20211123215356744](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211123215356744.png)



**2、继承**

~~~JavaScript
class pupil extends Student{
        constructor(name,grade){
            super(name);
            this.grade=grade;
        }

        myGrade(){
            alert('我是一名小学生')
        }
    }

    var xiaohong=new pupil("xiaohong",1);
~~~



![image-20211123220322436](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211123220322436.png)

本质：查看对象原型

![image-20211123220706254](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211123220706254.png)





## 7、操作BOM对象(*)

> 浏览器介绍

JavaScript 诞生就是为了让他在浏览器中运行！！！

Bom：浏览器对象模型

* Chrome
* Safari
* FireFox



> window

window 代表 浏览器窗口

~~~JavaScript
window.alert(1)
undefined
window.innerHeight
187
window.innerWidth
1077
window.outerHeight
741
window.outerWidth
878
//可以调整浏览器窗口玩~~~
~~~



> screen

~~~javascript
screen.width
1920 px
screen.height
1080 px
~~~



> location(重要)

location 代表当前页面的URL信息

~~~JavaScript
host: "www.baidu.com"   //主机
href: "https://www.baidu.com/"	//当前位置
protocol: "https:"	//协议
reload: ƒ reload()	//重新加载

//设置新的地址
location.assign("https://www.bilibili.com/")
~~~



> document(重要)：DOM

document 代表当前页面， HTML DOM文档树

~~~JavaScript
document.title
'百度一下，你就知道'
document.title='你好，靓仔'
'你好，靓仔'
~~~

![image-20211123223138221](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211123223138221.png)

获取具体的文档树节点

~~~JavaScript
<d1 id="app">
    <dt>Java</dt>
    <dd>JavaSE</dd>
    <dd>JavaEE</dd>
</d1>

<script>
    var d1=document.getElementById('app');
</script>
~~~

获取cookie（淘宝）

~~~JavaScript
document.cookie
'miid=398070701237022987; cna=p+jyGZOK3mICAX1aMWDBelLQ; ......'
~~~

劫持 cookie 原理

~~~JavaScript
<script src="aa.js"></script>
/*恶意人员，获取你的 cookie 上传到它的服务器*/
~~~

服务器端可以设置 cookie：httpOnly





## 8、操作DOM对象(*)

> 核心

浏览器网页就是一个Dom树形结构！！！

* 更新：更新Dom节点
* 遍历dom节点：得到Dom节点
* 删除：删除一个Dom节点
* 添加：添加一个新节点

要操作一个Dom节点，就必须要先获取这个Dom节点



### 1、获得dom节点

~~~JavaScript 
<div id="father">
    <h1>标题一</h1>
    <p id="p1">p1</p>
    <p class="p2">p2</p>
</div>

<script>
    //对应 css 选择器
    var d1 = document.getElementsByTagName('h1')
    var p1 = document.getElementById('p1')
    var p2 = document.getElementsByClassName('p2')

    //获取父节点下的所有子节点
    var childrens = father.children[index]
    father.firstChild
    father.lastChild
</script>
~~~

这是原生代码，值后我们尽量都使用jQuery();



### 2、更新dom节点

~~~JavaScript
<div id="id1"></div>

<script>
    var id1 = document.getElementById('id1')
</script>
~~~

操作文本

~~~JavaScript
//1、修改文本值
id1.innerText='456' 
'456'

//2、解析HTML文本标签
id1.innerHTML='<strong>123</strong>'
'<strong>123</strong>'
~~~

操作JS

~~~JavaScript
//属性使用 字符串 包裹
id1.style.color='yellow';
'yellow'
id1.style.fontSize='200px';
'200px'
id1.style.padding='2em';
'2em'
~~~



### 3、删除dom节点

删除节点的步骤：先获取父节点，再通过父节点删除自己

~~~JavaScript
<div id="father">
    <h1>标题一</h1>
    <p id="p1">p1</p>
    <p class="p2">p2</p>
</div>

<script>
    //对应 css 选择器
    var p1 = document.getElementById('p1')
    var father=document.getElementById('father')
    father.removeChild(p1)

    //删除是一个动态的过程
    father.removeChild(father.children[0])
    father.removeChild(father.children[0])
</script>
~~~

注意：删除多个节点的时候，children是时刻变化的，删除节点的时候一定要注意！！！



### 4、插入dom节点

我们获得了某个Dom节点，假设这个dom节点是空的，我们通过innerHTML就可以增加一个元素了，但是这个DOM节点存在元素了，我们就不能这么干，会覆盖原数据！

> 追加

~~~javascript
<p id="js">JavaScript</p>
<div id="list">
    <p id="SE">JavaSE</p>
    <p id="EE">JavaEE</p>
    <p id="ME">JavaME</p>
</div>

<script>
   var js = document.getElementById('js')
   var list = document.getElementById('list')
   list.appendChild(js) //追加到后面
</script>
~~~



> 创建一个新的节点

~~~javascript
//通过JS创建一个新的节点
   var newP=document.createElement('p')
   newP.id='newP'
   newP.innerText="HelloWorld";
~~~

![image-20211124090725584](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211124090725584.png)



>创建一个标签节点

~~~javascript
//创建一个标签节点
    var myScript=document.createElement('script')
    myScript.setAttribute('type','text/javascript')
~~~



> 创建一个Style标签

~~~javascript
var body=document.getElementsByTagName('body')
body[0].style.backgroundColor="#a9475b"
~~~

![image-20211124091426641](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211124091426641.png)





## 9、操作表单(验证)

> 表单是什么  form  Dom树

* 文本框	text
* 下拉框    < select >
* 单选框    radio
* 多选框    checkbox
* 隐藏域     hidden
* 密码框     password
* ......

表单的目的：提交信息



> 获得要提交的信息

~~~html
<form action="post">
    <p>
        <span>用户名：</span><input type="text" id="username">
    </p>

    <p>
        <span>性别：</span>
        <input type="radio" name="sex" value="man" id="boy">男
        <input type="radio" name="sex" value="women" id="girl">女
    </p>
</form>

<script>
   var input_text = document.getElementById('username')
   var boy_radio = document.getElementById('boy')
   var girl_radio = document.getElementById('girl')

   //获得输入框的值
   input_text.value
   //修改输入框的值
   input_text.value='123'

    //对于 单选框&多选框 固定的值
    boy_radio.checked  //true
    girl_radio.checked  //false
</script>
~~~

![image-20211124093028985](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211124093028985.png)





> 提交表单，md5加密密码，表单优化

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdn.bootcss.com/blueimp-md5/2.10.0/js/md5.min.js"></script>

</head>
<body>
<!--onsubmit:表单绑定提交事件-->
<form action="https://www.baidu.com/" method="post" onsubmit="return aaa()">
    <p>
        <span>用户名：</span><input type="text" id="username" name="username">
    </p>
    <p>
        <span>密码：</span><input type="text" id="input-password">
    </p>

    <input type="hidden" id="md5-password" name="password">
    <button type="submit">提交</button>
</form>

<script>
    function aaa(){
        alert(1);
        var uname=document.getElementById('username');
        var pwd=document.getElementById('input-password');
        var md5pwd=document.getElementById('md5-password');

        md5pwd.value=md5(pwd.value);
        return true;
    }
</script>

</body>
</html>
~~~

![image-20211124100546906](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211124100546906.png)





## 10、JQuery(*)

> JQuery库中存在大量的JavaScript函数

JQuery帮助文档：

~~~javascript
https://jquery.cuishifeng.cn/index.html
~~~



### 1、初识JQuery及公式

> 获取JQuery

```html
<!--1、cdn引入-->
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>

<!--2、导包-->
略......
```



> 公式(*)

~~~html
$(selector).action()
~~~

~~~html
//例：
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--cdn引入-->
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
</head>
    
<body>
<a href="" id="test-jQuery">点我</a>

<script>
    $('#test-jQuery').click(function(){
        alert('hello,Jquery');
    })
</script>

</body>
</html>
~~~

![image-20211124101807267](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211124101807267.png)



### 2、选择器

~~~html
<script>
    //原生js，选择器少，麻烦不好记
    document.getElementsByTagName();    //标签选择器
    document.getElementById()    //id选择器
    document.getElementsByClassName();    //类选择器

    //jQuery css中的选择器它都可以用！！！
    $('p').click();    //标签选择器
    $('#id').click();    //id选择器
    $('.class').click();    //类选择器
</script>
~~~

jQuery帮助文档：https://jquery.cuishifeng.cn/index.html



### 3、事件

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>

    <style>
        #divMove{
            width:500px;
            height:500px;
            border:1px solid red;
        }
    </style>

</head>
<body>
<!--要求：获取鼠标当前的一个坐标-->
mouse:<span id="mouseMove"></span>

<div id="divMove">移动鼠标试试</div>

<script>
    /*当网页元素加载完毕后，响应事件*/
    $(function(){
        $('#divMove').mousemove(function(e){
            $('#mouseMove').text('x:'+e.pageX+'  y:'+e.pageY)
        })
    });
</script>

</body>
</html>
```

![image-20211124104652504](https://gitee.com/cocochimp/koko/raw/master/Front_end_three_pieces/image-20211124104652504.png)



### 4、操作dom

>节点文本操作

~~~JavaScript
<ul id="test-ul">
    <li class="js">JavaScript</li>
    <li name="python">Python</li>
</ul>

<script>
    $('#test-ul li[name=python]').text();   //获取值
    $('#test-ul li[name=python]').text('xxx');  //设置值
    $('#test-ul').html();   
    $('#test-ul').html('<strong>123</strong>');
~~~



>css 的操作

~~~JavaScript
$('#test-ul li[name=python]').css("color","red")
~~~



> 元素的显示和隐藏：本质 display:none;

~~~javascript
$('#test-ul li[name=python]').show()
$('#test-ul li[name=python]').hide()
~~~



未来操作ajax();

~~~javascript
$('#from').ajax()
~~~



> 小技巧

1、如何巩固JS（看jQuery源码，看游戏源码！！！）

2、巩固HTML、CSS（扒网站，下载下来，进行修改！！！）



一些组件的网站：

~~~JavaScript
https://ant.design/components/overview-cn/
https://element.eleme.cn/#/zh-CN/component/color
https://www.layuiweb.com/doc/index.htm
......
~~~