import { describe, it, expect, beforeEach } from 'vitest'
import { createRouter, createWebHistory } from 'vue-router'
import { createPinia } from 'pinia'
import { mount } from '@vue/test-utils'

import vuetify from '../../plugins/vuetify'
import { useChaptersStore } from '../../stores/chapters.js'
import HomeView from '../HomeView.vue'

/**
 * prevention for windows resize evetn undefined error 
 */
window.ResizeObserver =
  window.ResizeObserver ||
  vi.fn().mockImplementation(() => ({
    disconnect: vi.fn(),
    observe: vi.fn(),
    unobserve: vi.fn()
  }))

describe('HomeView', () => {
  let wrapper
  let chapterStore
  const router = createRouter({
    history: createWebHistory(),
    routes: []
  })

  beforeEach(() => {
    wrapper = mount(HomeView, {
      global: {
        plugins: [vuetify, router, createPinia()]
      }
    })
    chapterStore = useChaptersStore()
  })

  it('should contain data model with initial values', () => {
    expect(wrapper.vm.actionMode).toEqual(0)
    expect(wrapper.vm.mode[wrapper.vm.actionMode]).toEqual('sentence')
    wrapper.vm.actionMode = 1
    expect(wrapper.vm.mode[wrapper.vm.actionMode]).toEqual('word')
  })

  it('should chapter info changed', async () => {
    expect(chapterStore.chapterList.length).toEqual(3)
    const chapter = chapterStore.chapterList[0]
    expect(chapter.chapter).toEqual('chapter01')
    chapterStore.setCurrentChapter(chapter)
    expect(chapterStore.currentChapter.chapter).toEqual('chapter01')
    await wrapper.vm.$nextTick()
    expect(wrapper.vm.engText.length > 0).toEqual(true)
  })
})
