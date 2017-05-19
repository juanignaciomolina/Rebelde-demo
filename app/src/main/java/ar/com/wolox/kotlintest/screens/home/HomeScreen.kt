package ar.com.wolox.kotlintest.screens.home

import android.content.Context
import com.brianegan.bansa.BaseStore
import com.wealthfront.magellan.Screen
import trikita.anvil.Anvil


class HomeScreen : Screen<HomeView>() {

    //Store
    val store = BaseStore(HomeState(), HomeReducer().reducer)
    val presenter = HomePresenter(store)

    // View layer
    override fun createView(context: Context): HomeView {
        store.subscribe { Anvil.render() }
        return HomeView(context)
    }
}
