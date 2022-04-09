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
import androidx.room.Room
import com.amitshekhar.DebugDB
import com.nknd.checkproduct.Data.AppDatabase
import com.nknd.checkproduct.Data.ProductData
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

        // roomTest
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "Product"
        ).allowMainThreadQueries()
            .build()
            //result_text.text = db.todoDao().getAll().toString() // 데이터 출력

        // Test용 버튼
        binding.bntEx.setOnClickListener{
            // roomTest - Insert
            db.productDataDao().insert(ProductData("TestProduct", "안녕하세요. 저희 제품을 사용해 주셔서 감사합니다. 지금부터 데이터를 입력하겠습니다."))
            //result_text.text = db.todoDao().getAll().toString() // 데이터 출력.
            DebugDB.getAddressLog()

            // FirstCategory 이동
            var intent = Intent(this, FirstCategory::class.java)
            startActivity(intent)
            finish()
        }
    }
}