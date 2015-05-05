package com.citrus.maravilhaspe.wonder.business;

import com.citrus.maravilhaspe.wonder.WonderFactory;
import com.citrus.maravilhaspe.wonder.domain.Wonder;
import com.citrus.maravilhaspe.wonder.persistence.IWonderDAO;

import java.util.ArrayList;

/**
 * Created by Erick on 30/04/2015.
 */
public class WonderServices implements IWonderServices {
    @Override
    public ArrayList<Wonder> getAllWonders() {
        IWonderDAO dao = WonderFactory.getInstance().createWonderDAO();

        return dao.getAll();
    }

    @Override
    public Wonder getWonderById(int id) {
        IWonderServices dao = WonderFactory.getInstance().createWonderServices();
        return dao.getWonderById(id);
    }
}
