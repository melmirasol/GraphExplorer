package ca.melmirasol.graphexplorer;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import java.util.logging.Level;
import java.util.logging.Logger;

@org.springframework.context.annotation.Configuration
@ComponentScan
public class Configuration {
    @Bean
    @Scope("prototype")
    public Logger logger(final InjectionPoint injectionPoint) {
        Class<?> classOnWired = injectionPoint.getMember().getDeclaringClass();

        Logger logger = Logger.getLogger(classOnWired.getName());
        logger.setLevel(Level.ALL);

        return logger;
    }
}
