package com.example.seudjeuo.ui.fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.seudjeuo.ItemClick;
import com.example.seudjeuo.R;
import com.example.seudjeuo.databinding.FragmentHomeBinding;
import com.example.seudjeuo.model.TaskModel;
import com.example.seudjeuo.ui.adapter.TaskAdapter;
import java.util.List;

public class HomeFragment extends Fragment implements ItemClick {

    private HomeViewModel viewModel;
    private FragmentHomeBinding binding;
    private ItemClick itemClick;
    private TaskAdapter adapter = new TaskAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setupRecyclerView();
        setupListener();
        setItem(itemClick);
      //  passDataToDetail();
    }

    private void setItem(ItemClick itemClick) {
        adapter.setOnClick(position -> {
            Bundle bundle = new Bundle();
            TaskModel taskModel = new TaskModel(adapter.list.get(position).getPhoto(),adapter.list.get(position).getTitle());
            bundle.putSerializable("a", taskModel);
            getParentFragmentManager().setFragmentResult("b", bundle);
            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
            navController.navigate(R.id.action_homeFragment_to_detailFragment);
        });
    }

    private void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
    }
    private void setupRecyclerView() {
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rv.setAdapter(adapter);
    }
    private void setupListener() {
        binding.buttonAdd.setOnClickListener(v -> {
            binding.buttonAdd.setVisibility(View.GONE);
            viewModel.geUser();
        });
        viewModel.data.observe(getViewLifecycleOwner(), new Observer<List<TaskModel>>() {
            @Override
            public void onChanged(List<TaskModel> taskModels) {
                binding.buttonAdd.setVisibility(View.GONE);
                adapter.addList(taskModels);
            }
        });
    }

    @Override
    public void onItemClick(int position) {

    }
}