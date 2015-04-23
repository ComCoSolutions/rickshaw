package com.rickshaw
import spock.lang.*

/**
 *
 */
class CustomerIntegrationSpec extends Specification {
    def "Saving our first customer to the database" () {
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
}
