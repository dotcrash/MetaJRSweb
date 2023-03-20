export default {
  state: {
    token: localStorage.getItem("token"),
    user: {
		"_id":1,"nickname":"爱开发的小罗","avatar": "./static/img/avatar/1.jpg"
	}
  },
  mutations: {
    setToken(stare, token) {
      localStorage.setItem("token", JSON.stringify(token));
      stare.token = localStorage.getItem("token")
    },
    setUser(state, info) {
      state.user = info
    }
  },
  getters: {
    getToken(state) {
      if (state.token) {
        return JSON.parse(state.token)
      }
      return null
    },
    getUser(state) {
      return state.user
    }
  }
}

