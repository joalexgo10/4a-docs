<template>
  <!-- <head>
    <meta charset="utf-8">
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, shrink-to-fit=no"
    >

    <link
      rel="stylesheet"
      href="assets/bootstrap/css/bootstrap.min.css"
    >
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css"
    >
    <link
      rel="stylesheet"
      href="assets/css/styles.css"
    >
    <link
      rel="stylesheet"
      href="../css/mdb.min.css"
    >
  </head> -->
  <div
    class="bg-image"
    style="background-image: url('https://i.imgur.com/1gxor8j.jpeg'); height: 225px;"
  >
    <h1 style="color: var(--bs-red);font-size: 75px">
      STOCKWOOD
    </h1>
    <h1 style="color: var(--bs-black);font-size: 25px">
      INVENTORY AND DATA MANAGEMENT
    </h1>
    <div
      data-bss-parallax-bg="true"
      style="height: 600px;background-image: url(https://fondosmil.com/fondo/27751.jpg);background-position: center;background-size: cover;"
    >
      <div id="nav">
        | <router-link to="/user/logIn">
          <v-btn
            type="button"
            class="btn btn-success"
          >
            Iniciar Sesión
          </v-btn>
        </router-link> |
        <router-link to="/user/signUp">
          <v-btn
            type="button"
            class="btn btn-success"
          >
            Registrarse
          </v-btn>
        </router-link> |

        <router-link to="/creacionProveedores">
          <v-btn
            type="button"
            class="btn btn-success"
          >
            Creación de Proveedores
          </v-btn>
        </router-link>  |
        <router-link to="/consultaProveedores">
          <v-btn
            type="button"
            class="btn btn-success"
          >
            Consulta de Proveedores
          </v-btn>
        </router-link> |
        <router-link to="/creacionMateriasPrimas">
          <v-btn
            type="button"
            class="btn btn-success"
          >
            Creación de Materias Primas
          </v-btn>
        </router-link> |
        <router-link to="/consultaMateriasPrimas">
          <v-btn
            type="button"
            class="btn btn-success"
          >
            Consulta de Materias Primas
          </v-btn>
        </router-link> |

        <v-btn
          type="button"
          class="btn btn-success"
          @click="logOut"
        >
          Cerrar sesion
        </v-btn>
      </div>
    </div>
  </div>

  <div>
    <router-view
      @completedSignUp="completedSignUp"
      @completedLogIn="completedLogIn"
    />
  </div>
</template>

<script>
// import 'bootstrap/dist/css/bootstrap.min.css';
import jwt_decode from 'jwt-decode'
export default {
  name: 'App',

  computed: {
    is_auth: {
      get: function () {
        return this.$route.meta.requiresAuth
      },
      set: function () { }
    }
  },

  methods: {

    loadLogIn: function () {
      this.$router.push({ name: 'logIn' })
    },

    loadSignUp: function () {
      this.$router.push({ name: 'signUp' })
    },

    completedLogIn: function (data) {
      localStorage.setItem('username', data.username)
      localStorage.setItem('token_access', data.token_access)
      localStorage.setItem('token_refresh', data.token_refresh)
      localStorage.setItem('userId', jwt_decode(data.token_refresh).user_id)
      alert('Autenticación Exitosa')
      this.loadHome()
    },

    completedSignUp: function (data) {
      alert('Registro Exitoso')
      this.completedLogIn(data)
    },

    loadHome: function () { // Pendiente de ser eliminado
      this.$router.push({ name: 'home' })
    },

    loadAccount: function () { // Pendiente de ser eliminado
      this.$router.push({ name: 'account' })
    },

    loadTransaction: function () {
      this.$router.push({ name: 'transaction' })
    },

    logOut: function () {
      localStorage.clear()
      alert('Sesión Cerrada')
      this.loadLogIn()
    }
  }
}

</script>

<style>
body {
 background-image: url('./assets/img/madera1.jpg')

}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
