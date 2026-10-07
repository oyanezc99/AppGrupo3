package pe.edu.cibertec.appGrupo3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appGrupo3.databinding.FragmentPregunta3Binding


class Pregunta3Fragment : Fragment() {
    private var _binding: FragmentPregunta3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta3Binding.inflate(inflater, container, false)

        binding.rvobras.layoutManager = LinearLayoutManager(requireContext())
        binding.rvobras.adapter = ObraAdapter(obtenerObras())

        return binding.root
    }

    private fun obtenerObras(): List<Obra> {
        return listOf(
            Obra("Los gallinazos sin plumas", "Julio Ramón Ribeyro", "https://picsum.photos/seed/obra1/300/400"),
            Obra("Ña Catita", "Manuel Ascencio Segura", "https://picsum.photos/seed/obra2/300/400"),
            Obra("Tradiciones peruanas", "Ricardo Palma", "https://picsum.photos/seed/obra3/300/400"),
            Obra("Cartas a un ángel", "Carlos Augusto Salaverry", "https://picsum.photos/seed/obra4/300/400"),
            Obra("Aves sin nido", "Clorinda Matto de Turner", "https://picsum.photos/seed/obra5/300/400"),
            Obra("El caballero Carmelo", "Abraham Valdelomar", "https://picsum.photos/seed/obra6/300/400"),
            Obra("Páginas libres", "Manuel González Prada", "https://picsum.photos/seed/obra7/300/400"),
            Obra("Los heraldos negros", "César Vallejo", "https://picsum.photos/seed/obra8/300/400"),
            Obra("Trilce", "César Vallejo", "https://picsum.photos/seed/obra9/300/400"),
            Obra("La ciudad y los perros", "Mario Vargas Llosa", "https://picsum.photos/seed/obra10/300/400"),
            Obra("El mundo es ancho y ajeno", "Ciro Alegría", "https://picsum.photos/seed/obra11/300/400"),
            Obra("Yawar Fiesta", "José María Arguedas", "https://picsum.photos/seed/obra12/300/400"),
            Obra("Los ríos profundos", "José María Arguedas", "https://picsum.photos/seed/obra13/300/400"),
            Obra("Conversación en La Catedral", "Mario Vargas Llosa", "https://picsum.photos/seed/obra14/300/400"),
            Obra("Ollantay", "Anónimo (tradición oral quechua)", "https://picsum.photos/seed/obra15/300/400"),
            Obra("Lima, hora cero", "Enrique Congrains Martin", "https://picsum.photos/seed/obra16/300/400"),
            Obra("Un mundo para Julius", "Alfredo Bryce Echenique", "https://picsum.photos/seed/obra17/300/400"),
            Obra("La palabra del mudo", "Julio Ramón Ribeyro", "https://picsum.photos/seed/obra18/300/400"),
            Obra("Comentarios reales de los incas", "Inca Garcilaso de la Vega", "https://picsum.photos/seed/obra19/300/400"),
            Obra("El sargento Canuto", "Manuel Ascencio Segura", "https://picsum.photos/seed/obra20/300/400")
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}