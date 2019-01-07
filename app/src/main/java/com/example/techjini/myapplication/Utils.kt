package com.example.techjini.myapplication

import android.view.View
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by Surya N on 04/01/19.
 */
object Utils {

    fun setupItem(view: View, libraryObject: LibraryObject) {
        val txt = view.findViewById(R.id.tag) as TextView
        txt.text = libraryObject.title
    }

    class LibraryObject(var title: String?)
}
