package com.example.testableapproach.presentation.firstfragment

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testableapproach.R
import com.example.testableapproach.databinding.FragmentFirstBinding
import com.example.testableapproach.domain.DomainModel
import com.example.testableapproach.presentation.App
import com.example.testableapproach.presentation.firstfragment.adapter.FirstFragmentAdapter
import com.example.testableapproach.presentation.firstfragment.viewmodel.FirstFragmentViewModel
import com.example.testableapproach.presentation.firstfragment.viewmodel.FirstFragmentViewModelFactory
import com.example.testableapproach.presentation.secondfragment.SecondFragment

class FirstFragment : Fragment() {

    private val viewModel: FirstFragmentViewModel by lazy {
        ViewModelProvider(
            this,
            FirstFragmentViewModelFactory(App.instance)
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
        binding.ffFab.setOnClickListener{
            launchSecondFragment()
        }
        fragmentAdapter.itemClickListener = {
            launchSecondFragment(it.count)
        }
        viewModel.testRetrofit()
    }

    private fun launchSecondFragment(count: Int = 0) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, SecondFragment.newInstance(count))
            .addToBackStack(SecondFragment.NAME_FRAGMENT)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}