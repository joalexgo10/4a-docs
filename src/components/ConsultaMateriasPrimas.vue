<template>
  <div>
    <h1>Consulta todas las materias primas</h1>
    <button
      type="button"
      class="submit"
      style="color: #E5E7E9; background: #283747; border-radius: 5px; padding: 10px 25px; margin: 5px 0 25px 0"
      @click="consultaMariasPrimas"
    >
      CONSULTAR
    </button>

    <div
      v-for="(materiaPrimas, index) of materiasPrimas"
      :key="index"
      class="mt-3"
    >
      <div
        class="alert alert-primary"
        role="alert"
      >
        <div class="d-flex justify-content-between align-items-center">
          <div>
            Descripcion: {{ materiaPrimas.materiaPrima_descripcion }} {{ materiaPrimas.materiaPrima_existencias }} {{materiaPrimas.materiaPrima_unidad }} <br>
            Categoria: {{ materiaPrimas.materiaPrima_categoria_id }} <br>
          </div>
        </div>
      </div>
    </div>

    <!-- <p>{{ proveedores }}</p> -->
  </div>
</template>

<script>
import gql from 'graphql-tag'
import axios from 'axios'
import swal from 'sweetalert'
import { mapMutations } from 'vuex'
export default {
  name: 'ConsultaMateriasPrimas',

  data: function () {
    return {
      userId: parseInt(localStorage.getItem('userId')),
      materiasPrimas: {}
    }
  },
  methods: {
    consultaMariasPrimas: async function () {
      await this.$apollo
        .query({
          query: gql`
query($userId: Int!) {
getAllMateriasPrimas(userId: $userId) {
    materiaPrima_codigo
    materiaPrima_categoria_id
    materiaPrima_descripcion
    materiaPrima_existencias
    materiaPrima_unidad
    proveedoresId
}
}
`,
          variables: {
            userId: this.userId
          }
        })
        .then((result) => {
          this.materiasPrimas = result.data.getAllMateriasPrimas
        })
        .catch((error) => {
          alert('ERROR: En la consulta de materias primas.')
        })
    }

  }
}
</script>

<style>

  .h1{
    color: #283747;
  }

</style>
