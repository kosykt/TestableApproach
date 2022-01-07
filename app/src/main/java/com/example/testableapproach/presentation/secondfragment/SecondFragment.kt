package com.example.testableapproach.presentation.secondfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testableapproach.databinding.FragmentSecondBinding
import kotlin.properties.Delegates

class SecondFragment : Fragment() {

    private var count by Delegates.notNull<Int>()

    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding
        get() = _binding ?: throw RuntimeException("FragmentSecondBinding? = null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (count != 0) {
            binding.sfTv.text = count.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArgs() {
        requireArguments().getInt(BUNDLE_KEY).let {
            count = it
        }
    }

    companion object {

        const val NAME_FRAGMENT = "SecondFragment"
        private const val BUNDLE_KEY = "bundle_key"

        fun newInstance(count: Int): SecondFragment {
            return SecondFragment().apply {
                arguments = Bundle().apply {
                    putInt(BUNDLE_KEY, count)
                }
            }
        }
    }
}