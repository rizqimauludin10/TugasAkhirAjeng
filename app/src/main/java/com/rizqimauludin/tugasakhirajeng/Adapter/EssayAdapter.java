package com.rizqimauludin.tugasakhirajeng.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rizqimauludin.tugasakhirajeng.Model.Essay.EssayDataItem;
import com.rizqimauludin.tugasakhirajeng.R;

import java.util.List;

public class EssayAdapter extends RecyclerView.Adapter<EssayAdapter.EssayHolder> {

    private List<EssayDataItem> essayDataItemList;
    private Context context;


    public EssayAdapter(Context context, List<EssayDataItem> essayDataItemList) {
        this.context = context;
        this.essayDataItemList = essayDataItemList;
    }

    /*public void setEssayDataItemList(List<EssayDataItem> essayDataItemList) {
        this.essayDataItemList = essayDataItemList;
        notifyDataSetChanged();
    }*/

    @NonNull
    @Override
    public EssayAdapter.EssayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_essay, parent, false);
        return new EssayHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EssayAdapter.EssayHolder holder, int position) {
        final EssayDataItem essayDataItem = essayDataItemList.get(position);
        holder.essaySoal.setText(essayDataItem.getSoal());
    }

    @Override
    public int getItemCount() {
        return essayDataItemList.size();
    }

    static class EssayHolder extends RecyclerView.ViewHolder {
        public TextView essaySoal;

        EssayHolder(View view) {
            super(view);

            essaySoal = view.findViewById(R.id.essaySoal);

        }
    }
}
