<script setup>
import { ref, reactive, watch } from 'vue'
import { useChaptersStore } from '../stores/chapters'
import feedTextService from '../services/FeedTextService'

const chapterStore = useChaptersStore()

const actionMode = ref(0)
const mode = reactive(['sentence', 'word'])

const engText = ref('')

watch(
  () => chapterStore.currentChapter,
  (chapter) => {
    feedTextService.getEngText(chapter).then( data => {
      engText.value = data
    })
  }
)

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
          <v-textarea label="English" rows="10" auto-grow v-model="engText" />
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
