package ar.com.wolox.kotlintest.screens.search

import android.content.Context
import android.text.InputType
import android.widget.LinearLayout
import ar.com.wolox.kotlintest.R
import ar.com.wolox.kotlintest.components.DelayedTextWatcher
import ar.com.wolox.kotlintest.components.GifRecyclerComponent
import com.github.ybq.android.spinkit.style.DoubleBounce
import com.wealthfront.magellan.BaseScreenView
import trikita.anvil.Anvil
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView

class SearchView(context: Context) : BaseScreenView<SearchScreen>(context) {

    init {
        addView(object : RenderableView(context) {
            override fun view() {
                linearLayout {
                    size(MATCH, MATCH)
                    orientation(LinearLayout.VERTICAL)

                    linearLayout {
                        size(MATCH, dip(96))
                        orientation(LinearLayout.HORIZONTAL)
                        padding(dip(16), dip(32), dip(16), dip(8))
                        backgroundColor(ar.com.wolox.kotlintest.R.color.colorPrimary)

                        imageView {
                            size(dip(24), dip(24))
                            imageResource(R.drawable.ic_search)
                            layoutGravity(BOTTOM)
                            margin(0, 0, 0, dip(16))
                        }

                        editText {
                            size(0, MATCH)
                            weight(1f)
                            hint("Search something...")
                            textSize(sip(18f))
                            singleLine(true)
                            margin(dip(8), 0, 0, 0)
                            inputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS)

                            onTextChanged(DelayedTextWatcher({
                                query ->
                                screen.presenter.searchGifs(query)
                            }))
                        }

                        progressBar {
                            size(dip(24), dip(24))
                            visibility(screen.store.state.isFetching)
                            layoutGravity(BOTTOM)
                            margin(0, 0, 0, dip(16))
                            indeterminateDrawable(DoubleBounce())
                        }
                    }

                    GifRecyclerComponent(context, screen.store.state.gifs)
                }
            }

            // TODO TEMPORAL FIX FOR RECYCLER ISSUE
            override fun onDetachedFromWindow() {
                Anvil.unmount(this, false)
            }
        })
    }

}