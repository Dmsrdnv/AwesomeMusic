package com.music.awesomemusic.functionalities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.music.awesomemusic.R
import com.music.awesomemusic.databinding.ActivityMainBinding
import com.music.awesomemusic.databinding.ActivityStartBinding
import com.music.awesomemusic.di.Injectable
import com.music.awesomemusic.di.ViewModelInjectionFactory
import com.music.awesomemusic.functionalities.start.StartActivity
import com.music.awesomemusic.functionalities.start.StartVM
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Injectable {

    private val _TAG = MainActivity::class.java.name

    private lateinit var _binding: ActivityMainBinding
    private lateinit var _viewModel: MainVM

    @Inject
    lateinit var viewModelInjectionFactory: ViewModelInjectionFactory<MainVM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBinding()
    }

    private fun initBinding() {
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        _viewModel = ViewModelProviders.of(this, viewModelInjectionFactory).get(MainVM::class.java)
        _binding.viewModel = _viewModel
    }
}