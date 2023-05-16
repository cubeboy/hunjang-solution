import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useChaptersStore = defineStore('chpters', () => {
  const list = ref(['chapter 1', 'chapter 2', 'chapter 2'])

  return { list }
})
