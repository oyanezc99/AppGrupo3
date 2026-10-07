package pe.edu.cibertec.appGrupo3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appGrupo3.databinding.ActivityPregunta5Binding

class Pregunta5Activity : AppCompatActivity() {
    private lateinit var binding: ActivityPregunta5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPregunta5Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}