package com.example.recycleview

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

data class Student(
    @JsonProperty("id")
    var studentId: String?,
    @JsonProperty("gender")
    var gender: String?,
    @JsonProperty("birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    var birthDay: Date?,
    @JsonProperty("email")
    var email: String?,
    @JsonProperty("address")
    var address: String?,
    @JsonProperty("major")
    var majoir: String?,
    @JsonProperty("gpa")
    var gpa: Float = 0f,
    @JsonProperty("year")
    var year: Int = 1,

    ) {
    @JsonProperty("full_name")
    private fun unpackFullName(fullName:Map<String,Any>){
        this.fullName = FULL_NAME(
            fullName["first"].toString(),
            fullName["last"].toString(),
            fullName["midd"].toString()
        )
    }
    fun getFullName():String{
        return (fullName?.firstName +" "+ fullName?.middName+" "+fullName?.lastName)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (studentId != other.studentId) return false

        return true
    }

    override fun hashCode(): Int {
        return studentId?.hashCode() ?: 0
    }


    internal data
    class FULL_NAME(
        @JsonProperty("first")
        var firstName: String?,
        @JsonProperty("last")
        var lastName: String?,
        @JsonProperty("midd")
        var middName: String?

    )
    private var fullName:FULL_NAME ?= null;
}