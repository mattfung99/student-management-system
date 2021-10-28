package com.app

class Classroom {
    String classId
    String teacher
    int classSize
    int roomNumber
    static hasMany = [student: Student]

    static constraints = {
        classId nullable: false, blank: false, unique: true
        teacher nullable: false, blank: false, size: 5..40
        classSize nullable: false, blank: false, min: 10, max: 30
        roomNumber nullable: false, blank: false, min: 1, max: 200, unique: true
    }

    String toString() {
        classId
    }
}
