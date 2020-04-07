package com.internshala.mounty.ui.upcoming

import androidx.lifecycle.ViewModel
import com.internshala.mounty.data.repositories.MoviesRepository
import com.internshala.mounty.util.lazyDeferred

class UpcomingViewModel(
    repository: MoviesRepository
): ViewModel() {
    val upcomingMovies by lazyDeferred {
        repository.getUpcomingMovies("ff770397fd24c1dae861a3dfbee0a218")
    }
}