/*
    This class will represent an object which is an encapsulated representation of a product and the quantity it was
     ordered in.
*/
package com.rickshaw

class OrderItem {
    Integer quantity
    Float total

    static belongsTo = [order: Order, product: Product]

    static constraints = {
        quantity min: 1
        total nullable: false, total min 0
    }

}
