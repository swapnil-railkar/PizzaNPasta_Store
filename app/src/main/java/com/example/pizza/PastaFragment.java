package com.example.pizza;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PastaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PastaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PastaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PastaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PastaFragment newInstance(String param1, String param2) {
        PastaFragment fragment = new PastaFragment();
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

    /*
    For more detailed comments refer PizzaFragment.java class
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         /*
        Recycler view object which inflates the View to return it when called.
         */
        RecyclerView pasta_recyclerView=
                (RecyclerView)inflater.inflate(R.layout.fragment_pasta,container,false);

        /*
        get names and images of all stores from Pasta.class class
         */
        String[] pasta_name=new String[Pasta.pastas.length];
        for (int i=0;i<pasta_name.length;i++)
        {
            pasta_name[i]=Pasta.pastas[i].getName();
        }

        int[] pasta_res=new int[Pasta.pastas.length];
        for (int i=0;i<pasta_res.length;i++)
        {
            pasta_res[i]=Pasta.pastas[i].getImageResourceId();
        }

        CaptionedImageAdapter captionedImageAdapter=new CaptionedImageAdapter(pasta_name,pasta_res);
        pasta_recyclerView.setAdapter(captionedImageAdapter);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),1);
        pasta_recyclerView.setLayoutManager(gridLayoutManager);

        captionedImageAdapter.setListener(new CaptionedImageAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent=new Intent(getActivity(),PastaDetail.class);
                intent.putExtra(PastaDetail.EXTRA_PASTA_ID,position);
                getActivity().startActivity(intent);
            }
        });
        return pasta_recyclerView;
    }
}