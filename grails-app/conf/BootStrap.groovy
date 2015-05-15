import com.rickshaw.Customer
import com.rickshaw.Order

class BootStrap {

    def init = { servletContext ->
        environments {
            development {
                if (!Customer.count()) createSampleData()
            }
        }
    }

    private createSampleData() {
        println "Creating sample data ..."

        def rick = new Customer(firstName: "Rick", lastName: "Shaw",
                                email: "rshaw@nowhere.com", password: 'secret12').save(failOnError: true)

        def john = new Customer(firstName: "John", lastName: "Doe",
                email: "jdoe@nowhere.com", password: 'secret12').save(failOnError: true)

        //def order1 = new Order(dateCreated: new Date(), total: 23.23)
        //def order2 = new Order(dateCreated: new Date(), total: 46.23)

        rick.addToOrders(dateCreated: new Date(), total: 23.23)
        rick.addToOrders(dateCreated: new Date(), total: 46.23)

        rick.save(failOnError: true)
    }
}
