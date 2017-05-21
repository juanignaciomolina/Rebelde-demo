package ar.com.wolox.kotlintest.screens.search

import android.content.Context
import com.wealthfront.magellan.Screen

class SearchScreen : Screen<SearchView>() {

    override fun createView(context: Context): SearchView {
        return SearchView(context)
    }

}