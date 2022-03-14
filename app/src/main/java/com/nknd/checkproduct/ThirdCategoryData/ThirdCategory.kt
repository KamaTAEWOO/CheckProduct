/*
 날짜 2022-03-14
 class 명: ThirdCategory
 작성자: 김태우
 설명:
  - 세 번째 카테고리 (더 세분화 되어 있음.)
  - 마지막 카테고리임.
*/

package com.nknd.checkproduct.ThirdCategoryData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nknd.checkproduct.R
import com.nknd.checkproduct.databinding.ActivitySecondCategoryBinding
import com.nknd.checkproduct.databinding.ActivityThirdCategoryBinding

class ThirdCategory : AppCompatActivity() {
    private lateinit var binding: ActivityThirdCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_category)

        binding = ActivityThirdCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "3번째 title"
        // SecondCategory 값 받기.
        var bundle :Bundle ?=intent.extras
        var secondGridTxt = bundle!!.getString("mGridTxt")
        binding.textView.setText(secondGridTxt)
    }
}