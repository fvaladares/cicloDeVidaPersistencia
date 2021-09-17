package br.com.pitagoras.ac.dadosresistentesmudanadeestado

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.pitagoras.ac.dadosresistentesmudanadeestado.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}