package com.rickshaw

class LoginController {

    def index() {

    }

    def login() {
        def customer = Customer.findByEmailAndPassword(params.loginID, params.password)
        if (customer) {
            redirect controller: "order"
        } else {
            flash.message = "Sorry, no such customer"
            render view: "index"
        }
    }


}
