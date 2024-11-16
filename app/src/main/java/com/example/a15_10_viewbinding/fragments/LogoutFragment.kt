package com.example.a15_10_viewbinding.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a15_10_viewbinding.BaseActivity
import com.example.a15_10_viewbinding.R
import com.example.a15_10_viewbinding.databinding.FragmentLogoutBinding

class LogoutFragment : Fragment() {

    private var _binding: FragmentLogoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (activity is BaseActivity) {
            (activity as BaseActivity).setupToolbar(R.id.toolbar, true)
        }
        _binding = FragmentLogoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logoutIV.setOnClickListener {
            requireActivity().finishAffinity()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}