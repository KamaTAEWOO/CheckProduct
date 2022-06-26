/*
 날짜 2022-03-09
 class 명: FirstCategoryAdapter
 작성자: 김태우
 설명:
  - FirstCategory의 데이터를 받아서 처리해주는 부분
*/

package com.nknd.checkproduct.FirstCategoryData

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.nknd.checkproduct.R

internal class FirstCategoryAdapter(
   private val context: Context,
   private val numbersInWords: ArrayList<String>,
   private val numberImage: IntArray
) :
BaseAdapter() {
   private var layoutInflater: LayoutInflater? = null
   private lateinit var imageView: ImageView
   private lateinit var textView: TextView
   override fun getCount(): Int {
      return numbersInWords.size
   }
   override fun getItem(position: Int): Any? {
      return null
   }
   override fun getItemId(position: Int): Long {
      return 0
   }
   override fun getView(
   position: Int,
   convertView: View?,
   parent: ViewGroup
   ): View? {
      var convertView = convertView
      if (layoutInflater == null) {
         layoutInflater =
         context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
      }
      if (convertView == null) {
         convertView = layoutInflater!!.inflate(R.layout.grid_item, null)
      }
      imageView = convertView!!.findViewById(R.id.grid_item_icon)
      textView = convertView.findViewById(R.id.grid_item_txt)
      imageView.setImageResource(numberImage[position])
      textView.text = numbersInWords[position]
      return convertView
   }
}