package ar.com.wolox.kotlintest.screens.home

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import ar.com.wolox.kotlintest.R
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.drawable.ProgressBarDrawable
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.facebook.drawee.view.SimpleDraweeView
import com.wealthfront.magellan.BaseScreenView
import trikita.anvil.Anvil
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView
import trikita.anvil.recyclerview.Recycler


class HomeView(context: Context) : BaseScreenView<HomeScreen>(context) {

    init {
        addView(object : RenderableView(context) {
            override fun view() {
                linearLayout {
                    backgroundColor(Color.BLACK)
                    size(MATCH, MATCH)
                    orientation(LinearLayout.VERTICAL)

                    textView {
                        size(MATCH, WRAP)
                        visibility(screen.store.state.isFetching)
                        gravity(CENTER)
                        text("LOADING")
                        textSize(sip(18f))
                    }

                    v(RecyclerView::class.java) {
                        val recycler = Anvil.currentView<RecyclerView>()
                        size(MATCH, 0)
                        weight(1f)

                        recycler.layoutManager =
                                LinearLayoutManager(
                                        context,
                                        LinearLayoutManager.VERTICAL,
                                        false)

                        recycler.setHasFixedSize(true)

                        recycler.adapter =
                                Recycler.Adapter.simple(screen.store.state.gifs) {
                                    viewHolder ->

                                    v(SimpleDraweeView::class.java) {
                                        init {
                                            Anvil.currentView<SimpleDraweeView>().hierarchy =
                                                    GenericDraweeHierarchyBuilder(context.resources)
                                                            .setPlaceholderImage(R.drawable.ic_loading)
                                                            .setProgressBarImage(ProgressBarDrawable())
                                                            .build()
                                        }
                                        size(MATCH, dip(360))
                                        showGif(Anvil.currentView(),
                                                screen.store.state
                                                        .gifs[viewHolder.adapterPosition]
                                                        .images.original.webp)
                                    }
                                }

                        recycler.onFlingListener = null
                        LinearSnapHelper().attachToRecyclerView(recycler)
                    }

                    button {
                        size(WRAP, WRAP)
                        text("Load gifs")
                        layoutGravity(CENTER)
                        padding(dip(16))
                        onClick {
                            screen.presenter.getGifs()
                            //screen.store.dispatch(HomeReducer.INCREMENT)
                            // screen.navigator.goTo(DetailScreen())
                        }
                    }
                }
            }
        })
    }

    private fun showGif(simpleDraweeView: SimpleDraweeView, webpUrl: String) {
        simpleDraweeView.controller = Fresco.newDraweeControllerBuilder()
                .setUri(webpUrl)
                .setAutoPlayAnimations(true)
                .build()
    }

}