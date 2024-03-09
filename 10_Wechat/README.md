# 微信小程序学习资源



## 1.  环境准备

>1、获取APPID

登录地址：[微信公众平台](https://mp.weixin.qq.com/)

* 获取小程序ID步骤

主页—>开发—>开发管理—>开发设置—>开发者ID中的`AppID`（复制）

> 2、下载“微信开发者工具”

下载地址：[微信开发者工具](https://developers.weixin.qq.com/miniprogram/dev/devtools/download.html)

![image-20220130150532668](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220130150532668.png)

> 3、第一个项目

![image-20220316220400458](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220316220400458.png)

* 使用测试号

> 4、平台布局

![image-20220130151728760](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220130151728760.png)



## 2. 小程序结构目录

### 2.1 小程序和传统web文件结构对比

| 结构   | 传统web      | 微信小程序   |
| ------ | ------------ | ------------ |
| 结构层 | `HTML`       | `WXML`       |
| 样式层 | `CSS`        | `WXSS`       |
| 逻辑层 | `Javascript` | `Javascript` |
| 配置层 | 无           | `JSON`       |



### 2.2 基本的项目目录

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220316220911957.png" alt="image-20220316220911957" style="zoom: 67%;" />



## 3. 配置文件JSON

> 简介

一个小程序包括最基本的两种配置文件

* 全局的配置文件`app.json`
* 页面自己的配置文件`page.json`

注：配置文件中不能出现注解



### 3.1 [全局配置`app.json`](https://developers.weixin.qq.com/miniprogram/dev/framework/config.html)

`app.json` 是当前⼩程序的全局配置，包括了⼩程序的所有⻚⾯路径、界⾯表现、⽹络超时时间、底 部 tab 等。普通快速启动项⽬⾥边的 `app.json` 配置

```json
{
  "pages":[
    "pages/index/index",
    "pages/logs/logs"
 ],
  "window":{
    "backgroundTextStyle":"light",
    "navigationBarBackgroundColor": "#fff",
    "navigationBarTitleText": "WeChat",
    "navigationBarTextStyle":"black"
 }
}
```

字段的含义 

1. `pages` 字段⸺⽤于描述当前⼩程序所有⻚⾯路径，这是为了让微信客⼾端知道当前你的⼩程序 ⻚⾯定义在哪个⽬录。
2. `window` 字段⸺定义⼩程序所有⻚⾯的顶部背景颜⾊，⽂字颜⾊定义等。
3. 完整的配置信息请参考 [全局配置](https://developers.weixin.qq.com/miniprogram/dev/reference/configuration/app.html)



### 3.2 [页面配置`page.json`](https://developers.weixin.qq.com/miniprogram/dev/reference/configuration/page.html)

1. 这⾥的 `page.json` 其实⽤来表⽰⻚⾯⽬录下的 `page.json` 这类和⼩程序⻚⾯相关的配置。
2. 开发者可以独⽴定义每个⻚⾯的⼀些属性，如顶部颜⾊、是否允许下拉刷新等等。
3. ⻚⾯的配置只能设置 `app.json` 中部分 window 配置项的内容，⻚⾯中配置项会覆盖 `app.json` 的 window 中相同的配置项。



### 3.3 [sitemap 配置](https://developers.weixin.qq.com/miniprogram/dev/reference/configuration/sitemap.html)

小程序根⽬录下的 `sitemap.json` ⽂件⽤于配置小程序及其⻚⾯是否允许被微信索引！

注：了解即可



## 4. 模板语句WXML

> 简介

WXML（`WeiXin Markup Language`）是框架设计的⼀套标签语⾔，结合[基础组件](https://developers.weixin.qq.com/miniprogram/dev/component/)、[事件系统](https://developers.weixin.qq.com/miniprogram/dev/framework/view/wxml/event.html)，可以构建出⻚⾯的结构！



### 4.1 基本用法

> 测试

1. `wxml`

```html
<!-- 
  1 text 相当于以前web中的 span标签 行内元素  不会换行
  2 view 相当于以前web中的 div标签 块级元素  会换行
  3 checkbox 以前的复选框标签 
 -->
<!-- <text>1</text>
<text>2</text>
<view>1</view>
<view>2</view> -->

<!-- 1 字符串 -->
<view> {{msg}} </view>
<!-- 2 数字类型 -->
<view>{{num}}</view>
<!-- 3 bool类型  -->
<view> 是否是伪娘: {{isGirl}} </view>
<!-- 4 object类型 -->
<view>{{person.age}}</view>
<view>{{person.height}}</view>
<view>{{person.weight}}</view>
<view>{{person.name}}</view>

<!-- 5 在标签的属性中使用 -->
<view data-num="{{num}}"> 自定义属性</view>
```

2. `js`

```js
//Page Object
Page({
  data: {
    msg: "hello mina",
    num: 10000,
    isGirl: false,
    person: {
      age: 74,
      height: 145,
      weight: 200,
      name: "富婆"
    }
  }
});
```

3. 测试

![image-20220316223021538](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220316223021538.png)



### 4.2 逻辑运算

> 测试

1. `wxml`

```html
<!-- 
  6 使用bool类型充当属性 checked  
    1 字符串和 花括号之间一定不要存在空格 否则会导致识别失败 
      以下写法就是错误的示范
         <checkbox checked="       {{isChecked}}"> </checkbox>
 -->
<view>
  <checkbox checked="{{isChecked}}"> </checkbox>
</view>

<!-- 
  7 运算 => 表达式
    1 可以在花括号中 加入 表达式 --  “语句”
    2 表达式
      指的是一些简单 运算 数字运算 字符串 拼接  逻辑运算。。
      1 数字的加减。。
      2 字符串拼接
      3 三元表达式 
    3 语句
      1 复杂的代码段
        1 if else
        2 switch
        3 do while 。。。。
        4 for 。。。
 -->
<view>{{1+1}}</view>
<view>{{'1'+'1'}}</view>
<view>{{ 11%2===0 ? '偶数' : '奇数' }}</view>
```

2. `js`

```js
//Page Object
Page({
    isChecked:true,
  }
);
```

3. 测试

![image-20220316223321708](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220316223321708.png)



### 4.3 列表循环

> 测试

1. `wxml`

```html
<!-- 
  8 列表循环
    1 wx:for="{{数组或者对象}}"  wx:for-item="循环项的名称"  wx:for-index="循环项的索引"
    2 wx:key="唯一的值" 用来提高列表渲染的性能
      1 wx:key 绑定一个普通的字符串的时候 那么这个字符串名称 肯定是 循环数组 中的 对象的 唯一属性
      2 wx:key ="*this"  就表示 你的数组 是一个普通的数组  *this 表示是 循环项 
        [1,2,3,44,5]
        ["1","222","adfdf"]
    3 当出现 数组的嵌套循环的时候 尤其要注意  以下绑定的名称 不要重名
        wx:for-item="item" wx:for-index="index"
    4 默认情况下 我们 不写
       wx:for-item="item" wx:for-index="index"
       小程序也会把 循环项的名称 和 索引的名称 item 和 index 
       只有一层循环的话 （wx:for-item="item" wx:for-index="index"） 可以省略

  9 对象循环
    1 wx:for="{{对象}}" wx:for-item="对象的值"  wx:for-index="对象的属性"
    2 循环对象的时候 最好把 item和index的名称都修改一下
      wx:for-item="value"  wx:for-index="key"

 -->
 <view>
   <view wx:for="{{list}}" wx:for-item="item"
  wx:for-index="index" wx:key="id">
     索引：{{index}}--值:{{item.name}}
   </view>
 </view>

 <view>
   <view>对象循环</view>
   <view wx:for="{{person}}" wx:for-item="value"  
  wx:for-index="key" wx:key="age">
     属性:{{key}}--值:{{value}}
   </view>
 </view>

 <!-- 
   10 block
    1 占位符的标签 
    2 写代码的时候 可以看到这标签存在
    3 页面渲染 小程序会把它移除掉
  -->
  <view>
    <block wx:for="{{list}}" wx:for-item="item"
   wx:for-index="index" wx:key="id"
   class="my_list">
      索引：{{index}} -- 值:{{item.name}}
    </block>
  </view>
```

2. `js`

```js
//Page Object
Page({
    list:[
      {
        id:0,
        name:"猪八戒"
      },
      {
        id:1,
        name:"天蓬元帅"
      },
      {
        id:2,
        name:"悟能"
      }
    ]
});
```

3. 测试

![image-20220316224005616](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220316224005616.png)



### 4.4 条件渲染

> 测试

1. `wxml`

```html
<!-- 
    11 条件渲染
      1 wx:if="{{true/false}}"
        1 if , else , if else
        wx:if
        wx:elif
        wx:else 
      2 hidden 
        1 在标签上直接加入属性 hidden 
        2 hidden="{{true}}"

      3 什么场景下用哪个
        1 当标签不是频繁的切换显示 优先使用 wx:if
          直接把标签从 页面结构给移除掉 
        2 当标签频繁的切换显示的时候 优先使用 hidden
          通过添加样式的方式来切换显示 
          hidden 属性 不要和 样式 display一起使用
   -->
   <view>
     <view>条件渲染</view>
     <view wx:if="{{true}}">显示</view>
     <view wx:if="{{false}}">隐藏</view>

     <view wx:if="{{flase}}">1</view>
     <view wx:elif="{{flase}}">2 </view>
     <view wx:else> 3 </view>

     <view>---------------</view>
     <view hidden>hidden1</view>
     <view hidden="{{false}}" >hidden2</view>

     <view>-----000-------</view>
     <view wx:if="{{false}}">wx:if</view>
     <view hidden  style="display: flex;" >hidden</view>
   </view>
```

2. 测试

![image-20220316223943263](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220316223943263.png)

频繁切换 ⽤ `hidden`

不常使⽤ ⽤ `wx:if`



### 4.5 拓展

> 测试

1. `wxml`

```html
<!-- 
  1 长按文字复制 selectable
  2 对文本内容 进行 解码
 -->
<text selectable decode>
  text &nbsp; 123 &lt;
</text>
```

2. 测试

![image-20220316231006146](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220316231006146.png)



## 5. 逻辑关系JS

> 简述

在组件中绑定事件，在`js`中处理事件和存储数据

* 细节在**小程序生命周期**中细说！！！

> 测试

1. `wxml`

```html
<!-- 
  1 需要给input标签绑定 input事件 
    绑定关键字 bindinput
  2 如何获取 输入框的值 
    通过事件源对象来获取  
    e.detail.value 
  3 把输入框的值 赋值到 data当中
    不能直接 
      1 this.data.num=e.detail.value 
      2 this.num=e.detail.value 
    正确的写法
      this.setData({
        num:e.detail.value 
      })
  4 需要加入一个点击事件 
      1 bindtap
      2 无法在小程序当中的 事件中 直接传参 
      3 通过自定义属性的方式来传递参数
      4 事件源中获取 自定义属性
 -->
<input type="text" bindinput="handleInput" />
<button bindtap="handletap" data-operation="{{1}}" >+</button>
<button bindtap="handletap" data-operation="{{-1}}">-</button>
<view>  
  {{num}}
</view>
```

2. `js`

```js
// pages/demo04/demo04.js
Page({
  data: {
    num: 0
  },
  // 输入框的input事件的执行逻辑
  handleInput(e) {
    // console.log(e.detail.value );
    this.setData({
      num: e.detail.value
    })
  },
  // 加 减 按钮的事件
  handletap(e) {
    // console.log(e);
    // 1 获取自定义属性 operation
    const operation = e.currentTarget.dataset.operation;
    this.setData({
      num: this.data.num + operation
    })
  }
})
```

3. 测试

![image-20220316225049082](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220316225049082.png)

* 实现加法减法器的功能



## 6. 样式列表WXSS

> 简述

WXSS( `WeiXin Style Sheets`)是⼀套样式语⾔，⽤于描述 WXML 的组件样式

与 `CSS` 相比，`WXSS` 扩展的特性有

* 响应式⻓度单位 `rpx` 

* 样式导入



### 6.1 尺寸单位

> 简述

`rpx` （responsive pixel）: 可以根据屏幕宽度进⾏⾃适应。规定屏幕宽为 750rpx 。如在 iPhone6 上，屏幕宽度为 375px ，共有750个物理像素，则 750rpx = 375px = 750物理像 素 ， 1rpx = 0.5px = 1物理像素

| 设备         | `rpx`换算`px`(屏幕宽度/750) | `px`换算`rpx`(750/屏幕宽度) |
| ------------ | --------------------------- | --------------------------- |
| iPhone5      | 1rpx = 0.42px               | 1px = 2.34rpx               |
| iPhone6      | 1rpx = 0.5px                | 1px = 2rpx                  |
| iPhone6 Plus | 1rpx = 0.552px              | 1px = 1.81rpx               |

**建议**： 开发微信⼩程序时设计师可以⽤ iPhone6 作为视觉稿的标准

使⽤步骤：

1. 确定设计稿宽度 `pageWidth`
2. 计算⽐例 `750rpx = pageWidth px` ,因此 `1px=750rpx/pageWidth` 
3. 在less⽂件中，只要把设计稿中的 `px` => `750/pageWidth rpx` 即可。

> 测试

1. `wxml`

```html
<view>
  rpx
</view>
```

2. `wxss`

```css
view{
   /* width: 200rpx; */
   height: 200rpx;
   font-size: 40rpx;
   background-color: aqua;
  /* 以下代码写法是错误  */
  /*  width:750 rpx * 100 / 375 ;  */
  width:calc(750rpx * 100 / 375);
 }
```

3. 测试

![image-20220316225236927](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220316225236927.png)



### 6.2 样式导入

> 测试

1. `demo06.wxss`

```css
/* 
1 引入的 代码 是通过 @import 来引入
2 路径 只能写相对路径
 */
 @import "../../styles/common.wxss";
```

2. `common.wxss`

```css
view{
  color: aqua;
  font-size: 50px;
}
```

3. 测试

![image-20220316230307830](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220316230307830.png)



### 6.3 导入less

> 简述

原生的小程序app不支持less，可以使用vscode

> 测试

1. `wxss`

```css
/* 1 定义less变量 */
text {
  /* 2 使用变量 */
  color: yellow;
}
view .vie1 text {
  color: red;
}
/* 导入 */
view {
  color: green;
}
.main {
  /* 
  1 less中 支持 两种注释  多行  单行
  2 wxss 不能写 单行注释 因为 写了 和没写是一样！！！
   */
  /* font-size: 200px; */
}
```

2. `less`

```less
/* 1 定义less变量 */
@color:yellow;
text{
  /* 2 使用变量 */
  color:@color;
}

view{
  .vie1{
    text{
      color: red;
    }
  }
}

/* 导入 */
@import "../../styles/reset.less";
view{
  color: @themeColor;
}
.main{
  /* 
  1 less中 支持 两种注释  多行  单行
  2 wxss 不能写 单行注释 因为 写了 和没写是一样！！！
   */
  /* font-size: 200px; */
  // font-size: 400px;
}
```

3. `reset.less`

```less
@themeColor:green;
```

4. 测试

![image-20220316230810089](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220316230810089.png)



## 7. 常见组件

### 7.1 [view](https://developers.weixin.qq.com/miniprogram/dev/component/view.html)

> 普通标签

相当于是html中的`div`标签

```html
<view>helloworld</view>
```



### 7.2 [text](https://developers.weixin.qq.com/miniprogram/dev/component/text.html)

> 文本标签

1. ⽂本标签 
2. 只能嵌套text 
3. 长按⽂字可以复制（只有该标签有这个功能） 
4. 可以对空格回车进⾏编码

| 属性名     | 类型    | 默认值 | 说明         |
| ---------- | ------- | ------ | ------------ |
| selectable | Boolean | false  | 文本是否可选 |
| decode     | Boolean | false  | 是否解码     |

```html
<text selectable="{{false}}" decode="{{false}}">
普&nbsp;通
</text>
```



### 7.3 [image](https://developers.weixin.qq.com/miniprogram/dev/component/image.html)

> 图片标签

1. `src` 指定要加载的图片的路径,图片存在默认的宽度和高度 320 * 240 (原图大小是 200 * 100)
2. `mode` 决定 图片内容 如何 和 图片标签 宽高 做适配
   1. `scaleToFill` 默认值 不保持纵横比缩放图片，使图片的宽高完全拉伸至填满 image 元素
   2. `aspectFit` 保持宽高比 确保图片的长边 显示出来   页面轮播（常用）
   3. `aspectFill` 保持纵横比缩放图片，只保证图片的 短 边能完全显示出来（少用）
   4. `widthFix` 以前web的图片的 宽度指定了之后 高度 会自己按比例来调整 （常用）
   5. `bottom` 类似以前的 `background-position`
3. 小程序当中的图片 直接就支持 懒加载  `lazy-load`
   1. `lazy-load` 会自己判断当图片出现在视口上下三屏的高度之内的时候自己开始加载图片

> 测试

1. `wxml`

```html
<image mode="bottom" lazy-load src="https://tva2.sinaimg.cn/large/007DFXDhgy1g51jlzfb4lj305k02s0sp.jpg" />
```

2. `wxss`

```css
image{
  box-sizing: border-box;
  border: 1px solid red;

  width: 300px;
  height: 200px;
}
```

3. 测试

![image-20220317110409392](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317110409392.png)



### 7.4 [swiper](https://developers.weixin.qq.com/miniprogram/dev/component/swiper.html)

> 微信内置轮播图组件

1. 轮播图外层容器 swiper
2. 每一个轮播项 swiper-item
3. swiper标签 存在默认样式
   1. width 100%
   2. height 150px（image 存在默认宽度和高度 320 * 240）
   3. swiper 高度无法实现由内容撑开
4. 先找出来 原图的宽度和高度 等比例 给swiper 定 宽度和高度（原图的宽度和高度  1125 * 352 px）
   * swiper 宽度 / swiper  高度 =  原图的宽度  /  原图的高度
   * swiper  高度  =  swiper 宽度 *  原图的高度 / 原图的宽度
   * height: 100vw * 352 / 1125

| 属性                     | 说明                      |
| ------------------------ | ------------------------- |
| `autoplay`               | 自动轮播                  |
| `interval`               | 修改轮播时间              |
| `circular`               | 衔接轮播                  |
| `indicator-dots`         | 显示 指示器 分页器 索引器 |
| `indicator-color`        | 指示器的未选择的颜色      |
| `indicator-active-color` | 选中的时候的指示器的颜色  |

> 测试

1. `wxml`

```html
<swiper autoplay interval="1000" circular indicator-dots indicator-color="#0094ff" indicator-active-color="#ff0094">
    <swiper-item> <image mode="widthFix" src="//gw.alicdn.com/imgextra/i1/44/O1CN013zKZP11CCByG5bAeF_!!44-0-lubanu.jpg" /> </swiper-item>
    <swiper-item> <image mode="widthFix" src="//aecpm.alicdn.com/simba/img/TB1CWf9KpXXXXbuXpXXSutbFXXX.jpg_q50.jpg" /> </swiper-item>
    <swiper-item> <image mode="widthFix" src="//gw.alicdn.com/imgextra/i2/37/O1CN01syHZxs1C8zCFJj97b_!!37-0-lubanu.jpg" /> </swiper-item>
</swiper>
```

2. `wxss`

```css
/* pages/demo10/demo10.wxss */
swiper {
  width: 100%;
  /* height: calc(100vw * 352 /  1125); */
  height: 31.28vw;
}
image {
  width: 100%;
}
```

3. 测试

![image-20220317112038458](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317112038458.png)



### 7.5 [navigator](https://developers.weixin.qq.com/miniprogram/dev/component/navigator.html)

>导航组件（类似超链接标签）

| 属性名    | 说明                                                         |
| --------- | ------------------------------------------------------------ |
| url       | 要跳转的页面路径（绝对路径/相对路径）                        |
| target    | 要跳转到当前的小程序 还是其他的小程序的页面    1.self 默认值 自己 小程序的页面               2.miniProgram 其他的小程序的页面 |
| open-type | 跳转方式                                                     |

`open-type`有效值：

| 值                 | 说明                                                         |
| ------------------ | ------------------------------------------------------------ |
| navigate（默认值） | 保留当前页面，跳转到应用内的某个页面，但是不能跳到 `tabbar` 页面 |
| redirect           | 关闭当前页面，跳转到应用内的某个页面，但是不允许跳转到 `tabbar` 页面 |
| switchTab          | 跳转到 `tabBar` 页面，并关闭其他所有非 `tabBar` 页面         |
| reLaunch           | 关闭所有页面，打开到应用内的某个页面                         |

> 测试

1. `wxml`

```html
 <navigator url="/pages/demo10/demo10"> 轮播图页面 </navigator>
 <navigator url="/pages/index/index"> 直接跳转到 tabbar页面 </navigator>
 <navigator open-type="redirect" url="/pages/demo10/demo10">  轮播图页面 redirect </navigator>
 <navigator open-type="switchTab" url="/pages/index/index">  switchTab直接跳转到 tabbar页面 </navigator>
 <navigator open-type="reLaunch" url="/pages/index/index">  reLaunch 可以随便跳 </navigator> 
```

2. `测试`

![image-20220317112134318](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317112134318.png)



### 7.6 [rich-text](https://developers.weixin.qq.com/miniprogram/dev/component/rich-text.html)

> 富文本标签

可以将字符串解析成 对应标签，类似 `vue`中 `v-html` 功能

> 测试

1. `wxml`

```html
<!-- 
  rich-text 富文本标签
  1 nodes属性来实现
    1 接收标签字符串 
    2 接收对象数组 
 -->
 <rich-text nodes="{{html}}"></rich-text>
```

2. `js`

```js
// pages/demo12/demo12.js
Page({
  data: {
    // 1 标签字符串 最常用的
    // 2 对象数组
    html:[
      {
        // 1 div标签 name属性来指定
        name:"div",
        // 2 标签上有哪些属性
        attrs:{
          // 标签上的属性 class  style
          class:"my_div",
          style:"color:red;"
        },
        // 3 子节点 children 要接收的数据类型和 nodes第二种渲染方式的数据类型一致 
        children:[
          {
            name:"p",
            attrs:{},
            // 放文本
            children:[
              {
                type:"text",
                text:"hello"
              }
            ]
          }
        ]
      }
    ]
  }
})
```

3. 测试

![image-20220317113157111](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317113157111.png)

### 7.7 [button](https://developers.weixin.qq.com/miniprogram/dev/component/button.html)

> 按钮标签

1. 外观属性

| 属性    | 说明                                                         |
| ------- | ------------------------------------------------------------ |
| size    | 控制按钮的大小                                              1.default 默认大小                                           2.mini 小尺寸 |
| type    | 用来控制按钮的颜色（default 灰色/primary 绿色/warn 红色）    |
| plain   | 按钮是否镂空，背景色透明                                     |
| loading | 文字前显示正在等待图标                                       |

> 测试

1. `wxml`

```html
 <button>默认按钮</button>
 <button size="mini">  mini 默认按钮</button>
 <button type="primary"> primary 按钮</button> 
 <button type="warn"> warn 按钮</button> 
 <button type="warn" plain> plain 按钮</button> 
 <button type="primary" loading> loading 按钮</button> 
```

2. 测试

![image-20220317121535957](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317121535957.png)

> open-type的合法值

* button的拓展功能

| 值             | 说明                                                         |
| -------------- | ------------------------------------------------------------ |
| contact        | 直接打开客服对话功能，需要在微信小程序的后台配置，只能够通过真机调试来打开 |
| share          | 转发当前的小程序到微信朋友中（不能把小程序 分享到朋友圈）    |
| getPhoneNumber | 获取当前用户的手机号码信息，结合一个事件来使用 ，不是企业的小程序账号，没有权限来获取用户的手机号码 |
| getUserInfo    | 获取当前用户的个人信息，可以从bindgetuserinfo回调中获取到用户信息 |
| launchApp      | 打开APP，可以通过app-parameter属性设定向APP传的参数          |
| openSetting    | 打开小程序内置的授权页面                                     |
| feedback       | 打开小程序内置的意见反馈页面（只能够通过真机调试来打开）     |

> 测试

1. `wxml`

```html
<button open-type="contact">contact</button>
<button open-type="share">share</button>
<button open-type="getPhoneNumber" bindgetphonenumber="getPhoneNumber">getPhoneNumber</button>
<button open-type="getUserInfo" bindgetuserinfo="getUserInfo">getUserInfo</button>
<button open-type="launchApp">launchApp</button>
<button open-type="openSetting">openSetting</button>
<button open-type="feedback">feedback</button>
```

2. `js`

```js
// pages/demo13/demo13.js
Page({
  // 获取用户的手机号码信息
  getPhoneNumber(e){
    console.log(e);
  },
  // 获取用户个人信息
  getUserInfo(e){
    console.log(e);
  }
})
```

3. 测试

![image-20220317121550938](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317121550938.png)



### 7.8 [icon](https://developers.weixin.qq.com/miniprogram/dev/component/icon.html)

> 图标标签

| 属性         | 说明     |
| ------------ | -------- |
| type（必填） | 图标类型 |
| size         | 图标大小 |
| color        | 图标颜色 |

> 测试

1. `wxml`

```html
<view class="group">
  <block wx:for="{{iconSize}}">
    <icon type="success" size="{{item}}"/>
  </block>
</view>
<view class="group">
  <block wx:for="{{iconType}}">
    <icon type="{{item}}" size="40"/>
  </block>
</view>
<view class="group">
  <block wx:for="{{iconColor}}">
    <icon type="success" size="40" color="{{item}}"/>
  </block>
</view>
```

2. `js`

```js
Page({
  data: {
    iconSize: [20, 30, 40, 50, 60, 70],
    iconType: [
      'success', 'success_no_circle', 'info', 'warn', 'waiting', 'cancel',
'download', 'search', 'clear'
   ],
    iconColor: [
      'red', 'orange', 'yellow', 'green', 'rgb(0,255,255)', 'blue', 'purple'
   ],
 }
})
```

3. 测试

![image-20220317121330286](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317121330286.png)



### 7.9 [radio](https://developers.weixin.qq.com/miniprogram/dev/component/radio.html)

> 单选框标签

1. radio标签 必须要和父元素 radio-group 来使用
2. value 选中的单选框的值
3. 需要给 radio-group 绑定 change 事件
4. 需要在页面中显示选中的值

> 测试

1. `wxml`

```html
<radio-group bindchange="handleChange">
   <radio color="red" value="male">男</radio>
   <radio color="red" value="female" >女</radio>
 </radio-group>

 <view>您选中的是:{{gender}}</view>
```

2. `js`

```js
// pages/demo15/demo15.js
Page({
  data: {
    gender: ""
  },
  handleChange(e){
    // 1 获取单选框中的值
    let gender=e.detail.value;
    // 2 把值 赋值给 data中的数据
    this.setData({
      // gender:gender
      gender
    })
  }
})
```

3. 测试

![image-20220317113442462](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317113442462.png)



### 7.10 [checkbox](https://developers.weixin.qq.com/miniprogram/dev/component/checkbox.html)

> 复选框

1. 需要搭配 checkbox-group ⼀起使⽤
2. 通过color属性来修改颜色（跟单选框一样）

> 测试

1. `wxml`

```html
<view>
  <checkbox-group bindchange="handleItemChange">
    <checkbox value="{{item.value}}" wx:for="{{list}}" wx:key="id">
      {{item.name}}
    </checkbox>

  </checkbox-group>
  <view>
    选中的水果:{{checkedList}}
  </view>
</view>
```

2. `js`

```js
// pages/demo16/demo16.js
Page({
  data: {
    list:[
      {
        id:0,
        name:"🍎",
        value:"apple"
      },
      {
        id:1,
        name:"🍇",
        value:"grape"
      },
      {
        id:2,
        name:"🍌",
        value:"bananer"
      }
    ],
    checkedList:[]
  },
  // 复选框的选中事件
  handleItemChange(e){
    // 1 获取被选中的复选框的值
    const checkedList=e.detail.value;
    // 2 进行赋值
    this.setData({
      checkedList
    })
  }
})
```

3. 测试

![image-20220317113532479](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317113532479.png)



## 8. [自定义组件](https://developers.weixin.qq.com/miniprogram/dev/framework/custom-component/)

### 8.1 创建自定义组件

> 简述

一个自定义组件由 `json` `wxml` `wxss` `js` 4个文件组成

![image-20220317163013452](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317163013452.png)

> 测试（组件端）

1. `Tabs.json`

⾸先需要在组件的 `json` ⽂件中进⾏⾃定义组件声明

```json
{
  "component": true,
}
```

2. `Tabs.wxml`

在组件的 `wxml` ⽂件中编写组件模板，在 `wxss` ⽂件中加⼊组件样式

```html
<!-- 这是自定义组件的内部WXML结构 -->
<view class="tabs">
  <view class="tabs_title">
    <!-- <view class="title_item active">首页</view>
    <view class="title_item">原创</view>
    <view class="title_item">分类</view>
    <view class="title_item">关于</view> -->
    <view wx:for="{{tabs}}" wx:key="id"
    class="title_item {{item.isActive?'active':''}}"
    bindtap="hanldeItemTap" data-index="{{index}}">
    {{item.name}}
 	 </view>
  </view>
  <view class="tabs_content">
    <!-- 
      slot 标签 其实就是一个占位符 插槽
      等到 父组件调用 子组件的时候 再传递 标签过来 最终 这些被传递的标签
      就会替换 slot 插槽的位置 
     -->
    <slot></slot>
  </view>
</view>
```

3. `Tabs.wxss`

* 在组件`wxss`中不应使用ID选择器、属性选择器和标签名选择器

```css
.tabs{}
.tabs_title{
  display: flex;
  padding: 10rpx 0;
}
.title_item{
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
}
.active{
  color:red;
  border-bottom: 5rpx solid currentColor;
}
.tabs_content{}
```



### 8.2 声明引入自定义组件

> 简述

在页面的 `json` 文件中进行引用声明

* page包下的页面文件

![image-20220317163947454](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317163947454.png)

> 测试（页面端）

1. `json`

```json
{
  "usingComponents": {
    "Tabs":"../../components/Tabs/Tabs"
  }
}
```

2. `js`

```js
// pages/demo17/demo18.js
Page({
  /**
   * 页面的初始数据
   */
  data: {
    tabs: [
      {
        id: 0,
        name: "首页",
        isActive: true
      },
      {
        id: 1,
        name: "原创",
        isActive: false
      }
      ,
      {
        id: 2,
        name: "分类",
        isActive: false
      }
      ,
      {
        id: 3,
        name: "关于",
        isActive: false
      }
    ]

  },

  // 自定义事件 用来接收子组件传递的数据的
  handleItemChange(e) {
    // 接收传递过来的参数
    const { index } = e.detail;
    let { tabs } = this.data;
    tabs.forEach((v, i) => i === index ? v.isActive = true : v.isActive = false);
    this.setData({
      tabs
    })
  }
})
```

3. `wxml`

```html
<!-- 
  1 父组件(页面) 向子组件 传递数据 通过 标签属性的方式来传递
    1 在子组件上进行接收
    2 把这个数据当成是data中的数据直接用即可
  2 子向父传递数据 通过事件的方式传递
    1 在子组件的标签上加入一个自定义事件
 -->
<Tabs tabs="{{tabs}}" binditemChange="handleItemChange" >

<block wx:if="{{tabs[0].isActive}}">0 </block>
<block wx:elif="{{tabs[1].isActive}}">1 </block>
<block wx:elif="{{tabs[2].isActive}}">2 </block>
<block wx:else>3</block>
 
</Tabs>
```

4. 测试

![image-20220317164539320](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317164539320.png)

![image-20220317164547758](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317164547758.png)

![image-20220317164559411](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317164559411.png)

![image-20220317164608798](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317164608798.png)



### 8.3 自定义父子组件

> 简述

流程：

* 父组件通过**属性**给子组件传递参数
* 子组件通过**事件**给父组件传递参数

> 测试

1. 父组件把数据 `{{tabs}}` 传递到 ⼦组件的 `tabItems` 属性中 
2. 父组件 监听 `onMyTab` 事件 
3. 子组件 触发 `bindmytap` 中的 `mytap` 事件 
   1. ⾃定义组件触发事件时，需要使用`triggerEvent` 方法，指定`事件名`、`detail` 对象
4. 父->子 动态传值 `this.selectComponent("#tabs");`

**父组件代码**

```html
<!--page.wxml-->
<tabs tabItems="{{tabs}}" bindmytap="onMyTab" >
 内容-这里可以放插槽
</tabs>
```

```js
//page.js
  data: {
    tabs:[
     {name:"体验问题"},
     {name:"商品、商家投诉"}
   ]
 },
  onMyTab(e){
    console.log(e.detail);
 },
```

**子组件代码**

```html
<!--com.wxml-->
<view class="tabs">
  <view class="tab_title"  >
    <block  wx:for="{{tabItems}}" wx:key="{{item}}">
      <view bindtap="handleItemActive" data-index="{{index}}">{{item.name}}</view>
    </block>
  </view>
  <view class="tab_content">
    <slot></slot>
  </view>
</view>
```

```js
//com.js
Component({
  properties: {
    tabItems:{
      type:Array,
      value:[]
   }
 },
  /**
   * 组件的初始数据
   */
  data: {
 },
  /**
   * 组件的方法列表
   */
  methods: {
    handleItemActive(e){
      this.triggerEvent('mytap','haha');
   }
 }
})
```



## 9. 小程序生命周期

> 简述

分为**应用生命周期**和**页面生命周期**

### 9.1 [应用生命周期](https://developers.weixin.qq.com/miniprogram/dev/reference/api/App.html)

| 属性                                                         | 类型     | 必填 | 说明                   |
| ------------------------------------------------------------ | -------- | ---- | ---------------------- |
| [`onLaunch`](https://developers.weixin.qq.com/miniprogram/dev/reference/api/App.html#onlaunchobject-object) | function | 否   | 监听小程序初始化       |
| [`onShow`](https://developers.weixin.qq.com/miniprogram/dev/reference/api/App.html#onshowobject-object) | function | 否   | 监听小程序启动或切前台 |
| [`onHide`](https://developers.weixin.qq.com/miniprogram/dev/reference/api/App.html#onhide) | function | 否   | 监听小程序切后台       |
| [`onError`](https://developers.weixin.qq.com/miniprogram/dev/reference/api/App.html#onerrorstring-error) | function | 否   | 错误监听函数           |
| [`onPageNotFound`](https://developers.weixin.qq.com/miniprogram/dev/reference/api/App.html#onpagenotfoundobject-object) | function | 否   | 页面不存在监听函数     |

> 测试

1. app.js(应用`js`程序)

```js
//app.js
App({
  //  1、应用第一次启动的就会触发的事件  
  onLaunch() {
    //  在应用第一次启动的时候 获取用户的个人信息 
    // console.log("onLaunch");
    // aabbcc

    // js的方式来跳转 不能触发 onPageNotFound
    // wx.navigateTo({
    //   url: '/11/22/33'
    // });
  },
    
  // 2、应用 被用户看到 
  onShow(){
    // 对应用的数据或者页面效果 重置 
    // console.log("onShow");
  },
    
  // 3、应用 被隐藏了 
  onHide(){
    // 暂停或者清除定时器 
    // console.log("Hide");
  },
    
  // 4、应用的代码发生了报错的时候 就会触发
  onError(err){
    // 在应用发生代码报错的时候，收集用户的错误信息，通过异步请求 将错误的信息发送后台去
    // console.log("onError");
    // console.log(err);
  },
    
  // 5、页面找不到就会触发 
  //  应用第一次启动的时候，如果找不到第一个入口页面 才会触发
  onPageNotFound(){
    // 如果页面不存在了 通过js的方式来重新跳转页面 重新跳到第二个首页
    // 不能跳到tabbar页面  导航组件类似  
    wx.navigateTo({
      url: '/pages/demo09/demo09' 
    });  
    // console.log("onPageNotFound");
  }
})
```



### 9.2 [页面生命周期](https://developers.weixin.qq.com/miniprogram/dev/reference/api/Page.html)

| 属性                | 类型     | 说明                              |
| ------------------- | -------- | --------------------------------- |
| `data`              | Object   | 页面初始数据                      |
| `onLoad`            | function | 生命周期回调—监听页面加载         |
| `onShow`            | function | 生命周期回调—监听页面显示         |
| `onReady`           | function | 生命周期回调—监听页面初次渲染完成 |
| `onHide`            | function | 生命周期回调—监听页面隐藏         |
| `onUnload`          | function | 生命周期回调—监听页面卸载         |
| `onPullDownRefresh` | function | 监听用户下拉动作                  |
| `onReachBottom`     | function | 页面上拉触底事件                  |
| `onShareAppMessage` | function | 用户点击右上角转发                |
| `onPageScroll`      | function | 页面滚动触发事件的处理函数        |
| `onResize`          | function | 页面尺寸改变时触发                |
| `onTabItemTap`      | function | 当前页面是tab页时，点击tab时触发  |

> 测试

1. `json`

* 手机支持旋转配置

```json
{
    "pageOrientation": "auto"
}
```

2. `js`（*）

* 对应上述页面生命周期中的属性

```js
Page({

  /**
   *1、 页面的初始数据
   */
  data: {

  },

  /**
   * 2、生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("onLoad");
    // onLoad发送异步请求来初始化页面数据 
  },
  /**
   * 3、生命周期函数--监听页面显示
   */
  onShow: function () {
    console.log("onShow");
  },
  /**
    * 4、生命周期函数--监听页面初次渲染完成
    */
  onReady: function () {
    console.log("onReady");
  },
  /**
   * 5、生命周期函数--监听页面隐藏
   */
  onHide: function () {
    console.log("onHide");
  },

  /**
   * 6、生命周期函数--监听页面卸载 也是可以通过点击超链接来演示 
   * 
   */
  onUnload: function () {
    console.log("onUnload");
  },

  /**
   * 7、页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    console.log("onPullDownRefresh");
    // 页面的数据 或者效果 重新 刷新
  },

  /**
   * 8、页面上拉触底事件的处理函数
   * 需要让页面 出现上下滚动才行 
   */
  onReachBottom: function () {
    console.log("onReachBottom");
    // 上拉加载下一页数据 
  },

  /**
   * 9、用户点击右上角分享
   */
  onShareAppMessage: function () {
    console.log("onShareAppMessage");
  },
  /**
   * 10、页面滚动 就可以触发 
   */
  onPageScroll(){
    console.log("onPageScroll");
  },
  /**
   * 11、页面的尺寸发生改变的时候 触发
   * 小程序 发生了 横屏竖屏 切换的时候触发 
   */
  onResize(){
    console.log("onResize");
  },
  /**
   * 12、
   * 1 必须要求当前页面 也是tabbar页面
   * 2 点击的自己的tab item的时候才触发
   */
  onTabItemTap(){
    console.log("onTabItemTap");
  }
})
```

3. `wxml`

```html
<!--pages/demo18/demo18.wxml-->
<navigator url="/pages/demo17/demo17" open-type="navigate">
  跳转到demo17
</navigator>

<navigator url="/pages/demo17/demo17" open-type="redirect">
  重定向到demo17(redirect)
</navigator>
```

4. 测试

* 组件端的测试

![image-20220317173020613](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317173020613.png)

* 打开“调试器”，对上述12种属性进行测试（下面只是部分测试）

![image-20220317173137212](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317173137212.png)



### 9.3 页面生命周期图解

![image-20220317173218482](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220317173218482.png)

