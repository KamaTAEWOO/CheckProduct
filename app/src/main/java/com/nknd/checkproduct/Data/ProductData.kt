/*
 날짜 2022-04-09
 class 명: ProductData
 작성자: 김태우
 설명:
  - Entity class
  - auto number
  - title
*/

package com.nknd.checkproduct.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ProductData  (
    var num: Int,
    var title: String,
    var contents: String
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}