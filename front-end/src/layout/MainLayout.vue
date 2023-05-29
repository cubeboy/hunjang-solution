<script setup>
import { ref } from 'vue'
import { useChaptersStore } from '../stores/chapters'
import { useRouter } from 'vue-router'

const router = useRouter()

const drawer = ref(null)

const chapterStore = useChaptersStore()

const selectChapter = (chapter) => {
  drawer.value = null
  chapterStore.setCurrentChapter(chapter)
}
</script>

<template>
  <v-layout>
    <v-app-bar class="elevation-2" color="white" flat>
      <template v-slot:prepend>
        <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
        <v-app-bar-title>영어 훈장님</v-app-bar-title>
      </template>
      <v-spacer></v-spacer>
    </v-app-bar>
    <v-main>
      <RouterView />
    </v-main>
    <v-navigation-drawer variant="text" v-model="drawer">
      <v-sheet color="grey-lighten-4" class="pa-4">
        <v-avatar class="mb-4" color="grey-darken-1" size="64"></v-avatar>
        <div>sunny@hunjang.com</div>
      </v-sheet>
      <v-divider></v-divider>
      <v-list>
        <v-list-subheader class="text-h6">The Old Man And The Sea</v-list-subheader>
        <v-list-item
          v-for="(chapter, index) in chapterStore.chapterList"
          :key="index"
          link
          @click="selectChapter(chapter)"
        >
          <template v-slot:prepend>
            <v-icon>mdi-book-settings-outline</v-icon>
          </template>
          <v-list-item-title>{{ chapter.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </v-layout>
</template>
