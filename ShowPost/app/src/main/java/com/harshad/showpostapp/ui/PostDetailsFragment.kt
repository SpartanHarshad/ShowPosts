package com.harshad.showpostapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.harshad.showpostapp.R
import com.harshad.showpostapp.data.DetailPost
import com.harshad.showpostapp.databinding.FragmentPostDetailsBinding


class PostDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPostDetailsBinding
    private val args: PostDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostDetailsBinding.inflate(inflater, container, false)
        val post: DetailPost = args.post
        setData(post)
        return binding.root
    }

    private fun setData(post: DetailPost) {
        binding.apply {
            tvUserId.text = "${post.userId}"
            tvId.text = "${post.id}"
            tvTitle.text = post.title
            tvBody.text = post.body
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = PostDetailsFragment()
    }
}