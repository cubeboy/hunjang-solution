//import axios from 'axios'
import book from '../assets/books/OldManAndSea.json'

export default {
  getEngText(bookInfo) {
    console.log(bookInfo)
    return new Promise((resolve, reject) => {
      try {
        book.forEach(chapter => {
          if (bookInfo.chapter == chapter.chapter) {
            resolve(chapter.engText)
          }
        })
      }catch(error){
        reject(error)
      }
    })
  }
}