package com.citrus.maravilhaspe.wonder.gui;

import android.support.v4.app.Fragment;
import android.view.Menu;

import com.citrus.maravilhaspe.R;
import com.citrus.maravilhaspe.SingleFragmentActivity;

/**
 * Created by Erick on 29/04/2015.
 */
public class WonderListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new WonderListFragment();
    }

}
