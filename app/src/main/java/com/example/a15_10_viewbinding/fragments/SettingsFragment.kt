package com.example.a15_10_viewbinding.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.a15_10_viewbinding.MainActivity
import com.example.a15_10_viewbinding.databinding.FragmentSettingsBinding
import com.example.a15_10_viewbinding.R

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // SharedPreferences
        sharedPreferences = requireActivity().getSharedPreferences("app_preferences", AppCompatActivity.MODE_PRIVATE)

        // Устанавливаем начальное состояние переключателя
        val isDarkMode = sharedPreferences.getBoolean("dark_mode", false)
        binding.switchTheme.isChecked = isDarkMode

        binding.switchTheme.setOnCheckedChangeListener { _, isChecked ->

            val editor = sharedPreferences.edit()
            editor.putBoolean("dark_mode", isChecked)
            editor.apply()

            applyTheme(isChecked)

            requireActivity().recreate()
        }
    }

    override fun onResume() {
        super.onResume()

        val isDarkMode = sharedPreferences.getBoolean("dark_mode", false)
        applyTheme(isDarkMode)

        (activity as? MainActivity)?.setupToolbar(R.id.toolbar, true)
    }

    private fun applyTheme(isDarkMode: Boolean) {
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
