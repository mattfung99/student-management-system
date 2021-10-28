package com.app

class Student {

    String studName
    int studAge
    String studID
    int studCreditCount
    String studHomeroom
    String studImageUrl

    static constraints = {
        studName nullable: false, blank: false
        studAge nullable: false, blank: false
        studID nullable: false, blank: false
        studCreditCount nullable: false, blank: false
        studHomeroom nullable: false, blank: false
        studImageUrl nullable: true
    }
}
