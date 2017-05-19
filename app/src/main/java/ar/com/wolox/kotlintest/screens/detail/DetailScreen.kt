package ar.com.wolox.kotlintest.screens.detail

import android.content.Context
import com.wealthfront.magellan.Screen

class DetailScreen : Screen<DetailView>() {

    override fun createView(context: Context): DetailView {
        return DetailView(context)
    }

}