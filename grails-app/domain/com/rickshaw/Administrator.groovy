/* Represents an administrator for back end maintenance tasks. */

package com.rickshaw

class Administrator {
    String loginId
    String password

    static constraints = {
        loginId blank: false, unique: true
        password blank: false, size: 6..8, validator: { passwd, user ->
            return passwd != user.loginId
        }
    }
}
