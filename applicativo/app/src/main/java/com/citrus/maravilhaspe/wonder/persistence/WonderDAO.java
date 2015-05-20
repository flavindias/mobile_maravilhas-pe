package com.citrus.maravilhaspe.wonder.persistence;

import android.util.Log;

import com.citrus.maravilhaspe.generic.GenericFactory;
import com.citrus.maravilhaspe.generic.persistence.IRESTAccess;
import com.citrus.maravilhaspe.wonder.domain.Wonder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Erick on 30/04/2015.
 */
public class WonderDAO implements IWonderDAO {

    public WonderDAO(){
    }

    @Override
    public ArrayList<Wonder> getAll() {
        ArrayList<Wonder> mWonders = new ArrayList<Wonder>();

        IRESTAccess rest = GenericFactory.getInstance().createRestAccess();
        String result = rest.executeGetMethod("wonders.json");

        try {
            Log.i("logs" , result);
            JSONObject jWonders = new JSONObject(result);
            JSONArray jArrayWonders = jWonders.getJSONArray("wonders");
            for (int i = 0 ; i < jArrayWonders.length(); i ++){
                Wonder w = new Wonder();
                JSONObject jwonder = jArrayWonders.getJSONObject(i);
                //Setando dados
                w.setName((String)jwonder.getString("name"));
                w.setId((int) jwonder.getInt("id"));
                w.setDescription((String)jwonder.getString("description"));
                //Adicionando na array
                mWonders.add(w);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mWonders;
    }

    @Override
    public Wonder getById(int id) {
        Wonder wonder = new Wonder();

        IRESTAccess rest = GenericFactory.getInstance().createRestAccess();
        Log.i("log-maravilha", "wonders/view/" + id + ".json");
        String result = rest.executeGetMethod("wonders/view/"+id+".json");

        try {
            JSONObject jWonder = new JSONObject(result);
            wonder.setName(jWonder.getJSONObject("wonder").getString("name"));
            wonder.setDescription(jWonder.getJSONObject("wonder").getString("description"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return wonder;
    }
}
