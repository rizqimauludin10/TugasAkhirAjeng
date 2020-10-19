package com.rizqimauludin.tugasakhirajeng.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.rizqimauludin.tugasakhirajeng.Model.Pilgan.PilganDataItem;
import com.rizqimauludin.tugasakhirajeng.R;

import java.util.List;

public class PilganAdapter extends RecyclerView.Adapter<PilganAdapter.PilganHolder> {
    private List<PilganDataItem> pilganDataItemList;
    private Context context;
    private Integer correct = 0;

    public PilganAdapter(Context context, List<PilganDataItem> pilganDataItemList) {
        this.context = context;
        this.pilganDataItemList = pilganDataItemList;
    }

    @NonNull
    @Override
    public PilganHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pilgan, parent, false);
        return new PilganHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PilganHolder holder, int position) {
        String item = (String.valueOf(holder.getAdapterPosition() + 1));
        final PilganDataItem pilganDataItem = pilganDataItemList.get(position);
        holder.pilganNo.setText(item);
        holder.pilganSoal.setText(HtmlCompat.fromHtml(pilganDataItem.getSoal(), 0));
        holder.rbA.setText(pilganDataItem.getPilihanA());
        holder.rbB.setText(pilganDataItem.getPilihanB());
        holder.rbC.setText(pilganDataItem.getPilihanC());
        holder.rbD.setText(pilganDataItem.getPilihanD());
        holder.rbE.setText(pilganDataItem.getPilihanE());
        //holder.pilganJawaban.setText(pilganDataItem.getJawaban());
    }

    @Override
    public int getItemCount() {
        return pilganDataItemList.size();
    }

    public int jawaban() {
        return correct;
    }

    public class PilganHolder extends RecyclerView.ViewHolder {
        public TextView pilganNo;
        public TextView pilganSoal;
        public RadioGroup rgPilgan;
        public RadioButton rbA;
        public RadioButton rbB;
        public RadioButton rbC;
        public RadioButton rbD;
        public RadioButton rbE;
        public RadioButton radioButton;
        public TextView pilganJawaban;

        public PilganHolder(@NonNull View itemView) {
            super(itemView);

            pilganNo = itemView.findViewById(R.id.pilganNo);
            pilganSoal = itemView.findViewById(R.id.pilganSoal);
            rgPilgan = itemView.findViewById(R.id.rgPilgan);
            rbA = itemView.findViewById(R.id.rgA);
            rbB = itemView.findViewById(R.id.rgB);
            rbC = itemView.findViewById(R.id.rgC);
            rbD = itemView.findViewById(R.id.rgD);
            rbE = itemView.findViewById(R.id.rgE);
            //pilganJawaban = itemView.findViewById(R.id.pilganJawaban);

            rgPilgan.setOnCheckedChangeListener((group, checkedId) -> {
                Integer radioId;
                radioId = rgPilgan.getCheckedRadioButtonId();
                radioButton = itemView.findViewById(radioId);


                if (radioButton.getText().equals(pilganJawaban.getText())) {
                    correct++;
                    Toast.makeText(context, pilganJawaban.getText(), Toast.LENGTH_SHORT).show();
                    Log.d("Benar => ", String.valueOf(correct));
                }
            });
        }
    }
}
