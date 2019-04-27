package com.example.leskuy;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BottomSheetDialog extends BottomSheetDialogFragment {
    private BottomSheetListener mListener;
    private Button btn_kls1, btn_kls2, btn_kls3, btn_kls4, btn_kls5, btn_kls6, btn_kls7, btn_kls8, btn_kls9, btn_kls10IPA,btn_kls11IPA,btn_kls12IPA,btn_kls10IPS,btn_kls11IPS,btn_kls12IPS;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet,container,false);
        btn_kls1 = v.findViewById(R.id.btn_kls1);
        btn_kls2 = v.findViewById(R.id.btn_kls2);
        btn_kls3 = v.findViewById(R.id.btn_kls3);
        btn_kls4 = v.findViewById(R.id.btn_kls4);
        btn_kls5 = v.findViewById(R.id.btn_kls5);
        btn_kls6 = v.findViewById(R.id.btn_kls6);
        btn_kls7 = v.findViewById(R.id.btn_kls7);
        btn_kls8 = v.findViewById(R.id.btn_kls8);
        btn_kls9 = v.findViewById(R.id.btn_kls9);
        btn_kls10IPA = v.findViewById(R.id.btn_kls10IPA);
        btn_kls11IPA = v.findViewById(R.id.btn_kls11IPA);
        btn_kls12IPA = v.findViewById(R.id.btn_kls12IPA);
        btn_kls10IPS = v.findViewById(R.id.btn_kls10IPS);
        btn_kls11IPS = v.findViewById(R.id.btn_kls11IPS);
        btn_kls12IPS = v.findViewById(R.id.btn_kls12IPS);

        btn_kls1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onButtonClicked(btn_kls1.getText().toString());
                dismiss();
            }
        });
        return v;
    }

    public interface BottomSheetListener{
        void onButtonClicked(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener=(BottomSheetListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
            +"must implement BottomSheetListener");
        }

    }
}
