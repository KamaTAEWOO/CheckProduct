/*
 날짜 2022-02-26
 class 명: ImageListAdapter
 작성자: 김태우
 설명:
  - xml 연결
  - Grid View Adapter
*/

package com.nknd.checkproduct.FirstCategoryData

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.nknd.checkproduct.R
import com.nknd.checkproduct.databinding.GridItemBinding

internal class ImageListAdapter internal constructor(
    context: Context,
    private val resource: Int,
    private val itemList: Array<String>?
) : ArrayAdapter<ImageListAdapter.ItemViewHolder>(context, resource) {
 
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private lateinit var itemBinding: GridItemBinding
 
    override fun getCount(): Int {
        return if (this.itemList != null) this.itemList.size else 0
    }
 
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var convertView = view
        val holder: ItemViewHolder
        if (convertView == null) {
            itemBinding = GridItemBinding.inflate(inflater)
            convertView = itemBinding.root
            holder = ItemViewHolder()
            holder.name = itemBinding.gridItemTxt
            holder.icon = itemBinding.gridItemIcon
            convertView.tag = holder
        } else {
            holder = convertView.tag as ItemViewHolder
        }
        holder.name!!.text = this.itemList!![position]
        holder.icon!!.setImageResource(R.mipmap.ic_launcher)
        return convertView
    }
 
    internal class ItemViewHolder {
        var name: TextView? = null
        var icon: ImageView? = null
    }
}
