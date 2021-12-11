<template>
  <div class="signUp_user">
    <div class="container_signUp_user">
      <h1>Registrarse</h1>

      <form @submit.prevent="processSignUp">
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

        <input
          v-model="user.name"
          type="text"
          placeholder="Name"
        >
        <br>

        <input
          v-model="user.email"
          type="email"
          placeholder="Email"
        >
        <br>

        <button type="submit">
          Registrarse
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import gql from 'graphql-tag'

export default {
  name: 'SignUp',
  data: function () {
    return {
      user: {
        username: '',
        password: '',
        name: '',
        email: ''
      }
    }
  },
  methods: {
    processSignUp: async function () {
      await this.$apollo
        .mutate({
          mutation: gql`
mutation($userInput: SignUpInput!) {
signUpUser(userInput: $userInput) {
refresh
access
}
}
`,
          variables: {
            userInput: this.user
          }
        })
        .then((result) => {
          const dataLogIn = {
            username: this.user.username,
            token_access: result.data.signUpUser.access,
            token_refresh: result.data.signUpUser.refresh
          }
          this.$emit('completedSignUp', dataLogIn)
          this.user = ''
        })
        .catch((error) => {
          alert('ERROR: Fallo en el registro.')
        })
    }
  }
}
</script>

<style>
.signUp_user {
  margin: 0;
  padding: 0%;
  height: 100%;
  width: 100%;

  display: flex;
  justify-content: center;
  align-items: center;
}

.signUp_user h1 {
  color: #283747;
}

.signUp_user input {
  height: 40px;
  width: 100%;

  box-sizing: border-box;
  padding: 10px 20px;
  margin: 5px 0;

  border: 1px solid #283747;
}

.signUp_user button {
  width: 100%;
  height: 40px;

  color: #e5e7e9;
  background: #283747;
  border: 1px solid #e5e7e9;

  border-radius: 5px;
  padding: 10px 25px;
  margin: 5px 0 25px 0;
}

.signUp_user button:hover {
  color: #e5e7e9;
  background: crimson;
  border: 1px solid #283747;
}
</style>
