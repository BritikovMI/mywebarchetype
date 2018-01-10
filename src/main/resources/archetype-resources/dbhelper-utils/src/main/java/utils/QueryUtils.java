#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils;

import static ${package}.utils.AlternateSelector.selector;

/**
 * Created by er23887 on 26.07.2017.
 */
public class QueryUtils {

    public static String getQuery(String query) {
        String sqlQuery = String.valueOf(selector(query));
        if (sqlQuery == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Commands: ${symbol_escape}n");
            for (Cmd cmd : Cmd.values()) {
                sb.append('${symbol_escape}t').append(cmd.name()).append('${symbol_escape}n');
            }
            throw new IllegalArgumentException("Unknown command.");
        }
        return sqlQuery;
    }
}