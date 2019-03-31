package com.example.apptintuc.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apptintuc.DetailArticle;
import com.example.apptintuc.ItemClickListener;
import com.example.apptintuc.Object.ISO8601Parse;
import com.example.apptintuc.Object.TinTuc;
import com.example.apptintuc.R;
import com.github.curioustechizen.ago.RelativeTimeTextView;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private Context context;
    private List<TinTuc> tinTucs;

    public NewsAdapter(Context context, List<TinTuc> tinTucs) {
        this.context = context;
        this.tinTucs = tinTucs;
        tinTucs.remove(0);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news_recycler, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final TinTuc tinTuc = tinTucs.get(i);
        Picasso.get().load(tinTuc.getImg()).into(viewHolder.image);
        if(tinTuc.getTieude().length()>65){
            viewHolder.title.setText(tinTuc.getTieude().substring(0,65)+"...");
        }else {
            viewHolder.title.setText(tinTuc.getTieude());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        long time = 0;
        try {
            time = sdf.parse(tinTuc.getNgaydangtin()).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long now = System.currentTimeMillis();

        CharSequence ago =
                DateUtils.getRelativeTimeSpanString(time, now, DateUtils.HOUR_IN_MILLIS);

        viewHolder.time.setText(ago);
        viewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent detail = new Intent(context, DetailArticle.class);
                detail.putExtra("idNews",tinTuc.getId_tin());
                detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tinTucs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ItemClickListener itemClickListener;
        private ImageView image;
        private TextView title;
        private TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_item);
            time = itemView.findViewById(R.id.time_ago);
            title = itemView.findViewById(R.id.title_article);
            itemView.setOnClickListener(this);
        }
        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }
    }
}