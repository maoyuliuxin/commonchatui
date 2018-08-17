package com.iflytek.chatdetails.config;

import com.iflytek.chatdetails.R;
import com.iflytek.chatdetails.constant.ConfigConstant;
import com.iflytek.chatdetails.defaultviewholder.DefaultLeftTextViewHolder;

import java.util.HashMap;

/**
 * description:
 * data: 2018/8/15
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class HolderConfig {

    private HashMap<Integer, String> mTypeAndHolderMap = new HashMap<>();

    private HashMap<String, Integer> mHolderAndResMap = new HashMap<>();

    private HolderConfig() {
        init();
    }

    private void init() {
        mTypeAndHolderMap.put(ConfigConstant.LEFT_TEXT_TYPE, DefaultLeftTextViewHolder.class.getName());
        mHolderAndResMap.put(DefaultLeftTextViewHolder.class.getName(), R.layout.item_left_text);
    }

    public static HolderConfig getInstance() {
        return Helper.sHolderConfig;
    }

    public void putTypeAndHolder(Integer key, String value) {
        mTypeAndHolderMap.put(key, value);
    }

    public void putHolderAndRes(String key, Integer res) {
        mHolderAndResMap.put(key, res);
    }

    public String getClassez(Integer key) {
        return mTypeAndHolderMap.get(key);
    }

    public Integer getRes(String key) {
        return mHolderAndResMap.get(key);
    }

    private static class Helper {
        static HolderConfig sHolderConfig = new HolderConfig();
    }
}
