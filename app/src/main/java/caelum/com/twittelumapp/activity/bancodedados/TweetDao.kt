package caelum.com.twittelumapp.activity.bancodedados

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import caelum.com.twittelumapp.activity.Tweet

@Dao
interface TweetDao {
    @Insert
    fun salva(tweet: Tweet)
    @Query("select * from Tweet")
    fun lista(): LiveData<List<Tweet>>
}