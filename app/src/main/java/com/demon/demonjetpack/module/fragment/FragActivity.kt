package com.demon.demonjetpack.module.fragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.demon.basemvvm.intent.extraAct
import com.demon.basemvvm.mvvm.BaseViewModel
import com.demon.basemvvm.mvvm.MvvmActivity
import com.demon.demonjetpack.base.data.RouterConst
import com.demon.demonjetpack.databinding.ActivityFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@Route(path = RouterConst.ACT_FRAGMENT)
@AndroidEntryPoint
class FragActivity : MvvmActivity<ActivityFragmentBinding,BaseViewModel>() {

    var list: ArrayList<String> by extraAct("params", arrayListOf())

    override fun init() {

        //val list = arrayListOf("鸿洋", "郭霖")

        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = list.size

            override fun createFragment(position: Int): Fragment = TabFragment(list[position])
        }
        binding.viewPager2.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = list[position]
        }.attach()
    }

    override fun initViewModel() {
    }

}
