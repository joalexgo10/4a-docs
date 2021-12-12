<template>
  <div>
    <h1 style="color: var(--bs-light);font-size: 30px">
      Actualización De Proveedor
    </h1>

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
        ACTUALIZAR
      </button>
    </form>

    <h2>{{ proveedorStore.proveedorId }}</h2>
  </div>
</template>

<script>
import axios from 'axios'
import swal from 'sweetalert'
import { mapState } from 'vuex'
export default {
  name: 'FormActualizarMateriasPrimas',

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
          console.log(this.proveedorStore)
          this.proveedorStore = {}
          console.log(this.proveedorStore)
        },
        swal('El proveedor se actualizó exitosamente!', '', 'success'),
        this.$router.push({ name: 'ConsultaProveedores' }))
    }
  }
}
</script>

<style scoped>
</style>
