package com.example.a15_10_viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a15_10_viewbinding.databinding.FragmentDashboardBinding
import com.example.a15_10_viewbinding.fragments.ChatFragment
import com.example.a15_10_viewbinding.fragments.HomeFragment
import com.example.a15_10_viewbinding.fragments.LogoutFragment
import com.example.a15_10_viewbinding.fragments.ProfileFragment
import com.example.a15_10_viewbinding.fragments.SettingsFragment
import com.example.a15_10_viewbinding.fragments.WidgetsFragment

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonHome.setOnClickListener {
            (activity as MainActivity).replaceFragment(HomeFragment())
        }

        binding.buttonChat.setOnClickListener {
            (activity as MainActivity).replaceFragment(ChatFragment())
        }

        binding.buttonProfile.setOnClickListener {
            (activity as MainActivity).replaceFragment(ProfileFragment())
        }

        binding.buttonWidgets.setOnClickListener {
            (activity as MainActivity).replaceFragment(WidgetsFragment())
        }

        binding.buttonSettings.setOnClickListener {
            (activity as MainActivity).replaceFragment(SettingsFragment())
        }

        binding.buttonLogout.setOnClickListener {
            (activity as MainActivity).replaceFragment(LogoutFragment())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}