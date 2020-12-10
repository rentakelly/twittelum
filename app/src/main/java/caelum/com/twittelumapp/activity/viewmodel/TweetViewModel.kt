package caelum.com.twittelumapp.activity.viewmodel

import androidx.lifecycle.ViewModel
import caelum.com.twittelumapp.activity.Tweet
import caelum.com.twittelumapp.activity.bancodedados.TweetRepository

class TweetViewModel(private val repository: TweetRepository) : ViewModel() {
    fun lista() = repository.lista()
    fun salva(tweet: Tweet) = repository.salva(tweet)
}