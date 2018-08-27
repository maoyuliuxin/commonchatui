package com.iflytek.chatdetails.manage;

import com.iflytek.chatdetails.config.HolderConfig;

/**
 * description: 对viewHolder进行配置
 * data: 2018/8/27
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class ConfigManage {

    private ConfigManage() {

    }

    public static ConfigManage getInstance() {
        return Helper.sConfigManage;
    }

    public void addViewHolder(int type, Class clazz, int resLayout) {
        addViewHolder(type, clazz.getName(), resLayout);
    }

    public void addViewHolder(int type, String className, int resLayout) {
        HolderConfig.getInstance().putTypeAndHolder(type, className);
        HolderConfig.getInstance().putHolderAndRes(className, resLayout);
    }

    private static class Helper {
        static ConfigManage sConfigManage = new ConfigManage();
    }
}
