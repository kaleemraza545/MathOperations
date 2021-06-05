package Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mathoperations.MainActivity;
import com.example.mathoperations.R;

import Plane_Geometry.Circle;
import Plane_Geometry.Hexagon;
import Plane_Geometry.Rectangle;
import Plane_Geometry.Rhombus;
import Plane_Geometry.SemiCircle;
import Plane_Geometry.Square;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlaneGeometry extends Fragment {
    Button squareBtn, circleBtn, rectangleBtn,semicircleBtn,rhombusBtn,hexagonBtn;

    public PlaneGeometry() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_plane_geometry, container, false);
        squareBtn = v.findViewById(R.id.squareBtn);
        circleBtn = v.findViewById(R.id.circleBtn);
        rectangleBtn = v.findViewById(R.id.rectangleBtn);
        semicircleBtn = v.findViewById(R.id.semicircleBtn);
        rhombusBtn = v.findViewById(R.id.rhombusBtn);
        hexagonBtn = v.findViewById(R.id.hexagonBtn);

        ((MainActivity)this.getActivity()).getSupportActionBar().setTitle("Plane Geometry");

        squareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Square square = new Square();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.plan_container,square).addToBackStack(null).commit();
            }
        });
        circleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Square square = new Square();
                Circle circle = new Circle();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.plan_container,circle).addToBackStack(null).commit();
            }
        });
        rectangleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rectangle rectangle = new Rectangle();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.plan_container,rectangle).addToBackStack(null).commit();
            }
        });
        semicircleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SemiCircle semiCircle = new SemiCircle();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.plan_container,semiCircle).addToBackStack(null).commit();
            }
        });
        rhombusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rhombus rhombus = new Rhombus();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.plan_container,rhombus).addToBackStack(null).commit();
            }
        });
        hexagonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hexagon hexagon = new Hexagon();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.plan_container,hexagon).addToBackStack(null).commit();
            }
        });



   return  v;
    }



}
