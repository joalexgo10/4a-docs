<template>
  <div>
    <h1>Creacion Nuevo Proveedor</h1>
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
        style="box-sizing: border-box; padding: 10px 20px; margin: 5px 0; border: 1px solid #283747;"
      >
      <br>

      <input
        v-model="proveedor.proveedor_Telefono"
        type="num"
        placeholder="Telefono"
        style="box-sizing: border-box; padding: 10px 20px; margin: 5px 0; border: 1px solid #283747;"
      >
      <br>

      <input
        v-model="proveedor.proveedor_Direccion"

        type="text"
        placeholder="Direccion"
        style="box-sizing: border-box; padding: 10px 20px; margin: 5px 0; border: 1px solid #283747;"
      >
      <br>

      <input
        v-model="proveedor.proveedor_Email"
        type="text"
        placeholder="e-mail"
        style="box-sizing: border-box; padding: 10px 20px; margin: 5px 0; border: 1px solid #283747;"
      >
      <br>

      <input
        v-model="proveedor.proveedor_Nit"

        type="text"
        placeholder="NIT"

        style="box-sizing: border-box; padding: 10px 20px; margin: 5px 0; border: 1px solid #283747;"
      >
      <br>

      <button
        type="submit"
        style="color: #E5E7E9; background: #283747; border-radius: 5px; padding: 10px 25px; margin: 5px 0 25px 0"
      >
        Crear
      </button>
    </form>
  </div>
</template>

<script>
import axios from 'axios'

import swal from 'sweetalert'
import { mapState } from 'vuex'
export default {
  name: 'CreacionNuevosProveedores',

  data: function () {
    return {
      proveedor: {
        proveedor_Name: '',

        proveedor_Telefono: '',

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
          
        },
        swal('El proveedor se creó exitosamente!', '', 'success')
        )
      this.proveedor = ''
    }
  }
}
</script>

<style>
  .h1 {
    color: #283747;
  }

</style>
