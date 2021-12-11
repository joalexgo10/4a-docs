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

    <form @submit.prevent="actualizaconDeProveedor">
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
        Actualizar
      </button>
    </form>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'ActualizacionProveedor',

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
  methods: {
    actualizaconDeProveedor: function () {
      console.log(this.proveedor)
      axios.put('https://db-aplicacion-web.herokuapp.com/actualizar/200/', this.proveedor)
        .then((result) => {
          console.log(this.proveedor)
          console.log(result)
        })
    }
  }
}
</script>

<style scoped>

</style>
