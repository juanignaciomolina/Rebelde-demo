package ar.com.wolox.kotlintest.screens.detail

import android.content.Context
import android.widget.LinearLayout
import ar.com.wolox.kotlintest.components.gif.GifComponent
import com.facebook.drawee.drawable.ScalingUtils
import com.wealthfront.magellan.BaseScreenView
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView


class DetailView(context: Context) : BaseScreenView<DetailScreen>(context) {

    init {
        addView(object : RenderableView(context) {
            override fun view() {

                linearLayout {
                    size(MATCH, MATCH)
                    orientation(LinearLayout.VERTICAL)

                    GifComponent(
                            context,
                            MATCH,
                            dip(420),
                            screen.store.state.gif.images.original.webp,
                            ScalingUtils.ScaleType.FIT_CENTER)
                }

            }
        })

    }
}