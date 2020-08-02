package com.rizqimauludin.tugasakhirajeng.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.rizqimauludin.tugasakhirajeng.Model.Latihan.LatihanDataItem;
import com.rizqimauludin.tugasakhirajeng.R;

import java.util.List;

public class LatihanAdapter extends RecyclerView.Adapter<LatihanAdapter.LatihanHolder> {

    private List<LatihanDataItem> latihanDataItems;
    private Context context;

    public LatihanAdapter(Context context, List<LatihanDataItem> latihanDataItems) {
        this.context = context;
        this.latihanDataItems = latihanDataItems;
    }

    @NonNull
    @Override
    public LatihanAdapter.LatihanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_latihan, parent, false);
        return new LatihanAdapter.LatihanHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LatihanHolder holder, int position) {
        String item = (String.valueOf(holder.getAdapterPosition() + 1));
        final LatihanDataItem latihanDataItem = latihanDataItems.get(position);
        holder.latihanSoal.setText(HtmlCompat.fromHtml(latihanDataItem.getSoal(), 0));
        holder.latihanNo.setText(item);

    }

    @Override
    public int getItemCount() {
        return latihanDataItems.size();
    }

    public class LatihanHolder extends RecyclerView.ViewHolder {
        public TextView latihanSoal;
        public TextView latihanNo;

        public LatihanHolder(View view) {
            super(view);

            latihanNo = view.findViewById(R.id.latihanNo);
            latihanSoal = view.findViewById(R.id.latihanSoal);
        }
    }
}
