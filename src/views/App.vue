<template>
  <head>
    <meta charset="utf-8">
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, shrink-to-fit=no"
    >
    <title>Untitled</title>
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
  </head>
  <div
    class="bg-image"
    style="background-image: url('https://i.imgur.com/1gxor8j.jpeg'); height: 225px;"
  >
    <h1>     ­   </h1>
    <h1 style="color: var(--bs-red);font-size: 70px">
      WOODSTOCK
    </h1>
    <div
      data-bss-parallax-bg="true"
      style="height: 600px;background-image: url(https://fondosmil.com/fondo/27751.jpg);background-position: center;background-size: cover;"
    >
      <div id="nav">
        <router-link to="/">
          <v-btn
            type="button"
            class="btn btn-success"
          >
            Inicio
          </v-btn>
        </router-link> |
        <router-link to="/CreacionProveedores">
          <v-btn
            type="button"
            class="btn btn-success"
          >
            Proveedores
          </v-btn>
        </router-link> |

        <router-link to="/ConsultaProveedores">
          <v-btn
            type="button"
            class="btn btn-success"
          >
            Consulta
          </v-btn>
        </router-link> |
        <router-link to="/FormActualizaProveedores">
          <v-btn
            type="button"
            class="btn btn-success"
          >
            Actualizacion
          </v-btn>
        </router-link>
      </div>
    </div>
  </div>
  <router-view />
</template>

<script>
// import 'bootstrap/dist/css/bootstrap.min.css';
export default {

}
</script>

<style>
main {
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
