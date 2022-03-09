/*
 날짜 2022-03-09
 class 명: SecondCategory
 작성자: 김태우
 설명:
  - FirstCategory의 데이터를 받아서 처리해주는 부분
  - 받은 데이터 뿌려주는 작업 완료
*/

package com.nknd.checkproduct.SecondCategoryData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nknd.checkproduct.R
import com.nknd.checkproduct.databinding.ActivityFirstCategoryBinding
import com.nknd.checkproduct.databinding.ActivitySecondCategoryBinding

class SecondCategory : AppCompatActivity() {
    private lateinit var binding: ActivitySecondCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_category)

        binding = ActivitySecondCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var bundle :Bundle ?=intent.extras
        var firstGridTxt = bundle!!.getString("mGridTxt") // 1
        //var strUser: String = intent.getStringExtra("value") // 2
        binding.testTxt.setText(firstGridTxt)
    }
}