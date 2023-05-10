// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? =
    customer.orders
        .filter { it.isDelivered }
        .flatMap { it.products }
        .maxByOrNull(Product::price)


// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
//    customers.fold(0) {sum, t -> sum + t.getOrderedProducts().filter { it == product }.size }
    return customers.flatMap { it.getOrderedProducts() }
        .count { it == product }
}

fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap(Order::products)
