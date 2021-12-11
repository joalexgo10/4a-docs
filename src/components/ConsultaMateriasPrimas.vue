<template>
  <div>
    <h1>Consulta de Proveedores</h1>
    <button
      type="button"
      class="submit"
      @click="consultaProveedores"
      style="color: #E5E7E9; background: #283747; border-radius: 5px; padding: 10px 25px; margin: 5px 0 25px 0"
    >
      CONSULTAR
    </button>

    <div
      v-for="(proveedor, index) of proveedores"
      :key="index"
      class="mt-3"
    >
      <div
        class="alert alert-primary"
        role="alert"
      >
        <div class="d-flex justify-content-between align-items-center">
          <div>
            Nombre: {{ proveedor.proveedorId }}-{{ proveedor.proveedor_Name }} <br>
            Telefono: {{ proveedor.proveedor_Telefono }} <br>
            Direccion: {{ proveedor.proveedor_Direccion }} <br>
          </div>
          <div>
            <button
              class="btn btn-success btn-sm"
              @click=" definirProveedorStore(proveedor); editarProveedor();"
            >
              Editar
            </button>
            <button class="btn btn-danger btn-sm" @click=" eliminar(proveedor.proveedorId); consultaProveedores;">
              Eliminar
             </button>
             </div>
        </div>
      </div>
    </div>

    <!-- <p>{{ proveedores }}</p> -->
  </div>
</template>

<script>
import axios from 'axios'
import swal from 'sweetalert'
import { mapMutations } from 'vuex'
export default {
  name: 'ConsultaMateriasPrimas',

  data: function () {
    return {
      proveedores: {}
    }
  },
  methods: {
    ...mapMutations(['definirProveedorStore']),
    consultaProveedores: function () {
      axios
        .get('https://db-aplicacion-web.herokuapp.com/proveedores/', {
          headers: {}
        })
        .then((result) => {
          this.proveedores = result.data
        })
    },
    eliminar: function (idCambio) {
      axios.delete('https://db-aplicacion-web.herokuapp.com/actualizar/' + idCambio + '/', this.proveedorStore)
        .then((result) => {
          console.log(result)
          console.log(idCambio)
          location.reload()
        },
        swal('El proveedor se eliminó exitosamente!', '', 'success'),
        this.$router.push({ name: 'ConsultaProveedores' }))
    },
    editarProveedor: function () {
      this.$router.push({ name: 'FormActualizarProveedores' })
    }
  }
}
</script>

<style>

  .h1{
    color: #283747;
  }

</style>