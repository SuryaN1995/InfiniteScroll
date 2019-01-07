package com.example.techjini.myapplication

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.techjini.myapplication.Utils.setupItem

/**
 * Created by Surya N on 04/01/19.
 */
class PageScrollAdapter(val list: List<Utils.LibraryObject>, val context: Context) : PagerAdapter() {
    override fun isViewFromObject(view: View, any: Any): Boolean {
        return view == any
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_help_list, container, false)
        setupItem(view, list[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}