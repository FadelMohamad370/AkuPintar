package com.fadelmohamad.aku_pintar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.fadelmohamad.aku_pintar.Database.SQLiteHelper;
import com.fadelmohamad.aku_pintar.Model.UniversitasModel;
import com.fadelmohamad.aku_pintar.R;
import com.fadelmohamad.aku_pintar.View.HalamanDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class UniversitasAdapter extends RecyclerView.Adapter<UniversitasAdapter.ViewHolder> {
    public static final String TAG_ID="id" ;
    private SQLiteHelper db;
    private Context context;
    private List<UniversitasModel> univer;

    public UniversitasAdapter(Context context) {
        this.context = context;
        this.univer = new ArrayList<>();
    }

    public void setUniver(List<UniversitasModel> univer) {
        this.univer = univer;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_universitas, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Integer[] kampus = {R.drawable.itb, R.drawable.ugm, R.drawable.ipb, R.drawable.its, R.drawable.ui, R.drawable.undip, R.drawable.unair, R.drawable.unhas, R.drawable.ub, R.drawable.unpad,};
        final UniversitasModel universitasModel = univer.get(i);

        viewHolder.tvNama.setText(universitasModel.getNama());
        viewHolder.tvAkreditas.setText(universitasModel.getAkreditas());
        viewHolder.tvStatus.setText(universitasModel.getStatus());

        final int idd = i;
        final int idx = universitasModel.getId();
        viewHolder.ivlogo.setImageResource(kampus[idx-1]);

        viewHolder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final UniversitasModel universitasModel = univer.get(idd);

                Intent intent = new Intent(context, HalamanDetailActivity.class);
                intent.putExtra("id",universitasModel.getId());
                intent.putExtra("nama", universitasModel.getNama() );
                intent.putExtra("akreditas", universitasModel.getAkreditas() );
                intent.putExtra("status", universitasModel.getStatus() );
                intent.putExtra("jenis", universitasModel.getJenis() );
                intent.putExtra("alamat", universitasModel.getAlamat() );
                intent.putExtra("kota", universitasModel.getKota() );
                intent.putExtra("provinsi", universitasModel.getProvinsi() );
                intent.putExtra("website", universitasModel.getWebsite() );
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return univer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvItem;
        private TextView tvNama, tvAkreditas, tvStatus;
        ImageView ivlogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvItem = itemView.findViewById(R.id.cv_item);
            tvNama = itemView.findViewById(R.id.tv_title);
            tvAkreditas = itemView.findViewById(R.id.tv_akreditas);
            tvStatus = itemView.findViewById(R.id.tv_status);
            ivlogo = itemView.findViewById(R.id.logo);

        }
    }
}