package caelum.com.twittelumapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import caelum.com.twittelumapp.databinding.ActivityListaTweetsBinding
import caelum.com.twittelumapp.modelo.Tweet
import caelum.com.twittelumapp.viewmodel.TweetViewModel
import caelum.com.twittelumapp.viewmodel.ViewModelFactory

class ListaTweetsActivity : AppCompatActivity() {

    private val binding: ActivityListaTweetsBinding by lazy {
        ActivityListaTweetsBinding.inflate(layoutInflater)
    }
    private val viewModel: TweetViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory)[TweetViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.fabNovo.setOnClickListener{
            val intencao = Intent(this, TweetActivity::class.java)

            startActivity(intencao)
        }
    }


    override fun onResume() {
        super.onResume()
        val tweetsLiveData: LiveData<List<Tweet>> = viewModel.lista()

        tweetsLiveData.observe(this, { tweets ->
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tweets)

            binding.listaTweet.adapter = adapter

        })
    }
}