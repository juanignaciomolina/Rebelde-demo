package ar.com.wolox.kotlintest.screens.home

import android.content.Context
import android.graphics.Color
import android.support.design.widget.FloatingActionButton
import ar.com.wolox.kotlintest.R
import ar.com.wolox.kotlintest.components.gif.GifRecyclerComponent
import ar.com.wolox.kotlintest.screens.detail.DetailScreen
import ar.com.wolox.kotlintest.screens.search.SearchScreen
import com.github.ybq.android.spinkit.style.CubeGrid
import com.wealthfront.magellan.BaseScreenView
import com.wealthfront.magellan.transitions.NoAnimationTransition
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

                    if (screen.store.state.isFetching) {
                        progressBar {
                            size(MATCH, WRAP)
                            visibility(screen.store.state.isFetching)
                            layoutGravity(CENTER)
                            margin(dip(48))
                            indeterminateDrawable(CubeGrid())
                        }
                    } else {
                        GifRecyclerComponent(context, screen.store.state.gifs) { _, gif ->
                            screen.navigator.
                                    overrideTransition(NoAnimationTransition())
                                    .show(DetailScreen(gif))
                        }
                    }

                    v(FloatingActionButton::class.java) {
                        size(WRAP, WRAP)
                        margin(0, 0, dip(16), dip(64))
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