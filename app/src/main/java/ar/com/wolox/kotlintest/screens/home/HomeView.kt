package ar.com.wolox.kotlintest.screens.home

import android.content.Context
import android.graphics.Color
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

class HomeView(context: Context) : BaseScreenView<HomeScreen>(context) {

    var gifView : SimpleDraweeView? = null

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

                    v(SimpleDraweeView::class.java) {
                        init {
                            gifView = Anvil.currentView()
                            gifView!!.hierarchy = GenericDraweeHierarchyBuilder(context.resources)
                                    .setPlaceholderImage(R.drawable.ic_loading)
                                    .setProgressBarImage(ProgressBarDrawable())
                                    .build()
                        }
                        size(MATCH, 0)
                        weight(1f)
                        showGif()
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

    private fun showGif() {
        gifView!!.controller = Fresco.newDraweeControllerBuilder()
                .setUri(screen.store.state.gif.webp)
                .setAutoPlayAnimations(true)
                .build()
    }

}