package pe.edu.cibertec.appGrupo3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.cibertec.appGrupo3.ObraLiteraria
import pe.edu.cibertec.appGrupo3.databinding.ItemObraLiterariaBinding

class ObrasAdapter(private val listaObras: List<ObraLiteraria>) :
    RecyclerView.Adapter<ObrasAdapter.ObraViewHolder>() {

    class ObraViewHolder(val binding: ItemObraLiterariaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObraViewHolder {
        val binding = ItemObraLiterariaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ObraViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ObraViewHolder, position: Int) {
        val obra = listaObras[position]
        holder.binding.txtTitulo.text = obra.titulo
        holder.binding.txtAutor.text = obra.autor
        holder.binding.txtEstacion.text = "Estación: ${obra.estacion}"

        // Carga de imagen utilizando Glide con una URL aleatoria/temática de internet
        Glide.with(holder.itemView.context)
            .load(obra.imagenUrl)
            .centerCrop()
            .placeholder(android.R.drawable.ic_menu_gallery)
            .into(holder.binding.imgObra)
    }

    override fun getItemCount(): Int = listaObras.size
}
