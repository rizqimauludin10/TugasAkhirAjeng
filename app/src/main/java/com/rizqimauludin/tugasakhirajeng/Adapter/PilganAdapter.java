package com.rizqimauludin.tugasakhirajeng.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.rizqimauludin.tugasakhirajeng.Model.Pilgan.PilganDataItem;
import com.rizqimauludin.tugasakhirajeng.R;

import java.util.List;

public class PilganAdapter extends RecyclerView.Adapter<PilganAdapter.PilganHolder> {
    private List<PilganDataItem> pilganDataItemList;
    private Context context;

    public int correct = 0;
    public int total;

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
        holder.pilganJawaban.setText(pilganDataItem.getJawaban());
//        holder.pilganScore.setText(point());

    }

    @Override
    public int getItemCount() {
        return pilganDataItemList.size();
    }

    public Integer point() {
        Log.d("Total Method Point => ", String.valueOf(correct));
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
        public TextView pilganScore;

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
            pilganJawaban = itemView.findViewById(R.id.pilganJawaban);
            pilganScore = itemView.findViewById(R.id.pilganScore);

            rgPilgan.setOnCheckedChangeListener((group, checkedId) -> {
                int radioId;
                radioId = rgPilgan.getCheckedRadioButtonId();
                radioButton = itemView.findViewById(radioId);

                if (correct == 0) {
                    if (radioButton.getText().equals(pilganJawaban.getText())) {
                        correct++;
                        Log.d("True => ", String.valueOf(correct));
                    } else if (!radioButton.getText().equals(pilganJawaban.getText())) {
                        Log.d("Wrong => ", String.valueOf(correct));
                    }
                } else if (correct >= 0) {
                    if (radioButton.getText().equals(pilganJawaban.getText())) {
                        correct++;
                        Log.d("True => ", String.valueOf(correct));
                    } else if (!radioButton.getText().equals(pilganJawaban.getText())) {
                        correct--;
                        Log.d("Wrong => ", String.valueOf(correct));
                    }
                }

                Log.d("Total => ", String.valueOf(correct));

            });

        }
    }

}
