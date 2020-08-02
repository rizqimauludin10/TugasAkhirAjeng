package com.rizqimauludin.tugasakhirajeng.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
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


    @NonNull
    @Override
    public EssayAdapter.EssayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_essay, parent, false);
        return new EssayHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EssayAdapter.EssayHolder holder, int position) {
        String item = (String.valueOf(holder.getAdapterPosition() + 1));
        final EssayDataItem essayDataItem = essayDataItemList.get(position);
        holder.essaySoal.setText(HtmlCompat.fromHtml(essayDataItem.getSoal(), 0));
        holder.essayNo.setText(item);
    }

    @Override
    public int getItemCount() {
        return essayDataItemList.size();
    }

    static class EssayHolder extends RecyclerView.ViewHolder {
        public TextView essaySoal;
        public TextView essayNo;

        EssayHolder(View view) {
            super(view);

            essaySoal = view.findViewById(R.id.essaySoal);
            essayNo = view.findViewById(R.id.essayNo);

        }
    }
}
