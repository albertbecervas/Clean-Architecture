package com.abecerra.cleanarchitecture.core.base

import android.support.v7.widget.RecyclerView

abstract class BaseAdapter<K : RecyclerView.ViewHolder, L>() : RecyclerView.Adapter<K>() {

    private val mItems: ArrayList<L> = arrayListOf()

    override fun onBindViewHolder(p0: K, p1: Int) {
        onBindViewHolder(p0, mItems[p1])
    }

    abstract fun onBindViewHolder(holder: K, item: L)

    override fun getItemCount(): Int = mItems.size

    fun setItems(items: List<L>) {
        mItems.clear()
        mItems.addAll(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<L>) {
        mItems.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: L) {
        mItems.add(item)
        notifyDataSetChanged()
    }

    fun clear() {
        mItems.clear()
    }

}