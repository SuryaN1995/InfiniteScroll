package com.example.techjini.myapplication

import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ScrollListener {
    val list = ArrayList<Utils.LibraryObject>()
    var adapter: HelpAdapter? = null

    override fun onRecyclerListener(position: Int) {
        Toast.makeText(this, list[position].title, Toast.LENGTH_SHORT).show()
        adapter?.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager = CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true)
        layoutManager.setPostLayoutListener(CarouselZoomPostLayoutListener())
        list.add(getList("1"))
        list.add(getList("2"))
        list.add(getList("3"))
        list.add(getList("4"))
        list.add(getList("5"))
        rvFlip.adapter = PageScrollAdapter(list,this)
        rvFlip.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
//                Toast.makeText(this@MainActivity,"onScrolled Pos :${list[p0]}",Toast.LENGTH_SHORT).show()
            }

            override fun onPageSelected(p0: Int) {
                Toast.makeText(this@MainActivity,"onScrolled Pos :${rvFlip.realItem} , ${p0}",Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun getList(string: String): Utils.LibraryObject {
        return  Utils.LibraryObject(string)


    }

    class Data {
        var list: String? = null
        var isEnabled = false
    }
}
