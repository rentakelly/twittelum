package caelum.com.twittelumapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import caelum.com.twittelumapp.R
import caelum.com.twittelumapp.activity.viewmodel.TweetViewModel
import caelum.com.twittelumapp.activity.viewmodel.ViewModelFactory

class ActivityMain : AppCompatActivity() {

    private val viewModel: TweetViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.tweet_menu_cadastrar -> {
                publicaTweet()
                finish()
            }
            android.R.id.home -> finish()
        }
        return false
    }



    private fun publicaTweet() {
        val campoDeMensagemDoTweet = findViewById<EditText>(R.id.conteudo_tweet)
        val mensagemDoTweet: String = campoDeMensagemDoTweet.text.toString()
        val tweet = Tweet(mensagemDoTweet)
        viewModel.salva(tweet)
        Toast.makeText(this, "$tweet foi salvo com sucesso :D", Toast.LENGTH_LONG).show()
    }
}
