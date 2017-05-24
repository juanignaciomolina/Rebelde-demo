package ar.com.wolox.kotlintest.components

import android.content.Context
import android.text.InputType
import android.widget.LinearLayout
import ar.com.wolox.kotlintest.R
import com.github.ybq.android.spinkit.style.DoubleBounce
import trikita.anvil.DSL
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView

/**
 * MIT License
 *
 * Copyright (c) 2017 Juan Ignacio Molina
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
class SearchBarComponent(context: Context,
                         val w: Int = MATCH,
                         val h: Int = WRAP,
                         val isFetching: Boolean,
                         val searchCallback: (query: String) -> Unit) : RenderableView(context) {

    init {
        view()
    }

    override fun view() {
        linearLayout {
            size(w, h)
            orientation(LinearLayout.HORIZONTAL)

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
                textSize(DSL.sip(18f))
                singleLine(true)
                margin(dip(8), 0, 0, 0)
                inputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS)

                onTextChanged(DelayedTextWatcher { text ->
                    searchCallback(text)
                })

            }

            progressBar {
                size(dip(24), dip(24))
                visibility(isFetching)
                layoutGravity(BOTTOM)
                margin(0, 0, 0, dip(16))
                indeterminateDrawable(DoubleBounce())
            }
        }
    }

}