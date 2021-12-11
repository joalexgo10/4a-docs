<template>
  <div>
    <h1>Andres Santos</h1>
    <!-- <button
      type="button"
      class="btn btn-primary"
      @click="creacionDeProveedor"
    >
      Primary
    </button> -->

    <form @submit.prevent="creacionDeProveedor">
      <input
        v-model="proveedor.proveedor_Name"
        type="text"
        placeholder="Nombre"
      >
      <br>
      <input
        v-model="proveedor.proveedor_Telefono"
        type="num"
        placeholder="Telefono"
      >
      <br>
      <input
        v-model="proveedor.proveedor_Direccion"
        type="text"
        placeholder="Direccion"
      >
      <br>
      <input
        v-model="proveedor.proveedor_Email"
        type="text"
        placeholder="e-mail"
      >
      <br>
      <input
        v-model="proveedor.proveedor_Nit"
        type="text"
        placeholder="NIT"
      >
      <br>
      <button type="submit">
        Crear
      </button>
    </form>

    <h2>{{ proveedorStore }}</h2>
  </div>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'
export default {
  name: 'CreacionNuevosProveedores',

  data: function () {
    return {
      proveedor: {
        proveedor_Name: '',
        proveedor_Telefono: 0,
        proveedor_Direccion: '',
        proveedor_Email: '',
        proveedor_Nit: ''
      }
    }
  },
  computed: {
    ...mapState(['proveedorStore'])
  },
  mounted () {

  },
  methods: {
    creacionDeProveedor: function () {
      axios.post('https://db-aplicacion-web.herokuapp.com/proveedores/', this.proveedor, { headers: {} })
        .then((result) => {
          console.log(result)
        })
    }
  }
}
</script>

<style scoped>

</style>
