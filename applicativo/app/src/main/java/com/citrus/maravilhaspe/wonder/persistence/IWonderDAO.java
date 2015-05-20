package com.citrus.maravilhaspe.wonder.persistence;

import com.citrus.maravilhaspe.wonder.domain.Wonder;

import java.util.ArrayList;

/**
 * Created by Erick on 30/04/2015.
 */
public interface IWonderDAO {
    ArrayList<Wonder> getAll();
    ArrayList<Wonder> getByType(String type);
    Wonder getById(int id);
}
