package gonzalo.yellows;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import data.CustomAdapter;
import models.Parada;
import utils.Utils;

/**
 * Created by gonzalobarbalopez on 22/06/14.
 */
public class Origen extends Fragment {

    //Debug
    private static final String TAG = "Debug";

    private ListView lstListado;
    private ArrayList<Parada> paradas = new ArrayList<Parada>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.parada_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        lstListado = (ListView)getView().findViewById(R.id.LstListado);
        GetParadas();
        lstListado.setAdapter(new CustomAdapter(this, paradas));

    }

    public ArrayList<Parada> GetParadas(){
        try {
            //JSONObject jsonResponse = new JSONObject(loadJSONFromAsset());
            JSONObject jsonResponse = new JSONObject(Utils.loadJSONFromAsset(this.getActivity(),"paradas.json"));
            JSONArray jsonArray = jsonResponse.getJSONArray("paradas");
            JSONObject jsonObject;
            for (int i = 1; i <= jsonArray.length(); i++) {
                jsonObject = (JSONObject) jsonArray.get(i);
                Log.e(TAG, jsonObject.getString("nombre"));
                paradas.add(new Parada(Integer.parseInt(jsonObject.getString("id")),
                                        jsonObject.getString("nombre")));
            }
            return paradas;
        } catch (JSONException e) {
            e.printStackTrace();
            return paradas;
        }
    }

}
