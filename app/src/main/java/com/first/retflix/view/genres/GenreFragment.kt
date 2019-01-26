package com.first.retflix.view.genres

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.first.retflix.R
import com.first.retflix.model.themoviewdb.genres.GenresItem
import com.first.retflix.presenter.movie.GenresPresenter
import com.first.retflix.presenter.movie.GenresView
import com.first.retflix.view.genres.adapter.TabPagerAdapter
import kotlinx.android.synthetic.main.fragment_genre.*
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [GenreFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [GenreFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class GenreFragment : Fragment(),GenresView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val genresPresenter = GenresPresenter(this)
        genresPresenter.getAllGenres()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_genre, container, false)
    }
    override fun onResponseGenres(list: List<GenresItem>) {
        setTabPager(list)
    }

    override fun onFailureGenres(msg: String) {
        toast(msg)
    }

    private fun setTabPager(list: List<GenresItem>) {
        val adapter = TabPagerAdapter(activity!!.supportFragmentManager,list)
        viewHome.adapter = adapter
        tabHome.setupWithViewPager(viewHome)

    }


}
