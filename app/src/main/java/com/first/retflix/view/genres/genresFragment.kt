package com.first.retflix.view.genres

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.first.retflix.R
import com.first.retflix.model.themoviewdb.moviebygenre.ResultsItem
import com.first.retflix.presenter.movie.MoviePresenter
import com.first.retflix.presenter.movie.MovieView
import com.first.retflix.view.detailmovie.DetailMovieActivity
import com.first.retflix.view.home.adapter.MovieRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_genres.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

@SuppressLint("ValidFragment")
/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [genresFragment.OnListFragmentInteractionListener] interface.
 */
class genresFragment(private val i: Int) : Fragment(), MovieView {



    var genre_id = i

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_genres, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataMovie()
        swipeRefresh.setOnRefreshListener {
            Handler(Looper.getMainLooper()).postDelayed({
                getDataMovie()
                swipeRefresh.isRefreshing = false
            },2000)
        }
    }

    private fun getDataMovie() {
        val moviePresenter = MoviePresenter(this)
        moviePresenter.getMoviesbyGenre(genre_id)
    }

    override fun onResponseMovie(list: List<ResultsItem>) {
        showItemMovies(list)
    }

    override fun onFailureMovie(msg: String) {
        toast(msg)
    }

    private fun showItemMovies(list: List<ResultsItem>) {
        listMovie.adapter = MovieRecyclerViewAdapter(list,object :MovieRecyclerViewAdapter.onClickListener{
            override fun itemOnClick(item: ResultsItem) {
               startActivity<DetailMovieActivity>("movieId" to item.id.toString())
            }

        });
        listMovie.layoutManager = GridLayoutManager(context,3)
    }

    override fun onResponsePopular(list: List<ResultsItem>) {

    }

    override fun onResponseToprated(list: List<ResultsItem>) {

    }

    override fun onResponseUpcoming(list: List<ResultsItem>) {

    }
}
