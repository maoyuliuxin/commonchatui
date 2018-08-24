package com.iflytek.chatdetails.defaultviewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
public class DefaultLeftFileViewHolder<T extends IMessage> extends BaseViewHolder<T> {


    private TextView mFileName;
    private TextView mFileState;

    public DefaultLeftFileViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setView(View itemView) {
        mFileName = itemView.findViewById(R.id.tv_file_name);
        mFileState = itemView.findViewById(R.id.tv_file_state);
    }

    @Override
    public void setBind(T message) {
        mFileName.setText(message.getFileName());
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
