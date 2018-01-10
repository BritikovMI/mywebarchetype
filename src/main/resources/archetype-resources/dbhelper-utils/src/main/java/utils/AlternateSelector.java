#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils;

/**
 * Created by er23887 on 25.07.2017.
 */
public class AlternateSelector {

    public static Cmd selector(String name) {//daoselector
        try {
            return Cmd.valueOf(name);
        } catch (Exception e) {
            System.out.println("Please enter valid command! Error :   " +  e.getMessage());
            return null;
        }
    }
}