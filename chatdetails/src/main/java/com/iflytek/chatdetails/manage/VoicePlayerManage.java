package com.iflytek.chatdetails.manage;

import com.iflytek.chatdetails.cache.VoicePlayerCache;
import com.iflytek.chatdetails.intf.IMessage;
import com.iflytek.chatdetails.intf.IViewHolder;

/**
 * description:
 * data: 2018/8/27
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class VoicePlayerManage {

    private final VoicePlayerCache mVoicePlayerCacha;

    private VoicePlayerManage() {
        mVoicePlayerCacha = new VoicePlayerCache();
    }

    public static VoicePlayerManage getInstance() {
        return Helper.sVoicePlayerManage;
    }

    public void startPlayer(IViewHolder iViewHolder, IMessage message) {
        if (mVoicePlayerCacha.haveCache()) {
            mVoicePlayerCacha.get().stopPlayer();
        }
        mVoicePlayerCacha.addCache(iViewHolder, message);
        //TODO 播放
    }

    public void stopPlayer() {
        mVoicePlayerCacha.removeCache().setIsPlayer(false);
        //TODO 停止播放
    }

    private static class Helper {
        static VoicePlayerManage sVoicePlayerManage = new VoicePlayerManage();
    }
}
