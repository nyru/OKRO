package eswar.com.okro.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import eswar.com.okro.Adapters.BasketAdapter;
import eswar.com.okro.Model.BasketitemsModel;
import eswar.com.okro.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FruitsFragment extends Fragment {
    RecyclerView recyclerView;
    BasketAdapter basketAdapter;
    List<BasketitemsModel> basketitemsModels= new ArrayList<>();

    public FruitsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_fruits, container, false);
        recyclerView=v.findViewById(R.id.recycler_view_fruitsfrag);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        return v;    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        BasketitemsModel basketitemsModel = new BasketitemsModel(R.drawable.apple, "Apple", "200", "1kg", "1");
        basketitemsModels.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.pineapple, "PineApple", "200", "1kg", "1");
        basketitemsModels.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.litchi, "Litchi", "200", "1kg", "1");
        basketitemsModels .add(basketitemsModel);



        basketAdapter=new BasketAdapter(basketitemsModels);

        recyclerView.setAdapter(basketAdapter);
        basketAdapter.notifyDataSetChanged();
    }
}
