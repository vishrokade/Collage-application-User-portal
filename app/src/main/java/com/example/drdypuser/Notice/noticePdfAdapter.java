package com.example.drdypuser.Notice;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drdypuser.Ebook.EbookAdapter;
import com.example.drdypuser.Ebook.PdfViewerActivity;
import com.example.drdypuser.R;

import java.util.List;

public class noticePdfAdapter extends RecyclerView.Adapter<noticePdfAdapter.noticePdfViewHolder>{

    private Context context;

    private List<NoticePdfData> list;
    public noticePdfAdapter(Context context, List<NoticePdfData> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public noticePdfAdapter.noticePdfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notice_pdf_item_layout, parent, false);
        return new noticePdfAdapter.noticePdfViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull noticePdfAdapter.noticePdfViewHolder holder, int position) {

        holder.noticePdfName.setText(list.get(position).getPdfTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,NoticePdfViewerActivity.class);
                intent.putExtra("downloadUrl",list.get(position).getDownloadUrl());
                context.startActivity(intent);
            }
        });

        holder.noticePdfDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getDownloadUrl()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class noticePdfViewHolder extends RecyclerView.ViewHolder {

        private TextView noticePdfName;
        private ImageView noticePdfDownload;

        public noticePdfViewHolder(@NonNull View itemView) {
            super(itemView);

            noticePdfName = itemView.findViewById(R.id.noticePdfName);
            noticePdfDownload = itemView.findViewById(R.id.noticePdfDownload);
        }

    }
}


