import axios from 'axios'
// import { useChaptersStore } from '../stores/chapters'

axios.defaults.baseURL = '/api'
axios.defaults.headers.common.Accept = 'application/json'
axios.interceptors.response.use(
  (response) => {
    //const chapterStore = useChaptersStore()
    //chapterStore.setIsRunning(false)
    return response
  },
  (error) => {
    //const chapterStore = useChaptersStore()
    //chapterStore.setIsRunning(false)
    return Promise.reject(error)
  }
)
/*
axios.interceptors.request.use((request) => {
  console.log('interceptor request => ', request)
  const chapterStore = useChaptersStore()
  chapterStore.setIsRunning(true)
})
*/
