package com.example.testableapproach.presentation.secondfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.testableapproach.data.DomainRepositoryImpl
import com.example.testableapproach.data.retrofit.ApiHolder
import com.example.testableapproach.data.retrofit.NetworkRepositoryImpl
import com.example.testableapproach.data.roomdatabase.AppDatabase
import com.example.testableapproach.data.roomdatabase.DatabaseRepositoryImpl
import com.example.testableapproach.data.roomdatabase.RoomModel
import com.example.testableapproach.databinding.FragmentSecondBinding
import com.example.testableapproach.domain.GetUseCase
import com.example.testableapproach.presentation.App
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class SecondFragment : Fragment() {

    private val appDatabase = AppDatabase.getInstance(App.instance)
    private val databaseRepository = DatabaseRepositoryImpl(appDatabase)

    private val retrofitService = ApiHolder.retrofitService
    private val networkRepository = NetworkRepositoryImpl(retrofitService = retrofitService)
    private val domainRepository = DomainRepositoryImpl(
        networkRepository = networkRepository,
        databaseRepository = databaseRepository
    )
    private val getUseCase = GetUseCase(repository = domainRepository)

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
        lifecycleScope.launch {
            val b: RoomModel? = getUseCase.getById(count.toString())
            binding.sfTv.text = b?.login
            Log.d("testRoom", b?.login.toString())
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