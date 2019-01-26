package com.first.retflix.view.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView

import com.first.retflix.R
import com.first.retflix.model.themoviewdb.moviebygenre.ResultsItem
import com.first.retflix.presenter.movie.MoviePresenter
import com.first.retflix.presenter.movie.MovieView
import com.first.retflix.view.home.adapter.MovieRecyclerViewAdapter
import com.first.retflix.view.home.adapter.NowplayingRecycle
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeFragment : Fragment(), MovieView {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val moviePresenter = MoviePresenter(this)

        moviePresenter.getMovieNowplaying()
        moviePresenter.getMoviePopular()
        moviePresenter.getMovieToprated()
        moviePresenter.getMovieUpcoming()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onResponseMovie(list: List<ResultsItem>) {
        homeNowplayingRecycleview.adapter = NowplayingRecycle(list, object : NowplayingRecycle.onClickListener {
            override fun itemOnClick(idMovie: ResultsItem) {

            }

        })
        homeNowplayingRecycleview.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onResponsePopular(list: List<ResultsItem>) {
        homePopularRecycleview.adapter =
                MovieRecyclerViewAdapter(list, object : MovieRecyclerViewAdapter.onClickListener {
                    override fun itemOnClick(idMovie: ResultsItem) {

                    }

                })
        homePopularRecycleview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onResponseToprated(list: List<ResultsItem>) {
        homeTopratedRecycleview.adapter = MovieRecyclerViewAdapter(list,object :MovieRecyclerViewAdapter.onClickListener{
            override fun itemOnClick(idMovie: ResultsItem) {

            }

        })

        homeTopratedRecycleview.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
    }

    override fun onResponseUpcoming(list: List<ResultsItem>) {
        homeUpcomingRecycleview.adapter = MovieRecyclerViewAdapter(list,object :MovieRecyclerViewAdapter.onClickListener{
            override fun itemOnClick(idMovie: ResultsItem) {

            }

        })

        homeUpcomingRecycleview.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

    }

    override fun onFailureMovie(msg: String) {
        toast(msg)
    }

}
