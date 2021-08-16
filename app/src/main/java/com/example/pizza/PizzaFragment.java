package com.example.pizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PizzaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PizzaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PizzaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PizzaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PizzaFragment newInstance(String param1, String param2) {
        PizzaFragment fragment = new PizzaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pizza_recyclerView = (RecyclerView)
                inflater.inflate(R.layout.fragment_pizza, container, false);
        String[] pizzaName = new String[Pizza.pizza.length];
        for (int i = 0; i < pizzaName.length; i++) {
            pizzaName[i] = Pizza.pizza[i].getName();
        }

        int[] pizzaImages = new int[Pizza.pizza.length];
        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = Pizza.pizza[i].getImageResourceId();
        }

        CaptionedImageAdapter captionedImageAdapter = new CaptionedImageAdapter(pizzaName, pizzaImages);
        pizza_recyclerView.setAdapter(captionedImageAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        pizza_recyclerView.setLayoutManager(gridLayoutManager);

        captionedImageAdapter.setListener(new CaptionedImageAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent=new Intent(getActivity(),PizzaDetail.class);
                intent.putExtra(PizzaDetail.EXTRA_PIZZA_ID, position);
                getActivity().startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        return pizza_recyclerView;
    }
}