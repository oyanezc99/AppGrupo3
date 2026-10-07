package pe.edu.cibertec.appGrupo3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.cibertec.appGrupo3.databinding.ItemUsuarioBinding
import pe.edu.cibertec.appGrupo3.retrofit.response.Usuario

class UsuarioAdapter(private val listaUsuarios: List<Usuario>) : RecyclerView.Adapter<UsuarioAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemUsuarioBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUsuarioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario = listaUsuarios[position]
        holder.binding.apply {
            tvid.text = "ID: ${usuario.id}"
            tvnombre.text = "Nombre: ${usuario.firstName}"
            tvapellido.text = "Apellido: ${usuario.lastName}"
            tvemail.text = "Correo: ${usuario.email}"
            tvtelefono.text = "Teléfono: ${usuario.phone}"
        }
    }

    override fun getItemCount(): Int = listaUsuarios.size
}
