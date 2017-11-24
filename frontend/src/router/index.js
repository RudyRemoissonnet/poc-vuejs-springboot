import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Heroes from '@/components/Heroes'
import Details from '@/components/Details'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/heroes',
      name: 'Heroes',
      component: Heroes
    },
    {
      path: '/details/:id',
      name: 'Details',
      component: Details
    }
  ]
})
