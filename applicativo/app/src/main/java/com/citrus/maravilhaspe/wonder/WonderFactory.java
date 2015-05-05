package com.citrus.maravilhaspe.wonder;

import com.citrus.maravilhaspe.wonder.business.IWonderServices;
import com.citrus.maravilhaspe.wonder.business.WonderServices;
import com.citrus.maravilhaspe.wonder.persistence.IWonderDAO;
import com.citrus.maravilhaspe.wonder.persistence.WonderDAO;

/**
 * Created by Erick on 30/04/2015.
 */
public class WonderFactory{
    private static final WonderFactory INSTANCE = new WonderFactory();
    private static IWonderDAO WONDER_DAO;
    private static IWonderServices WONDER_SERVICES;

    public synchronized static WonderFactory getInstance(){
        return INSTANCE;
    }

    public synchronized IWonderDAO createWonderDAO(){
        if(WONDER_DAO == null){
            WONDER_DAO = new WonderDAO();
        }

        return WONDER_DAO;
    }

    public synchronized IWonderServices createWonderServices(){
        if(WONDER_SERVICES == null){
            WONDER_SERVICES = new WonderServices();
        }

        return WONDER_SERVICES;
    }
}
