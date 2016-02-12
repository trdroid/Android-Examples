package com.gruprog.customgridviewadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private ImagesGridViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);

        /*
            Usual way of creating an adapter is by passing in a data source and a child view layout

            The responsibility of an adapter is then to manage data and provide child views to the list control

            The data source, in this example, is defined within the adapter, and is not passed from here;
            also the child view to use is hardcoded in the adapter for this example

            So just pass a context, as it is customary to pass in the context to an adapter

            Instead of the following:

            CustomAdapter adapter = new CustomAdapter(this,
                R.layout.child_view_layout, dataSource);

            we use

            CustomAdapter adapter = new CustomAdapter(this);

            as shown below
         */

        //
        adapter = new ImagesGridViewAdapter(this);

        /*
            set the ListView control (GridView) with the custom adapter instance.

            The ListView control calls methods on the adapter to set itself up with the views to display which are configured with data

            For eg. The ListView control calls getCount() method on the adapter instance to determine the number of objects there are to display.
         */
        gridView.setAdapter(adapter);
    }

    /*
        The adapter manages the passing of data from a data source to construct Android View objects that will be used by the list control,
                GridView in this case
     */
    public static class ImagesGridViewAdapter extends BaseAdapter {
        private static final String TAG = "PhotoGridViewAdapter";
        private static int convertViewCounter = 0;
        private Context mContext;
        private LayoutInflater mInflater;

        /*
            The adapter is aware of the data as the data is defined with in it
            However, data could come from a cursor object that can be passed to an adapter
         */

        // define an array with the resource ids of the images
        private int[] imagesResourceIds = { R.drawable.img1, R.drawable.img2, R.drawable.img3,
                R.drawable.img4, R.drawable.img5, R.drawable.img6,
                R.drawable.img7, R.drawable.img8, R.drawable.img9,
                R.drawable.img10, R.drawable.img11, R.drawable.img12,
                R.drawable.img13, R.drawable.img14, R.drawable.img15,
                R.drawable.img16, R.drawable.img17, R.drawable.img18,
                R.drawable.img19, R.drawable.img20, R.drawable.img21,
                R.drawable.img22, R.drawable.img23, R.drawable.img24,
                R.drawable.img25, R.drawable.img26, R.drawable.img27,
                R.drawable.img28, R.drawable.img29, R.drawable.img30
        };

        public ImagesGridViewAdapter(Context context) {
            Log.v(TAG, "In constructor ...");
            this.mContext = context;

            /*
                Obtain a LayoutInflater from the context, as it helps in performance when a new view
                has to be created and returned to the list control
             */
            mInflater = LayoutInflater.from(context);

            for(int iter = 0; iter < imagesResourceIds.length; iter++) {
                images[iter] = BitmapFactory.decodeResource(context.getResources(), imagesResourceIds[iter]);
                thumbnails[iter] = Bitmap.createScaledBitmap(images[iter], 200, 200, false);
            }
        }

        /*
            It is typical in an adapter to create ViewHolder objects to contain the view objects for each row representing the data elements

            If each data element contains both an image and its title, then each row should contain an ImageView and a TextView,
                in which case the ViewHolder contains an ImageView and a TextView, as it is representative of a single row's views

                static class ViewHolder {
                    ImageView image;
                    TextView title;
                }
         */
        static class ViewHolder {
            ImageView image;
        }

        /*
            images array is the data source for the adapter
         */
        private Bitmap[] images = new Bitmap[imagesResourceIds.length];
        private Bitmap[] thumbnails = new Bitmap[imagesResourceIds.length];

        /*
            Lets the AdapterView control know how many objects there are to display
         */
        @Override
        public int getCount() {
            Log.v(TAG, "In getCount()");
            return imagesResourceIds.length;
        }

        @Override
        public Object getItem(int position) {
            Log.v(TAG, "In getItem() for position " + position);
            return images[position];
        }

        /*
            Item Ids provide a mechanism to access data separate from its position,
                which is seen in cases where the data resides external to the adapter (eg. contacts)

            If a ListView were displaying contacts using a contact provider, the item id would be the
                _ID value from the contact provider.

            In this case, since the adapter holds the data and can access it directly, the position
             of the data can be used as the id and is returned.
         */
        @Override
        public long getItemId(int position) {
            Log.v(TAG, "In getItem() for position " + position);

            int itemId = position;

            return itemId;
        }

        /*
            This method is related to the getViewTypeCount() method

            if getViewTypeCount() returns 3 indicating that the GridView could display three different view types,
                the return value of getItemViewType indicates which of the 3 view types is at a particular position in the data,
                    so the getItemViewType should return either 0, 1 or 2
         */
        @Override
        public int getItemViewType(int position) {
            //return super.getItemViewType(position);

            Log.v(TAG, "In getItemViewType() for position " + position);
            return 0;
        }

         /*
            Returns the number of different types of views that could be displayed in the GridView.

            Say for a ListView, if each row should have a view configured with data and a separator, return 2 from this method,

            say for a ListView, if each row should have a view configured with data and a separator, return 2 from this method,
                in this case the separator is treated as data as it has "taken" a position in the data,
                in which case the data source can be imagined to be:
                           [data object 1, separator, data object 2, separator, ..]

            A) When the ListView control calls getView on the adapter instance for position 0,
                getView() will have to return a view configured with the data from data object 1,
                and getItemViewType() should return the appropriate integer value defined to match that view type.

            B) When the ListView control calls getView on the adapter instance for position 1 (i.e. after getting data object 1 for position 0),
                       getView() will have to return the separator as a view rather than a view configured with data object,
                       and getItemViewType() should return the appropriate integer value defined to match that view type.

            Let's say 0 implies view configured with data and 1 implies separator, then step A's getItemViewType()
                should return 0 where as step B's getItemViewType() returns 1
         */
        @Override
        public int getViewTypeCount() {
            //return super.getViewTypeCount();

            Log.v(TAG, "In getViewTypeCount()");
            return 1;
        }

        /*
            The list control asks for Views to build the UI.
            It also passes views that are no longer needed in for recycling
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder imageHolder;

            Log.v(TAG, "In getView() for position " + position + ", convertView is " + ((convertView == null)? "null" : "being recycled"));

            if(convertView == null) {
                convertView = mInflater.inflate(R.layout.single_image_view, null);
                convertViewCounter++;

                imageHolder = new ViewHolder();
                imageHolder.image = (ImageView) convertView.findViewById(R.id.singleImageView);

                convertView.setTag(imageHolder);
            } else {
                imageHolder = (ViewHolder) convertView.getTag();
            }

            imageHolder.image.setImageBitmap(thumbnails[position]);

            return convertView;
        }
    }
}