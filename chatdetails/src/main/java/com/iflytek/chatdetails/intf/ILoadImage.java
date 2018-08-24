package com.iflytek.chatdetails.intf;

import android.widget.ImageView;

/**
 * description:
 * data: 2018/8/17
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public interface ILoadImage {

    /**
     * 加载图片
     *
     * @param url
     * @param imageView
     */
    void loadImage(Object url, ImageView imageView);

    void loadHeaderImage(Object url, ImageView imageView);
}
