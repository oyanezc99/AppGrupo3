package pe.edu.cibertec.appGrupo3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.cibertec.appGrupo3.databinding.ItemObraBinding

class ObraAdapter(private var listaObras: List<Obra>) : RecyclerView.Adapter<ObraAdapter.ViewHolder>()  {
    inner class ViewHolder(val binding: ItemObraBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemObraBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(listaObras[position]) {
                binding.tvtitulo.text = titulo
                binding.tvautor.text = autor
                Glide.with(itemView.context).load(urlImagen).into(binding.ivportada)
            }
        }
    }
    override fun getItemCount() = listaObras.size
}