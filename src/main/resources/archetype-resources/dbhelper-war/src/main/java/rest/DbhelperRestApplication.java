#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Конфигурация REST приложения
 */
@ApplicationPath("/")
public class DbhelperRestApplication extends Application {
}
