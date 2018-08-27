package com.iflytek.chatdetails.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iflytek.chatdetails.manage.LoadImageManage;
import com.iflytek.chatdetails.intf.IMessage;
import com.iflytek.chatdetails.intf.IViewHolder;

/**
 * description: viewHolder父类，所有的viewHolder都需要继承该viewHolder
 * data: 2018/8/15
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
abstract public class BaseViewHolder<T extends IMessage> extends RecyclerView.ViewHolder implements IViewHolder<T> {

    private View mItemView;
    private final Context mContext;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mItemView = itemView;
        setView(itemView);
        mContext = itemView.getContext();
    }

    public void setData(T message) {
        setBind(message);
        setHeaderImage(message.getHeaderRes());
        setShowTime(message.getHeadTime(), message.isShowTime());
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    private void setShowTime(String headTime, boolean isShowTime) {
        if (getTimeViewId() == 0) {
            return;
        }
        TextView textView = mItemView.findViewById(getTimeViewId());
        if (isShowTime && !TextUtils.isEmpty(headTime)) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(headTime);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    private void setHeaderImage(Object headerRes) {
        if (getHeaderViewId() == 0) {
            return;
        }
        ImageView imageView = mItemView.findViewById(getHeaderViewId());
        LoadImageManage.loadHeaderImage(headerRes, imageView);
    }

    @Override
    public void startPlayer() {

    }

    @Override
    public void stopPlayer() {

    }
}
