package com.iflytek.chatdetails.config;

import android.widget.ImageView;

import com.iflytek.chatdetails.intf.ILoadImage;

/**
 * description: 需要在初始化时进行设置
 * data: 2018/8/17
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class LoadImageManage {

    private static ILoadImage sILoadImage;

    public static void initLoadImage(ILoadImage loadImage) {
        sILoadImage = loadImage;
    }

    public static void loadImage(Object url, ImageView imageView) {
        if (sILoadImage == null) {
            throw new IllegalArgumentException("请初始化图片加载器");
        }
        sILoadImage.loadImage(url, imageView);
    }
}
