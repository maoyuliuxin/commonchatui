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
        return null;
    }

    @Override
    public boolean isLeft() {
        return false;
    }
}
