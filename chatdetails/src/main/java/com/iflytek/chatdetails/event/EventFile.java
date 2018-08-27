package com.iflytek.chatdetails.event;

import com.iflytek.chatdetails.intf.IMessage;

/**
 * description:
 * data: 2018/8/27
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class EventFile<T extends IMessage> {
    private T mIMessage;

    public EventFile(T IMessage) {
        mIMessage = IMessage;
    }

    public T getIMessage() {
        return mIMessage;
    }

    public void setIMessage(T IMessage) {
        mIMessage = IMessage;
    }

    @Override
    public String toString() {
        return "EventHeader{" +
                "mIMessage=" + mIMessage +
                '}';
    }
}
