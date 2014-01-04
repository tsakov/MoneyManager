package lu.uni2013.tp4.ws.rest.config;

import lu.uni2013.tp4.ws.rest.HelloWorldRestService;
import lu.uni2013.tp4.ws.rest.UserCommentRestService;
import lu.uni2013.tp4.ws.rest.UserRestService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User: schullto
 * Date: 11/21/13
 * Time: 6:55 PM
 */
@ApplicationPath("rs")
public class ApplicationConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(
                HelloWorldRestService.class,
                UserRestService.class,
                UserCommentRestService.class));
    }
}