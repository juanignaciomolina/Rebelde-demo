package ar.com.wolox.kotlintest.screens.home

import android.content.Context
import android.graphics.Color
import android.support.design.widget.FloatingActionButton
import ar.com.wolox.kotlintest.R
import ar.com.wolox.kotlintest.components.GifRecyclerComponent
import ar.com.wolox.kotlintest.screens.search.SearchScreen
import com.wealthfront.magellan.BaseScreenView
import trikita.anvil.Anvil
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView


class HomeView(context: Context) : BaseScreenView<HomeScreen>(context) {

    init {
        addView(object : RenderableView(context) {
            override fun view() {
                frameLayout {
                    backgroundColor(Color.BLACK)
                    size(MATCH, MATCH)

                    GifRecyclerComponent(context, screen.store.state.gifs)

                    v(FloatingActionButton::class.java) {
                        size(WRAP, WRAP)
                        margin(0, 0 , dip(16), dip(64))
                        layoutGravity(BOTTOM or END)
                        imageResource(R.drawable.ic_search)

                        onClick {
                            screen.navigator.goTo(SearchScreen())
                        }
                    }

                }
            }

            // TODO TEMPORAL FIX FOR RECYCLER ISSUE
            override fun onDetachedFromWindow() {
                Anvil.unmount(this, false)
            }
        })

    }


}