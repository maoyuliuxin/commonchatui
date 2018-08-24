package com.iflytek.chatdetails.intf;

import android.content.Context;
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

    /**
     * 获取头像控件id
     * 如果不需要获取头像，返回0
     *
     * @return
     */
    int getHeaderViewId();

    /**
     * 获取显示时间控件的id
     * 如果该条目不需要显示时间，就返回0
     *
     * @return
     */
    int getTimeViewId();

    /**
     * 获取Context的方法
     *
     * @return
     */
    Context getContext();
}