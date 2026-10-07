package pe.edu.cibertec.appGrupo3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import pe.edu.cibertec.appGrupo3.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            replaceFragment(Pregunta1Fragment())
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_pregunta1 -> {
                    replaceFragment(Pregunta1Fragment())
                    true
                }
                R.id.nav_pregunta2 -> {
                    replaceFragment(Pregunta2Fragment())
                    true
                }
                R.id.nav_pregunta3 -> {
                    replaceFragment(Pregunta3Fragment())
                    true
                }
                R.id.nav_pregunta4 -> {
                    replaceFragment(Pregunta4Fragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}