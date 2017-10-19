package com.example.user.matapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Belal on 18/09/16.
 */


public class Fragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        initViews(view);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Menu 2");
//        Toolbar toolbar = (Toolbar) view.findViewById(R.id.my_toolbar);
//        getActivity().setActionBar(toolbar);
    }



    private ArrayList countries;
    private ArrayList gambar;

    private void initViews(View v){
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.frag2_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        countries = new ArrayList<>();
        countries.add("Email");
        countries.add("Phone number");
        countries.add("Password");
        countries.add("Facebook");
        countries.add("Line");


        gambar = new ArrayList<>();
        gambar.add("sjupiyandi@gmail.com");
        gambar.add("081233212423");
        gambar.add("********");
        gambar.add("Sisco Jupiyandi");
        gambar.add("sjupiyandi");

        RecyclerView.Adapter adapter = new AdapterAkun(countries, gambar);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getActivity().getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if(child != null && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(child);
                    mulaiSubMenu(position);

                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }




    public void mulaiSubMenu(int position){
        Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(getActivity().getApplicationContext(), ProfileAsli.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(getActivity().getApplicationContext(), LeaderboardAsli.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(getActivity().getApplicationContext(), tesKetajaman.class);
                startActivity(intent);
                break;
            case 3 :
                Toast.makeText(getActivity().getApplicationContext(), (CharSequence) countries.get(position), Toast.LENGTH_SHORT).show();
                break;
            case 4 :
                Toast.makeText(getActivity().getApplicationContext(), (CharSequence) countries.get(position), Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(getActivity().getApplicationContext(), (CharSequence) countries.get(position), Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(getActivity().getApplicationContext(), (CharSequence) countries.get(position), Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getActivity().getApplicationContext(), (CharSequence) countries.get(position), Toast.LENGTH_SHORT).show();
                break;
        }



    }

}