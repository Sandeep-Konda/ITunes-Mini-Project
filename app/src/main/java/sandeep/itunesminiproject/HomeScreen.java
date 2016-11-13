package sandeep.itunesminiproject;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sandeep.itunesminiproject.DTO.OutputResponse;
import sandeep.itunesminiproject.customadapters.SearchListRecyclerAdapter;
import sandeep.itunesminiproject.dialogviews.ShowAlertDialog;
import sandeep.itunesminiproject.retrofitutils.APIInterface;
import sandeep.itunesminiproject.retrofitutils.RetrofitAPIInstance;

public class HomeScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,SearchView.OnQueryTextListener {

    private static final String TAG = "HomeScreen";
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private FrameLayout fragments_layout;
    private APIInterface apiInterface;
    private ShowAlertDialog showAlertDialog;
    private static String selectedCategory;
    private ITunesApplication iTunesApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        showAlertDialog=ShowAlertDialog.getInstance();
        fragments_layout=(FrameLayout)findViewById(R.id.fragments_layout);
        setSupportActionBar(toolbar);
        setUpNavigationDrawer();
        iTunesApplication=ITunesApplication.getInstance();
        apiInterface= RetrofitAPIInstance.getClient().create(APIInterface.class);
        performAPICall("all","musicVideo","home");
    }
    private void performAPICall(String searchquery, String category, final String from)
    {
        if (isNetworkConnected())
        {
            Call<OutputResponse> outputResponseCall=apiInterface.getSearchResults(searchquery,category);
            outputResponseCall.enqueue(new Callback<OutputResponse>() {
                @Override
                public void onResponse(Call<OutputResponse> call, Response<OutputResponse> response) {
                    Log.e(TAG, "onResponse: "+response.body().getResults().size() );
                    final OutputResponse outputResponse=response.body();
                    if (outputResponse!=null&&outputResponse.getResults().size()>0)
                    {
                        Handler handler=new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                iTunesApplication.setOutputResult(outputResponse.getResults());
                                SearchResultsFragment searchResultsFragment=new SearchResultsFragment();
                                Bundle bundle=new Bundle();
                                bundle.putParcelableArrayList("searchresults",outputResponse.getResults());
                                searchResultsFragment.setArguments(bundle);
                                addFragment(searchResultsFragment);

                            }
                        },100);


                    }
                    else
                    {

                        showAlertDialog.showDialog(HomeScreen.this,"Alert","No Data Please try with other query");
                    }
                }

                @Override
                public void onFailure(Call<OutputResponse> call, Throwable t) {

                }
            });
        }
        else
        {
            showAlertDialog.showDialog(HomeScreen.this,"Alert","Please check your internet connection");

        }
    }

    private void addFragment(SearchResultsFragment searchResultsFragment)
    {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragments_layout,searchResultsFragment);
        fragmentTransaction.commit();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        apiInterface= RetrofitAPIInstance.getClient().create(APIInterface.class);
        handleIntent(intent);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        SearchManager searchManager =
                (SearchManager)HomeScreen.this.getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search_view).getActionView();
        Log.e(TAG, "onCreateOptionsMenu: "+searchView);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(this.getComponentName()));
       return true;

    }

    private void setUpNavigationDrawer()
    {
         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        handleIntent(getIntent());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        Log.e(TAG, "onOptionsItemSelected: "+id);
        switch (id)
        {
            case R.id.nav_movie:
                Log.e(TAG, "onOptionsItemSelected: movie");
                performAPICall("all","movie","");
                selectedCategory="movie";
                break;
            case R.id.nav_podcast:
                Log.e(TAG, "onOptionsItemSelected: movie");
                performAPICall("all","podcast","");
                selectedCategory="podcast";
                break;
            case R.id.nav_music:
                performAPICall("all","musicArtist","");
                selectedCategory="musicArtist";
                break;
            case R.id.nav_music_video:
                Log.e(TAG, "onOptionsItemSelected: video");
                performAPICall("all","musicVideo","");
                selectedCategory="musicVideo";
                break;
            case R.id.nav_audiobook:
                performAPICall("all","audiobook","");
                selectedCategory="audiobook";
                break;
            case R.id.nav_short_film:
                performAPICall("all","shortFilm","");
                selectedCategory="shortFilm";
                break;
            case R.id.nav_tv_show:
                performAPICall("all","tvSeason","");
                selectedCategory="tvSeason";
                break;
            case R.id.nav_software:
                performAPICall("all","macSoftware","");
                selectedCategory="macSoftware";
                break;
            case R.id.nav_ebook:
                performAPICall("all","ebook","");
                selectedCategory="ebook";
                break;



        }
        return true;
    }

    private void handleIntent(Intent intent) {
        apiInterface= RetrofitAPIInstance.getClient().create(APIInterface.class);
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
            Log.e(TAG, "handleIntent: query"+query );
            performAPICall(query,selectedCategory,"");
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        return false;
    }
}
