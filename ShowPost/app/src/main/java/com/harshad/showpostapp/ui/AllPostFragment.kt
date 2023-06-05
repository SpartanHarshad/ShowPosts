package com.harshad.showpostapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.harshad.showpostapp.PostApplication
import com.harshad.showpostapp.R
import com.harshad.showpostapp.databinding.ActivityMainBinding
import com.harshad.showpostapp.databinding.FragmentAllPostBinding
import com.harshad.showpostapp.viewmodel.PostViewFactory
import com.harshad.showpostapp.viewmodel.PostViewModel


class AllPostFragment : Fragment() {

    private lateinit var binding: FragmentAllPostBinding
    private lateinit var postViewModel: PostViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAllPostBinding.inflate(inflater, container, false)
        initViewModel()
        return binding.root
    }

    private fun initViewModel() {
        val postApp = activity?.application as PostApplication
        val postRepo = postApp.postRepository
        val postFactory = PostViewFactory(postRepo)
        postViewModel = ViewModelProvider(requireActivity(), postFactory)[PostViewModel::class.java]
        postViewModel.getPost()
    }

    companion object {
        @JvmStatic
        fun newInstance() = AllPostFragment()
    }
}