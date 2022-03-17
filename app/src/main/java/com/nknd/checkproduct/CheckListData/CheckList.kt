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
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nknd.checkproduct.FirstCategoryData.FirstCategoryAdapter
import com.nknd.checkproduct.R
import com.nknd.checkproduct.databinding.ActivityCheckListBinding
import com.nknd.checkproduct.databinding.ActivityFirstCategoryBinding

class CheckList : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityCheckListBinding

    lateinit var adapter: ItemAdapter
    var model = ItemModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_list)

        binding = ActivityCheckListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "checkList"
        // FristCategory 값 받기.
        var bundle: Bundle? = intent.extras
        var answerTxt = bundle!!.getString("mGridTxt") // 1
        binding.textView2.setText(answerTxt)

        init()

    }

    fun init() {
        //binding.btnSelectAll.setOnClickListener(this)
        model.makeTestItems()
        adapter = ItemAdapter()
        adapter.items = model

        var linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        binding.recyclerview.layoutManager = linearLayoutManager
        binding.recyclerview.adapter = adapter

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onClick(v: View?) {
        model.toggleAllItemClick()
        adapter.notifyDataSetChanged()
    }
}