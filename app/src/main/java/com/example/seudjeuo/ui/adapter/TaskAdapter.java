package com.example.seudjeuo.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seudjeuo.ItemClick;
import com.example.seudjeuo.databinding.TaskItemBinding;
import com.example.seudjeuo.model.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private TaskItemBinding binding;
    private ItemClick onClick;
    public List<TaskModel> list = new ArrayList<>();

    public void addList(List<TaskModel> getList) {
        this.list = getList;
        notifyDataSetChanged();
    }

    public void setOnClick(ItemClick onClick) { this.onClick = onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = TaskItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding.getRoot());
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }
    @Override
    public int getItemCount()
    { return list.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(v -> {
                onClick.onItemClick(getAdapterPosition());
            });
        }
        public void onBind(TaskModel taskModel) {
            binding.itemIm.setImageResource(taskModel.getPhoto());
            binding.itemName.setText(taskModel.getTitle());
        }
    }
}

