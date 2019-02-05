package com.chaturaloka.dota2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chaturaloka.dota2.view.HeroListFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add project list fragment if this is first creation
        if (savedInstanceState == null) {
            val fragment = HeroListFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment, HeroListFragment.TAG).commit()
        }
    }


}
