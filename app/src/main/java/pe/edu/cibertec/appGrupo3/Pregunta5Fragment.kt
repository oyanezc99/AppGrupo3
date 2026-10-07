package pe.edu.cibertec.appGrupo3
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appGrupo3.adapter.ObrasAdapter
import pe.edu.cibertec.appGrupo3.databinding.FragmentPregunta5Binding

class Pregunta5Fragment : Fragment() {

    private var _binding: FragmentPregunta5Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta5Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaObras = listOf(
            ObraLiteraria(
                "La ciudad y los perros",
                "Mario Vargas Llosa",
                "Moderna",
                "https://picsum.photos/seed/obra1/200/300"
            ),
            ObraLiteraria(
                "Los perros hambrientos",
                "Ciro Alegría",
                "Indigenista",
                "https://picsum.photos/seed/obra2/200/300"
            ),
            ObraLiteraria(
                "Redoble por Rancas",
                "Manuel Scorza",
                "Indigenista",
                "https://picsum.photos/seed/obra3/200/300"
            ),
            ObraLiteraria(
                "Trilce",
                "César Vallejo",
                "Vanguardista",
                "https://picsum.photos/seed/obra4/200/300"
            ),
            ObraLiteraria(
                "El sexto",
                "José María Arguedas",
                "Indigenista",
                "https://picsum.photos/seed/obra5/200/300"
            ),
            ObraLiteraria(
                "Aves sin nido",
                "Clorinda Matto de Turner",
                "Realismo",
                "https://picsum.photos/seed/obra6/200/300"
            ),
            ObraLiteraria(
                "Tradiciones peruanas",
                "Ricardo Palma",
                "Romanticismo",
                "https://picsum.photos/seed/obra7/200/300"
            ),
            ObraLiteraria(
                "La palabra del mudo",
                "Julio Ramón Ribeyro",
                "Generación del 50",
                "https://picsum.photos/seed/obra8/200/300"
            ),
            ObraLiteraria(
                "Un mundo para Julius",
                "Alfredo Bryce Echenique",
                "Moderna",
                "https://picsum.photos/seed/obra9/200/300"
            ),
            ObraLiteraria(
                "Los gallinazos sin plumas",
                "Julio Ramón Ribeyro",
                "Generación del 50",
                "https://picsum.photos/seed/obra10/200/300"
            ),
            ObraLiteraria(
                "Yawar Fiesta",
                "José María Arguedas",
                "Indigenista",
                "https://picsum.photos/seed/obra11/200/300"
            ),
            ObraLiteraria(
                "La casa verde",
                "Mario Vargas Llosa",
                "Moderna",
                "https://picsum.photos/seed/obra12/200/300"
            ),
            ObraLiteraria(
                "Paco Yunque",
                "César Vallejo",
                "Realismo Social",
                "https://picsum.photos/seed/obra13/200/300"
            ),
            ObraLiteraria(
                "Huasipungo (mencionado en contexto)",
                "Ciro Alegría",
                "Indigenista",
                "https://picsum.photos/seed/obra14/200/300"
            ),
            ObraLiteraria(
                "Lima la horrible",
                "Sebastián Salazar Bondy",
                "Ensayo / Mod.",
                "https://picsum.photos/seed/obra15/200/300"
            ),
            ObraLiteraria(
                "Cambio de guardia",
                "Julio Ramón Ribeyro",
                "Generación del 50",
                "https://picsum.photos/seed/obra16/200/300"
            ),
            ObraLiteraria(
                "Cerro de Pasco",
                "Manuel Scorza",
                "Indigenista",
                "https://picsum.photos/seed/obra17/200/300"
            ),
            ObraLiteraria(
                "Pantaleón y las visitadoras",
                "Mario Vargas Llosa",
                "Moderna",
                "https://picsum.photos/seed/obra18/200/300"
            ),
            ObraLiteraria(
                "El zorro de arriba y el zorro de abajo",
                "José María Arguedas",
                "Indigenista",
                "https://picsum.photos/seed/obra19/200/300"
            ),
            ObraLiteraria(
                "Heraldo negros",
                "César Vallejo",
                "Modernismo",
                "https://picsum.photos/seed/obra20/200/300"
            )
        )

        // Configuración del RecyclerView
        binding.recyclerObras.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerObras.adapter = ObrasAdapter(listaObras)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}