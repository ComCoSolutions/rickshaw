package com.rickshaw

class LoginController {

    def login() {
        def customer = Customer.findByEmailAndPassword(params.loginID, params.password)
        if (customer) {
            println "Customer found"
        } else {
            println "Sorry, no such customer"
        }
    }
}
