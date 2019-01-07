package com.example.techjini.myapplication

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.techjini.myapplication.databinding.AdapterHelpListBinding

/**
 * Created by Surya N on 04/01/19.
 */
class HelpAdapter(var list: List<MainActivity.Data>) : RecyclerView.Adapter<HelpAdapter.HelpViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelpViewHolder {
        val binding = DataBindingUtil.inflate<AdapterHelpListBinding>(LayoutInflater.from(parent.context), R.layout.adapter_help_list, parent, false)
        return HelpViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HelpViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateList(list: List<MainActivity.Data>) {
        this.list = list
        notifyDataSetChanged()
    }


    inner class HelpViewHolder(val binding: AdapterHelpListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: MainActivity.Data) {
            binding.tag.text = data.list
        }

    }
}
