/*
 날짜 2022-04-09
 interface 명: ProductDataDao
 작성자: 김태우
 설명:
  -
*/

package com.nknd.checkproduct.Data

import androidx.room.*

@Dao
interface ProductDataDao {
    // 모두 출력
    @Query("SELECT * FROM ProductData")
    fun getAll(): List<ProductData>

    @Insert
    fun insert(todo: ProductData)

    @Delete
    fun delete(todo: ProductData)

    @Update
    fun update(todo: ProductData)

    // 필요한 값만 들고오기.
    @Query("SELECT contents FROM ProductData WHERE title = :title")
    fun getTitle(title: String): String

    // 전체 데이터 삭제
    @Query("DELETE FROM ProductData")
    fun deleteAll()
}