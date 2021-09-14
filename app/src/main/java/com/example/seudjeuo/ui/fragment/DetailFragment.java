package com.example.seudjeuo.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seudjeuo.R;
import com.example.seudjeuo.databinding.FragmentDetailBinding;
import com.example.seudjeuo.model.TaskModel;


public class DetailFragment extends Fragment {
    private HomeViewModel viewmodel;
    private TaskModel model;
    private FragmentDetailBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        getData();
        initialize();
    }

    private void initialize() {
        viewmodel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
    }

    private void getData() {
        getParentFragmentManager().setFragmentResultListener("b", getViewLifecycleOwner(), (requestKey, result) -> {
            model = (TaskModel) result.getSerializable("a");
            binding.nya.setImageResource(model.getPhoto());
            binding.arigatou.setText(model.getTitle());
            Log.e("anime", "setItem: " + model.getPhoto());

        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }
}