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
import java.util.Collections;
import java.util.Comparator;


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
                "drawable", "au.edu.unsw.infs3634.gamifiedlearningcom");
        holder.iv_topicLogo.setImageResource(image);
        holder.tv_topicTitle.setText(item.getTopicTitle());

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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_topicTitle = itemView.findViewById(R.id.tv_topicTitle);
            iv_topicLogo = itemView.findViewById(R.id.iv_topicLogo);
        }
    }

}































































//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Filter;
//import android.widget.Filterable;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
//public class SubTopicAdapter extends RecyclerView.Adapter<SubTopicAdapter.destinationViewHolder> implements Filterable {
//    public static final int SORT_REVIEW_NUMBER = 1;
//    public static final int SORT_SCORE = 2;
//    public ArrayList<Places> mPlacesFiltered;
//    private ArrayList<Places> mPlaces;
//    private RecyclerViewClickListener mListener;
//
//    public SubTopicAdapter(ArrayList<Places> places, RecyclerViewClickListener listener) {
//        mPlaces = places;
//        mListener = listener;
//        mPlacesFiltered = places;
//    }
//
//    @Override
//    //filter for the search function
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                String charString = constraint.toString();
//                if (charString.isEmpty()) {
//                    mPlacesFiltered = mPlaces;
//                } else {
//                    ArrayList<Places> FilteredList = new ArrayList<>();
//                    for (Places places : mPlaces) {
//                        if (places.getPlacesName().toLowerCase().contains(charString.toLowerCase())) {
//                            FilteredList.add(places);
//                        }
//                    }
//                    mPlacesFiltered = FilteredList;
//                }
//
//                FilterResults filterResults = new FilterResults();
//                filterResults.values = mPlacesFiltered;
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//                mPlacesFiltered = (ArrayList<Places>) results.values;
//                notifyDataSetChanged();
//            }
//        };
//    }
//
//    @NonNull
//    @Override
//    public destinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        //layout inflater
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.places_list_row, parent, false);
//        return new destinationViewHolder(v, mListener);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull destinationViewHolder holder, int position) {
//        Places places = mPlacesFiltered.get(position);
//        DecimalFormat df = new DecimalFormat("#,###,###,###");
//        holder.placeName1.setText(places.getPlacesName());
//        holder.placeDesc1.setText(places.getPlaceDesc());
//        holder.placeRoughLc1.setText(places.getPlaceRoughLc());
//        double temp; //using a double to display decimal
//        temp = Double.parseDouble(df.format(places.getPlaceScore())) / 10;
//        holder.placeScore1.setText("Score ranking: " + temp);
//        holder.reviewPopulation1.setText("(From " + df.format(places.getReviewPopulation()) + " users)");
//        holder.itemView.setTag(places.getPlacesName());
//        holder.myImage.setImageResource(places.getPlacePicture());
//    }
//
//    @Override
//    public int getItemCount() {
//        return mPlacesFiltered.size();
//    }
//
//    //the sorting method
//    public void sort(final int sortMethod) {
//        if (mPlacesFiltered.size() > 0) {
//            Collections.sort(mPlacesFiltered, new Comparator<Places>() {
//                @Override
//                public int compare(Places o1, Places o2) {
//                    if (sortMethod == SORT_REVIEW_NUMBER) {
//                        return o2.getReviewPopulation().compareTo(o1.getReviewPopulation());
//                    } else if (sortMethod == SORT_SCORE) {
//                        return o2.getPlaceScore().compareTo(o1.getPlaceScore());
//                    }
//                    return o2.getPlaceScore().compareTo(o1.getReviewPopulation());
//                }
//            });
//        }
//        notifyDataSetChanged();
//    }
//
//    public interface RecyclerViewClickListener {
//        void onClick(View view, String placesName);
//    }
//
//    public static class destinationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        //creating a view holder object to display information
//        public TextView placeName1, placeDesc1, placeScore1, reviewPopulation1, placeRoughLc1;
//        ImageView myImage;
//        private RecyclerViewClickListener listener;
//
//        public destinationViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
//            super(itemView);
//            this.listener = listener;
//            itemView.setOnClickListener(this);
//            placeName1 = itemView.findViewById(R.id.tvPlace);
//            placeDesc1 = itemView.findViewById(R.id.tvDesc);
//            placeScore1 = itemView.findViewById(R.id.tvUserScore);
//            placeRoughLc1 = itemView.findViewById(R.id.tvRough);
//            reviewPopulation1 = itemView.findViewById(R.id.tvReviewPopulation);
//            myImage = itemView.findViewById(R.id.ivPicture);
//        }
//
//        @Override
//        public void onClick(View v) {
//            listener.onClick(v, (String) v.getTag());
//        }
//    }
//}