import Vue from 'vue'
import Router from 'vue-router'
import InputCliente from '@/components/input-cliente'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/cliente',
      name: 'Clientes',
      component: InputCliente
    }
  ]
})
