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
import com.example.viewmodelexample.databinding.Fragment2FragmentBinding

class Fragment2 : Fragment() {

    companion object {
        fun newInstance() = Fragment2()
    }

    private var binding: Fragment2FragmentBinding? = null
    private lateinit var viewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2FragmentBinding.inflate(inflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
        viewModel.getData().observe(viewLifecycleOwner, Observer {num ->
            binding!!.textView2.text = num.toString()
        })
    }

}