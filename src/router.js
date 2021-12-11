import { createRouter, createWebHistory } from "vue-router";
import App from './App.vue';

import LogIn from './components/LogIn.vue'
import SignUp from './components/SignUp.vue'
import Home from './components/Home.vue'
import Account from './components/Account.vue'
import CreacionProveedores from './components/CreacionProveedores.vue'
import ConsultaProoveedores from './components/ConsultaProoveedores.vue'
import FormActualizaProveedores from './components/FormActualizaProveedores.vue'
import FormActualizaMateriasPrimas from './components/FormActualizarMateriasPrimas.vue'
import ConsultaMateriasPrimas from './components/ConsultaMateriasPrimas.vue'
import CreacionMateriasPrimas from './components/CreacionMateriasPrimas.vue'


const routes = [{
        path: '/',
        name: 'root',
        component: App
    },
    {
        path: '/user/logIn',
        name: "logIn",
        component: LogIn
    },
    {
        path: '/user/signUp',
        name: "signUp",
        component: SignUp
    },
    {
        path: '/user/home',
        name: "home",
        component: Home
    },
    {
        path: '/user/account',
        name: "account",
        component: Account
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
        path: '/FormActualizaProveedores',
        name: 'FormActualizaProveedores',
        component: FormActualizaProveedores
      },

      {
        path: '/creacionMateriasPrimas',
        name: 'CreacionMateriasPrimas',
        component: CreacionMateriasPrimas
      },

      {
        path: '/consultaMateriasPrimas',
        name: 'ConsultaMateriasPrimas',
        component: ConsultaMateriasPrimas
      },

      {
        path: '/FormActualizarMateriasPrimas',
        name: 'FormActualizarMateriasPrimas',
        component: FormActualizaMateriasPrimas
      }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;