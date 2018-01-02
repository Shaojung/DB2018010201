package com.example.student.db2018010201;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.student.db2018010201.data.Student;

/**
 * Created by student on 2018/1/2.
 */

public class AddDialogFragment extends DialogFragment {
    EditText ed1, ed2, ed3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_data, container);
        Button btn = (Button) v.findViewById(R.id.button);
        ed1 = (EditText) v.findViewById(R.id.editText);
        ed2 = (EditText) v.findViewById(R.id.editText2);
        ed3 = (EditText) v.findViewById(R.id.editText3);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).dao.add(
                        new Student(
                            Integer.valueOf(ed1.getText().toString()),
                                ed2.getText().toString(),
                                Integer.valueOf(ed3.getText().toString())
                ));
                ((MainActivity)getActivity()).refreshData();
                dismiss();
            }
        });
        return v;
    }

}
