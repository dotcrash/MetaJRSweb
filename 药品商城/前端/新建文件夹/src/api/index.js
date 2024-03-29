import axios from 'axios'
import $utils from '@/utils/index'
import router from "@/router"
import store from "@/store"

if (process.env.NODE_ENV === "production") {
  axios.defaults.baseURL = 'http://8.129.208.48:3000'
} else {
  axios.defaults.baseURL = 'http://localhost:8083'
}

//超时时间
axios.defaults.timeout = 15 * 1000;

//全局请求拦截处理
axios.interceptors.request.use(
  request => {
    request.headers.Authorization = "Bearer " + store.getters.getToken;
    request.headers.post["Content-Type"] = "multipart/form-data";
    return request
  },
  error => {
    return Promise.reject(error);
  }
);

//全局响应拦截处理
axios.interceptors.response.use(
  response => {
    if (store.getters.getToken && response.data.code === 962464) {
      localStorage.clear()
      if (router.currentRoute.path !== "/" && router.currentRoute.path !== "/login") {
        router.push("/")
      }
      return $utils.elMessageBox("登录失效，请重新登录-全局", "warning", 3000, true)
    }
    if ([-1, 400, 401].includes(response.data.code)) {
      return $utils.elMessageBox(response.data.msg, "warning")
    }
    return response.data;
  },
  error => {
    if (JSON.stringify(error).includes(" Request failed")) {
      $utils.elMessageBox("请求错误，请稍后再试-全局", "error", 3000, true)
    } else if (JSON.stringify(error).includes("Network Error")) {
      $utils.elMessageBox("网络异常，请稍后再试-全局", "error", 3000, true)
    } else if (JSON.stringify(error).includes("Error: timeout")) {
      $utils.elMessageBox("请求超时，请稍后再试-全局", "error", 3000, true)
    }
    return Promise.reject(error);
  }
);

export default axios