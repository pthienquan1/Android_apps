package com.example.recycleview

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StudentViewModel() :ViewModel() {
    private val liveData:MutableLiveData<List<Student>> = MutableLiveData()

    val students: LiveData<List<Student>>
        get() = liveData

    fun loadData(context: Context?){
        val parse = JsonParse()
        val jsonString = parse.getJsonFromFile(context!!)
        val studentsList = parse.getStudents(jsonString)
        if(studentsList != null){
            liveData.value = studentsList
        }
    }
    companion object{
        var instance:StudentViewModel? = null
            get(){
                if(field == null){
                    field=StudentViewModel()
                }
                return field
            }

    }
}