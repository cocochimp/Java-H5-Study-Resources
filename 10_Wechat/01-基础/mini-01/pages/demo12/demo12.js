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