package com.berker.whatsappclone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.berker.whatsappclone.R
import com.berker.whatsappclone.databinding.ActivityMainBinding
import com.berker.whatsappclone.ui.chat.ChatFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : FragmentActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var fragmentList: ArrayList<Pair<Fragment, String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val viewPager = binding.vpHome
        val tabLayout = binding.tabLayout
        val vpAdapter = HomePagerAdapter(initFragmentList(), supportFragmentManager)
        initViewPager(viewPager, tabLayout, vpAdapter)
    }

    private fun initViewPager(
        viewPager: ViewPager,
        tabLayout: TabLayout,
        vpAdapter: HomePagerAdapter,
        currentItem: Int = 1,
    ) {
        viewPager.offscreenPageLimit = 2
        viewPager.adapter = vpAdapter
        viewPager.currentItem = currentItem
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    private fun initFragmentList(): ArrayList<Pair<Fragment, String>> {
        val fragmentListWithTitles: ArrayList<Pair<Fragment, String>> = arrayListOf()
        fragmentListWithTitles.add(Pair<Fragment, String>(ChatFragment(), "\uD83D\uDCF7"))
        fragmentListWithTitles.add(Pair<Fragment, String>(ChatFragment(), "CHAT"))
        fragmentListWithTitles.add(Pair<Fragment, String>(ChatFragment(), "STATUS"))
        fragmentListWithTitles.add(Pair<Fragment, String>(ChatFragment(), "CALLS"))
        return fragmentListWithTitles
    }
}