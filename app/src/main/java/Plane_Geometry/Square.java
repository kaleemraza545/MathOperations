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
import androidx.fragment.app.FragmentManager;

import com.example.mathoperations.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Square extends Fragment {
    Button computeBtn, clearBtn;
    WebView wv;
    EditText edit;
    //String data1 = getString(R.string.kousar);

    public Square() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_square, container, false);
        edit = v.findViewById(R.id.s_edit);
        computeBtn = v.findViewById(R.id.sq_computeBtn);
        clearBtn = v.findViewById(R.id.sq_clearBtn);
        wv = v.findViewById(R.id.sq_wv);


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
                    final int result = num * num;
                    wv.setBackgroundColor(Color.parseColor("#000000"));

                    wv.loadData("<p align = center style=" + "color:yellow;" + "><i>Here, Side(a) = " + num +
                            " <br><span style=color:white> Area = a<sup>2</sup> = " + num + "<sup>2</sup> = " + result +"</span>"+
                            "<br> Perimeter = 4a = 2 x " + num + " = " + 4*num + "</i></p>", "text/html", " charset=utf-8");

                }
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Square square = new Square();
                FragmentManager ft = getFragmentManager();
                ft.beginTransaction().replace(R.id.plan_container,square).commit();
            }
        });


    return  v;
    }
}
