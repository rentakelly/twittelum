package caelum.com.twittelumapp.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import caelum.com.twittelumapp.activity.viewmodel.TweetViewModel
import caelum.com.twittelumapp.activity.viewmodel.ViewModelFactory
import caelum.com.twittelumapp.databinding.ActivityListaBinding
import com.example.twiitelum.db.TwittelumDatabase

class ListaActivity : AppCompatActivity() {
    private val viewModel: TweetViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory).get(TweetViewModel::class.java)
    }

    private lateinit var binding : ActivityListaBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.fabAdd.setOnClickListener {
            val intencao = Intent(this, ActivityMain::class.java)
            startActivity(intencao)



        }



        viewModel.lista().observe(this, observer())


    }

    private fun observer(): Observer<List<Tweet>> {
        return Observer {
            binding.listaTweet.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, it)
        }
    }


}