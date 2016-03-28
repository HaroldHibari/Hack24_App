package com.hibatop.haroldhibari.hack24;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import java.util.ArrayList;


/**
 * Created by Hibatop on 19/03/2016.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>{

    private ArrayList<Article> mArticles;
    private Context mContext;
    public ArticleAdapter(ArrayList<Article> Articles, Context context){
        mContext = context;
        mArticles = Articles;
    }

    @Override
    public ArticleAdapter.ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false);

        v.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });

        ArticleViewHolder artV = new ArticleViewHolder(v);
        return artV;
    }

    @Override
    public void onBindViewHolder(ArticleAdapter.ArticleViewHolder holder, int position) {

        holder.header.setText(mArticles.get(position).getHeader());
        holder.summary.setText(mArticles.get(position).getHeader());
        Picasso.with(mContext).load(mArticles.get(position).getImage())
                .error(R.drawable.queen)
                .placeholder(R.drawable.queen)
                .into(holder.articleImage);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), ChatActivity.class);
                mContext.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView header;
        TextView summary;
        ImageView articleImage;
        Button button;
        public ArticleViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.acv);
            header = (TextView)itemView.findViewById(R.id.header);
            summary = (TextView)itemView.findViewById(R.id.summary);
            articleImage = (ImageView)itemView.findViewById(R.id.artImg);
            button = (Button)itemView.findViewById(R.id.chat);
        }
    }
}
