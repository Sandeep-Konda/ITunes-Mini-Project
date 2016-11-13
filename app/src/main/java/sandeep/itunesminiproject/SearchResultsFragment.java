package sandeep.itunesminiproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sandeep.itunesminiproject.DTO.Result;
import sandeep.itunesminiproject.customadapters.RecyclerClickListener;
import sandeep.itunesminiproject.customadapters.RecyclerTouchListener;
import sandeep.itunesminiproject.customadapters.SearchListRecyclerAdapter;



public class SearchResultsFragment extends Fragment{

    private RecyclerView results_recycler_view;
    private static final String TAG = "SearchResultsFragment";
    private ArrayList<Result> result;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=new Bundle();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View convertView=inflater.inflate(R.layout.search_results_layout,null);
        Bundle bundle=getArguments();
        result=bundle.getParcelableArrayList("searchresults");

        Log.e(TAG, "onCreateView: result size"+result.size());

        return convertView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        results_recycler_view=(RecyclerView)view.findViewById(R.id.results_recycler_view);
        results_recycler_view.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        results_recycler_view.setLayoutManager(mLayoutManager);

        SearchListRecyclerAdapter searchListRecycleradapter=new SearchListRecyclerAdapter(getActivity(),result);
        results_recycler_view.setAdapter(searchListRecycleradapter);
        RecyclerClickListener recyclerClickListener=new RecyclerClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.e(TAG, "onClick: Recyclerclick" );


                Intent intent=new Intent(getActivity(),SearchDetails.class);
                intent.putExtra("clickedposition",position);
                getActivity().startActivity(intent);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        };

        results_recycler_view.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),results_recycler_view,recyclerClickListener));
    }
}
