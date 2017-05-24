package ar.com.wolox.kotlintest.components.gif

import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco.newDraweeControllerBuilder
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.facebook.drawee.view.SimpleDraweeView
import trikita.anvil.Anvil
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView

/**
 * MIT License
 *
 * Copyright (c) 2017 Wolox S.A
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */
class GifComponent(context: Context,
                   val w: Int = MATCH,
                   val h: Int = WRAP,
                   val gifUri: String,
                   val scaleType: ScalingUtils.ScaleType = ScalingUtils.ScaleType.CENTER_CROP)
    : RenderableView(context) {

    init {
        view()
    }

    override fun view() {
        // Fresco Image to display the selected Gif
        v(SimpleDraweeView::class.java) {
            init {
                Anvil.currentView<SimpleDraweeView>().hierarchy =
                        GenericDraweeHierarchyBuilder(context.resources)
                                .setPlaceholderImage(ar.com.wolox.kotlintest.R.drawable.ic_loading)
                                .setProgressBarImage(com.facebook.drawee.drawable.ProgressBarDrawable())
                                .setActualImageScaleType(scaleType)
                                .build()
            }

            size(w, h)
            backgroundColor(ar.com.wolox.kotlintest.R.color.black)

            Anvil.currentView<SimpleDraweeView>().controller =
                    newDraweeControllerBuilder()
                            .setUri(gifUri)
                            .setAutoPlayAnimations(true)
                            .build()
        }
    }

}