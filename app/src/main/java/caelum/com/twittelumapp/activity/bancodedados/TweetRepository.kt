package caelum.com.twittelumapp.activity.bancodedados

import caelum.com.twittelumapp.activity.Tweet

class TweetRepository(private val fonteDeDados: TweetDao) {
    fun lista() = fonteDeDados.lista()
    fun salva(tweet: Tweet) = fonteDeDados.salva(tweet)
}