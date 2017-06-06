package com.appbusters.robinkamboj.bottomnavigation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class TempFragment extends Fragment {

    private String from;

    public TempFragment() {
        // Required empty public constructor
    }

    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_temp, container, false);
        textView = (TextView) v.findViewById(R.id.text);

        Bundle args = getArguments();
        from = args.getString("from");
        Log.e("FROM", from);
        textView.setText(from);

        return v;
    }

}
