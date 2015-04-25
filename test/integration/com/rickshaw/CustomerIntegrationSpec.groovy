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

    def "When a customer is saved, their order is also saved"() {
        given: "A brand new customer and a new order"
        def moe = new Customer(firstName: 'Moe', lastName: 'B',
                            email: 'moeb@somewhere.com', password: 'secret')
        def moesOrder = new CustomerOrder(dateCreated: new Date(), total: 0F)
        when: "the order is added to customer and customer is saved"
        moe.addToOrders(moesOrder)
        moe.save(failOnError: true)
        then: "order and customer exist in db and order is owned by customer"
        Customer.count() == 1
        CustomerOrder.count() == 1
        moe.orders.contains(CustomerOrder.get(moesOrder.id))
    }
}


