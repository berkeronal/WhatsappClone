package com.berker.whatsappclone.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomePagerAdapter(
    private var fragmentList: ArrayList<Pair<Fragment, String>>,
    fragmentManager: FragmentManager,
) :
    FragmentPagerAdapter(fragmentManager) {
    override fun getCount() = fragmentList.size
    override fun getItem(position: Int) = fragmentList[position].first
    override fun getPageTitle(position: Int) = fragmentList[position].second
}