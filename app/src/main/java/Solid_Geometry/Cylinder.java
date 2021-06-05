package Solid_Geometry;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mathoperations.R;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class Cylinder extends Fragment {
    EditText edit_r ;
    EditText edit_h;
    Button compute, clear;
    WebView webView;

    public Cylinder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cylinder, container, false);

        edit_r = v.findViewById(R.id.cyl_r_edit);
        edit_h = v.findViewById(R.id.cyl_h_edit);
        compute = v.findViewById(R.id.cyl_computeBtn);
        clear = v.findViewById(R.id.cyl_clearBtn);
        webView = v.findViewById(R.id.cyl_wv);

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit_r.getText().toString().isEmpty()){
                    edit_r.requestFocus();
                    edit_r.setError("Please Enter Valid Value");
                } else if (edit_h.getText().toString().isEmpty()) {
                    edit_h.requestFocus();
                    edit_h.setError("Please Enter Valid Value");
                }else {
                    String temp_l = edit_r.getText().toString();
                    String temp_w = edit_h.getText().toString();
                    int r = Integer.parseInt(temp_l);
                    int h = Integer.parseInt(temp_w);
                    int sqr = r * r;

                    double area = (2*Math.PI * r * h) + (2 * Math.PI *sqr);
                    area = Double.parseDouble(new DecimalFormat("#.####").format(area));
                    double l_area = 2 * Math.PI * r * h ;
                    l_area = Double.parseDouble(new DecimalFormat("#.####").format(l_area));
                    double vol = Math.PI * (r*r) * h ;
                    vol = Double.parseDouble(new DecimalFormat("#.####").format(vol));

                    webView.setBackgroundColor(Color.parseColor("#000000"));
                    webView.loadData("<p align = center style=\"color:yellow;\"><i>Here, Radius(r) = " + r +
                            ", Height(h) = " + h +
                            "<br><span align = center style=color:white>Total Surface Area = 2&#960;rh + 2&#960;r<sup>2</sup></span>" +
                            "<br><span align = center style=color:white>Total Surface Area = 2&#960; x "+r+" x "+h+" + 2&#960; x "+r+"<sup>2</sup>" +
                            "<br><span align = center style=color:yellow>Total Surface Area = "+area+
                            "<br><span align = center style=color:white>Lateral Area = 2&#960;rh = 2&#960; x "+r+" x "+h+"</span>" +
                            "<br><span align = center style=color:yellow>Lateral Area = "+l_area+
                            "<br><span align = center style=color:white>Volume = &#960;r<sup>2</sup>h = &#960; x "+r+"<sup>2</sup> x "+h+
                            "<br><span align = center style=color:yellow>Volume = "+vol,"text/html","charset=utf-8");

                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cylinder cylinder = new Cylinder();
                FragmentManager ft = getFragmentManager();
                ft.beginTransaction().replace(R.id.plan_container,cylinder).commit();
            }
        });

    return  v;
    }
}
