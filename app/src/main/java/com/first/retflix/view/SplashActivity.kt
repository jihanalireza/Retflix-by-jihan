package com.first.retflix.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.first.retflix.R
import com.first.retflix.model.database.AppDatabase
import com.first.retflix.model.database.Setslider
import com.first.retflix.view.home.HomeActivity
import com.first.retflix.view.setslide.SlideActivity
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        async(UI){
            val setSlide = bg {
                Thread.sleep(2000)
                AppDatabase.getDatabase(this@SplashActivity).SetsliderDao().getAll()
            }

            checkSet(setSlide.await())
        }.start()
    }

    private fun checkSet(data: List<Setslider>) {

        if (data.size > 0){
            startActivity<HomeActivity>()
        }else{
            startActivity<SlideActivity>()
        }

    }
}
