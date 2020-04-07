package com.internshala.mounty.ui.toprated

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.internshala.mounty.data.repositories.MoviesRepository

@Suppress("UNCHECKED_CAST")
class TopRatedViewModelFactory(
    private val repository: MoviesRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TopRatedViewModel(repository) as T
    }
}