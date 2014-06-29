package data;

import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import gonzalo.yellows.R;
import models.Parada;

public class CustomAdapter extends ArrayAdapter<Parada> {

    Activity context;
    private ArrayList<Parada> datos;

    public CustomAdapter(Fragment context, ArrayList<Parada> datos) {
        super(context.getActivity(), R.layout.parada_row, datos);
        this.datos = datos;
        this.context = context.getActivity();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.parada_row, null);

        TextView name = (TextView) item.findViewById(R.id.txt_row_parada);
        name.setText(datos.get(position).getName());

        TextView id = (TextView) item.findViewById(R.id.txt_row_id);
        id.setText(datos.get(position).getId() + "");

        return (item);
    }

}
