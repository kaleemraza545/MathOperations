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
public class Cube extends Fragment {
    Button computeBtn, clearBtn;
    WebView wv;
    EditText edit;

    public Cube() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cube, container, false);

        edit = v.findViewById(R.id.cube_edit);
        computeBtn = v.findViewById(R.id.cube_computeBtn);
        clearBtn = v.findViewById(R.id.cube_clearBtn);
        wv = v.findViewById(R.id.cube_wv);

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
                    final int surface = 6 * num * num;
                    final int l_area = 4 * num * num;
                    final  int vol = num * num * num;
                    double d_length = Math.sqrt(3) * num;
                    d_length = Double.parseDouble(new DecimalFormat("#.####").format(d_length));

                    wv.setBackgroundColor(Color.parseColor("#000000"));

                    wv.loadData("<body><p align = center style=" + "color:white;" + "><i>Here, Side(s) = " + num +
                            " <br>Total Surface Area = 6s<sup>2</sup> = 6 x " + num + "<sup>2</sup>" +
                            "<br>Total Surface Area = "+surface+
                            "<br>Lateral Area = 4s<sup>2</sup> = 4 x "+num+"<sup>2</sup>" +
                            "<br>Leteral Area = "+ l_area+
                            "<br> Volume = s<sup>3</sup> = "+num+"<sup>3</sup>" +
                            "<br> Volume = "+vol+"" +
                            "<br> Diagonal Length = <span style=\"position: relative; vertical-align: middle;\">&#8730;</span>" +
                            "<span style=\" border-top: thin black solid;\">3</span></span> x side(s)" +
                            "<br>Diagonal Length = <span style=\"position: relative; font-size: 20px; vertical-align: middle;\">&#8730;</span>" +
                            "<span style=\" border-top: thin solid black;\">3</span></span> x " + num +" = "+d_length+
                            "</i></p></body>", "text/html", " charset=utf-8");

                }
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cube cube = new Cube();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.solid_container,cube).commit();
            }
        });
    return  v;
    }
}
