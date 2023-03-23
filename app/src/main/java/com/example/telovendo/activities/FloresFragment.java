package com.example.telovendo.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.telovendo.R;
import com.example.telovendo.adapters.FloresAdapter;
import com.example.telovendo.model.Flores;

import java.util.ArrayList;
import java.util.List;

public class FloresFragment extends Fragment implements FloresAdapter.FloresAdapterOnClickHandler {
    private RecyclerView recyclerView;
    private FloresAdapter adapter;
    private NavController navController;
    public FloresFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_flores, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        recyclerView = view.findViewById(R.id.flores);
        SetUpRecyclerView();
    }
    @Override
    public void onClick(Flores flores) {
        Fragment fragment = new Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("floresNombre", flores.getNombre());
        fragment.setArguments(bundle);

        navController.navigate(R.id.action_floresFragment_to_floresDetailFragment, bundle);
    }
    private void SetUpRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                new
                        LinearLayoutManager(getContext()).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapter = new FloresAdapter(getContext(),this,
                getListFlores());
        recyclerView.setAdapter(adapter);
    }
        private List<Flores> getListFlores() {
        List<Flores> listFlores = new ArrayList<Flores>();

        listFlores.add(new Flores("Dalia", R.drawable.dhalia));
        listFlores.add(new Flores("Ave del Paraíso", R.drawable.florave));
        listFlores.add(new Flores("Passiflora", R.drawable.passiflora));
        listFlores.add(new Flores("Orquidea", R.drawable.orch));
       return listFlores;
    }
}