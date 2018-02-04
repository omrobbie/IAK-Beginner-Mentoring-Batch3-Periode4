package com.omrobbie.myrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by omrobbie on 04/02/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<ItemData> itemData;

    public ItemAdapter(List<ItemData> itemData) {
        this.itemData = itemData;
    }

    public void addData(ItemData itemData) {
        this.itemData.add(itemData);
        notifyDataSetChanged();
    }

    public void replaceData(List<ItemData> itemData) {
        this.itemData = itemData;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(itemData.get(position));
    }

    @Override
    public int getItemCount() {
        return itemData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView iv_avatar;
        private TextView tv_judul;
        private TextView tv_content;

        public ViewHolder(final View itemView) {
            super(itemView);

            iv_avatar = (CircleImageView) itemView.findViewById(R.id.iv_avatar);
            tv_judul = (TextView) itemView.findViewById(R.id.tv_judul);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        }

        public void bind(final ItemData itemData) {
            iv_avatar.setImageResource(itemData.getAvatar());
            tv_judul.setText(itemData.getJudul());
            tv_content.setText(itemData.getContent());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), itemData.getJudul(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
