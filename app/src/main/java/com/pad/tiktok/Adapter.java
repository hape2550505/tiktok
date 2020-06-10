package com.pad.tiktok;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<VideoInfo> mDataset;
    Context mcontext;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView like;
        public ImageButton cover;
        public ImageView start;
        public TextView title;
        public TextView author;



        public MyViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.tv_title);
            author = v.findViewById(R.id.tv_author);
            like = v.findViewById(R.id.tv_like);
            cover = v.findViewById(R.id.ibtn_cover);
            start = v.findViewById(R.id.iv_start);
        }
    }


    public void setData(List<VideoInfo> myDataset) {
        mDataset = myDataset;
    }
    public void setContext(Context context) {
        mcontext = context;
    }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(mDataset.get(position).description);
        holder.author.setText("作者："+mDataset.get(position).nickname );
        holder.start.setAlpha(150);
        Glide.with(mcontext)
                .setDefaultRequestOptions(
                        new RequestOptions()
                                .frame(1000000)
                                .centerCrop()
                )
                .load(mDataset.get(position).feedUrl)
                .into(holder.cover);
        holder.like.setText("点赞：" + Integer.toString(mDataset.get(position).likeCount));
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("URL", mDataset.get(position).feedUrl);//视频地址
                String temp = mDataset.get(position).feedUrl;
                Log.d("URL", temp);//视频地址

                Intent intent = new Intent(mcontext, player.class);//选择跳转到的页面
                intent.putExtra("mURL",temp);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(intent);
            }
        };
        holder.cover.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }

}
