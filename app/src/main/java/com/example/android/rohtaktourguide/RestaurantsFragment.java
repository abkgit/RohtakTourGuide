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
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.information_list, container, false);

        final ArrayList<Location> infoList = new ArrayList<Location>();
        infoList.add(new Location(R.string.restaurants_gulab_name,
                R.string.restaurants_gulab_address, R.string.restaurants_gulab_description,
                28.897179, 76.6088588, R.drawable.restaurants_gulab));
        infoList.add(new Location(R.string.restaurants_fouji_name,
                R.string.restaurants_fouji_address, R.string.restaurants_fouji_description,
                28.811843, 76.7186311, R.drawable.restaurants_fouji));
        infoList.add(new Location(R.string.restaurants_pandit_name,
                R.string.cities_panipat_address, R.string.restaurants_pandit_description,
                28.8904446, 76.6053298, R.drawable.restaurants_pandit_chat));
        infoList.add(new Location(R.string.restaurants_mcdonalds_name,
                R.string.restaurants_mcdonalds_address, R.string.restaurants_mcdonalds_description,
                28.8870488, 76.6120997, R.drawable.restaurants_mcdonalds));
        infoList.add(new Location(R.string.restaurants_subway_name,
                R.string.restaurants_subway_address, R.string.restaurants_subway_description,
                28.8851259, 76.6148362, R.drawable.restaurants_subway));
        infoList.add(new Location(R.string.restaurants_apsara_name,
                R.string.restaurants_apsara_address, R.string.restaurants_apsara_description,
                28.8812437, 76.6275178, R.drawable.restaurants_apsara));
        infoList.add(new Location(R.string.restaurants_dominos_name,
                R.string.restaurants_dominos_address, R.string.restaurants_dominos_description,
                28.8975289, 76.6296316, R.drawable.restaurants_dominos));
        infoList.add(new Location(R.string.restaurants_cafe_coffee_name,
                R.string.restaurants_cafe_coffee_address,
                R.string.restaurants_cafe_coffee_description,
                28.897481, 76.629409, R.drawable.restaurants_cafe_coffee));
        infoList.add(new Location(R.string.restaurants_pizza_wings_name,
                R.string.restaurants_pizza_wings_address,
                R.string.restaurants_pizza_wings_description,
                28.8965655, 76.6092686, R.drawable.restaurants_pizza_wings));
        infoList.add(new Location(R.string.restaurants_360_degrees_name,
                R.string.restaurants_360_degrees_address,
                R.string.restaurants_360_degrees_description,
                28.8975858, 76.6295756, R.drawable.restaurants_360_degrees));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}.
        // The adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), infoList,
                R.color.category_restaurants);

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
