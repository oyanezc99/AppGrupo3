package pe.edu.cibertec.appGrupo3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import pe.edu.cibertec.appGrupo3.databinding.FragmentPregunta1Binding

class Pregunta1Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnCalcular) {
            calcularConsumo()
        }
    }

    private fun calcularConsumo() {
        val consumoStr = binding.etConsumo.text.toString().trim()

        if (consumoStr.isEmpty()) {
            Toast.makeText(context, "Ingrese el volumen consumido", Toast.LENGTH_SHORT).show()
            return
        }

        val consumo = consumoStr.toDoubleOrNull()
        if (consumo == null || consumo < 0) {
            Toast.makeText(context, "Ingrese un número válido", Toast.LENGTH_SHORT).show()
            return
        }

        if (consumo <= 20) {
            binding.tvResultado.text = "Consumo dentro de la asignación regular."
        } else {
            val exceso = consumo - 20
            val recargo = 45.00 + (8.50 * exceso)

            binding.tvResultado.text = buildString {
                append("Volumen consumido: $consumo m³\n")
                append("Exceso: $exceso m³\n")
                append("Monto total del recargo: ${String.format("S/ %.2f", recargo)}")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}