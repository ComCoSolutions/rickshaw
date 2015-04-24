package com.rickshaw
import spock.lang.*

/**
 *
 */
class CustomerIntegrationSpec extends Specification {

    def "Saving our first customer to the database"() {
        given: "A brand new customer"
        def john = new Customer(firstName: 'John', lastName: 'Doe',
                email: 'jdoe@hotmail.com', password: 'secret')
        when: "the customer is saved"
        john.save()
        then: "it saved successfully and can be found in the database"
        john.errors.errorCount == 0
        john.id != null
        Customer.get(john.id).firstName == 'John'
    }

    def "deleting customer from database"() {
        given: "An existing customer"
        def ralph = new Customer(firstName: 'Ralph', lastName: 'Emerson',
                email: 'remerson@hotmail.com', password: 'secret')
        ralph.save(failOnError: true)
        when: "the customer is deleted"
        def foundCustomer = Customer.get(ralph.id)
        foundCustomer.delete(flush: true)
        then: "the customer is removed form the database"
        !Customer.exists(ralph.id)
    }

    def "Invalid customer should not be saved into database"() {
        given: "A brand new customer which violates constraints"
        def john = new Customer(firstName: 'John', lastName: 'Doe',
                email: 'notAnEmailAddress', password: 'sec')
        when: "the customer is validated"
        john.validate()
        then: "it has errors and does not persist"
        john.hasErrors()
        john.errors.errorCount == 2
        john.id == null
        "size.toosmall" == john.errors.getFieldError("password").code
        "sec" == john.errors.getFieldError("password").rejectedValue
        "email.invalid" == john.errors.getFieldError("email").code
        "notAnEmailAddress" == john.errors.getFieldError("email").rejectedValue
    }
}


