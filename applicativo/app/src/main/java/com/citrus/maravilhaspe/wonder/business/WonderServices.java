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
    public ArrayList<Wonder> getAllWonders(String type_wonder) {
        IWonderDAO dao = WonderFactory.getInstance().createWonderDAO();

        if(type_wonder == null) {
            return dao.getAll();
        }else{
            return dao.getByType(type_wonder);
        }
    }


    @Override
    public Wonder getWonderById(int id) {
        IWonderDAO dao = WonderFactory.getInstance().createWonderDAO();
        return dao.getById(id);
    }
}
