import _ from 'lodash'

export default {
  parse (error) {
    if (error.response) {
      const status = error.response.status
      const data = error.response.data
      if (status === 400) {
        if (data && data.message) {
          return new Error(data.message)
        } else {
          return new Error('잘못된 요청입니다.')
        }
      } else if (status === 401) {
        return new Error('인증되지 않은 사용자 입니다.')
      } else if (status === 403) {
        return new Error('권한이 부여되지 않은 사용자 입니다.')
      } else if (status === 404) {
        return new Error(i18n.t('페이지를 찾을 수 없습니다.'))
      } else if (status === 500) {
        if (data && data.message) {
          return new Error(data.message)
        } else {
          return new Error(i18n.t('알수없는 서버 오류 입니다.'))
        }
      } else {
        return new Error(i18n.t('요청에 실패 하였습니다.'))
      }
    } else if (error.request) {
      // Request was made and no response
      return new Error(i18n.t('요청에 응답이 없습니다.'))
    } else {
      return _.isError(error) ? error : new Error(error)
    }
  }
}