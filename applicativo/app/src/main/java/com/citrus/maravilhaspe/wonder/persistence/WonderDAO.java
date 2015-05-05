package com.citrus.maravilhaspe.wonder.persistence;

import com.citrus.maravilhaspe.wonder.domain.Wonder;

import java.util.ArrayList;

/**
 * Created by Erick on 30/04/2015.
 */
public class WonderDAO implements IWonderDAO {
    @Override
    public ArrayList<Wonder> getAll() {
        ArrayList<Wonder> mWonders = new ArrayList<Wonder>();
        for(int i = 0; i < 100; i ++){
            Wonder w = new Wonder();
            w.setName("Museu" + i);
            mWonders.add(w);
        }
        return mWonders;
    }

    @Override
    public Wonder getById(int id) {
        Wonder w = new Wonder();
        w.setName("Museu 1");
        return w;
    }
}
