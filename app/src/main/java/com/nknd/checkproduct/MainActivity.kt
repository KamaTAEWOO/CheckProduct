/*
 날짜 2022-02-26
 class 명: MainActivity
 작성자: 김태우
 설명:
  - xml 연결
*/

package com.nknd.checkproduct

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nknd.checkproduct.FirstCategoryData.FirstCategory
import com.nknd.checkproduct.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // xml이 연결 완료. findview 사용 안 해도 됨.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Test용 버튼
        binding.bntEx.setOnClickListener{
            // FirstCategory 이동
            var intent = Intent(this, FirstCategory::class.java)
            startActivity(intent)
        }
    }
}