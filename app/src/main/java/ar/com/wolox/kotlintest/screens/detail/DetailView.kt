package ar.com.wolox.kotlintest.screens.detail

import android.content.Context
import android.widget.LinearLayout
import ar.com.wolox.kotlintest.R
import ar.com.wolox.kotlintest.components.gif.GifComponent
import ar.com.wolox.kotlintest.components.share.ShareMethodComponent
import ar.com.wolox.kotlintest.components.share.SocialNetwork
import com.facebook.drawee.drawable.ScalingUtils
import com.mcxiaoke.koi.ext.isAppInstalled
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

                    frameLayout {
                        size(MATCH, 0)
                        weight(0.6f) // 60% of the screen height

                        GifComponent(
                                context,
                                MATCH,
                                MATCH,
                                screen.store.state.gif.images.original.webp,
                                ScalingUtils.ScaleType.FIT_CENTER)
                    }

                    frameLayout {
                        size(MATCH, 0)
                        weight(0.4f) // 40% of the screen height
                        backgroundColor(R.color.white)
                        padding(dip(24), dip(32), dip(32), dip(32))

                        scrollView {
                            linearLayout {
                                size(MATCH, MATCH)
                                orientation(LinearLayout.VERTICAL)

                                textView {
                                    size(MATCH, WRAP)
                                    textSize(sip(24f))
                                    text(R.string.screen_detail_share)
                                    margin(0, 0, 0, dip(24))
                                }

                                SocialNetwork.values()
                                        .filter {
                                            it.packageName == null ||
                                                    context.isAppInstalled(it.packageName)
                                        }
                                        .forEach {
                                            ShareMethodComponent(
                                                    context,
                                                    it,
                                                    screen.store.state.gif.url
                                            )
                                        }

                            }
                        }
                    }
                }
            }
        })
    }
}