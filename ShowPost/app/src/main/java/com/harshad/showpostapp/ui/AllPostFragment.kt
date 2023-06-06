package com.harshad.showpostapp.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.harshad.showpostapp.PostApplication
import com.harshad.showpostapp.adapter.OnItemClick
import com.harshad.showpostapp.adapter.PostsAdapter
import com.harshad.showpostapp.data.DetailPost
import com.harshad.showpostapp.data.local.PostEntity
import com.harshad.showpostapp.databinding.FragmentAllPostBinding
import com.harshad.showpostapp.util.CheckConnection
import com.harshad.showpostapp.viewmodel.PostViewFactory
import com.harshad.showpostapp.viewmodel.PostViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AllPostFragment : Fragment(), OnItemClick {

    private lateinit var binding: FragmentAllPostBinding
    private lateinit var postViewModel: PostViewModel
    private lateinit var checkConnection: CheckConnection
    private var posts = emptyList<PostEntity>()
    private lateinit var postsAdapter: PostsAdapter
    private val TAG = "AllPost"

    companion object {
        var isPostFetched = false
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView")
        binding = FragmentAllPostBinding.inflate(inflater, container, false)
        initViewModel()
        checkNetworkAndCallApi()
        setRecyclerview()
        checkApiCalled()
        return binding.root
    }

    private fun checkApiCalled() {
        if (!isPostFetched){
            getPostFromLocalDb()
        }else{
            binding.loader.visibility = View.GONE
        }
    }

    private fun getPostFromLocalDb() {
        binding.loader.visibility = View.GONE
        isPostFetched = true
        CoroutineScope(Dispatchers.IO).launch {
            posts = postViewModel.getAllLocalPost()
            postsAdapter.updatePostList(posts)
        }
    }

    private fun setRecyclerview() {
        postsAdapter = PostsAdapter(posts, this)
        binding.rvPosts.layoutManager = LinearLayoutManager(context)
        binding.rvPosts.adapter = postsAdapter
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
                postViewModel.loadPost()
            } else {
                Toast.makeText(
                    context,
                    "Please check your connection once network is back please re-lunch app",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onPostClick(postEntity: PostEntity) {
        val postDetails =
            DetailPost(postEntity.id, postEntity.userId, postEntity.title, postEntity.body)
        val action =
            AllPostFragmentDirections.actionAllPostFragmentToPostDetailsFragment(postDetails)
        findNavController().navigate(action)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach")
    }
}