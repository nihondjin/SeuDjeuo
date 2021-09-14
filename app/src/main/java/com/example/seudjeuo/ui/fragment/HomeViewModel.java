package com.example.seudjeuo.ui.fragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.seudjeuo.R;
import com.example.seudjeuo.model.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {
    public MutableLiveData<List<TaskModel>> data = new MutableLiveData<>();
    List<TaskModel> list = new ArrayList<>();
    public void geUser() {

        list.add(new TaskModel(R.drawable.alan,"Alan Wake"));
        list.add(new TaskModel(R.drawable.outbr,"Outbreak"));
        list.add(new TaskModel(R.drawable.harry,"HarryPotter"));
        list.add(new TaskModel(R.drawable.nich,"Minna no nichongo"));
        list.add(new TaskModel(R.drawable.re,"Doutsu mo Remupure"));
        data.setValue(list);
    }
}




