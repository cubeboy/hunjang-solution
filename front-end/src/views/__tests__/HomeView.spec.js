import { describe, it, expect, beforeEach } from 'vitest'

import { mount } from '@vue/test-utils'
import { createRouter, createWebHistory } from 'vue-router'
import vuetify from '../../plugins/vuetify'

import HomeView from '../HomeView.vue'

window.ResizeObserver =
    window.ResizeObserver ||
    vi.fn().mockImplementation(() => ({
        disconnect: vi.fn(),
        observe: vi.fn(),
        unobserve: vi.fn(),
    }));


describe('HomeView', () => {
  let wrapper
  const router = createRouter({
    history: createWebHistory(),
    routes: []
  })

  beforeEach(() => {
    wrapper = mount(HomeView, {
      global: {
        plugins: [vuetify, router]
      }
    })
  })

  it('should contain data model with initial values', () => {
    expect(wrapper.vm.actionMode).toEqual(0)
    expect(wrapper.vm.mode[wrapper.vm.actionMode]).toEqual('sentence')
  })
})