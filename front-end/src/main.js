import { createApp } from 'vue'
import pinia from './stores'

import App from './App.vue'
import router from './router'

import vuetify from '@/plugins/vuetify'

import './plugins/axios'


const app = createApp(App)

app.use(pinia)
app.use(router)
app.use(vuetify)

app.mount('#app')
