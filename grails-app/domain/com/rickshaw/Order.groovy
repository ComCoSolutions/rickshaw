/*
    This class will represent order objects in the rickshaw application. Specifically, an order object
    represents and order placed by a customer.
*/
package com.rickshaw

class Order {
    Date dateCreated
    Float total

    static belongsTo = [customer: Customer]

    static hasMany = [orderItems: OrderItem]

    static mapping = {
        table "`Order`"
    }
    
    static constraints = {
        total nullable: false
    }
}
