package com.iflytek.chatdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.iflytek.chatdetails.adapter.ChatDetailsAdapter
import com.iflytek.chatdetails.constant.ConfigConstant
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val chatDetailsAdapter = ChatDetailsAdapter<MyMessage>()
        recyclerView.adapter = chatDetailsAdapter
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.LEFT_TEXT_TYPE))
    }
}
