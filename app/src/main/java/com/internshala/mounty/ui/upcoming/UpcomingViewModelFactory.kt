package com.internshala.mounty.ui.upcoming

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.internshala.mounty.data.repositories.MoviesRepository

@Suppress("UNCHECKED_CAST")
class UpcomingViewModelFactory(
    private val repository: MoviesRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UpcomingViewModel(repository) as T
    }
}