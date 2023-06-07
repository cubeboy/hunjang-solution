<script setup>
import { ref, reactive, watch } from 'vue'
import { useChaptersStore } from '../stores/chapters'
import feedTextService from '../services/FeedTextService'
import textTranslationService from '../services/TextTranslationService'

const dialog = ref(false)

const errorMessage = ref('')

const chapterStore = useChaptersStore()

const actionMode = ref(0)

const mode = reactive(['sentence', 'word'])

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
watch(
  () => chapterStore.isRunning,
  (isRunning) => {
    console.log('isrunning => ', isRunning)
    dialog.value = isRunning
  }
)

const trans = (text) => {
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
        <v-alert
          v-show="errorMessage"
          class="pa-4 ma-4"
          color="warning"
          icon="$warning"
          title="Translate Fail"
          :text="errorMessage"
        ></v-alert>
      </v-col>
    </v-row>
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
              <v-list-item
                class="pointer"
                v-for="(item, index) in engTexts"
                :key="index"
                @click="trans(item)"
              >
                {{ item }}
              </v-list-item>
            </v-list>
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
