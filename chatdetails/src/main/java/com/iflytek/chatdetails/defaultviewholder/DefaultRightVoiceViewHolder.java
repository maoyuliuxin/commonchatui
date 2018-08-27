package com.iflytek.chatdetails.defaultviewholder;

import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iflytek.chatdetails.R;
import com.iflytek.chatdetails.base.BaseViewHolder;
import com.iflytek.chatdetails.event.EventSendError;
import com.iflytek.chatdetails.intf.IMessage;
import com.iflytek.chatdetails.manage.VoicePlayerManage;
import com.iflytek.chatdetails.utils.SizeUtils;
import com.iflytek.chatdetails.wighet.UploadStateView;

import org.greenrobot.eventbus.EventBus;

/**
 * description:
 * data: 2018/8/15
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class DefaultRightVoiceViewHolder<T extends IMessage> extends BaseViewHolder<T> implements View.OnClickListener {


    private AnimationDrawable mMVoiceIconDrawable;
    private TextView mVoiceTime;

    private UploadStateView mUploadStateView;

    public DefaultRightVoiceViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setView(View itemView) {
        ImageView voiceIcon = itemView.findViewById(R.id.voice_icon);
        voiceIcon.setBackgroundResource(R.drawable.aurora_anim_right_voice);
        mMVoiceIconDrawable = (AnimationDrawable) voiceIcon.getDrawable();

        View voiceItem = itemView.findViewById(R.id.voice_item);
        voiceItem.setOnClickListener(this);

        mVoiceTime = itemView.findViewById(R.id.tv_voice_time);

        mUploadStateView = itemView.findViewById(R.id.upload_state_view);
        mUploadStateView.setOnClick(this);
    }

    @Override
    public void setBind(T message) {
        SizeUtils.setRightVoiceWith(getContext(), mVoiceTime, message.getVoiceTime());
        mUploadStateView.setState(message.getFileLoadProgress());
        Log.e("shen", "isPlayer=" + message.isPlayer());
        if (mMessage.isPlayer()) {
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
        } else if (v.getId() == R.id.iv_error) {
            EventBus.getDefault().post(new EventSendError<>(mMessage));
        }
    }

    @Override
    public void startPlayer() {
        mMessage.setIsPlayer(true);
        mMVoiceIconDrawable.start();
        VoicePlayerManage.getInstance().startPlayer(this, mMessage);
    }


    @Override
    public void stopPlayer() {
        mMessage.setIsPlayer(false);
        mMVoiceIconDrawable.stop();
        mMVoiceIconDrawable.setVisible(true, true);
        VoicePlayerManage.getInstance().stopPlayer();
    }
}
