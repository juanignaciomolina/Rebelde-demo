package ar.com.wolox.kotlintest.screens.home

import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import ar.com.wolox.kotlintest.extensions.loadImage
import com.wealthfront.magellan.BaseScreenView
import trikita.anvil.Anvil
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView

class HomeView(context: Context) : BaseScreenView<HomeScreen>(context) {

    init {
        addView(object : RenderableView(context) {
            override fun view() {
                linearLayout {
                    size(MATCH, MATCH)
                    padding(dip(8))
                    orientation(LinearLayout.VERTICAL)

                    /*textView {
                        visibility = if (screen.store.state.isFetching) View.VISIBLE else View.GONE
                        size(MATCH, WRAP)
                        gravity(CENTER)
                        text("LOADING")
                        textSize(sip(18f))
                    }*/

                    /*textView {
                        size(MATCH, 0)
                        weight(1f)
                        gravity(CENTER)
                        textSize(sip(32f))
                        text("URL: " + screen.store.state.gif.url)
                    }*/

/*                    v(SimpleDraweeView::class.java) {
                        size(MATCH, 0)
                        weight(1f)
                        init {
                            val view: SimpleDraweeView = Anvil.currentView()
                            view.setImageURI(screen.store.state.gif.url)
                        }
                    }*/

                    imageView {
                        size(MATCH, 0)
                        weight(1f)
                        init {
                            Anvil
                                    .currentView<ImageView>()
                                    .loadImage(screen.store.state.gif.url)
                        }
                    }

                    button {
                        size(MATCH, WRAP)
                        text("Go to detail")
                        layoutGravity(CENTER)
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

}