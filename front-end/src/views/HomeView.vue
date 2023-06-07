<script setup>
import { ref, reactive, watch } from 'vue'
import { useChaptersStore } from '../stores/chapters'
import feedTextService from '../services/FeedTextService'

const chapterStore = useChaptersStore()

const actionMode = ref(0)

const mode = reactive(['sentence', 'word'])

const engTexts = ref([])

watch(
  () => chapterStore.currentChapter,
  (chapter) => {
    feedTextService.getEngText(chapter).then(data => {
      engTexts.value = []
      data.forEach(item => engTexts.value.push(item))
    })
  }
)

const trans = (text) => {
  console.log('trans', text)
}

</script>

<script>
export default {
  name: 'HomeView'
}
</script>

<template>
  <v-container>
    <v-row>
      <v-col cols="12">
        <v-btn-toggle color="primary" v-model="actionMode" dense>
          <v-btn>문장해석</v-btn>
          <v-btn>단어해석</v-btn>
        </v-btn-toggle>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12" lg="6">
        <v-sheet>
          <v-card color="grey-lighten-4">
            <v-card-title>English</v-card-title>
            <v-list>
              <v-list-item class="pointer" v-for="(item, index) in engTexts" :key="index" @click="trans(item)">
                {{ item }}
              </v-list-item>
            </v-list>
          </v-card>
        </v-sheet>
      </v-col>
      <v-col cols="12" lg="6">
        <v-sheet>
          <v-textarea label="Korean" rows="10" auto-grow />
        </v-sheet>
      </v-col>
    </v-row>
  </v-container>
</template>

<style>
  .pointer {
    cursor: pointer
  }
</style>