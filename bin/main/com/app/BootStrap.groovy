package com.app

import com.app.User
import com.app.Role
import com.app.UserRole

class BootStrap {

    def init = { servletContext ->
        new Role(authority: 'ROLE_ADMIN').save()
        new Role(authority: 'ROLE_USER').save()
    }
    def destroy = {
    }
}
