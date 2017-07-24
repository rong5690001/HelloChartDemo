package com.rong.map.recyclerviewitemtouchhelper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作者：陈华榕
 * 邮箱:mpa.chen@sportq.com
 * 时间：2017/7/21  16:37
 */

public class SimpleAdapter extends RecyclerView.Adapter {

    private Context mContext;

    public SimpleAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_text, parent, false);
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String text = "item";
        if (position == 0) {
            text = "图表";
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mContext.startActivity(new Intent(mContext, ChartActivity.class));
                }
            });
        }
        ((TextView) holder.itemView.findViewById(R.id.text)).setText(text + position);
    }

    @Override
    public int getItemCount() {
        return 10;
    }


}
