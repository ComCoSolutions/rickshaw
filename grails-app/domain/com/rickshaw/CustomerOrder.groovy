/*
    This class will represent order objects in the rickshaw application. Specifically, an order object
    represents and order placed by a customer.
*/
package com.rickshaw

class CustomerOrder {
    Date dateCreated
    Float total

    static belongsTo = [customer: Customer]

    static hasMany = [orderItems: OrderItem]
    
    static constraints = {
        total nullable: false
    }
}
