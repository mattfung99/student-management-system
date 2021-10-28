package com.app

class Student {

    static belongsTo = [classroom: Classroom]
    String studName
    int studAge
    String studID
    int studGrade

    static constraints = {
        studName nullable: false, blank: false, size: 5..40
        studAge nullable: false, blank: false, min: 5, max: 13
        studID nullable: false, blank: false, unique: true
        studGrade nullable: false, blank: false, min: 1, max: 7
    }

    String toString() {
        studName
    }
}
