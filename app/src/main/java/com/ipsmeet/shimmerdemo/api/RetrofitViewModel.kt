package com.ipsmeet.shimmerdemo.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipsmeet.shimmerdemo.model.PostsItem
import kotlinx.coroutines.launch

class RetrofitViewModel : ViewModel() {

    private val retrofitRepository = RetrofitRepository()

    private val _allPosts = MutableLiveData<List<PostsItem>>(emptyList())
    val allPosts: LiveData<List<PostsItem>> = _allPosts

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            _allPosts.value = retrofitRepository.getPosts().body()
        }
    }
}
