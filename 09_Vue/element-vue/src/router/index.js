//导入vue
import Vue from 'vue';
import VueRouter from 'vue-router';
//导入组件
import Main from "../views/Main";
import Login from "../views/Login";
//导入子模块
import UserList from "../views/user/List";
import UserProfile from "../views/user/Profile";
import NotFound from '../views/NotFound';

//使用
Vue.use(VueRouter);
//导出
export default new VueRouter({
  mode:'history',
  routes: [
    {
      //登录页
      path: '/main',
      component: Main,
      props:true,
      //  写入子模块
      children: [
        {
          path: '/user/profile/:id',
          name:'UserProfile',
          component: UserProfile,
          props: true
        }, {
          path: '/user/list',
          component: UserList,
        },
      ]
    },
    //首页
    {
      path: '/login',
      component: Login
    },
    //重定向
    {
      path: '/main',
      name: 'Main',
      component: Main
    },
    {
      path: '/goHome',
      redirect: '/main'
    },
    {
      path: '*',
      component: NotFound
    }
  ]
})
