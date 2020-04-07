package com.internshala.mounty

import android.app.Application
import com.internshala.mounty.data.network.NetwrokConnectionInterceptor
import com.internshala.mounty.data.network.TMDBApi
import com.internshala.mounty.data.repositories.MoviesRepository
import com.internshala.mounty.ui.toprated.TopRatedViewModelFactory
import com.internshala.mounty.ui.upcoming.UpcomingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MountyApplicaton: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MountyApplicaton))

        bind() from singleton { NetwrokConnectionInterceptor(instance()) }
        bind() from singleton { TMDBApi(instance()) }
        bind() from singleton { MoviesRepository(instance()) }
        bind() from singleton { TopRatedViewModelFactory(instance()) }
        bind() from singleton { UpcomingViewModelFactory(instance()) }
    }

}