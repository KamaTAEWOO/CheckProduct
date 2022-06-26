package com.nknd.checkproduct.Data

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.room.Room
import com.amitshekhar.DebugDB
import java.lang.Exception

open class DataLoad : Application() {

    private val TAG: String = "DataLoad"

    // 1차 카테고리 리스트
    val _disitalMathine: ArrayList<String> = arrayListOf<String>("아이폰",      "아이패드",    "맥북",   "애플워치",    "아이맥",
                                                                 "에어팟",      "아이팟",      "악세서리")

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
            Log.d("$TAG::", "-> DataLoad 시작")

            // 디지털 기기
            for(i in _disitalMathine.indices) {
                variableDB().productDataDao().insert(ProductData(i, _disitalMathine[i], digitalMachine(_disitalMathine[i])))
            }

        }catch (e: Exception) {
            Log.d("$TAG::", "-> firstDataLoad() 에러, 데이터 로드 확인하기")
        }
    }

    // Table에 있는 Data 전체 삭제
    fun allDelete() {
        variableDB().productDataDao().deleteAll()
    }

    // 필요한 데이터를 title을 이용해서 데이터를 가지고 오기
    fun dataSearch(title: String) {
        try{
            Log.d("$TAG::", "-> Data ${variableDB().productDataDao().getTitle("TestProduct11")}")
            //result_text.text = db.todoDao().getAll().toString() // 데이터 출력.
        }catch (e: Exception) {
            Log.d("$TAG::", "-> dataSearch() 에러, 데이터 가지고 오기 실패")
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

    // 애플기기
    private fun digitalMachine(name: String): String {
//        "아이폰",      "아이패드",    "맥북",   "애플워치",    "아이맥",
//        "에어팟",      "아이팟",      "악세서리"
        var content: String = ""
        try{
            when (name) {
                "아이폰" -> content = "액정에 잔상이 있는지 확인;유심 작동이 잘 되는지 꽂아서 확인하기;페이스 아이디 가능 여부;분실 도난 폰인지 확인하기" +
                        ";선택 약정 가능 여부 확인;애플 케어 여부 확인;사설 수리 여부 확인;배터리 성능 확인;용량 맞는지 확인" +
                        ";Apple Login 되는지 확인하기;보조 배터리 들고가서 충전되는지 확인;정품인지 확인하기 (계산기를 가로 모드로 16자리 쳐보기)" +
                        ";카메라 전면과 후면 작동 유무;폰 외관 흠집 여부;"

                "아이패드" -> content = "분실 여부 확인;정상해지 확인(셀룰러 버전인 경우);사설 수리 여부 체크;볼륨키, 전원키, 홀드키 확인\n" +
                        "애플튠즈, 애플 ID 로그아웃 확인;와이파이 잘 잡히는지 확인;블루투스 확인" +
                        "용량확인;지문인식 가능여부 확인;카메라 전면, 후면 확인;액정상태 확인" +
                        "음성녹음 확인;외관 상태 확인;휘어짐 상태 확인;"

                "맥북" -> content = "맥북 중고의 사양(RAM. 내장메모리) 확인;배터리 사이클 체크;디스플레이 잔상 및 스테인게이트 현상 체크" +
                        ";사설업체 수리 이력 체크;제조년식 체크;키보드/트랙패드 확인;외관 체크;맥의 모델명과 연식;" +
                        "포트 상태 체크하기;구성품 확인하기(충전기 상태, 설명서, 줄 상태);제품 보증 상태 확인;"

                "애플워치" -> content = "애플워치 연결 해제 되었는지 확인;icloud 기기 삭제 되었는지 확인;애플워치 데이터 초기화 되었는지 확인;"

                "아이맥" -> content =  ""

                "에어팟" -> content = "시리얼 넘버를 미리 확인하여 애플 사이트에서 유효한지, 제조 연원이 언제인지, 리퍼 기간이 얼마나 남아 있는지 확인하기" +
                        "블루투스 연결이 잘 되는지 확인;음질이 깨지지 않는지 확인;한쪽씩 껴보고 잘 들리는지 확인;가품이 많다고 하니깐 꼼꼼히 보기"

                "아이팟" -> content = ""

                "악세서리" -> content = ""

             else -> content = "Data 찾지 못했습니다."
            }
        }catch (e: Exception) {
            Log.d("$TAG::", "digital_appleMachine() -> Data Error ")
        }
        return content
    }

    companion object {
        // DataLoad Class를 다른 Class들도 사용하기 위함
        lateinit var instance: DataLoad
            private set
    }
}