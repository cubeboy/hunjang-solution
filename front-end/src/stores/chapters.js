import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useChaptersStore = defineStore('chapters', () => {
  const isRunning = ref(false)  

  const chapterList = ref([
    {bookId: 'OldManAndSea', title: 'chapter 1', chapter: 'chapter01'}, 
    {bookId: 'OldManAndSea', title: 'chapter 2', chapter: 'chapter02'}, 
    {bookId: 'OldManAndSea', title: 'chapter 3', chapter: 'chapter03'}, 
  ])

  const currentChapter = ref(null)

  const setIsRunning = (val) => { isRunning.value = val }

  const setCurrentChapter = (chapter) => {  currentChapter.value = chapter  }
  
  return { isRunning, chapterList, currentChapter, setCurrentChapter, setIsRunning}
})
