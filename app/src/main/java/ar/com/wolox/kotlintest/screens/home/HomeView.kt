package ar.com.wolox.kotlintest.screens.home

import android.content.Context
import android.graphics.Color
import android.widget.LinearLayout
import ar.com.wolox.kotlintest.components.GifRecyclerComponent
import com.wealthfront.magellan.BaseScreenView
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView


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

                    GifRecyclerComponent(context, screen.store.state.gifs)

                }
            }
        })
    }


}