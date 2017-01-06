package com.tzs.eyepetizer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tzs.eyepetizer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ADTwoFragment extends AuthorDetailFragment {


    public ADTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_adtwo, container, false);
    }

}
