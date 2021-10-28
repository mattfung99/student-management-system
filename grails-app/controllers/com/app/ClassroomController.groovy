package com.app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class ClassroomController {

    ClassroomService classroomService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond classroomService.list(params), model:[classroomCount: classroomService.count()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def show(Long id) {
        respond classroomService.get(id)
    }

    @Secured('ROLE_ADMIN')
    def create() {
        respond new Classroom(params)
    }

    @Secured('ROLE_ADMIN')
    def save(Classroom classroom) {
        if (classroom == null) {
            notFound()
            return
        }

        try {
            classroomService.save(classroom)
        } catch (ValidationException e) {
            respond classroom.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'classroom.label', default: 'Classroom'), classroom.id])
                redirect classroom
            }
            '*' { respond classroom, [status: CREATED] }
        }
    }

    @Secured('ROLE_ADMIN')
    def edit(Long id) {
        respond classroomService.get(id)
    }

    @Secured('ROLE_ADMIN')
    def update(Classroom classroom) {
        if (classroom == null) {
            notFound()
            return
        }

        try {
            classroomService.save(classroom)
        } catch (ValidationException e) {
            respond classroom.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'classroom.label', default: 'Classroom'), classroom.id])
                redirect classroom
            }
            '*'{ respond classroom, [status: OK] }
        }
    }

    @Secured('ROLE_ADMIN')
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        classroomService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'classroom.label', default: 'Classroom'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'classroom.label', default: 'Classroom'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
