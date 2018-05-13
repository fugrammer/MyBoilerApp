package com.example.myboilerapp.DB;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class ExampleDB {
    Application application;
    private AppDatabase mDb;

    public ExampleDB(Application application) {
        this.application = application;
        mDb = AppDatabase.getPersistentDatabase(application);
    }

    public void getNames(){
        Thread t = new Thread(new Runnable() {
            public void run() {
                List<Person> persons = mDb.personDAO().getAll();
                ArrayList<String> names = new ArrayList<>();
                for (Person person:persons){
                    names.add(person.getFirstname());
                }
            }
        });
        t.start();
    }

    public void addName(final String name){
        Thread t = new Thread(new Runnable() {
            public void run() {
                Person person = new Person(name);
                mDb.personDAO().insertAll(person);
            }
        });
        t.start();
    }

    public void reset(){
        Thread t = new Thread(new Runnable() {
            public void run() {
                mDb.personDAO().nukeTable();
            }
        });
        t.start();
    }
}
