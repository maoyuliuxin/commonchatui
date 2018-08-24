package com.iflytek.chatdetails.defaultviewholder;

import android.view.View;
import android.widget.TextView;

import com.iflytek.chatdetails.R;
import com.iflytek.chatdetails.base.BaseViewHolder;
import com.iflytek.chatdetails.intf.IMessage;

import org.w3c.dom.Text;

/**
 * description:
 * data: 2018/8/22
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class DefaultRightTextViewHolder<T extends IMessage> extends BaseViewHolder<T> {

    private TextView mTvRight;

    public DefaultRightTextViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setView(View itemView) {
        mTvRight = itemView.findViewById(R.id.tv_right);
    }

    @Override
    public void setBind(T message) {
        mTvRight.setText(message.getText());
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
