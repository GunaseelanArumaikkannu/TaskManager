package com.guna.taskmanager;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;

public class UploadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        handleIntent(getIntent());

        // Create new fragment and transaction
        Fragment newFragment = new ItemFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
        transaction.replace(R.id.fragment, newFragment,"Items");
        transaction.addToBackStack("Items");

// Commit the transaction
        transaction.commit();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.v("App", query);
            ItemFragment fragment = (ItemFragment) getFragmentManager().findFragmentByTag("Items");
            if(fragment!=null&&fragment.isVisible()){
                fragment.filter(query);
            }
            //use the query to search your data somehow
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String name = getIntent().getStringExtra("name");
        if (name !=null && name.equals("user")) {
            getMenuInflater().inflate(R.menu.menu_search, menu);

            // Associate searchable configuration with the SearchView
           /* SearchManager searchManager =
                    (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            MenuItem searchMenuItem = menu.findItem(R.id.search);
            SearchView searchView =
                    (SearchView) MenuItemCompat
                            .getActionView(searchMenuItem);
            SearchableInfo info = searchManager.getSearchableInfo(getComponentName());
            searchView.setSearchableInfo(info);*/
            SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
            // Assumes current activity is the searchable activity
            ComponentName componentName = new ComponentName(getApplicationContext(), UploadActivity.class);//getComponentName();
            SearchableInfo info = searchManager.getSearchableInfo(componentName);
            searchView.setSearchableInfo(info);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        Log.v("App", getFragmentManager().getBackStackEntryCount() + " is count");
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            getFragmentManager().popBackStack();
        }
        // Default action on back pressed
        else super.onBackPressed();
    }
}
