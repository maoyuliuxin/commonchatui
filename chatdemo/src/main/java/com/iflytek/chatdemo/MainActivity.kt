package com.iflytek.chatdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.iflytek.chatdetails.adapter.ChatDetailsAdapter
import com.iflytek.chatdetails.constant.ConfigConstant
import com.iflytek.chatdetails.event.EventFile
import com.iflytek.chatdetails.event.EventHeader
import com.iflytek.chatdetails.event.EventImage
import com.iflytek.chatdetails.intf.ILoadImage
import com.iflytek.chatdetails.manage.LoadImageManage
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventBus.getDefault().register(this)
        initImageLoad()

        recyclerView.layoutManager = LinearLayoutManager(this)
        val chatDetailsAdapter = ChatDetailsAdapter<MyMessage>(recyclerView)
        recyclerView.adapter = chatDetailsAdapter
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.LEFT_TEXT_TYPE))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_TEXT_TYPE))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.LEFT_IMAGE_TYPE))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_IMAGE_TYPE))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.LEFT_FILE_TYPE))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_FILE_TYPE))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.LEFT_VOICE_TYPE, 10))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.LEFT_VOICE_TYPE, 20))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.LEFT_VOICE_TYPE, 60))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.LEFT_VOICE_TYPE, 5))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.LEFT_VOICE_TYPE, 1))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 10))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 20))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 60))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 5))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1))
        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1))

        chatDetailsAdapter.addData(MyMessage(ConfigConstant.RIGHT_VOICE_TYPE, 1), true)
    }

    private fun initImageLoad() {
        LoadImageManage.initLoadImage(object : ILoadImage {
            override fun loadImage(url: Any?, imageView: ImageView?) {
                Glide.with(imageView?.context)
                        .load(url)
                        .into(imageView)
            }

            override fun loadHeaderImage(url: Any?, imageView: ImageView?) {
                Glide.with(imageView?.context)
                        .load(url)
                        .into(imageView)
            }

        })
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onHeader(message: EventHeader<MyMessage>) {
        Toast.makeText(this, "onHeader", 0).show()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onFile(message: EventFile<MyMessage>) {
        Toast.makeText(this, "onFIle", 0).show()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onImage(message: EventImage<MyMessage>) {
        Toast.makeText(this, "onImage", 0).show()
    }
}
