package com.example.android2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {
    private final MutableLiveData<String> selectedItem = new MutableLiveData<String>();

    public void SetData(String item){
        selectedItem.setValue(item);
    }

    public LiveData<String> getSelectedItem(){
        return selectedItem;
    }
}
