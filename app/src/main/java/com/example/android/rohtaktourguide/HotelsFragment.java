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
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.information_list, container, false);

        final ArrayList<Location> infoList = new ArrayList<Location>();
        infoList.add(new Location(R.string.hotels_d2m_name,
                R.string.hotels_d2m_address, R.string.hotels_d2m_description,
                28.8993877, 76.6047979, R.drawable.hotels_d2m));
        infoList.add(new Location(R.string.hotels_rivoli_name,
                R.string.hotels_rivoli_address, R.string.hotels_rivoli_description,
                28.8961652, 76.6086397, R.drawable.hotels_rivoli));
        infoList.add(new Location(R.string.hotels_crystal_name,
                R.string.hotels_crystal_address, R.string.hotels_crystal_description,
                28.8937481, 76.6151299, R.drawable.hotels_crystal_continental));
        infoList.add(new Location(R.string.hotels_sagar_name,
                R.string.hotels_sagar_address, R.string.hotels_sagar_description,
                28.8934953, 76.6162194, R.drawable.hotels_sagar_villa));
        infoList.add(new Location(R.string.hotels_harjais_name,
                R.string.hotels_harjais_address, R.string.hotels_harjais_description,
                28.875531, 76.636848, R.drawable.hotels_harjais));
        infoList.add(new Location(R.string.hotels_platinum_name,
                R.string.hotels_platinum_address, R.string.hotels_platinum_description,
                28.8850416, 76.6232202, R.drawable.hotels_platinum_plaza));
        infoList.add(new Location(R.string.hotels_royal_name,
                R.string.hotels_royal_address, R.string.hotels_royal_description,
                28.885733, 76.623437, R.drawable.hotels_royal_mall));
        infoList.add(new Location(R.string.hotels_glassee_name,
                R.string.hotels_glassee_address, R.string.hotels_glassee_description,
                28.8880609, 76.608692, R.drawable.hotels_glassee));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}.
        // The adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), infoList,
                R.color.category_hotels);

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

