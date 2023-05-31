import { describe, expect, it } from "vitest";
import feedTextService from '../FeedTextService'

describe('FeedTextService', () => {
  it('should retun english text', () => {
    const bookInfo = { bookId: 'OldManAndSea', chapter: 'chapter00' }
    feedTextService.getEngText(bookInfo).then(engText => {
      console.log('engText => ', engText)
      expect(engText.length > 0).toEqual(true)
    }).catch(error => {
      console.log('should return english text error raise => ', error)
      expect(false).toEqual(true)
    })
  })
})