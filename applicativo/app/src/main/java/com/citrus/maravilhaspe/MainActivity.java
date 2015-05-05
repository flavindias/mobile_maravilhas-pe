package com.citrus.maravilhaspe;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;

public class MainActivity extends SingleFragmentActivity {

    protected Fragment createFragment() {
        return new MainFragment();
    }
    //@Override
    //protected void onCreate(Bundle savedInstanceState) {
    //    super.onCreate(savedInstanceState);
    //    setContentView(R.layout.activity_main);
    //}


}
