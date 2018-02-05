package com.deerlive.lipstick.fragment;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deerlive.lipstick.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CityDialogFragment extends DialogFragment {


    public CityDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city_dialog, container, false);
    }

}
