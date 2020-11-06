package au.edu.unsw.infs3634.gamifiedlearning;


        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;



public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder>{
    ArrayList<MainTopicsCategory> mLists;
    Context context;
    private OnItemClickListener onItemClickListener;

    public TopicAdapter(Context context, ArrayList<MainTopicsCategory> mLists) {
        this.context = context;
        this.mLists = mLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_topic_category_list, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        MainTopicsCategory item = mLists.get(position);

        int image = context.getResources().getIdentifier(item.getImageName(),
                "drawable", "com.example.gamifiedlearning");
        holder.iv_topicCategory.setImageResource(image);
        holder.tv_mtopicTittle.setText(item.getTopicCategory());
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
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_mtopicTittle;
        ImageView iv_topicCategory;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tv_mtopicTittle = itemView.findViewById(R.id.tv_mtopicTittle);
            iv_topicCategory = itemView.findViewById(R.id.iv_topicCategory);


        }

    }
}
