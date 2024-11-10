package com.example.a15_10_viewbinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.a15_10_viewbinding.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupWindowInsets(R.id.main)
        setupToolbar(R.id.toolbar, false)

        // Стартовый фрагмент
        if (savedInstanceState == null) {
            replaceFragment(DashboardFragment())
        }
    }

    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()

        // Настроить Toolbar после замены фрагмента
        supportFragmentManager.addOnBackStackChangedListener {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
            if (currentFragment is DashboardFragment) {
                setupToolbar(R.id.toolbar, false)
            } else {
                setupToolbar(R.id.toolbar, true)
            }
        }
    }
}