package sandeep.itunesminiproject.customadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import sandeep.itunesminiproject.DTO.Result;
import sandeep.itunesminiproject.R;
import sandeep.itunesminiproject.customviews.CustomBoldTextview;
import sandeep.itunesminiproject.customviews.CustomTextView;



public class SearchListRecyclerAdapter extends RecyclerView.Adapter<SearchListRecyclerAdapter.SearchListViewHolder>{

    public Context mContext;
    public ArrayList<Result> searchData;

    public SearchListRecyclerAdapter(Context _mContext,ArrayList<Result> _searchData)
    {
        mContext=_mContext;
        searchData=_searchData;
    }

    public static class SearchListViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView art_image;
        public CustomBoldTextview trackName,price;
        public CustomTextView shortDescription;

        public SearchListViewHolder(View itemView) {
            super(itemView);
            art_image=(ImageView)itemView.findViewById(R.id.art_image);
            trackName=(CustomBoldTextview)itemView.findViewById(R.id.trackName);
            shortDescription=(CustomTextView)itemView.findViewById(R.id.shortDescription);
            price=(CustomBoldTextview)itemView.findViewById(R.id.price);
        }
    }

    @Override
    public SearchListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        View convertView=layoutInflater.inflate(R.layout.search_results_recyclerview_binder,null);
        SearchListViewHolder searchListViewHolder=new SearchListViewHolder(convertView);
        return searchListViewHolder;
    }

    @Override
    public void onBindViewHolder(SearchListViewHolder holder, int position) {
        holder.shortDescription.setText(searchData.get(position).getKind());
        holder.trackName.setText(searchData.get(position).getTrackName());
        holder.price.setText(searchData.get(position).getCurrency()+searchData.get(position).getTrackPrice());
        Picasso.with(mContext).load(searchData.get(position).getArtworkUrl60()).into(holder.art_image);
    }

    @Override
    public int getItemCount() {
        return searchData.size();
    }


}
