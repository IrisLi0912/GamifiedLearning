package au.edu.unsw.infs3634.gamifiedlearning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FunFactsAdapter extends RecyclerView.Adapter<FunFactsAdapter.MyViewHolder> {
    List<FunFacts> mLists;
    Context context;


    public FunFactsAdapter(Context context, List<FunFacts> mLists) {
        this.context = context;
        this.mLists = mLists;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_funfacts_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //get corresponding value form list
        holder.tv_funfactTitle.setText(mLists.get(position).getFunfactTitle());
        holder.tv_description.setText(mLists.get(position).getDescription());
        holder.iv_funfactImage.setImageResource(mLists.get(position).getFunfactImage());
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_funfactTitle;
        TextView tv_description;
        ImageView iv_funfactImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_funfactTitle = (TextView) itemView.findViewById(R.id.tv_funfactTitle);
            iv_funfactImage = (ImageView) itemView.findViewById(R.id.iv_funfactImage);
            tv_description = (TextView) itemView.findViewById(R.id.tv_description);
        }
    }


}

