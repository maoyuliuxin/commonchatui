package com.iflytek.chatdetails.defaultviewholder;

import android.view.View;
import android.widget.ImageView;

import com.iflytek.chatdetails.R;
import com.iflytek.chatdetails.base.BaseViewHolder;
import com.iflytek.chatdetails.intf.IMessage;
import com.iflytek.chatdetails.manage.LoadImageManage;

/**
 * description:
 * data: 2018/8/15
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class DefaultLeftImageViewHolder<T extends IMessage> extends BaseViewHolder<T> {


    private ImageView mImageView;

    public DefaultLeftImageViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setView(View itemView) {
        mImageView = itemView.findViewById(R.id.iv_left);
    }

    @Override
    public void setBind(T message) {
        LoadImageManage.loadImage(message.getFileUrl(), mImageView);
    }

    @Override
    public int getHeaderViewId() {
        return R.id.iv_header;
    }

    @Override
    public int getTimeViewId() {
        return R.id.tv_header_time;
    }
}
