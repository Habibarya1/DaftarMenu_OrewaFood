package com.example.daftarmenu;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DashBoardActivity extends RecyclerView.Adapter<DashBoardActivity.DashBoardHolder> {

    private ArrayList<SetterGetter> listdata;

    public DashBoardActivity(ArrayList<SetterGetter>listdata){
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public DashBoardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_conversation, parent, false);
        DashBoardHolder holder = new DashBoardHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DashBoardHolder holder, int position) {

        SetterGetter model = listdata.get(position);
        final SetterGetter getData = listdata.get(position);
        String Makanan = getData.getMakanan();
        String Profile = getData.getProfile();
        String Harga = getData.getHarga();

        holder.makanan.setText(Makanan);
        holder.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                View dialogView = LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.deskirpsi,null);
                de.hdodenhof.circleimageview.CircleImageView profile_img;
                TextView nama_makanan;
                TextView deskripsi;
                TextView deskripsiHarga;
                nama_makanan = dialogView.findViewById(R.id.nama_makanan);
                deskripsi = dialogView.findViewById(R.id.Deskripsi);
                deskripsiHarga = dialogView.findViewById(R.id.DeskripsiHarga);
                profile_img = dialogView.findViewById(R.id.diskripsi_img);
                profile_img.setImageResource(model.getProfilepopup());
                nama_makanan.setText(model.getMakanan());
                deskripsi.setText(model.getDeskripsi());
                deskripsiHarga.setText(model.getDeskripsiHarga());
                builder.setView(dialogView);
                builder.setCancelable(true);
                builder.show();
            }
        });
        if(Profile.equals("FotoMakanan1")){
            holder.profile.setImageResource(R.drawable.takoyaki);
        }
        else if(Profile.equals("FotoMakanan2")){
            holder.profile.setImageResource(R.drawable.sushi);
        }
        else if(Profile.equals("FotoMakanan3")){
            holder.profile.setImageResource(R.drawable.onigiri);
        }
        else if(Profile.equals("FotoMakanan4")){
            holder.profile.setImageResource(R.drawable.ramen);
        }

        holder.harga.setText(Harga);
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class DashBoardHolder extends RecyclerView.ViewHolder {
        TextView makanan;
        ImageView profile;
        TextView harga;


        public DashBoardHolder(@NonNull View itemView) {
            super(itemView);

            profile = itemView.findViewById(R.id.profile);

            makanan = itemView.findViewById(R.id.makanan);
            harga = itemView.findViewById(R.id.harga);

        }
    }
}