/*
 날짜 2022-02-26
 class 명: FirstCategory
 작성자: 김태우
 설명:
  - xml 연결
  - 첫번째 카테고리
  - Grid List
*/

package com.nknd.checkproduct.FirstCategoryData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import com.nknd.checkproduct.R
import com.nknd.checkproduct.databinding.ActivityFirstCategoryBinding

class FirstCategory : AppCompatActivity() {
    private lateinit var binding: ActivityFirstCategoryBinding

    // Grid List
    private val itemList: Array<String>
        get() = arrayOf(
            "Item 1 입니다.",   "Item 2 입니다.",   "Item 3 입니다.",   "Item 4 입니다.",   "Item 5 입니다.",
            "Item 6 입니다.",   "Item 7 입니다.",   "Item 8 입니다.",   "Item 9 입니다.",   "Item 10 입니다.",
            "Item 11 입니다.",  "Item 12 입니다.",  "Item 13 입니다.",  "Item 14 입니다.",  "Item 15 입니다.",
            "Item 16 입니다.",  "Item 17 입니다.",  "Item 18 입니다.",  "Item 19 입니다.",  "Item 20 입니다.",
            "Item 21 입니다.",  "Item 22 입니다."
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_category)

        binding = ActivityFirstCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupGridView()
    }

    private fun setupGridView() {
        val adapter = ImageListAdapter(this, R.layout.grid_item, itemList)
        binding.gridview.adapter = adapter

        binding.gridview.onItemClickListener =
            AdapterView.OnItemClickListener { parent, v, position, id ->
                Toast.makeText(
                    this@FirstCategory, " Clicked Position: " + (position + 1),
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}