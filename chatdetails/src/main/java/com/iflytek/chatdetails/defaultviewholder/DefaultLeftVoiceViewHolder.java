package com.iflytek.chatdetails.defaultviewholder;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iflytek.chatdetails.R;
import com.iflytek.chatdetails.base.BaseViewHolder;
import com.iflytek.chatdetails.intf.IMessage;
import com.iflytek.chatdetails.manage.VoicePlayerManage;
import com.iflytek.chatdetails.utils.SizeUtils;

/**
 * description:
 * data: 2018/8/15
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class DefaultLeftVoiceViewHolder<T extends IMessage> extends BaseViewHolder<T> implements View.OnClickListener {


    private ImageView mVoiceIcon;
    private AnimationDrawable mMVoiceIconDrawable;
    private View mVoiceItem;
    private TextView mVoiceTime;
    private T mMessage;

    public DefaultLeftVoiceViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setView(View itemView) {
        mVoiceIcon = itemView.findViewById(R.id.voice_icon);
        mVoiceIcon.setBackgroundResource(R.drawable.aurora_anim_left_voice);
        mMVoiceIconDrawable = (AnimationDrawable) mVoiceIcon.getDrawable();

        mVoiceItem = itemView.findViewById(R.id.voice_item);
        mVoiceItem.setOnClickListener(this);

        mVoiceTime = itemView.findViewById(R.id.tv_voice_time);
    }

    @Override
    public void setBind(T message) {
        mMessage = message;
        SizeUtils.setLeftVoiceWith(getContext(), mVoiceTime, message.getVoiceTime());
        if (message.isPlayer()) {
            mMVoiceIconDrawable.start();
        } else {
            mMVoiceIconDrawable.stop();
            mMVoiceIconDrawable.setVisible(true, true);
        }
    }

    @Override
    public int getHeaderViewId() {
        return R.id.iv_header;
    }

    @Override
    public int getTimeViewId() {
        return R.id.tv_header_time;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.voice_item) {
            if (mMVoiceIconDrawable.isRunning()) {
                stopPlayer();
            } else {
                startPlayer();
            }
        }
    }

    @Override
    public void startPlayer() {
        mMessage.setIsPlayer(true);
        mMVoiceIconDrawable.start();
        VoicePlayerManage.getInstance().startPlayer(this,mMessage);
    }


    @Override
    public void stopPlayer() {
        mMessage.setIsPlayer(false);
        mMVoiceIconDrawable.stop();
        mMVoiceIconDrawable.setVisible(true, true);
        VoicePlayerManage.getInstance().stopPlayer();
    }
}
