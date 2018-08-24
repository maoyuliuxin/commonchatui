package com.iflytek.chatdetails.config;

import com.iflytek.chatdetails.R;
import com.iflytek.chatdetails.constant.ConfigConstant;
import com.iflytek.chatdetails.defaultviewholder.DefaultLeftFileViewHolder;
import com.iflytek.chatdetails.defaultviewholder.DefaultLeftImageViewHolder;
import com.iflytek.chatdetails.defaultviewholder.DefaultLeftTextViewHolder;
import com.iflytek.chatdetails.defaultviewholder.DefaultLeftVoiceViewHolder;
import com.iflytek.chatdetails.defaultviewholder.DefaultRightFileViewHolder;
import com.iflytek.chatdetails.defaultviewholder.DefaultRightImageViewHolder;
import com.iflytek.chatdetails.defaultviewholder.DefaultRightTextViewHolder;
import com.iflytek.chatdetails.defaultviewholder.DefaultRightVoiceViewHolder;

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
        //左文字
        mTypeAndHolderMap.put(ConfigConstant.LEFT_TEXT_TYPE, DefaultLeftTextViewHolder.class.getName());
        mHolderAndResMap.put(DefaultLeftTextViewHolder.class.getName(), R.layout.item_left_text);

        //右文字
        mTypeAndHolderMap.put(ConfigConstant.RIGHT_TEXT_TYPE, DefaultRightTextViewHolder.class.getName());
        mHolderAndResMap.put(DefaultRightTextViewHolder.class.getName(), R.layout.item_right_text);

        //左图片
        mTypeAndHolderMap.put(ConfigConstant.LEFT_IMAGE_TYPE, DefaultLeftImageViewHolder.class.getName());
        mHolderAndResMap.put(DefaultLeftImageViewHolder.class.getName(), R.layout.item_left_image);

        //右图片
        mTypeAndHolderMap.put(ConfigConstant.RIGHT_IMAGE_TYPE, DefaultRightImageViewHolder.class.getName());
        mHolderAndResMap.put(DefaultRightImageViewHolder.class.getName(), R.layout.item_right_image);

        //左文件
        mTypeAndHolderMap.put(ConfigConstant.LEFT_FILE_TYPE, DefaultLeftFileViewHolder.class.getName());
        mHolderAndResMap.put(DefaultLeftFileViewHolder.class.getName(), R.layout.item_left_file);

        //右文件
        mTypeAndHolderMap.put(ConfigConstant.RIGHT_FILE_TYPE, DefaultRightFileViewHolder.class.getName());
        mHolderAndResMap.put(DefaultRightFileViewHolder.class.getName(), R.layout.item_right_file);

        //左文件
        mTypeAndHolderMap.put(ConfigConstant.LEFT_VOICE_TYPE, DefaultLeftVoiceViewHolder.class.getName());
        mHolderAndResMap.put(DefaultLeftVoiceViewHolder.class.getName(), R.layout.item_left_voice);

        //右文件
        mTypeAndHolderMap.put(ConfigConstant.RIGHT_VOICE_TYPE, DefaultRightVoiceViewHolder.class.getName());
        mHolderAndResMap.put(DefaultRightVoiceViewHolder.class.getName(), R.layout.item_right_voice);
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
