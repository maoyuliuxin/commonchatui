package com.iflytek.chatdetails.intf;

/**
 * description: 消息接口类，所有的消息都要继承该类
 * data: 2018/8/15
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public interface IMessage {

    int getMessageId();

    int getMessageType();

    String getText();

    boolean isLeft();
}
