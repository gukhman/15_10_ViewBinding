package com.example.a15_10_viewbinding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a15_10_viewbinding.BaseActivity
import com.example.a15_10_viewbinding.R
import com.example.a15_10_viewbinding.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (activity is BaseActivity) {
            (activity as BaseActivity).setupToolbar(R.id.toolbar, true)
        }
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chatSendButton.setOnClickListener {
            binding.chatMessages.setText(binding.chatInput.text)
            binding.chatInput.text.clear()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}