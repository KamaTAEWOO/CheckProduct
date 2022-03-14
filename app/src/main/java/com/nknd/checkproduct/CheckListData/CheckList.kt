/*
 날짜 2022-03-14
 class 명: CheckList
 작성자: 김태우
 설명:
  - 해당 값듫이 들어오면 값들에 맞게 데이터를 뿌려준다.
*/

package com.nknd.checkproduct.CheckListData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nknd.checkproduct.FirstCategoryData.FirstCategoryAdapter
import com.nknd.checkproduct.R
import com.nknd.checkproduct.databinding.ActivityCheckListBinding
import com.nknd.checkproduct.databinding.ActivityFirstCategoryBinding

class CheckList : AppCompatActivity() {
    private lateinit var binding: ActivityCheckListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_list)

        binding = ActivityCheckListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "checkList"
        // FristCategory 값 받기.
        var bundle :Bundle ?=intent.extras
        var answerTxt = bundle!!.getString("mGridTxt") // 1
        binding.textView2.setText(answerTxt)

    }
}