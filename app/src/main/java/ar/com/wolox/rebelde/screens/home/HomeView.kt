package ar.com.wolox.rebelde.screens.home

import android.content.Context
import android.widget.LinearLayout
import ar.com.wolox.rebelde.R
import ar.com.wolox.rebelde.components.RebelItemsRecyclerComponent
import ar.com.wolox.rebelde.models.RebelItemsRepository
import ar.com.wolox.rebelde.screens.detail.DetailScreen
import com.wealthfront.magellan.BaseScreenView
import com.wealthfront.magellan.transitions.NoAnimationTransition
import trikita.anvil.Anvil
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView


class HomeView(context: Context) : BaseScreenView<HomeScreen>(context) {

    val rebelRepository = RebelItemsRepository()

    init {
        addView(object : RenderableView(context) {
            override fun view() {
                frameLayout {
                    backgroundResource(R.drawable.drawable_background)
                    size(MATCH, MATCH)

                    RebelItemsRecyclerComponent(context, screen.store.state.items) { _, rebelItem ->
                        screen.navigator.
                                overrideTransition(NoAnimationTransition())
                                .show(DetailScreen(rebelItem))
                    }

                    linearLayout {
                        size(MATCH, MATCH)
                        orientation(LinearLayout.HORIZONTAL)
                        gravity(CENTER_HORIZONTAL)
                        margin(0, dip(32))

                        button {
                            size(WRAP, WRAP)
                            text("All")

                            onClick {
                                screen.store.dispatch(HomeReducer.SET_ITEMS(rebelRepository.provideAllItems()))
                            }
                        }

                        button {
                            size(WRAP, WRAP)
                            text("Motorcycles")

                            onClick {
                                screen.store.dispatch(HomeReducer.SET_ITEMS(rebelRepository.provideMotorcycles()))
                            }
                        }

                        button {
                            size(WRAP, WRAP)
                            text("Haircuts")

                            onClick {
                                screen.store.dispatch(HomeReducer.SET_ITEMS(rebelRepository.provideHaircuts()))
                            }
                        }

                        button {
                            size(WRAP, WRAP)
                            text("Jackets")

                            onClick {
                                screen.store.dispatch(HomeReducer.SET_ITEMS(rebelRepository.provideLeatherjackets()))
                            }
                        }


                    }

                }
            }

            // This fixes an issue with Anvil and RecyclerViews
            // https://github.com/zserge/anvil/issues/95
            override fun onDetachedFromWindow() {
                Anvil.unmount(this, false)
            }
        })
    }
}