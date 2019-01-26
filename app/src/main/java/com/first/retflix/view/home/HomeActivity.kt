package com.first.retflix.view.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.first.retflix.R
import com.first.retflix.model.themoviewdb.genres.GenresItem
import com.first.retflix.presenter.movie.GenresPresenter
import com.first.retflix.presenter.movie.GenresView
import com.first.retflix.view.genres.GenreFragment
import com.first.retflix.view.genres.adapter.TabPagerAdapter
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.activityManager
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast
import android.graphics.Color.parseColor
import android.R.attr.fragment
import android.support.design.widget.TabLayout
import android.support.design.widget.TabLayout.OnTabSelectedListener
import com.first.retflix.view.trending.TrendingFragment


class HomeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setFragmentMenu(HomeFragment())

        tabBottom.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                when(p0?.position){
                    0 -> setFragmentMenu(HomeFragment())
                    1 -> setFragmentMenu(TrendingFragment())
                    2 -> setFragmentMenu(GenreFragment())
                }
            }

        })

    }


    fun setFragmentMenu(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frameMenu,fragment).commit()
    }


}
