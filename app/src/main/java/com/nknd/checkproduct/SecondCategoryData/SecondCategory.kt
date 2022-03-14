/*
 날짜 2022-03-09
 class 명: SecondCategory
 작성자: 김태우
 설명:
  - FirstCategory의 데이터를 받아서 처리해주는 부분
  - 받은 데이터 뿌려주는 작업 완료
  - FirstCatefory에서 받은 데이터를 분석해서 두 번째 카테고리가 있는지 확인
    - 두 번째 카테고리가 없는 경우 해당 카테고리에 대한 데이터 보여주기.
    - 세 번째 카테고리가 있는 경우 세 번째 카테고리로 Intent & value 보내기.
*/

package com.nknd.checkproduct.SecondCategoryData

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.nknd.checkproduct.CheckListData.CheckList
import com.nknd.checkproduct.R
import com.nknd.checkproduct.ThirdCategoryData.ThirdCategory
import com.nknd.checkproduct.databinding.ActivityFirstCategoryBinding
import com.nknd.checkproduct.databinding.ActivitySecondCategoryBinding

class SecondCategory : AppCompatActivity() {
    private lateinit var binding: ActivitySecondCategoryBinding

    // 세 번째 카테고리로 가야할 값
    //private var mThirdCategory = arrayOf("오징어게임", "재미있어요!")
    private var mThirdCategory: List<String> = arrayListOf("오징어게임")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_category)

        binding = ActivitySecondCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "2번째 title"
        // FristCategory 값 받기.
        var bundle :Bundle ?=intent.extras
        var firstGridTxt = bundle!!.getString("mGridTxt")
        binding.testTxt.setText(firstGridTxt)

        binding.check.setOnClickListener {
            categoryAnalyze(firstGridTxt!!)
        }
    }

    // 첫 번째 카테고리에서 넘어온 값을 분석해서 전달.
    private fun categoryAnalyze (firstValue: String){
        // 세 번째 카테고리가 없는 경우
        for (search in mThirdCategory) {
            // 세 번째 카테고리가 있는 경우
            if (search == firstValue) {
                // 세 번째 카테고리 class로 Intent
                val intent = Intent(this, ThirdCategory::class.java)
                intent.putExtra("mGridTxt", firstValue)
                startActivity(intent)
                finish()
                break
            }else {
                // checkList class로 Intent
                val intent = Intent(this, CheckList::class.java)
                intent.putExtra("mGridTxt", firstValue)
                startActivity(intent)
                finish()
                break
            }
        }
    }
}