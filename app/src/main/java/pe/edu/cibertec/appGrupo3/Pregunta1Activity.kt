package pe.edu.cibertec.appGrupo3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appGrupo3.databinding.ActivityPregunta1Binding

data class Usuario(val idUsuario: String, val contrasena: String)

class Pregunta1Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta1Binding

    private val listaUsuarios = listOf(
        Usuario("i202400595", "42296860"), //Cesar
        Usuario("i202315705", "75150122"), //Diana
        Usuario("i201711174", "77129340"), //Franco
        Usuario("i202506396", "60826268"), //Gustavo
        Usuario("i202506698", "75372329"), //Leonardo
        Usuario("i201611269", "72923871"), //Omar
        Usuario("i201511769", "46590118")  //Pedro
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnLogin) {
            validarLogin()
        }
    }

    private fun validarLogin() {
        val usuarioIngresado = binding.etUsername.text.toString().trim()
        val passwordIngresada = binding.etPassword.text.toString().trim()

        if (usuarioIngresado.isEmpty() || passwordIngresada.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese usuario y contraseña válidos", Toast.LENGTH_SHORT).show()
            return
        }

        val usuarioValido = listaUsuarios.find {
            it.idUsuario == usuarioIngresado && it.contrasena == passwordIngresada
        }

        if (usuarioValido != null) {
            Toast.makeText(this, "Bienvenido al sistema", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

        } else {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
    }
}