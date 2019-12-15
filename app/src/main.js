import Vue from 'vue/dist/vue.js'
import App from './App.vue'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'bootstrap/dist/css/bootstrap.css'
import BootstrapVue from 'bootstrap-vue'
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome'
import {library} from '@fortawesome/fontawesome-svg-core'
import {fas} from '@fortawesome/free-solid-svg-icons'
import Router from 'vue-router'
import IndexCliente from './views/cliente/index.vue'
import InputCliente from './views/cliente/input-cliente.vue'

Vue.use(Router);

const router = new Router({
  mode: 'history',
  base: '/',
  routes: [
    { path: '/cliente', name: 'clientes-index', component: IndexCliente},
    { path: '/cliente/new', name: 'clientes-new', component: InputCliente},
    { path: '/cliente/:_id/show', name: 'clientes-show', component: InputCliente},
    { path: '/cliente/:_id/edit', name: 'clientes-edit', component: InputCliente}
  ]
});

Vue.use(BootstrapVue)
Vue.component('font-awesome-icon', FontAwesomeIcon)
library.add(fas)

new Vue({
  router, render: h => h(App)
}).$mount('#app')