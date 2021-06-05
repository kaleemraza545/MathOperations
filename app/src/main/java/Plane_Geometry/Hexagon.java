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
public class Hexagon extends Fragment {
    EditText edit;
    Button compute, clear;
    WebView webView;

    public Hexagon() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hexagon, container, false);
        edit = v.findViewById(R.id.hex_edit);
        compute = v.findViewById(R.id.hex_computeBtn);
        clear = v.findViewById(R.id.hex_clearBtn);
        webView = v.findViewById(R.id.hex_wv);

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit.getText().toString().isEmpty()) {

                    edit.requestFocus();
                    edit.setError("Please Enter Valid Value");
                }else {
                    String temp = edit.getText().toString();
                    int num = Integer.parseInt(temp);
                    double a1 =  6 *num * num;
                    double t = 4 * Math.tan(Math.PI/6);
                    double area = a1/t;
                    area = Double.parseDouble(new DecimalFormat("#.####").format(area));
                    double per = 6 * num;
                    per = Double.parseDouble(new  DecimalFormat("#.####").format(per));

                    webView.setBackgroundColor(Color.parseColor("#000000"));
                    webView.loadData("<body style=\"text-align: center; color:white\"><span style=\"align-items: center;\"><i>Here, Side(a) = "+num+
                            "<br> Area = <div style=\"display: inline-grid; vertical-align:middle; margin: 0 0.2em 0.4ex; text-align: center\">" +
                            "<span style=\"display:inline; padding-top: 0.15em;\">6a<sup>2</sup></span>" +
                            "<span style=\"display:block; border-top: thin solid black;\">4 x tan " +
                            "<span style=\"align-items:center; font-size: 30px; text-align:center;\">(</span>" +
                            "<div style=\"display: inline-block; vertical-align:middle; margin: 0 0.2em 0.4ex; text-align: center\">" +
                            "<span style=\"display:inline; padding-top: 0.15em; border-bottom: thin solid black;\">&#960;</span>" +
                            "<span style=\"display:block\">6</span>" +
                            "</div><span style=\"align-items:center; font-size: 30px; text-align:center; \">)</span></span>" +
                            "<br> Area = <div style=\"display: inline-grid; vertical-align:middle; margin: 0 0.2em 0.4ex; text-align: center\">" +
                            "<span style=\"display:inline; padding-top: 0.15em border-bottom: thin solid black;\">6 x "+num+"<sup>2</sup></span>" +
                            "<span style=\"display:block; border-top: thin solid black;\">4 x tan " +
                            "<span style=\"align-items:center; font-size: 30px; text-align:center;\">(</span>" +
                            "<div style=\"display: inline-block; vertical-align:middle; margin: 0 0.2em 0.4ex; text-align: center\">" +
                            "<span style=\"display:inline; padding-top: 0.15em; border-bottom: thin solid black;\">&#960;</span>" +
                            "<span style=\"display:block\">6</span>" +
                            "</div><span style=\"align-items:center; font-size: 30px; text-align:center; \">)</span></span>" +
                            "<br> Area = "+ area+" <br> Perimeter = 6a = 6 x "+per+"</span>","text/html","charset=utf-8");
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hexagon hexagon = new Hexagon();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.plan_container,hexagon).commit();
            }
        });


    return v;
    }
}
