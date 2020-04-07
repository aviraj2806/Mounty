package com.internshala.mounty.ui.toprated

import android.util.Log
import androidx.lifecycle.ViewModel
import com.internshala.mounty.data.repositories.MoviesRepository
import com.internshala.mounty.util.NoInternetException
import com.internshala.mounty.util.lazyDeferred

class TopRatedViewModel(
    repository: MoviesRepository
): ViewModel() {

      val topRatedMovies by lazyDeferred {
              repository.getTopRatedMovies("ff770397fd24c1dae861a3dfbee0a218")
        }
}