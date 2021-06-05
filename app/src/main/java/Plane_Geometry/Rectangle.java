package Plane_Geometry;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mathoperations.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Rectangle extends Fragment {

    EditText editText_l ;
    EditText editText_w;
    Button compute, clear;
    WebView webView;

    public Rectangle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rectangle, container, false);

        editText_l = v.findViewById(R.id.rec_l_edit);
        editText_w = v.findViewById(R.id.rec_w_edit);
        compute = v.findViewById(R.id.rec_computeBtn);
        clear = v.findViewById(R.id.rec_clearBtn);
        webView = v.findViewById(R.id.rec_wv);

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText_l.getText().toString().isEmpty()){
                    editText_l.requestFocus();
                    editText_l.setError("Please Enter Valid Value");
                } else if (editText_w.getText().toString().isEmpty()) {
                    editText_w.requestFocus();
                    editText_w.setError("Please Enter Valid Value");
                }else {
                    String temp_l = editText_l.getText().toString();
                    String temp_w = editText_w.getText().toString();
                    int l = Integer.parseInt(temp_l);
                    int w = Integer.parseInt(temp_w);

                    int rectangle = l*w;
                    float pre = 2*(l+w);

                    webView.setBackgroundColor(Color.parseColor("#000000"));

                    webView.loadData("<p align = center style=" + "color:yellow;" + "><i>Here, Length(l) = " + l +
                            ", Width(w) = " + w +
                            "<br><span align = center style=color:white> Area = l x w = " + l + " x " + w + "</span>" +
                            "<br><span align = center style=color:yellow> Area = " + rectangle + "</span>" +
                            "<br><span align = center style=color:white> Perimeter = 2(l + w) = 2 x(" + l + " + "+ w + ")"+ "</span>" +
                            "<br><span align = center style=color:yellow> Perimeter = " + pre, "text/html", " charset=utf-8");
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rectangle rectangle = new Rectangle();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.plan_container,rectangle).commit();
            }
        });

    return  v;
    }
}
