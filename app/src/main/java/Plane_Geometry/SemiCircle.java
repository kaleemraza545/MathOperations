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

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class SemiCircle extends Fragment {
    EditText edit;
    Button compute,clear;
    WebView webView;

    public SemiCircle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_semi_circle, container, false);
        edit = v.findViewById(R.id.semicir_edit);
        compute = v.findViewById(R.id.semicir_computeBtn);
        clear = v.findViewById(R.id.semicir_clearBtn);
        webView = v.findViewById(R.id.semicir_wv);


        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().toString().isEmpty()){
                    edit.requestFocus();
                    edit.setError("Please Enter valid Value");
                }else{
                    String temp = edit.getText().toString();
                    int num = Integer.parseInt(temp);
                    double result = Math.PI * num * num;
                    result = Double.parseDouble(new DecimalFormat("#.####").format(result));
                    double results = result / 2;
                    results = Double.parseDouble(new DecimalFormat("#.####").format(results));
                    double per = (Math.PI * num) + (2*num);
                    per = Double.parseDouble(new DecimalFormat("#.####").format(per));


                    webView.setBackgroundColor(Color.parseColor("#000000"));
                    webView.loadData("<body style=\"text-align: center; color:yellow;\" ><span style=\"align-items: center;\">" +
                            "<i>Here, Radius(r)</i> = " + num +
                            "<br><span style=color:white>Area = <div style=\"display: inline-block; vertical-align:middle; margin: 0 0.2em 0.4ex; text-align: center\">\n" +
                            "<span style=\"display:inline; padding-top: 0.15em; border-bottom: thin solid white;\">&#960;r<sup>2</sup></span>\n" +
                            "<span style=\"display:block\">2</span>\n" +
                            "</div> = <div style=\"display: inline-block; vertical-align:middle; margin: 0 0.2em 0.4ex; text-align: center\">\n" +
                            "<span style=\"display:inline; padding-top: 0.15em; border-bottom: thin solid white;\">&#960; x "+num+"<sup>2</sup></span>\n" +
                            "<span style=\"display:block\">2</span>\n" +
                            "</div><br><span style=color:yellow;>Area = " + results +
                            "<br><span style=color:white> Perimeter = &#960;r + 2r = &#960; x "+ num +" + 2 x "+num+
                            "<br><span style=color:yellow>Perimeter = " + per +
                            "</span></body>","text/html","charset=utf-8");
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SemiCircle semiCircle = new SemiCircle();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.plan_container,semiCircle).commit();
            }
        });

   return v;
    }
}
