package pe.edu.cibertec.appGrupo3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appGrupo3.adapter.UsuarioAdapter
import pe.edu.cibertec.appGrupo3.databinding.FragmentPregunta4Binding
import pe.edu.cibertec.appGrupo3.retrofit.ClienteUsuarioRetrofit
import pe.edu.cibertec.appGrupo3.retrofit.response.ResultUsuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Pregunta4Fragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentPregunta4Binding? = null
    private val binding get() = _binding!!
    private var request: Call<ResultUsuario>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPregunta4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUsuarios.layoutManager = LinearLayoutManager(requireContext())
        binding.btnCargar.setOnClickListener(this)
        obtenerUsuarios()
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnCargar) obtenerUsuarios()
    }

    private fun obtenerUsuarios() {
        binding.btnCargar.isEnabled = false
        binding.pbCarga.visibility = View.VISIBLE
        binding.tvEstado.text = "Cargando usuarios..."
        val llamada = ClienteUsuarioRetrofit.retrofitUsuarioService.obtenerUsuarios()
        request = llamada
        llamada.enqueue(object : Callback<ResultUsuario> {
            override fun onResponse(call: Call<ResultUsuario>, response: Response<ResultUsuario>) {
                if (_binding == null || call.isCanceled) return
                finalizarCarga()
                val listaUsuarios = response.body()?.users
                if (response.isSuccessful && listaUsuarios != null) {
                    binding.rvUsuarios.adapter = UsuarioAdapter(listaUsuarios)
                    binding.tvEstado.text = if (listaUsuarios.isEmpty()) "No se encontraron usuarios." else "Usuarios cargados: ${listaUsuarios.size}"
                } else {
                    mostrarError("No se pudieron cargar los usuarios (HTTP ${response.code()}).")
                }
            }

            override fun onFailure(call: Call<ResultUsuario>, t: Throwable) {
                if (_binding == null || call.isCanceled) return
                finalizarCarga()
                mostrarError("Error de conexión. Verifica tu internet e intenta nuevamente.")
            }
        })
    }

    private fun finalizarCarga() {
        binding.btnCargar.isEnabled = true
        binding.pbCarga.visibility = View.GONE
    }

    private fun mostrarError(mensaje: String) {
        binding.tvEstado.text = mensaje
        Toast.makeText(requireContext(), mensaje, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        request?.cancel()
        request = null
        binding.rvUsuarios.adapter = null
        _binding = null
        super.onDestroyView()
    }
}
