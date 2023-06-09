<script setup>
import { ref, reactive, watch } from 'vue'
import { useChaptersStore } from '../stores/chapters'
import feedTextService from '../services/FeedTextService'
import textTranslationService from '../services/TextTranslationService'

const dialog = ref(false)

const errorMessage = ref('')

const chapterStore = useChaptersStore()

const actionMode = ref(0)

const engTexts = ref([])

const korText = ref('')

watch(
  () => chapterStore.currentChapter,
  (chapter) => {
    feedTextService.getEngText(chapter).then((data) => {
      engTexts.value = []
      data.forEach((item) => engTexts.value.push(item))
    })
  }
)

const transWord = (word) => {
  dialog.value = true
  errorMessage.value = ''
  textTranslationService
    .wordTranslate(word)
    .then((response) => {
      dialog.value = false
      korText.value = response
    })
    .catch((error) => {
      dialog.value = false
      errorMessage.value = `번역작업에 오류가 발생 했습니다. : ` + error.errorMessage
    })
}

const transText = (text) => {
  dialog.value = true
  errorMessage.value = ''
  textTranslationService
    .textTranslate(text)
    .then((response) => {
      dialog.value = false
      korText.value = text + '\n' + response
    })
    .catch((error) => {
      dialog.value = false
      errorMessage.value = `번역작업에 오류가 발생 했습니다. : ` + error.errorMessage
    })
}

const splitText = (text) => {
  return text.split(' ')
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
      <v-col cols="12" lg="6">
        <v-sheet>
          <v-card color="grey-lighten-3">
            <v-card-title>English</v-card-title>
              <v-card-text v-for="(item, index) in engTexts" :key="index">
                <v-btn color="bule" icon="mdi-view-headline" size="x-small" @click="transText(item)" />
                <span
                    class="pointer text-body-1"
                    v-for="(word, idx) in splitText(item)"
                    :key="idx"
                    @click="transWord(word)"
                    >{{ word + ' ' }}</span
                  >
              </v-card-text>
            
          </v-card>
        </v-sheet>
      </v-col>
      <v-col cols="12" lg="6">
        <v-sheet>
          <v-textarea label="Korean" rows="10" auto-grow :model-value="korText" readonly="true" />
        </v-sheet>
      </v-col>
    </v-row>
  </v-container>
  <v-dialog v-model="dialog" width="auto">
    <v-progress-circular :size="80" :width="10" color="primary" indeterminate />
  </v-dialog>
</template>

<style>
.pointer {
  cursor: pointer;
}
</style>
