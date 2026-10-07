package pe.edu.cibertec.appGrupo3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appGrupo3.databinding.ActivityPregunta1Binding

class Pregunta1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityPregunta1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}