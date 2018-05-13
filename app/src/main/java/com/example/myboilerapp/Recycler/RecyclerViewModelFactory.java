package com.example.myboilerapp.Recycler;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

public class RecyclerViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private Application mApplication;

    public RecyclerViewModelFactory(Application application) {
        mApplication = application;
    }
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new RecyclerViewModel(mApplication);
    }
}