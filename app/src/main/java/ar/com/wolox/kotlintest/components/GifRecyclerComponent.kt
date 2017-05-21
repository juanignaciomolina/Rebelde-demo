package ar.com.wolox.kotlintest.components

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import ar.com.wolox.kotlintest.R
import ar.com.wolox.kotlintest.models.Metadata
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.drawable.ProgressBarDrawable
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.facebook.drawee.view.SimpleDraweeView
import trikita.anvil.Anvil
import trikita.anvil.BaseDSL
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView
import trikita.anvil.recyclerview.Recycler

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
class GifRecyclerComponent(context: Context, val gifs: List<Metadata>) : RenderableView(context) {

    init {
        view()
    }

    /**
     * Neccesary to avoid a bug when detaching recycler views with Anvil
     */
    override fun onDetachedFromWindow() {
        Anvil.unmount(this, false)
    }

    override fun view() {

        v(RecyclerView::class.java) {
            val recycler = Anvil.currentView<RecyclerView>()
            size(MATCH, MATCH)

            recycler.layoutManager =
                    LinearLayoutManager(
                            context,
                            LinearLayoutManager.VERTICAL,
                            false)

            recycler.setHasFixedSize(true)

            recycler.adapter =
                    Recycler.Adapter.simple(gifs) {
                        viewHolder ->

                        v(SimpleDraweeView::class.java) {
                            BaseDSL.init {
                                Anvil.currentView<SimpleDraweeView>().hierarchy =
                                        GenericDraweeHierarchyBuilder(context.resources)
                                                .setPlaceholderImage(R.drawable.ic_loading)
                                                .setProgressBarImage(ProgressBarDrawable())
                                                .build()
                            }
                            size(MATCH, dip(360))
                            showGif(Anvil.currentView(),
                                    gifs[viewHolder.adapterPosition].images.original.webp)
                        }
                    }

            recycler.onFlingListener = null
            LinearSnapHelper().attachToRecyclerView(recycler)

        }
    }

    private fun showGif(simpleDraweeView: SimpleDraweeView, webpUrl: String) {
        simpleDraweeView.controller = Fresco.newDraweeControllerBuilder()
                .setUri(webpUrl)
                .setAutoPlayAnimations(true)
                .build()
    }
}