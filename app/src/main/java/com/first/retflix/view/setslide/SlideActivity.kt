package com.first.retflix.view.setslide

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.first.retflix.R
import com.first.retflix.model.database.AppDatabase
import com.first.retflix.model.database.Setslider
import com.first.retflix.view.home.HomeActivity
import com.first.retflix.view.setslide.adapter.SliderAdapter
import kotlinx.android.synthetic.main.activity_slide.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.onPageChangeListener
import java.util.*

class SlideActivity : AppCompatActivity() {
    var currentPage: Int? = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)

        slideviewpager.adapter = SliderAdapter(this)

        btnBack.onClick {
            currentPage?.minus(1)?.let { it1 -> slideviewpager.setCurrentItem(it1) }
        }

        btnNext.onClick {
            if (currentPage == 2) {

                val setslider = Setslider()

                val datenow = Calendar.getInstance().time
                setslider.firstSet = "finish"
                setslider.firstImpression = datenow.toString()

                doAsync {
                    bg {
                        AppDatabase.getDatabase(this@SlideActivity).SetsliderDao().insertAll(setslider)
                    }
                }

                startActivity<HomeActivity>()
            }
            currentPage?.plus(1)?.let { it1 -> slideviewpager.setCurrentItem(it1) }
        }
        slideviewpager.onPageChangeListener {
            onPageSelected { i ->
                currentPage = i
                if (currentPage == 0) {
                    btnNext.isEnabled = true
                    btnBack.isEnabled = false
                    btnBack.visibility = View.INVISIBLE

                    btnNext.text = "NEXT"
                    btnBack.text = ""
                } else if (currentPage == 2) {
                    btnNext.isEnabled = true
                    btnBack.isEnabled = true
                    btnBack.visibility = View.VISIBLE

                    btnNext.text = "FINISH"
                    btnBack.text = "BACK"
                } else {
                    btnNext.isEnabled = true
                    btnBack.isEnabled = true
                    btnBack.visibility = View.VISIBLE

                    btnNext.text = "NEXT"
                    btnBack.text = "BACK"
                }
            }
        }


    }


}
