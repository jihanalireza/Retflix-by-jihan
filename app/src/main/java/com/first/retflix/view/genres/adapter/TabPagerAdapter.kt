package com.first.retflix.view.genres.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.first.retflix.model.themoviewdb.genres.GenresItem
import com.first.retflix.view.genres.genresFragment

class TabPagerAdapter(fm:FragmentManager,private val Tab: List<GenresItem>):FragmentPagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment {
        var fragment: Fragment? = null
        fragment = genresFragment(Tab.get(p0).id ?: 0)
        return fragment
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return Tab.get(position).name
        return super.getPageTitle(position)
    }

}