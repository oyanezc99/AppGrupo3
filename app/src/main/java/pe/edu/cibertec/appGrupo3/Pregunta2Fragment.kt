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

        binding.btnCalcularFragment2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v?.id == binding.btnCalcularFragment2.id) {

            val texto = binding.txtEntradaFragment2.text.toString().trim()

            if (texto.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Ingrese un consumo",
                    Toast.LENGTH_SHORT
                ).show()
                return
            }

            val consumo = texto.toDouble()

            if (consumo <= 150) {

                binding.txtResultadoFragment2.text =
                    "Consumo eficiente sin sobrecosto."

            } else {

                val exceso = consumo - 150
                val recargo = 60.00 + (exceso * 1.80)

                binding.txtResultadoFragment2.text =
                    "Consumo ingresado: %.2f kWh\n" +
                            "Exceso: %.2f kWh\n" +
                            "Recargo: S/ %.2f".format(consumo, exceso, recargo)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
