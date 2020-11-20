package au.edu.unsw.infs3634.gamifiedlearning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SubTopicAdapter extends RecyclerView.Adapter<SubTopicAdapter.ViewHolder> {

    ArrayList<SubTopic> mLists;
    Context context;
    private OnItemClickListener onItemClickListener;

    public SubTopicAdapter(Context context, ArrayList<SubTopic> mLists) {
        this.context = context;
        this.mLists = mLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.actitvty_topic_list_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        SubTopic item = mLists.get(position);


        int image = context.getResources().getIdentifier(item.getTopicImageName(),
                "drawable", "au.edu.unsw.infs3634.gamifiedlearning");

        holder.iv_topicLogo.setImageResource(image);
        holder.tv_topicTitle.setText(item.getTopicTitle());
        holder.rating.setRating(Float.parseFloat(item.getRating().toString()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_topicTitle;
        ImageView iv_topicLogo;
        RatingBar rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_topicTitle = itemView.findViewById(R.id.tv_topicTitle);
            iv_topicLogo = itemView.findViewById(R.id.iv_topicLogo);
            rating = itemView.findViewById(R.id.rating);
        }
    }

}




