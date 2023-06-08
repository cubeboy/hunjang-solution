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
  },
  wordTranslate(word) {
    return new Promise((resolve, reject) => {
      const param = { promptText: word }
      axios
        .post('/transWord', param)
        .then(({ data }) => {
          console.log('transWord response => ', data.response)
          resolve(data.response)
        })
        .catch((error) => {
          console.log('word translate error => ', error)
          reject(errorParser.parse(error))
        })
    })
  }
}
