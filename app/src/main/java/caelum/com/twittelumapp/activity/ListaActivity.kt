package caelum.com.twittelumapp.activity

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import caelum.com.twittelumapp.databinding.ActivityListaBinding
import com.google.android.material.snackbar.Snackbar

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tweets = listOf("Agora foi 1", "Agora foi 2", "Agora foi 3", "Agora foi 4", "Agora foi 5" )
        val adapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1, tweets)

        binding.listaTweet.adapter = adapter

        binding.fabAdd.setOnClickListener {
            val intencao = Intent(this, MainActivity::class.java)
            startActivity(intencao)
        }

    }
}