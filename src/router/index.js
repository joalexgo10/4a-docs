import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'
import CreacionProveedores from '../components/CreacionProveedores.vue'
import ConsultaProoveedores from '@/components/ConsultaProoveedores.vue'
import ActualizacionProveedor from '@/components/ActualizacionProveedor.vue'
import FormActualizaProveedores from '@/components/FormActualizaProveedores.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/creacionProveedores',
    name: 'CreacionProveedores',
    component: CreacionProveedores
  },
  {
    path: '/consultaProveedores',
    name: 'ConsultaProveedores',
    component: ConsultaProoveedores
  },
  {
    path: '/ActualizacionProveedor',
    name: 'ActualizacionProveedor',
    component: ActualizacionProveedor
  },
  {
    path: '/FormActualizaProveedores',
    name: 'FormActualizaProveedores',
    component: FormActualizaProveedores
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
