package com.example.testableapproach.presentation.firstfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testableapproach.databinding.FragmentFirstBinding
import com.example.testableapproach.presentation.firstfragment.adapter.FirstFragmentAdapter
import com.example.testableapproach.presentation.firstfragment.viewmodel.FirstFragmentViewModel
import com.example.testableapproach.presentation.firstfragment.viewmodel.FirstFragmentViewModelFactory

class FirstFragment : Fragment() {

    private val viewModel: FirstFragmentViewModel by lazy {
        ViewModelProvider(
            this,
            FirstFragmentViewModelFactory()
        )[FirstFragmentViewModel::class.java]
    }
    private val fragmentAdapter by lazy {
        FirstFragmentAdapter()
    }

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding
        get() = _binding ?: throw RuntimeException("FragmentFirstBinding? = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ffRv.adapter = fragmentAdapter

        viewModel.modelCount.observe(viewLifecycleOwner){
            fragmentAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}