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

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class Circle extends Fragment {
    Button computeBtn, clearBtn;
    WebView wv;
    EditText edit;

    public Circle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_circle, container, false);
        edit = v.findViewById(R.id.cir_edit);
        wv = v.findViewById(R.id.cir_wv);
        computeBtn = v.findViewById(R.id.cir_computeBtn);
        clearBtn = v.findViewById(R.id.cir_clearBtn);


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
                     double result = Math.PI * num * num;
                     result = Double.parseDouble(new DecimalFormat("#.#####").format(result)   );
                     double pre = 2 * Math.PI * num;
                    pre = Double.parseDouble(new DecimalFormat("#.####").format(pre));
                   wv.setBackgroundColor(Color.parseColor("#000000"));
                   wv.loadData("<body style=\"text-align: center; color:white;\"><i>Here, Radius(r) = " + num +
                           "<br><span style=color:white> Area = &#960;r<sup>2</sup> = &#960; x " + num + "<sup>2</sup>" +
                           "<br><span style=color:yellow> Area = "+result+"<sup>2</sup>"+
                           "<br> Perimeter = 2&#960;r = 2 x &#960; x "+num+"</span>" +
                           "<br> Perimeter = "+pre+"</body?>","text/html","charset=utf-8");

                }
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Circle circle = new Circle();
                FragmentManager ft = getFragmentManager();
                ft.beginTransaction().replace(R.id.plan_container,circle).commit();
            }
        });


    return v;
    }
}