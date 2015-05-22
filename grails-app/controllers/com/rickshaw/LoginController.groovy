package com.rickshaw

class LoginController {

    def login() {
        def customer = Customer.findByEmailAndPassword(params.loginID, params.password)
        if (customer) {
            render "Customer found"
        } else {
            render "Sorry, no such customer"
        }
    }
}
