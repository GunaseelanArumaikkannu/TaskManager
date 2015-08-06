package com.guna.taskmanager;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

public class UploadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        // Create new fragment and transaction
        Fragment newFragment = new ItemFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
        transaction.replace(R.id.fragment, newFragment);
        transaction.addToBackStack("Items");

// Commit the transaction
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String name = getIntent().getStringExtra("name");
        if (name.equals("user")) {
            getMenuInflater().inflate(R.menu.menu_search, menu);

            // Associate searchable configuration with the SearchView
            SearchManager searchManager =
                    (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            SearchView searchView =
                    (SearchView) menu.findItem(R.id.search).getActionView();
//            searchView.setSearchableInfo(
//                    searchManager.getSearchableInfo(getComponentName()));

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
