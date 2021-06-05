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
public class Rhombus extends Fragment {
    EditText edit_1,edit_2;
    Button compute, clear;
    WebView webView;

    public Rhombus() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rhombus, container, false);
        edit_1 = v.findViewById(R.id.rhom_1_edit);
        edit_2 = v.findViewById(R.id.rhom_2_edit);
        compute = v.findViewById(R.id.rhom_computeBtn);
        clear = v.findViewById(R.id.rhom_clearBtn);
        webView = v.findViewById(R.id.rhom_wv);

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_1.getText().toString().isEmpty()) {
                    edit_1.requestFocus();
                    edit_1.setError("Please Enter Valid Value");
                } else if (edit_2.getText().toString().isEmpty()) {
                    edit_2.requestFocus();
                    edit_2.setError("Please Enter Valid Value");
                }else {
                    String temp1 = edit_1.getText().toString();
                    int num1 = Integer.parseInt(temp1);
                    String temp2 = edit_2.getText().toString();
                    int num2 = Integer.parseInt(temp2);

                    int area = num1 * num2;
                    float areas = area/2;

                    double d1 = (num1/2 * num1/2);
                    double d2 = (num2/2 * num2/2);
                    double d3 = d1 + d2;
                    double side = Math.sqrt(d3);
                    side = Double.parseDouble(new DecimalFormat("#.####").format(side));

                    double per = 4 * side;
                    per = Double.parseDouble(new DecimalFormat("#.####").format(per));

                    webView.setBackgroundColor(Color.parseColor("#000000"));
                    webView.loadData("<body style=\"text-align: center; color:white\"><span style=\"align-items:center;\"><i>Here, d1 = "+num1+", d2 = "+num2+
                            "<br>Area = <div style=\"display: inline-block; vertical-align:middle; margin: 0 0.2em 0.4ex; text-align: center\">" +
                            "<span style=\"display:inline; padding-top: 0.15em; border-bottom: thin solid black;\">d1 x d2</span>" +
                            "<span style=\"display:block\">2</span></div>" + //
                            "<br> Area = <div style=\"display: inline-block; vertical-align:middle; margin: 0 0.2em 0.4ex; text-align: center\">" +
                            "<span style=\"display:inline; padding-top: 0.15em; border-bottom: thin solid black;\">"+num1+" x "+num2+"</span>" +
                            "<span style=\"display:block\">2</span></div> = "+ areas+  //
                            "<br>Side(a) = <span style=\"position: relative; font-size: 40px; vertical-align: middle;\">&#8730;</span>" +
                            "<span style=\"padding: 1em 0.25em; border-top: thin black solid;\">" +
                            "<span style=\"align-items:center; font-size: 40px; text-align:center; padding-top: 10px; \">(</span>" +
                            "<div style=\"display: inline-block; vertical-align:middle; margin: 0 0.2em 0.4ex; text-align: center\">" +
                            "<span style=\"display:inline; padding-top: 0.15em; border-bottom: thin solid black;\">d1</span>" +
                            "<span style=\"display:block\">2</span>" +
                            "</div><span style=\"align-items:center; font-size: 40px; text-align:center; padding-top: 10px; \">)" +
                            "<sup style=\" font-size: 18px\">2</sup></span> + " +
                            "<span style=\"align-items:center; font-size: 40px; text-align:center;\">(</span>" +
                            "<div style=\"display: inline-block; vertical-align:middle; margin: 0 0.2em 0.4ex; text-align: center\">" +
                            "<span style=\"display:inline; padding-top: 0.15em; border-bottom: thin solid black;\">d2</span>" +
                            "<span style=\"display:block\">2</span>" +
                            "</div><span style=\"align-items:center; font-size: 40px; text-align:center; \">)" +
                            "<sup style=\" font-size: 18px\">2</sup></span></span></span><br>" + //
                                    "<br>Side(a) = <span style=\"position: relative; font-size: 40px; vertical-align: middle;\">&#8730;</span>" +
                                    "<span style=\"padding: 1em 0.25em; border-top: thin black solid;\">" +
                                    "<span style=\"align-items:center; font-size: 40px; text-align:center; padding-top: 10px; \">(</span>" +
                                    "<div style=\"display: inline-block; vertical-align:middle; margin: 0 0.2em 0.4ex; text-align: center\">" +
                                    "<span style=\"display:inline; padding-top: 0.15em; border-bottom: thin solid black;\">"+num1+"</span>" +
                                    "<span style=\"display:block\">2</span>" +
                                    "</div><span style=\"align-items:center; font-size: 40px; text-align:center; padding-top: 10px; \">)" +
                                    "<sup style=\" font-size: 18px\">2</sup></span> + " +
                                    "<span style=\"align-items:center; font-size: 40px; text-align:center;\">(</span>" +
                                    "<div style=\"display: inline-block; vertical-align:middle; margin: 0 0.2em 0.4ex; text-align: center\">" +
                                    "<span style=\"display:inline; padding-top: 0.15em; border-bottom: thin solid black;\">"+num2+"</span>" +
                                    "<span style=\"display:block\">2</span>" +
                                    "</div><span style=\"align-items:center; font-size: 40px; text-align:center; \">)" +
                                    "<sup style=\" font-size: 18px\">2</sup></span></span></span><br>"+
                            "Side(a) = "+side +
                            "<br> Perimeter = 4a = 4 x "+side+
                            "<br> Perimeter = "+per+

                            "</i></span></body>","text/html","charset=utf-8");

                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rhombus rhombus = new Rhombus();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.plan_container,rhombus).commit();
            }
        });


    return v;
    }
}
