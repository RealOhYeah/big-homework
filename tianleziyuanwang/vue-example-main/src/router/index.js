/**
 * 杨易达
 * @email: y51288033@outlook.com
 *         y51288033@gmail.com
 */
import Vue from 'vue'
import Router from 'vue-router'
import VueCookie from 'vue-cookie'
Vue.use(Router)

//主入口路由
const mainRouters =
  [
    // {
    // path: '/',
    // name: 'HelloWorld',
    // component: resolve=>(require(["@/components/HelloWorld"],resolve))
    // },
    {
      path: '/userindex',
      name: 'userindex',
      component: resolve => (require(["@/view/modules/user/index"], resolve))
    },
    {
      path: '/blogindex',
      name: 'blogindex',
      component: resolve => (require(["@/view/modules/blog/index"], resolve))
    },
    {
      path: "/",
      name: "auth",
      component: resolve => (require(["@/view/modules/auth/index"], resolve)),
      children: [ // 嵌套子路由
        {
          path: '/',
          component: resolve => (require(["@/view/modules/auth/component/login"], resolve))
        },
        {
          path: 'carouselLogin',
          component: resolve => (require(["@/view/modules/auth/component/carouselLogin"], resolve))
        },
        {
          path: 'fileLogin',
          component: resolve => (require(["@/view/modules/auth/component/fileLogin"], resolve))
        },
      ],
    },
    // {
    //   path: "/carouselLogin",
    //   name: "carouselLogin",
    //   component: resolve=>(require(["@/view/modules/auth/component/carouselLogin"],resolve))
    // },
    // {
    //   path: "/fileLogin",
    //   name: "fileLogin",
    //   component: resolve=>(require(["@/view/modules/auth/component/fileLogin"],resolve))
    // },
    {
      path: "/file",
      name: "file",
      component: resolve => (require(["@/view/modules/file/index"], resolve))
    },
    {
      path: "/show1/:id",
      name: "carousel_screen1",
      component: resolve => (require(["@/view/modules/carouselScreen/index"], resolve))
    },
    {
      path: "/show2/:id",
      name: "carousel_screen2",
      props: true,
      component: resolve => (require(["@/view/modules/carouselScreen/index2"], resolve))
    }, 
    {
      path: "/show3/:id",
      name: "carousel_screen3",
      props: true,
      component: resolve => (require(["@/view/modules/carouselScreen/index3"], resolve))
    }, 
    {
      path: "/show4/:id",
      name: "carousel_screen4",
      props: true,
      component: resolve => (require(["@/view/modules/carouselScreen/index4"], resolve))
    }, 
    {
      path: "/carousel",
      name: "carousel",
      component: resolve => (require(["@/view/modules/carousel/index"], resolve))
    },
    {
      name: "carouselFile",
      path: '/carouselFile/:id',
      component: resolve => (require(["@/view/modules/carouselFile/index"], resolve)),
      props: true
    },
    {
      name: "channels",
      path: '/channels',
      component: resolve => (require(["@/view/modules/channels/index"], resolve)),
      props: true
    },
    {
      name: "channelsFile",
      path: '/channelsFile/:id',
      component: resolve => (require(["@/view/modules/channelsFile/index"], resolve)),
      props: true
    },
    {
      name: "channelsFile",
      path: '/channelsFile/:id',
      component: resolve => (require(["@/view/modules/channelsFile/index"], resolve)),
      props: true
    },
    {
      path: "/allpublicfile",
      name: "allpublicfile",
      component: resolve => (require(["@/view/modules/allpublicfile/index"], resolve))
    },
  ]

const router = new Router({
  mode: "hash",
  routes: mainRouters,
})

/**
 * 路由前置环绕
 * 可以做的事情，比如做单点登入，或者查看用户是否有权限访问此页面
 * @param to    去哪个页面来
 * @param from  从哪个页面来
 * @param next  如果放行则是next(),跳转其他的next();
 */
router.beforeEach((to, from, next) => {
  const token = VueCookie.get('token');
  const type = VueCookie.get('logintype');

 

  // 如果用户已登录（拥有token）  
  if (token) {
    // 如果用户试图访问登录页面，则重定向到对应的首页  
    if (to.path === '/carouselLogin' || to.path === '/fileLogin') {
      if (type === 'carouselLogin') {
        next('/carousel'); // carousel 登录方式对应的首页  
      } else if (type === 'fileLogin') {
        next('/channels'); // file 登录方式对应的首页  
      } else {
        // 如果没有设置 type 或 type 不匹配任何登录方式，重定向到默认首页  
        next('/carousel');
      }
    } else {
      // 如果用户已登录且不是访问登录页面，则继续导航  
      next();
    }
  } else {
    // 用户未登录    
    if (to.path !== '/carouselLogin' && to.path !== '/fileLogin') {
      // 逻辑与 (&&) 表示：只有当to.path同时不等于这两个值时，才进入if块  
      if (type === 'fileLogin') {
        console.log('1111');
        next('/fileLogin'); // 如果type是fileLogin，重定向到/fileLogin  
      } else {
        // 如果没有设置type或type不匹配任何登录方式，重定向到默认登录页面  
        console.log('22222');
        next('/carouselLogin'); // 重定向到/carouselLogin  
      }
      // 注意：next()的调用应该在if块内，以确保不会无限循环  
    } else {
      // 如果用户尝试访问登录页面，则允许继续导航  
      next();
    }

  }
})


/**
 * 路由后置环绕
 * @param to    去哪个页面来
 * @param from  从哪个页面来
 */
router.afterEach(async (to, from) => {
  // console.log("router后置环绕");
})


export default router