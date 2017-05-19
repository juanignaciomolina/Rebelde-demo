package ar.com.wolox.kotlintest.screens.home

import android.content.Context
import com.wealthfront.magellan.Screen
import com.yheriatovych.reductor.Action
import com.yheriatovych.reductor.Reducer
import com.yheriatovych.reductor.annotations.ActionCreator
import com.yheriatovych.reductor.annotations.AutoReducer


class HomeScreen : Screen<HomeView>() {

    // State actions
    @ActionCreator
    internal interface CounterActions {

        companion object {
            const val INCREMENT = "INCREMENT"
            const val ADD = "ADD"
        }

        @ActionCreator.Action(INCREMENT)
        fun increment(): Action

        @ActionCreator.Action(ADD)
        fun add(value: Int): Action
    }

    // State reducer
    @AutoReducer
    internal abstract class CounterReducer : Reducer<Int> {

        companion object {

            fun create(): CounterReducer = CounterReducerImpl()
        }

        @AutoReducer.InitialState
        fun initialState(): Int {
            return 0
        }

        @AutoReducer.Action(value = CounterActions.INCREMENT, from = CounterActions::class)
        fun increment(state: Int): Int {
            return state + 1
        }

        @AutoReducer.Action(value = CounterActions.ADD, from = CounterActions::class)
        fun add(state: Int, value: Int): Int {
            return state + value
        }

    }

    // View layer
    override fun createView(context: Context): HomeView {
        return HomeView(context)
    }
}
