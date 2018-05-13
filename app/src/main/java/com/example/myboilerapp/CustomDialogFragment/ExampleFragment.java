//package com.example.myboilerapp.CustomDialogFragment;
//
//
//import android.app.Fragment;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.example.myboilerapp.R;
//
//public class ExampleFragment extends Fragment implements MyCustomDialog.OnInputListener{
//
//    private static final String TAG = "MainFragment";
//
//    //widgets
//    private Button mOpenDialog;
//    public TextView mDisplay;
//
//    public ExampleFragment() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        Log.d(TAG, "onCreateView: creating fragment");
//        // Inflate the layout for this fragment
//        View view =  inflater.inflate(R.layout.fragment_main, container, false);
//
//        mDisplay = view.findViewById(R.id.input_display);
//        mOpenDialog = view.findViewById(R.id.open_dialog);
//        mOpenDialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onClick: opening dialog.");
//                MyCustomDialog customDialog = new MyCustomDialog();
//                customDialog.setTargetFragment(MainFragment.this,1);
//                customDialog.show(getFragmentManager(),"MyCustomDialog");
//            }
//        });
//
//        return view;
//    }
//
//    @Override
//    public void sendInput(String input) {
//        mDisplay.setText(input);
//    }
//}
