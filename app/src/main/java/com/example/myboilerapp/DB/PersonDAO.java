package com.example.myboilerapp.DB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PersonDAO {
    @Query("SELECT * FROM person")
    List<Person> getAll();

    @Query("SELECT * FROM person WHERE uid IN (:userIds)")
    List<Person> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM person WHERE first_name LIKE :first"
            + " LIMIT 1")
    Person findByName(String first);

    @Insert
    void insertAll(Person... persons);

    @Delete
    void delete(Person person);

    @Query("DELETE FROM person")
    public void nukeTable();
}
