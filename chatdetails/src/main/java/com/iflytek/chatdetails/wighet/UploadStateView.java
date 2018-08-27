package com.iflytek.chatdetails.wighet;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.iflytek.chatdetails.R;
import com.iflytek.chatdetails.constant.StateConstant;

/**
 * description:
 * data: 2018/8/27
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class UploadStateView extends LinearLayout {


    private View mUpload;
    private ImageView mIvError;

    public UploadStateView(Context context) {
        super(context);
        init();
    }

    public UploadStateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UploadStateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.view_upload, this);
        mIvError = findViewById(R.id.iv_error);
        mUpload = findViewById(R.id.upload);
    }

    public void setState(int state) {
        if (StateConstant.SUCCESS_LOAD == state) {
            mIvError.setVisibility(GONE);
            mUpload.setVisibility(GONE);
        } else if (StateConstant.DEFEAT_LOAD == state) {
            mIvError.setVisibility(VISIBLE);
            mUpload.setVisibility(GONE);
        } else {
            mIvError.setVisibility(GONE);
            mUpload.setVisibility(VISIBLE);
        }
    }

    public void setOnClick(OnClickListener onClick) {
        mIvError.setOnClickListener(onClick);
    }
}
