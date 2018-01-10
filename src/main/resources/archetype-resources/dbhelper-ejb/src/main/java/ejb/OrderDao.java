#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ejb;


import ${package}.jpa.Customer_;
import ${package}.jpa.Order;
import ${package}.jpa.Order_;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by BritikovMI on 03.08.2017.
 */
@Stateless
public class OrderDao extends AbstractEntityDao<Long, Order> {
    EntityManager em = getEntityManager();
    public OrderDao() {
        super(Order.class);
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {//Получаем заказы определенного кастомера
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Order> criteria = builder.createQuery(Order.class);
        Root<Order> root = criteria.from(Order.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get(Order_.customer).get(Customer_.id), customerId));
        TypedQuery<Order> query = getEntityManager().createQuery(criteria);
        List<Order> result = query.getResultList();
        return result;
//        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
//        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
//        Root<Customer> root = query.from(Customer.class);
//        Join<Order,Customer> joinTab = root.join(String.valueOf(Order_.customer));
//        query.select(joinTab).where(builder.equal(root.get(Customer_.id), id));
//        List<Customer> custOrders = getEntityManager().createQuery(query).getResultList();
//        return custOrders;
    }
}
