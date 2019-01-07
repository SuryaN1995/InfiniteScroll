package com.example.techjini.myapplication

import android.support.v7.widget.RecyclerView


/**
 * Class for centering items after scroll event.<br></br>
 * This class will listen to current scroll state and if item is not centered after scroll it will automatically scroll it to center.
 */
class CenterScrollListener(private val listener: ScrollListener) : RecyclerView.OnScrollListener() {

    private var mAutoSet = true

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        val layoutManager = recyclerView.layoutManager
        if (layoutManager !is CarouselLayoutManager) {
            mAutoSet = true
            return
        }

        if (!mAutoSet) {
            if (RecyclerView.SCROLL_STATE_IDLE == newState) {
                val scrollNeeded = layoutManager.offsetCenterView
                if(scrollNeeded >= 0) {
                    if (CarouselLayoutManager.HORIZONTAL == layoutManager.orientation) {
                        recyclerView.scrollToPosition(scrollNeeded)
                    } else {
                        recyclerView.scrollToPosition(scrollNeeded)
                    }
                    mAutoSet = true
                }
            }
        }
        if (RecyclerView.SCROLL_STATE_DRAGGING == newState || RecyclerView.SCROLL_STATE_SETTLING == newState) {
            mAutoSet = false
        }
        if (RecyclerView.SCROLL_STATE_IDLE == newState) {
            listener.onRecyclerListener(layoutManager.centerItemPosition)
        }
    }
}