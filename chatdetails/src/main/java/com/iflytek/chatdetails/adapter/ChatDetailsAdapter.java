package com.iflytek.chatdetails.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iflytek.chatdetails.base.BaseViewHolder;
import com.iflytek.chatdetails.config.HolderConfig;
import com.iflytek.chatdetails.intf.IMessage;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 * description: 聊天详情的Adapter
 * data: 2018/8/15
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class ChatDetailsAdapter<T extends IMessage> extends RecyclerView.Adapter<BaseViewHolder<T>> {
    private ArrayList<T> mMessages = new ArrayList<>();
    private final RecyclerView mRecyclerView;

    public ChatDetailsAdapter(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
    }

    public void addData(T message) {
        addData(message, false);
    }

    public void addData(T message, boolean isToEnd) {
        mMessages.add(message);
        notifyItemRangeInserted(mMessages.size() - 1, 1);
        if (isToEnd) {
            mRecyclerView.scrollToPosition(mMessages.size() - 1);
        }
    }

    public void addData(ArrayList<T> messages, boolean isToEnd) {
        mMessages.addAll(messages);
        notifyItemMoved(mMessages.size() - messages.size(), mMessages.size());
        if (isToEnd) {
            mRecyclerView.scrollToPosition(mMessages.size() - 1);
        }
    }

    public void addDataToHeader(ArrayList<T> messages, boolean isToHeader) {
        mMessages.addAll(0, messages);
        notifyItemRangeInserted(0, messages.size());
        if (isToHeader) {
            mRecyclerView.scrollToPosition(0);
        }
    }

    public void addDataToHeader(T message, boolean isToHeader) {
        mMessages.add(0, message);
        notifyItemRangeInserted(0, 1);
        if (isToHeader) {
            mRecyclerView.scrollToPosition(0);
        }
    }

    public void updateData(T message, int messageId) {
        for (int i = 0; i < mMessages.size(); i++) {
            if (mMessages.get(i).getMessageId() == messageId) {
                mMessages.set(i, message);
                notifyItemChanged(i);
                break;
            }
        }
    }

    public ArrayList<T> getDatas() {
        return mMessages;
    }

    public T getData(int messageId) {
        for (T message : mMessages) {
            if (message.getMessageId() == messageId) {
                return message;
            }
        }
        return null;
    }

    @NonNull
    @Override
    public BaseViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return getViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<T> holder, int position) {
        holder.setData(mMessages.get(position));
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mMessages.get(position).getMessageType();
    }

    private <V extends BaseViewHolder<T>> BaseViewHolder<T> getViewHolder(ViewGroup parent, int viewType) {

        try {
            String className = HolderConfig.getInstance().getClassez(viewType);
            Class<V> viewHolderClass = (Class<V>) Class.forName(className);
            Integer res = HolderConfig.getInstance().getRes(className);
            View view = LayoutInflater.from(parent.getContext()).inflate(res, parent, false);
            Constructor<V> declaredConstructor = viewHolderClass.getDeclaredConstructor(View.class);
            return declaredConstructor.newInstance(view);
        } catch (Exception e) {
            Log.e("shen", "e=" + e.getMessage());
            return null;
        }

    }
}
