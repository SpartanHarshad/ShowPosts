package com.harshad.showpostapp.adapter

import com.harshad.showpostapp.data.local.PostEntity

interface OnItemClick {

    fun onPostClick(postEntity: PostEntity)
}