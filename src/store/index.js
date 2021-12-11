import { createStore } from 'vuex'

export default createStore({
  state: {
    proveedorStore: {}
  },
  mutations: {
    definirProveedorStore (state, proveedorS) {
      state.proveedorStore = proveedorS
      console.log(state.proveedorStore)
    }
  },
  actions: {
  },
  modules: {
  }
})
