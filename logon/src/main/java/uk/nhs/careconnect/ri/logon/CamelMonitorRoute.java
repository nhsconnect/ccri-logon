package uk.nhs.careconnect.ri.logon;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class CamelMonitorRoute extends RouteBuilder {

    @Autowired
    protected Environment env;


    @Value("${keycloak.rooturl}")
    private String keycloakrooturl;

    @Value("${keycloak.authserverurl}")
    private String keycloakauthserverurl;

    @Value("${keycloak.realm}")
    private String keycloakrealm;

    @Value("${keycloak.client_secret}")
    private String keycloakclient_secret;

    @Value("${keycloak.client_id}")
    private String keycloakclient_id;

    @Override
    public void configure()
    {

        restConfiguration()
                .component("servlet")
                .contextPath("api")
                .dataFormatProperty("prettyPrint", "true")
                .enableCORS(true);




        rest("/config")
                .get("/http").to("direct:hello");

        from("direct:hello")
                .routeId("helloTest")
                .setHeader("Content-Type", constant("application/json"))
                .transform().constant("{ "
                +"\"keycloakauthserverurl\": \""+keycloakauthserverurl+"\", "
                +"\"keycloakclient_id\": \""+keycloakclient_id+"\", "
                +"\"keycloakclient_secret\": \""+keycloakclient_secret+"\", "
                +"\"keycloakrealm\": \""+keycloakrealm+"\", "
                +"\"keycloakrooturl\": \""+keycloakrooturl+"\""
                + " }");



    }
}

