<template>
  <div>
    <h1>Andres Santos</h1>

    <form @submit.prevent="editar(proveedorStore.proveedorId)">
      <input
        v-model="proveedorStore.proveedor_Name"
        type="text"
        placeholder="Nombre"
      >
      <br>
      <input
        v-model="proveedorStore.proveedor_Telefono"
        type="num"
        placeholder="Telefono"
      >
      <br>
      <input
        v-model="proveedorStore.proveedor_Direccion"
        type="text"
        placeholder="Direccion"
      >
      <br>
      <input
        v-model="proveedorStore.proveedor_Email"
        type="text"
        placeholder="e-mail"
      >
      <br>
      <input
        v-model="proveedorStore.proveedor_Nit"
        type="text"
        placeholder="NIT"
      >
      <br>
      <button type="submit">
        Actualizar
      </button>
    </form>

    <h2>{{ proveedorStore.proveedorId }}</h2>
  </div>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'
export default {
  name: 'FormActualizaProveedores',

  data: function () {
    return {}
  },
  computed: {
    ...mapState(['proveedorStore'])
  },
  mounted () {},
  methods: {
    editar: function (idCambio) {
      axios.put('https://db-aplicacion-web.herokuapp.com/actualizar/' + idCambio + '/', this.proveedorStore)
        .then((result) => {
          console.log(result)
        },
        this.$router.push({ name: 'ConsultaProveedores' }))
    }
  }
}
</script>

<style scoped>
</style>
