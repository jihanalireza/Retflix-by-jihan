package com.first.retflix.view.trending

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.first.retflix.R
import com.first.retflix.model.themoviewdb.trending.ResultsItem
import com.first.retflix.presenter.movie.TrendingPresenter
import com.first.retflix.presenter.movie.TrendingView
import com.first.retflix.view.detailmovie.DetailMovieActivity
import com.first.retflix.view.trending.adapter.TrendingRecycleViewAdapter
import kotlinx.android.synthetic.main.fragment_trending.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TrendingFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TrendingFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TrendingFragment : Fragment(), TrendingView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val trendingPresenter = TrendingPresenter(this)
        trendingPresenter.getTrendingMovie("movie", "day")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending, container, false)
    }

    override fun onResponseTrending(list: List<ResultsItem>) {
        showTrending(list)
    }


    override fun onFailureTrending(localizedMessage: String) {
        toast(localizedMessage)
    }

    private fun showTrending(list: List<ResultsItem>) {
        try {


        trendingRecycleview.adapter = TrendingRecycleViewAdapter(list,object :TrendingRecycleViewAdapter.onClickListener{
            override fun itemOnClick(item: ResultsItem) {
                    startActivity<DetailMovieActivity>("movieId" to item.id.toString())
            }

        })
        trendingRecycleview.layoutManager = LinearLayoutManager(context)
        }catch (e:Exception){
            toast("Swipe")
        }
    }


}
