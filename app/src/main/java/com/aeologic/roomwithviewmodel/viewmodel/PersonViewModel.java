package com.aeologic.roomwithviewmodel.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.aeologic.roomwithviewmodel.database.AppDatabase;
import com.aeologic.roomwithviewmodel.model.Person;

import java.util.List;

public class PersonViewModel extends AndroidViewModel {
    private AppDatabase appDatabase;
    private LiveData<List<Person>> personListLiveData;

    public PersonViewModel(@NonNull Application application) {
        super(application);
        appDatabase = AppDatabase.getInstance(application);
        personListLiveData = appDatabase.personDao().loadAllPersons();
    }
    public LiveData<List<Person>> getPersonListLiveData() {
        return personListLiveData;
    }
}
