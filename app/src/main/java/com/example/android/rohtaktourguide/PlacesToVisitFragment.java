package com.example.android.rohtaktourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesToVisitFragment extends Fragment {

    public PlacesToVisitFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.information_list, container, false);

        final ArrayList<Location> infoList = new ArrayList<Location>();
        infoList.add(new Location(R.string.ptv_tilyar_lake_name,
                R.string.ptv_tilyar_lake_address, R.string.ptv_tilyar_lake_description,
                28.8802386, 76.6358562, R.drawable.ptv_tilyar_lake));
        infoList.add(new Location(R.string.ptv_tilyar_zoo_name,
                R.string.ptv_tilyar_zoo_address, R.string.ptv_tilyar_zoo_description,
                28.8801346, 76.6393805, R.drawable.ptv_tilyar_zoo));
        infoList.add(new Location(R.string.ptv_banni_name,
                R.string.ptv_banni_address, R.string.ptv_banni_description,
                28.963017, 76.5091, R.drawable.ptv_banni_khera_farm));
        infoList.add(new Location(R.string.ptv_merion_name,
                R.string.ptv_merion_address, R.string.ptv_merion_description,
                28.8973662, 76.6294422, R.drawable.ptv_merion_mall));
        infoList.add(new Location(R.string.ptv_splash_name,
                R.string.ptv_splash_address, R.string.ptv_splash_description,
                28.916133, 76.5812083, R.drawable.ptv_splash_water_park));
        infoList.add(new Location(R.string.ptv_sai_name,
                R.string.ptv_sai_address, R.string.ptv_sai_description,
                28.8426344, 76.6784012, R.drawable.ptv_sai_temple));
        infoList.add(new Location(R.string.ptv_mansarovar_name,
                R.string.ptv_mansarovar_address, R.string.ptv_mansarovar_description,
                28.8956771, 76.5975834, R.drawable.ptv_mansarovar_park));
        infoList.add(new Location(R.string.ptv_gufa_name,
                R.string.ptv_gufa_address, R.string.ptv_gufa_description,
                28.8889054, 76.612693, R.drawable.ptv_gufa_temple));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}.
        // The adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), infoList,
                R.color.category_places_to_visit);

        // Find the {@link ListView} object in the view hierarchy of the {@link Fragment}.
        // There should be a {@link ListView} with the view ID called list, which is declared in
        // the information_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} we created above, so that
        // the {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}