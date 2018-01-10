#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.other;

import ${package}.ejb.CustomerDao;
import ${package}.ejb.OrderDao;
import ${package}.ejb.OrderItemDao;
import ${package}.ejb.ProductDao;
import ${package}.jpa.Order;
import ${package}.jpa.Product;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Это CDI bean тут еще нет транзакций
 * тут мы еще не лезе в базульку
 * тут оперируем DAO-layer
 * <p>
 * Created by er23887 on 22.08.2017.
 */
public class DaoManager {

    @Inject
    private CustomerDao customerDao;
    @Inject
    private OrderDao orderDao;
    @Inject
    private ProductDao productDao;
    @Inject
    private OrderItemDao orderItemDao;

    public List<String> handleRequest(String name, Long num) {
        List<String> result = new ArrayList<>();
        if (name.equals("customer-order")) {
            List<Order> orders = orderDao.getOrdersByCustomerId(num);
            result.add("Получаем заказы определенного кастомера: ");
            result.add("${symbol_escape}n");
            orders.forEach(order -> result.add(order.toString()));
        } else if (name.equals("product-customer")) {
            List<Product> products = orderItemDao.getProductsByCustomerIdentifier(num);
            result.add("Получаем продукты, купленные определенным кастомером: ");
            result.add("${symbol_escape}n");
            products.forEach(product -> result.add(product.getProductType()));
        } else {
            result.add("Необходимо ввести команду, в командную строку после ?name=");
        }
        return result;
    }
}
