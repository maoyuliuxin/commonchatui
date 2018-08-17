package com.iflytek.chatdetails.intf;

import android.view.View;

/**
 * description: 定义ViewHolder需要实现的方法
 * data: 2018/8/15
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public interface IViewHolder<T extends IMessage> {

    /**
     * 设置控件的方法
     *
     * @param itemView
     */
    void setView(View itemView);

    /**
     * 设置消息的方法
     *
     * @param message
     */
    void setBind(T message);

}
