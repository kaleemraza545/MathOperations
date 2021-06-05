package com.example.mathoperations;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mathoperations.Adapter.CustomExpandableAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import Fragments.PlaneGeometry;
import Fragments.SolidGeometry;
import Matrix.Matrix_Addition;
import Matrix.Matrix_Multiplication;
import Matrix.Matrix_Subtraction;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private String[] items;

    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;
    private List<String> ListTitle;
    private HashMap<String, List<String>> listChild;
    private Fragment addFragment;
    private Button squareBtn;

    FragmentManager ft = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        squareBtn = findViewById(R.id.squareBtn);

        mDrawerlayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();
        expandableListView = (ExpandableListView)findViewById(R.id.navlist);

        initItems();
        View listHeaderView = getLayoutInflater().inflate(R.layout.nav_header,null,false);
        expandableListView.addHeaderView(listHeaderView);

        genData();

        addDrawersItems();
        setupDrawer();

        if(savedInstanceState == null)
            selectFirstItemAsDefault();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("KrK");


        if(savedInstanceState == null) {
            getSupportFragmentManager().
                    beginTransaction().replace(R.id.container,new PlaneGeometry()).commit();
        }

    }
    PlaneGeometry planeGeometry = new PlaneGeometry();
    SolidGeometry solidGeometry = new SolidGeometry();
    Matrix_Addition matrix_addition = new Matrix_Addition();
    Matrix_Subtraction matrix_subtraction = new Matrix_Subtraction();
    Matrix_Multiplication matrix_multiplication = new Matrix_Multiplication();

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void selectFirstItemAsDefault() {
            String firstItem = (String) ListTitle.get(0);
            getSupportActionBar().setTitle(firstItem);

    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerlayout,R.string.open,R.string.close)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("KRKGroup");
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu();
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerlayout.setDrawerListener(mDrawerToggle);
    }

    private void addDrawersItems() {
        adapter = new CustomExpandableAdapter(this,ListTitle,listChild);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                getSupportActionBar().setTitle(ListTitle.get(groupPosition).toString());
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                getSupportActionBar().setTitle(ListTitle.get(groupPosition).toString());
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                String SelectedItem = ((List)(listChild.get(ListTitle.get(groupPosition))))
                        .get(childPosition).toString();
                getSupportActionBar().setTitle(listChild.get(ListTitle.get(groupPosition)).get(childPosition));

                if(items[0].equals(ListTitle.get(groupPosition))) {
                    if (listChild.get(ListTitle.get(groupPosition)).get(childPosition).equals("Plane Geometry")) {
                        getSupportActionBar().setTitle("Plane Geometry");
                        ft.beginTransaction().replace(R.id.container,planeGeometry).commit();

                    } else if (listChild.get(ListTitle.get(groupPosition)).get(childPosition).equals("Solid Geometry")) {
                        getSupportActionBar().setTitle("Solid Geometry");
                        ft.beginTransaction().replace(R.id.container,solidGeometry).commit();

                    }

                }else if (items[2].equals(ListTitle.get(groupPosition))){
                    if (listChild.get(ListTitle.get(groupPosition)).get(childPosition).equals("Matrix Addition")){
                        ft.beginTransaction().replace(R.id.container,matrix_addition).commit();
                    }else if(listChild.get(ListTitle.get(groupPosition)).get(childPosition).equals("Matrix Subtraction")){
                        ft.beginTransaction().replace(R.id.container,matrix_subtraction).commit();
                    }else if(listChild.get(ListTitle.get(groupPosition)).get(childPosition).equals("Matrix Multiplication")){
                        ft.beginTransaction().replace(R.id.container,matrix_multiplication).commit();
                    }
                }
                else if (items[1].equals(ListTitle.get(groupPosition))){}

                else
                    throw new IllegalArgumentException("Not Support Fragment");

                mDrawerlayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void genData() {
        List<String> title = Arrays.asList("Geometry","Algebra Operations","Matrix Operations");
        List<String> Matrix_items = Arrays.asList("Matrix Addition","Matrix Subtraction","Matrix Multiplication");
        List<String> Algebra_items = Arrays.asList("Algebra Addition","Algebra Subtraction","Algebra Product");
        List<String> Geometry_items = Arrays.asList("Plane Geometry","Solid Geometry");

        listChild = new HashMap<>();
        listChild.put(title.get(0),Geometry_items);
        listChild.put(title.get(1),Algebra_items);
        listChild.put(title.get(2),Matrix_items);

        ListTitle = new ArrayList<>(listChild.keySet());

    }

    @SuppressLint("ResourceType")
    private void initItems() {

        items = new String[]{"Geometry","Algebra Operations","Matrix Operations"};

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(mDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Do You Want To Exit ?");
            builder.setCancelable(true);
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

    }
}
