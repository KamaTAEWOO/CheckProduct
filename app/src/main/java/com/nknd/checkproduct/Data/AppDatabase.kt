/*
 날짜 2022-04-09
 class 명: AppDatabase
 작성자: 김태우
 설명:
  - ProductData와 ProductDataDao 연결
*/

package com.nknd.checkproduct.Data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDataDao(): ProductDataDao
}
    