import axios from 'axios'
import errorParser from '../utils/error-parser'

export default {
  textTranslate(text) {
    return new Promise((resolve, reject) => {
      const param = { promptText: text }
      axios
        .post('/transText', param)
        .then(({ data }) => {
          resolve(data.response)
        })
        .catch((error) => {
          reject(errorParser.parse(error))
        })
    })
  }
}
