package com.internshala.mounty.ui.toprated

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.internshala.mounty.R
import com.internshala.mounty.data.network.responses.MovieResultsResponse
import com.internshala.mounty.ui.MovieItem
import com.internshala.mounty.util.Coroutines
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_top_rated.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class TopRatedFragment : Fragment(), KodeinAware {

    override val kodein by kodein()

    private val factory: TopRatedViewModelFactory by instance()

    private lateinit var viewModel: TopRatedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_rated, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(TopRatedViewModel::class.java)
        bindUI()
    }

    private fun bindUI() = Coroutines.main {
        initR(viewModel.topRatedMovies.await().results!!.toMovieItem())
        proTop.visibility = View.GONE
    }

     private fun initR(list: List<MovieItem>){

        val layoutManager1 = LinearLayoutManager(activity)
        layoutManager1.orientation = LinearLayoutManager.HORIZONTAL


        val adapter1 = GroupAdapter<ViewHolder>().apply {
            addAll(list)
        }

        recyclerTopRated.apply {

            layoutManager = layoutManager1
            setHasFixedSize(true)
            adapter = adapter1

        }
    }

     fun List<MovieResultsResponse>.toMovieItem(): List<MovieItem>{
        return this.map {
            MovieItem(it)
        }
    }

}
