package ar.com.wolox.rebelde.screens.detail

import android.content.Context
import ar.com.wolox.rebelde.models.IRebelItem
import com.brianegan.bansa.BaseStore
import com.wealthfront.magellan.Screen
import trikita.anvil.Anvil


class DetailScreen(item: IRebelItem) : Screen<DetailView>() {

    //Store
    val store = BaseStore(DetailState(item), DetailReducer().reducer)

    // View layer
    override fun createView(context: Context): DetailView {
        store.subscribe { Anvil.render() }
        return DetailView(context)
    }
}
