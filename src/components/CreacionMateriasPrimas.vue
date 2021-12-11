<template>
  <div>
    <h1>Creacion Nueva Materia Prima</h1>
    <!-- <button
      type="button"
      class="btn btn-primary"
      @click="creacionDeMateriaPrima"
    >
      Primary
    </button> -->

    <form @submit.prevent="creacionDeMateriaPrima">
      <input
        v-model="materiaPrima.materiaPrima_codigo"
        type="num"
        placeholder="Codigo de M.P"
        style="box-sizing: border-box; padding: 10px 20px; margin: 5px 0; border: 1px solid #283747;"
      >
      <br>

      <input
        v-model="materiaPrima.materiaPrima_categoria_id"
        type="text"
        placeholder="Categoria"
        style="box-sizing: border-box; padding: 10px 20px; margin: 5px 0; border: 1px solid #283747;"
      >
      <br>

      <input
        v-model="materiaPrima.materiaPrima_descripcion"
        type="text"
        placeholder="Descripcion"
        style="box-sizing: border-box; padding: 10px 20px; margin: 5px 0; border: 1px solid #283747;"
      >
      <br>

      <input
        v-model="materiaPrima.materiaPrima_existencias"
        type="num"
        placeholder="Cantidad disponible"
        style="box-sizing: border-box; padding: 10px 20px; margin: 5px 0; border: 1px solid #283747;"
      >
      <br>

      <input
        v-model="materiaPrima.materiaPrima_unidad"
        type="text"
        placeholder="Presentación"
        style="box-sizing: border-box; padding: 10px 20px; margin: 5px 0; border: 1px solid #283747;"
      >
      <br>

      <button type="submit" style="color: #E5E7E9; background: #283747; border-radius: 5px; padding: 10px 25px; margin: 5px 0 25px 0">Crear</button>
      </form>

  </div>
</template>

<script>
import axios from 'axios'
import swal from 'sweetalert'
import { mapState } from 'vuex'
export default {
  name: 'CreacionMateriasPrimas',

  data: function () {
    return {
      materiaPrima: {
        materiaPrima_codigo: '',
        materiaPrima_categoria_id: '',
        materiaPrima_descripcion: '',
        materiaPrima_existencias: '',
        materiaPrima_unidad: ''
      }
    }
  },
  computed: {
    ...mapState(['materiaPrimaStore'])
  },
  mounted () {

  },
  methods: {
    creacionDeProveedor: function () {
      axios.post('https://db-aplicacion-web.herokuapp.com/materiasPrimas/', this.materiaPrima, { headers: {} })
        .then((result) => {
          console.log(result)
        },
        swal('La materia prima se creó exitosamente!', '', 'success')
        )
      this.materiaPrima = ''
    }
  }
}
</script>

<style>
  .h1 {
    color: #283747;
  }
  
</style>