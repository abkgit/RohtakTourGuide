package com.example.android.rohtaktourguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link LocationAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * item based on a data source, which is a list of {@link Location} objects.
 */
public class LocationAdapter extends ArrayAdapter<Location> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    /**
     * Create a new {@link LocationAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being
     *                        created in.
     * @param location     is the list of {@link Location}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list.
     */
    public LocationAdapter(Context context, ArrayList<Location> location,
                           int colorResourceId) {
        super(context, 0, location);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Location} object located at this position in the list
        final Location currentLocation = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID text_view_name.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.text_view_name);
        // Get the Name from the currentLocation object and set this text on
        // the Name TextView.
        nameTextView.setText(currentLocation.getName());

        // Find the TextView in the list_item.xml layout with the ID text_view_address.
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.text_view_address);
        // Get the address from the currentLocation object and set this text on
        // the Address TextView.
        addressTextView.setText(currentLocation.getAddress());

        // Find the TextView in the list_item.xml layout with the ID text_view_description.
        TextView descriptionTextView =
                (TextView) listItemView.findViewById(R.id.text_view_description);
        // Get the address from the currentLocation object and set this text on
        // the Address TextView.
        descriptionTextView.setText(currentLocation.getDescription());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Display the provided image based on the resource ID
        imageView.setImageResource(currentLocation.getImageResourceId());

        // Set the theme color for the list item
        View listItemParent = listItemView.findViewById(R.id.list_item_parent);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        listItemParent.setBackgroundColor(color);

        ImageView locationIcon = (ImageView) listItemView.findViewById(R.id.go_to_map_icon);
        locationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double latitude = currentLocation.getLatitude();
                double longitude = currentLocation.getLongitude();
                String locationName = getContext().getString(currentLocation.getName());

                String completeURI = "geo:" + latitude + "," + longitude
                        + "?q=" + latitude + "," + longitude + "(" + locationName + ")";

                Uri uri = Uri.parse(completeURI);
                showMap(uri);
            }
        });

        // Return the whole list item layout (containing 3 TextViews and 1 ImageView) so that it
        // can be shown in the ListView.
        return listItemView;
    }

    public void showMap(Uri geoLocation) {
        Context currentContext = getContext();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(currentContext.getPackageManager()) != null) {
            currentContext.startActivity(intent);
        }
    }

}

