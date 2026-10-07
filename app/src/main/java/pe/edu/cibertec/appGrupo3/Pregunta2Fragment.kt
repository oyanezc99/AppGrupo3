package pe.edu.cibertec.appGrupo3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import pe.edu.cibertec.appGrupo3.databinding.FragmentPregunta2Binding

class Pregunta2Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta2Binding.inflate(inflater, container, false)
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
            Toast.makeText(context, "Ingrese el consumo en kWh", Toast.LENGTH_SHORT).show()
            return
        }

        val consumo = consumoStr.toDoubleOrNull()
        if (consumo == null || consumo < 0) {
            Toast.makeText(context, "Ingrese un número válido", Toast.LENGTH_SHORT).show()
            return
        }

        if (consumo <= 150) {
            binding.tvResultado.text = "Consumo eficiente sin sobrecosto."
        } else {
            val exceso = consumo - 150
            val recargo = 60.00 + (1.80 * exceso)

            binding.tvResultado.text = buildString {
                append("Consumo ingresado: $consumo kWh\n")
                append("Exceso: $exceso kWh\n")
                append("Recargo: ${String.format("S/ %.2f", recargo)}")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
