/*
    These are the actual product items that are in the inventory. They are used to build OrderItems.
*/
package com.rickshaw

class Product {
    String name
    String number
    Float price

    static hasMany = [orderItem: OrderItem]

    static constraints = {
        name blank: false
        number blank: false
        price min: 0F
    }
}
