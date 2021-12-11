<template>
  <div>
    <p>Consulta de proveedores</p>
    <button
      type="button"
      class="btn btn-primary"
      @click="consultaProveedores"
    >
      Primary
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
            <button
              class="btn btn-danger btn-sm"
              @click=" eliminar(proveedor.proveedorId); consultaProveedores; "
            >
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
import { mapMutations } from 'vuex'
export default {
  name: 'ConsultaProveedores',

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
        },
        this.$router.push({ name: 'ConsultaProveedores' }))
    },
    editarProveedor: function () {
      this.$router.push({ name: 'FormActualizaProveedores' })
    }
  }
}
</script>
