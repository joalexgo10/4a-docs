<template>
  <div class="logIn_user">
    <div class="container_logIn_user">
      <h1>Iniciar sesión</h1>

      <form @submit.prevent="processLogInUser">
        <input
          v-model="user.username"
          type="text"
          placeholder="Username"
        >
        <br>
        <input
          v-model="user.password"
          type="password"
          placeholder="Password"
        >
        <br>
        <button type="submit">
          Iniciar Sesion
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import gql from 'graphql-tag'

export default {
  name: 'LogIn',

  data: function () {
    return {
      user: {
        username: '',
        password: ''
      }
    }
  },

  methods: {
    processLogInUser: async function () {
      await this.$apollo
        .mutate({
          mutation: gql`
            mutation($credentials: CredentialsInput!) {
              logIn(credentials: $credentials) {
                refresh
                access
              }
            }
          `,
          variables: {
            credentials: this.user
          }
        })
        .then((result) => {
          const dataLogIn = {
            username: this.user.username,
            token_access: result.data.logIn.access,
            token_refresh: result.data.logIn.refresh
          }

          this.$emit('completedLogIn', dataLogIn)
          this.user = ''
        })
        .catch((error) => {
          alert('ERROR 401: Credenciales Incorrectas.')
        })
    }
  }
}
</script>
<style>

    .logIn_user{
        margin: 0;
        padding: 0%;
        height: 100%;
        width: 100%;

        display: flex;
        justify-content: center;
        align-items: center;
    }

    .logIn_user h1{
        color: #283747;

    }

    .logIn_user input{
        height: 40px;
        width: 100%;

        box-sizing: border-box;
        padding: 10px 20px;
        margin: 5px 0;

        border: 1px solid #283747;
    }

    .logIn_user button{
        width: 100%;
        height: 40px;

        color: #E5E7E9;
        background: #283747;
        border: 1px solid #E5E7E9;

        border-radius: 5px;
        padding: 10px 25px;
        margin: 5px 0;
    }

    .logIn_user button:hover{
        color: #E5E7E9;
        background: crimson;
        border: 1px solid #283747;
    }

</style>
