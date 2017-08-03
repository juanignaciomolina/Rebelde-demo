package ar.com.wolox.rebelde.screens.detail

import android.content.Context
import android.graphics.Typeface
import android.widget.LinearLayout
import ar.com.wolox.rebelde.R
import ar.com.wolox.rebelde.components.NetworkImageView
import com.facebook.drawee.drawable.ScalingUtils
import com.wealthfront.magellan.BaseScreenView
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView


class DetailView(context: Context) : BaseScreenView<DetailScreen>(context) {

    init {
        addView(object : RenderableView(context) {
            override fun view() {
                backgroundResource(R.drawable.drawable_background)

                linearLayout {
                    size(MATCH, MATCH)
                    orientation(LinearLayout.VERTICAL)

                    frameLayout {
                        size(MATCH, 0)
                        weight(0.6f) // 60% of the screen height

                        NetworkImageView(
                                context,
                                MATCH,
                                MATCH,
                                screen.store.state.item.pictureUrl(),
                                ScalingUtils.ScaleType.FIT_CENTER)
                    }

                    linearLayout {
                        size(MATCH, 0)
                        weight(0.4f) // 40% of the screen height
                        orientation(LinearLayout.VERTICAL)

                        // Item name
                        textView {
                            size(MATCH, WRAP)
                            gravity(CENTER)
                            text(screen.store.state.item.name())
                            textSize(sip(42F))
                            textColor(context.resources.getColor(R.color.colorAccent))
                            singleLine(true)
                            typeface(Typeface.createFromAsset(
                                    context.assets,
                                    "fonts/Bangers-Regular.ttf"))
                        }

                        // Item price
                        textView {
                            size(MATCH, WRAP)
                            gravity(CENTER)
                            textSize(sip(28F))
                            textColor(context.resources.getColor(R.color.white))
                            margin(0, dip(8), 0, 0)
                            text("For just $" + screen.store.state.item.price().toString())
                            typeface(Typeface.createFromAsset(
                                    context.assets,
                                    "fonts/KaushanScript-Regular.ttf"))
                        }

                        // Item description
                        textView {
                            size(MATCH, WRAP)
                            gravity(CENTER)
                            textSize(sip(18F))
                            textColor(context.resources.getColor(R.color.white))
                            margin(dip(8), dip(32), dip(8), dip(8))
                            text(screen.store.state.item.description())
                        }

                    }

                }
            }
        })
    }
}