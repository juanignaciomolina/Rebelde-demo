package ar.com.wolox.kotlintest.screens.detail

import android.content.Context
import android.widget.LinearLayout
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

                    textView{
                        size(MATCH, 0)
                        weight(1f)
                        text("Detail View")
                        textSize(sip(32f))
                    }

                    button{
                        size(WRAP, WRAP)
                        text("Go back")
                        onClick { screen.navigator.goBack() }
                    }
                }
            }

        })
    }

}