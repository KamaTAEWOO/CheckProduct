/*
 날짜 2022-02-26
 class 명: FirstCategory
 작성자: 김태우
 설명:
  - xml 연결
  - 첫번째 카테고리
  - Grid List
  - 두번째 카테고리와 연결
  - mGridTxt 내용 전달
*/

package com.nknd.checkproduct.FirstCategoryData

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.nknd.checkproduct.R
import com.nknd.checkproduct.SecondCategoryData.SecondCategory
import com.nknd.checkproduct.databinding.ActivityFirstCategoryBinding

class FirstCategory : AppCompatActivity() {
    private lateinit var binding: ActivityFirstCategoryBinding

    lateinit var gridView: GridView
    private var mGridTxt = arrayOf("오징어게임", "재미있어요!")
    private var mGridImage = intArrayOf(R.mipmap.qwe,R.mipmap.asd)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_category)

        binding = ActivityFirstCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "KotlinApp"
        gridView = findViewById(R.id.gridview)
        val mainAdapter = FirstCategoryAdapter(this@FirstCategory, mGridTxt, mGridImage)
        gridView.adapter = mainAdapter

        // Grid Item Click event
        // Click event - AdapterView, View, Int, long
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val gridTxtItem: String = mGridTxt[+position]
            val intent = Intent(this, SecondCategory::class.java)
            intent.putExtra("mGridTxt", gridTxtItem)
            startActivity(intent)
            finish()
        }
    }
}