package uk.nhs.careconnect.ri.logon;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogonApplication {

    public static void main(String[] args) {

        System.setProperty("hawtio.authenticationEnabled", "false");
        System.setProperty("hawtio.role","MANAGER");
        System.setProperty("management.security.enabled","false");

        System.setProperty("server.context-path", "/cc-logon");

        System.setProperty("management.contextPath","/");

        SpringApplication.run(LogonApplication.class, args);
    }


/*
    @Bean(name = "LogQuery", destroyMethod = "stop", initMethod = "start")
    @Scope("singleton")
    @Lazy(false)
    public Log4jLogQuery log4jLogQuery() {
        Log4jLogQuery log4jLogQuery = new Log4jLogQuery();
        return log4jLogQuery;
    }
*/
}
