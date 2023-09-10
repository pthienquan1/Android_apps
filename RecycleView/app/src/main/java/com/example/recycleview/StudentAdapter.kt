package com.example.recycleview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class StudentAdapter(private val context: Context, private val studentList: MutableList<Student>):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        var imgAva: ImageView
        var txtId: TextView
        var txtFullName: TextView
        var txtGpa: TextView

        init{
            imgAva = itemView.findViewById(R.id.img_ava)
            txtId = itemView.findViewById(R.id.txt_sdtudentId)
            txtFullName = itemView.findViewById(R.id.txt_fullName)
            txtGpa = itemView.findViewById(R.id.txt_gpa)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val adapterLayout = LayoutInflater.from(context).inflate(R.layout.item_student,parent,false)
        return StudentViewHolder(adapterLayout);
    }

    override fun getItemCount(): Int {
       return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.txtId.text = student.studentId
        holder.txtFullName.text = student.getFullName()
        holder.txtGpa.text = student.gpa.toString()
        holder.imgAva.setImageDrawable(
            Utils.getDrawable(context,student.gender)
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setStudents(students: List<Student>?) {
        this.studentList.clear();
        this.studentList.addAll(students!!)
        notifyDataSetChanged()
    }


}