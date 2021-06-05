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

import Solid_Geometry.Cube;
import Solid_Geometry.Cuboid;
import Solid_Geometry.Cylinder;
import Solid_Geometry.Hemisphere;
import Solid_Geometry.Pyramid;
import Solid_Geometry.Sphere;


/**
 * A simple {@link Fragment} subclass.
 */
public class SolidGeometry extends Fragment {
    Button cubeBtn, sphereBtn, cylinderBtn, pyramidBtn, hemisphereBtn,cuboidBtn;

    public SolidGeometry() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_solid_geometry, container, false);

        cubeBtn = v.findViewById(R.id.cubeBtn);
        sphereBtn = v.findViewById(R.id.sphereBtn);
        cylinderBtn = v.findViewById(R.id.cylinderBtn);
        pyramidBtn = v.findViewById(R.id.pyramidBtn);
        hemisphereBtn = v.findViewById(R.id.hemisphereBtn);
        cuboidBtn = v.findViewById(R.id.cuboidBtn);

        ((MainActivity)this.getActivity()).getSupportActionBar().setTitle("Solid Geometry");

        cubeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cube cube = new Cube();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.solid_container,cube).addToBackStack(null).commit();
            }
        });
        sphereBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sphere sphere = new Sphere();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.solid_container,sphere).addToBackStack(null).commit();
            }
        });
        cylinderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cylinder cylinder = new Cylinder();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.solid_container,cylinder).addToBackStack(null).commit();
            }
        });
        pyramidBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pyramid pyramid = new Pyramid();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.solid_container,pyramid).addToBackStack(null).commit();
            }
        });
        hemisphereBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hemisphere hemisphere = new Hemisphere();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.solid_container,hemisphere).addToBackStack(null).commit();
            }
        });
        cuboidBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cuboid cuboid = new Cuboid();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.solid_container,cuboid).addToBackStack(null).commit();
            }
        });

    return  v;
    }
}
