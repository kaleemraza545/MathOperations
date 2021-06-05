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
import androidx.fragment.app.FragmentTransaction;

import com.example.mathoperations.R;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class Hemisphere extends Fragment {
    Button computeBtn, clearBtn;
    WebView wv;
    EditText edit;

    public Hemisphere() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hemisphere, container, false);

        edit = v.findViewById(R.id.hemi_edit);
        wv = v.findViewById(R.id.hemi_wv);
        computeBtn = v.findViewById(R.id.hemi_computeBtn);
        clearBtn = v.findViewById(R.id.hemi_clearBtn);

        computeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().toString().isEmpty()){
                    edit.requestFocus();
                    edit.setError("Please Enter Valid Value");
                }else {
                    String temp = edit.getText().toString();
                    int num = 0;
                    num = Integer.parseInt(temp);
                    int a = num * num * num;
                    double area = 3 * Math.PI * num * num;
                    area = Double.parseDouble(new DecimalFormat("#.#####").format(area));
                    double l_area = 2 * Math.PI * num * num;
                    l_area = Double.parseDouble(new DecimalFormat("#.####").format(l_area));
                    double vol = (2.0 / 3) * Math.PI * a;
                    vol = Double.parseDouble(new DecimalFormat("#.####").format(vol));
                    wv.setBackgroundColor(Color.parseColor("#000000"));
                    wv.loadData("<body style=\"text-align: center; color:yellow;\"><i>Here, Radius(r) = " + num +
                            " <br><span style=color:white>Total Surface Area = 3<span>&#960;</span>r<sup>2</sup> = 3<span>&#960;</span> x " + num +"<sup>2</sup> </span>" +
                            "<br>Total Surface Area = " + area +
                            "<br><span style=color:white>Lateral Area = 2<span>&#960;</span>r<sup>2</sup> = 2<span>&#960;</span> x " + num +"<sup>2</sup> </span>"+
                            "<br>Lateral Area = " + l_area +
                            "<br><span style=color:white> Volume = <div style=\"display: inline-grid; color: white;vertical-align:middle; margin: 0 0.2em 0.4ex; text-align: center\">" +
                            "<span style=\"display:inline; padding-top: 0.15em; border-bottom: thin solid white;\">2</span>\n" +
                            "<span style=\"display:block\">3</span>" +
                            "</div><span>&#960;</span>r<sup>3</sup> = <div style=\"display: inline-grid; color: white; vertical-align:middle; margin: 0 0.2em 0.4ex; text-align: center\">" +
                            "<span style=\"display:inline; padding-top: 0.15em; border-bottom: thin solid white;\">2</span>" +
                            "<span style=\"display:block\">3</span>" +
                            "</div><span>&#960;</span> x " + num + "<sup>3</sup></span></span>" +
                            "<br> Volume = "+vol, "text/html", "charset=utf-8");


                }
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hemisphere hemisphere = new Hemisphere();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.solid_container,hemisphere).commit();
            }
        });

    return  v;
    }
}
