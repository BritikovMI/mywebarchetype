#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ejb;

import ${package}.jpa.Product;

import javax.ejb.Stateless;

/**
 * Created by BritikovMI on 03.08.2017.
 */
@Stateless
public class ProductDao extends AbstractEntityDao<Long, Product> {

    public ProductDao() {
        super(Product.class);
    }


}