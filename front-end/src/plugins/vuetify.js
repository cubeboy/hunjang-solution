import { createVuetify } from 'vuetify'
import 'vuetify/dist/vuetify.min.css' // add Vuetify style sheet
import '@mdi/font/css/materialdesignicons.min.css' // add Material Design Icons for design font

import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'

export default createVuetify({
  components,
  directives,
  icons: {
    iconfont: 'mdi'
  }
})
