package caelum.com.twittelumapp.activity.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import caelum.com.twittelumapp.activity.application.TwittelumApplication
import caelum.com.twittelumapp.activity.bancodedados.TweetRepository
import com.example.twiitelum.db.TwittelumDatabase

object ViewModelFactory : ViewModelProvider.Factory {
    private val database = TwittelumDatabase.getDatabase(TwittelumApplication.getInstance())
    private val tweetDao = database.getTweetDao()
    private val tweetRepository = TweetRepository(tweetDao)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = TweetViewModel(tweetRepository)
            as T
}