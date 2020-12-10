package caelum.com.twittelumapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import caelum.com.twittelumapp.bancodedados.TwittelumDatabase
import caelum.com.twittelumapp.modelo.Tweet
import caelum.com.twittelumapp.viewmodel.TweetViewModel
import caelum.com.twittelumapp.viewmodel.ViewModelFactory

class TweetActivity : AppCompatActivity() {

    lateinit var viewModel: TweetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tweet)

        viewModel = ViewModelProvider(this, ViewModelFactory)[TweetViewModel::class.java]
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.tweet_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.tweet_menu_cadastrar -> {
            publicaTweet()
            true
        }
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> false
    }
    fun publicaTweet() {
        val campoConteudo = findViewById<EditText>(R.id.conteudo_tweet)
        val conteudo = campoConteudo.text.toString()
        val tweet = Tweet(conteudo)
        val database = TwittelumDatabase.getDatabase(this)
        val tweetDao = database.getTweetDao()
        tweetDao.salva(tweet)

        Toast.makeText(this, conteudo, Toast.LENGTH_SHORT).show()

        finish()

    }
}