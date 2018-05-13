package com.example.myboilerapp.Recycler;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

public class RecyclerViewModel extends ViewModel {

    private static final String TAG = "RecyclerViewModel";

    private MutableLiveData<Boolean> refreshing = new MutableLiveData<>();
    private Application application;

    public RecyclerViewModel(@NonNull Application application) {
        this.application = application;
        refreshing.setValue(false);
    }

    public void load(){
        refreshing.setValue(true);
        refreshing.setValue(false);
    }

    public void onRefresh() {
        Log.i(TAG, "onRefresh: refreshing");
        refreshing.setValue(true);
    }

    public MutableLiveData<Boolean> getRefreshing() {
        return refreshing;
    }

    public void setRefreshing(MutableLiveData<Boolean> refreshing) {
        this.refreshing = refreshing;
    }

}
