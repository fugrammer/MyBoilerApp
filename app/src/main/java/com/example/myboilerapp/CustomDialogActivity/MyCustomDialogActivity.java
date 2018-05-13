package com.example.myboilerapp.CustomDialogActivity;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myboilerapp.R;

public class MyCustomDialogActivity extends DialogFragment {

    private static final String TAG = "MyCustomDialog";

    public interface OnInputListener{
        void sendInput(String input);
    }

    public OnInputListener onInputListener;

    //widgets
    private EditText mInput;
    private TextView mActionOk, mActionCancel;

    //vars

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_my_custom, container,false);

        mActionCancel = view.findViewById(R.id.cancelTextView);
        mActionOk = view.findViewById(R.id.okTextView);
        mInput = view.findViewById(R.id.editText);

        mActionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: closing dialog.");
                getDialog().dismiss();
            }
        });

        mActionOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: capturing input");

                String input = mInput.getText().toString();

                onInputListener.sendInput(input);

                getDialog().dismiss();
            }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            onInputListener = (OnInputListener) getActivity();
        } catch (ClassCastException e){
            Log.d(TAG, "onAttach: ClassCastException: " +e.getMessage());
        }
    }
}
