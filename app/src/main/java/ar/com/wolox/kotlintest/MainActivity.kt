package ar.com.wolox.kotlintest

import android.os.Bundle
import ar.com.wolox.kotlintest.screens.home.HomeScreen
import com.wealthfront.magellan.Navigator
import com.wealthfront.magellan.support.SingleActivity

class MainActivity : SingleActivity() {

    override fun createNavigator(): Navigator {
        return Navigator.withRoot(HomeScreen()).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}