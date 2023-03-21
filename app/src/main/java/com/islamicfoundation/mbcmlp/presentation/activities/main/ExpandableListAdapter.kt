package com.islamicfoundation.mbcmlp.presentation.activities.main

import DrawerListItem
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.islamicfoundation.mbcmlp.R

class ExpandableListAdapter(private val context: Context, private val items: List<DrawerListItem>) : BaseExpandableListAdapter() {

    override fun getGroup(groupPosition: Int): Any {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View? {
        return null
    }


    override fun getChildrenCount(groupPosition: Int): Int {
        return items[groupPosition].items.size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return items[groupPosition].items[childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.drawer_list_item, parent, false)
        view.findViewById<TextView>(R.id.drawer_list_item).text = items[groupPosition].items[childPosition]
        return view
    }
/*
    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.drawer_list_item, parent, false)
        view.findViewById<TextView>(R.id.drawer_list_item).text = items[groupPosition].items[childPosition]

        // Set layout params
        view.layoutParams = AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT)

        return view
    }*/
    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return items.size
    }
}