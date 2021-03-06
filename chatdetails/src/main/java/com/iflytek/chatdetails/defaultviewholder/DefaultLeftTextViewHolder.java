package com.iflytek.chatdetails.defaultviewholder;

import android.view.View;
import android.widget.TextView;

import com.iflytek.chatdetails.R;
import com.iflytek.chatdetails.base.BaseViewHolder;
import com.iflytek.chatdetails.intf.IMessage;

/**
 * description:
 * data: 2018/8/15
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class DefaultLeftTextViewHolder<T extends IMessage> extends BaseViewHolder<T> {


    private TextView mTvLeft;

    public DefaultLeftTextViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setView(View itemView) {
        mTvLeft = itemView.findViewById(R.id.tv_left);
    }

    @Override
    public void setBind(T message) {
        mTvLeft.setText(message.getText());
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
