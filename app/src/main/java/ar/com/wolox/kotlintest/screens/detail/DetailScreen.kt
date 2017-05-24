package ar.com.wolox.kotlintest.screens.detail

import android.content.Context
import ar.com.wolox.kotlintest.models.Metadata
import com.brianegan.bansa.BaseStore
import com.wealthfront.magellan.Screen
import trikita.anvil.Anvil


class DetailScreen(gif: Metadata) : Screen<DetailView>() {

    //Store
    val store = BaseStore(DetailState(gif), DetailReducer().reducer)
    val presenter = DetailPresenter(store)

    // View layer
    override fun createView(context: Context): DetailView {
        store.subscribe { Anvil.render() }
        return DetailView(context)
    }
}
