package com.harshad.showpostapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.harshad.showpostapp.PostApplication
import com.harshad.showpostapp.databinding.FragmentAllPostBinding
import com.harshad.showpostapp.util.CheckConnection
import com.harshad.showpostapp.viewmodel.PostViewFactory
import com.harshad.showpostapp.viewmodel.PostViewModel


class AllPostFragment : Fragment() {

    private lateinit var binding: FragmentAllPostBinding
    private lateinit var postViewModel: PostViewModel
    private lateinit var checkConnection: CheckConnection

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
        checkNetworkAndCallApi()
        return binding.root
    }

    private fun initViewModel() {
        val postApp = activity?.application as PostApplication
        checkConnection = CheckConnection(postApp)
        val postRepo = postApp.postRepository
        val postFactory = PostViewFactory(postRepo)
        postViewModel = ViewModelProvider(requireActivity(), postFactory)[PostViewModel::class.java]
    }

    private fun checkNetworkAndCallApi() {
        checkConnection.observe(viewLifecycleOwner) { networkState ->
            if (networkState) {
                postViewModel.getPost()
            } else {
                Toast.makeText(context, "Please check your connection once network is back please re-lunch app", Toast.LENGTH_SHORT).show()
            }
        }
    }

}