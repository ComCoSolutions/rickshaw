/*
    This class will represent customer objects in the rickshaw application.
*/

package com.rickshaw

class Customer {
    String firstName
    String lastName
    String email // We will also use this as the log in id
    String password

    static hasMany = [orders:  Order]

    static constraints = {
        firstName blank: false
        lastName blank: false
        email blank: false, unique: true, email: true
        password blank: false, size: 6..8, validator: { passwd, user ->
            return passwd != user.email
        } /* password cannot be the same as email (log in id) */
    }

    String toString() { return firstName + " " + lastName }
}
