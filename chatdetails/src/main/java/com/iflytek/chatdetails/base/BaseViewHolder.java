package com.iflytek.chatdetails.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.iflytek.chatdetails.intf.IMessage;
import com.iflytek.chatdetails.intf.IViewHolder;

/**
 * description:
 * data: 2018/8/15
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
abstract public class BaseViewHolder<T extends IMessage> extends RecyclerView.ViewHolder implements IViewHolder<T> {

    public BaseViewHolder(View itemView) {
        super(itemView);
        setView(itemView);
    }

}
