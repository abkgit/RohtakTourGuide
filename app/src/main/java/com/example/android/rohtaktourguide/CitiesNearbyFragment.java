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
public class CitiesNearbyFragment extends Fragment {

    public CitiesNearbyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.information_list, container, false);

        final ArrayList<Location> infoList = new ArrayList<Location>();
        infoList.add(new Location(R.string.cities_delhi_name,
                R.string.cities_delhi_address, R.string.cities_delhi_description,
                28.6139391, 77.2090212, R.drawable.cities_delhi));
        infoList.add(new Location(R.string.cities_chandigarh_name,
                R.string.cities_chandigarh_address, R.string.cities_chandigarh_description,
                30.7333148, 76.7794179, R.drawable.cities_chandigarh));
        infoList.add(new Location(R.string.cities_gurgaon_name,
                R.string.cities_gurgaon_address, R.string.cities_gurgaon_description,
                28.4594965, 77.0266383, R.drawable.cities_gurgaon));
        infoList.add(new Location(R.string.cities_panipat_name,
                R.string.cities_panipat_address, R.string.cities_panipat_description,
                29.3909464, 76.9635023, R.drawable.cities_panipat));
        infoList.add(new Location(R.string.cities_kurukshetra_name,
                R.string.cities_kurukshetra_address, R.string.cities_kurukshetra_description,
                29.9695121, 76.878282, R.drawable.cities_kurukshetra));


        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}.
        // The adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), infoList,
                R.color.category_cities_nearby);

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

