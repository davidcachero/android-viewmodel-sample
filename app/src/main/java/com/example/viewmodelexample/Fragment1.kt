package com.example.viewmodelexample

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelexample.databinding.Fragment1FragmentBinding

class Fragment1 : Fragment() {



    companion object {
        fun newInstance() = Fragment1()
    }

    private var binding: Fragment1FragmentBinding? = null
    private lateinit var viewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1FragmentBinding.inflate(inflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
        viewModel.getData().observe(viewLifecycleOwner, Observer {num ->
            binding!!.textView1.text = num.toString()
        })
    }

}