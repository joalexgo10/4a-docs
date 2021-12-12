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
        v-model.number="materiaPrimaM.materiaPrima_codigo"
        type="num"
        placeholder="Codigo de M.P"
        style="box-sizing: border-box; padding: 10px 20px; margin: 5px 0; border: 1px solid #283747;"
      >
      <br>

      <input
        v-model="materiaPrimaM.materiaPrima_categoria_id"
        type="text"
        placeholder="Categoria"
        style="box-sizing: border-box; padding: 10px 20px; margin: 5px 0; border: 1px solid #283747;"
      >
      <br>

      <input
        v-model="materiaPrimaM.materiaPrima_descripcion"
        type="text"
        placeholder="Descripcion"
        style="box-sizing: border-box; padding: 10px 20px; margin: 5px 0; border: 1px solid #283747;"
      >
      <br>

      <input
        v-model.number="materiaPrimaM.materiaPrima_existencias"
        type="num"
        placeholder="Cantidad disponible"
        style="box-sizing: border-box; padding: 10px 20px; margin: 5px 0; border: 1px solid #283747;"
      >
      <br>

      <input
        v-model="materiaPrimaM.materiaPrima_unidad"
        type="text"
        placeholder="Presentación"
        style="box-sizing: border-box; padding: 10px 20px; margin: 5px 0; border: 1px solid #283747;"
      >
      <br>

      <input        
        type="text"
        placeholder="Presentación"
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
import gql from 'graphql-tag'
import axios from 'axios'
import swal from 'sweetalert'
import { mapState } from 'vuex'
export default {
  name: 'CreacionMateriasPrimas',

  data: function () {
    return {
      userId: parseInt(localStorage.getItem('userId')),
      materiaPrimaM: {
        materiaPrima_codigo: 0,
        materiaPrima_categoria_id: '',
        materiaPrima_descripcion: '',
        materiaPrima_existencias: 0,
        materiaPrima_unidad: '',
        proveedoresId: [5, 6]
      },
      prueba: {
        num: 7,
        str: 'siete'
      }
    }
  },
  methods: {
    creacionDeMateriaPrima: async function () {
      console.log(this.materiaPrimaM)
      console.log(this.prueba)
      await this.$apollo
        .mutate({
          mutation: gql`
            mutation($userId: Int!, $materiaPrima: materiasPrimasI!) {
              crearMateriaPrima(userId: $userId, materiaPrima: $materiaPrima)
            }
          `,
          variables: {
            userId: this.userId,
            materiaPrima: this.materiaPrimaM
          }
        })
        .then((result) => {
          alert('Creacion' + result)
        })
        .catch((error) => {
          console.log(error)
          alert('Error en la creacion de materia prima')
        })
    }

  }
}
</script>

<style>
  .h1 {
    color: #283747;
  }

</style>
