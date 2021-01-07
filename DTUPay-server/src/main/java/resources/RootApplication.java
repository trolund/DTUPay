package resources;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.ws.rs.core.Application;
import java.util.logging.Logger;

@OpenAPIDefinition(
        tags = {
                /*@Tag(name="widget", description="Widget operations."),
                @Tag(name="gasket", description="Operations related to gaskets")*/
        },
        info = @Info(
                title="Simple DTU Pay API",
                version = "1.0.1",
                contact = @Contact(
                        name = "Example API Support",
                        url = "http://exampleurl.com/contact",
                        email = "techsupport@example.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"))
)

@ApplicationScoped
public class RootApplication extends Application {

        private final static Logger LOGGER = Logger.getLogger(RootApplication.class.getName());

        void onStart(@Observes StartupEvent ev) {
                LOGGER.info("The application is starting...");
        }
        void onStop(@Observes ShutdownEvent ev) {
                LOGGER.info("The application is stopping...");
        }


}