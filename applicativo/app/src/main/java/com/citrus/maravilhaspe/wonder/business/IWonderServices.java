package com.citrus.maravilhaspe.wonder.business;

import com.citrus.maravilhaspe.wonder.domain.Wonder;

import java.util.ArrayList;

/**
 * Created by Erick on 30/04/2015.
 */
public interface IWonderServices {
    ArrayList<Wonder> getAllWonders(String type_wonder);
    Wonder getWonderById(int Id);
}
