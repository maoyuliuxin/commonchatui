package com.iflytek.chatdetails.cache;

import com.iflytek.chatdetails.intf.IMessage;
import com.iflytek.chatdetails.intf.IViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * description:
 * data: 2018/8/27
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class VoicePlayerCache {

    private final Map<IViewHolder, IMessage> mIViewHolders;

    public VoicePlayerCache() {
        mIViewHolders = new HashMap<>();

    }

    public void addCache(IViewHolder iViewHolder, IMessage iMessage) {
        mIViewHolders.put(iViewHolder, iMessage);
    }

    public boolean haveCache() {
        return mIViewHolders.size() != 0;
    }

    public IViewHolder get() {
        for (IViewHolder iViewHolder : mIViewHolders.keySet()) {
            mIViewHolders.get(iViewHolder);
            return iViewHolder;
        }
        return null;
    }

    public IMessage removeCache() {
        for (IViewHolder iViewHolder : mIViewHolders.keySet()) {
            return mIViewHolders.remove(iViewHolder);
        }
        return null;
    }
}