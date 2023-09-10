package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewStudent: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewStudent = findViewById(R.id.rcv_student)

        val adapter = StudentAdapter(baseContext, ArrayList())
        val model = StudentViewModel.instance
        model?.students?.observe(this){
            students:List<Student>? ->adapter.setStudents(students)
        }
        model?.loadData(this)
        recyclerViewStudent.adapter = adapter
        recyclerViewStudent.layoutManager = LinearLayoutManager(this)
        recyclerViewStudent.setHasFixedSize(true)

    }


}