package com.iflytek.chatdemo;

import com.iflytek.chatdetails.intf.IMessage;

/**
 * description:
 * data: 2018/8/15
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class MyMessage implements IMessage {

    private int type;

    private long voiceTime;

    private boolean isPlayer;

    public MyMessage(int type, long voiceTime) {
        this.type = type;
        this.voiceTime = voiceTime;
    }

    public MyMessage(int type) {
        this.type = type;
    }

    @Override
    public int getMessageId() {
        return 0;
    }

    @Override
    public int getMessageType() {
        return type;
    }

    @Override
    public String getText() {
        return "1231231245645";
    }

    @Override
    public boolean isLeft() {
        return false;
    }

    @Override
    public Object getHeaderRes() {
        return "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2024669388,469028839&fm=27&gp=0.jpg";
    }

    @Override
    public String getHeadTime() {
        return "2018-1999-1111";
    }

    @Override
    public boolean isShowTime() {
        return true;
    }

    @Override
    public String getFileUrl() {
        return "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2024669388,469028839&fm=27&gp=0.jpg";
    }

    @Override
    public String getFileName() {
        return "我是测试的";
    }

    @Override
    public int getFileLoadProgress() {
        return 50;
    }

    @Override
    public long getVoiceTime() {
        return voiceTime;
    }

    @Override
    public boolean isPlayer() {
        return isPlayer;
    }

    @Override
    public void setIsPlayer(boolean isPlayer) {
        this.isPlayer = isPlayer;
    }
}
