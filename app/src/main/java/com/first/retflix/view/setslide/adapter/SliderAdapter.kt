package com.first.retflix.view.setslide.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.first.retflix.R
import kotlinx.android.synthetic.main.fragment_slide.view.*

class SliderAdapter(private val mContext: Context): PagerAdapter() {

    val titleslide = arrayOf("REVIEW","SHARE","TALK")
    val iconslide = arrayOf(R.drawable.review,R.drawable.share,R.drawable.talk)
    val descriptslide = arrayOf(
        "In my family, I am the second child. I have an older brother named Nathan and one younger sister named Grace. My mother is from China and my father is from Australia. We live in Indonesia.",
        "In my family, I am the second child. I have an older brother named Nathan and one younger sister named Grace. My mother is from China and my father is from Australia. We live in Indonesia.",
        "In my family, I am the second child. I have an older brother named Nathan and one younger sister named Grace. My mother is from China and my father is from Australia. We live in Indonesia."
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context)
            .inflate(R.layout.fragment_slide, container, false)
        view.iconslide.setImageResource(iconslide.get(position))
        view.titleslide.text = titleslide.get(position)
        view.descriptslide.text = descriptslide.get(position)

        container.addView(view)
        return view
    }

    override fun getCount(): Int {
        return titleslide.size
    }

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 === p1
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}
