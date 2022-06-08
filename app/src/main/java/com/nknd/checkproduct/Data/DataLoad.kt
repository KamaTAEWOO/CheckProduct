package com.nknd.checkproduct.Data

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.room.Room
import com.amitshekhar.DebugDB
import java.lang.Exception

open class DataLoad : Application() {

    private val TAG: String = "DataLoad"

    override fun onCreate() {
        super.onCreate()

        // 다른 class에서 사용하기 위함.
        instance = this

        // Log창에 Database 주소 띄워주기
        DebugDB.getAddressLog()
    }

    // 처음 앱을 실행 했을 때 데이터를 폰에 저장하기 위한 함수
    fun firstDataLoad() {
        try{
            Log.d("$TAG::firstDataLoad", "-> DataLoad 시작")

            variableDB().productDataDao().insert(ProductData(2, "TestProduct", "안녕하세요. 저희 제품을 사용해 주셔서 감사합니다. 지금부터 데이터를 입력하겠습니다."))

        }catch (e: Exception) {
            Log.d("$TAG::firstDataLoad", "-> firstDataLoad() 에러, 데이터 로드 확인하기")
        }
    }

    // Table에 있는 Data 전체 삭제
    fun allDelete() {
        variableDB().productDataDao().deleteAll()
    }

    // 필요한 데이터를 title을 이용해서 데이터를 가지고 오기
    fun dataSearch(title: String) {
        try{
            Log.d("$TAG::dataSearch", "-> Data ${variableDB().productDataDao().getTitle("TestProduct11")}")
            //result_text.text = db.todoDao().getAll().toString() // 데이터 출력.
        }catch (e: Exception) {
            Log.d("$TAG::dataSearch", "-> dataSearch() 에러, 데이터 가지고 오기 실패")
        }

    }

    // 여러 함수에서 DB라는 변수를 사용하기 위함.
    private fun variableDB(): AppDatabase {
        // Create Room Table
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "Product"
        ).allowMainThreadQueries()
            .build()
        return db
    }

    companion object {
        // DataLoad Class를 다른 Class들도 사용하기 위함
        lateinit var instance: DataLoad
            private set
    }
}