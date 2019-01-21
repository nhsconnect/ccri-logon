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



	@Value("${fhir.resource.serverBase}")
	private String serverBase;

	@Value("${fhir.messaging.serverBase}")
	private String messagingBase;

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

	@Value("${oauth2.client_id}")
	private String oauth2client_id;

	@Value("${oauth2.client_secret}")
	private String oauth2client_secret;

	@Value("${oauth2.cookie_domain}")
	private String oauth2cookie_domain;

	@Override
    public void configure() 
    {

		restConfiguration()
				.component("servlet")
				.contextPath("api")
				.dataFormatProperty("prettyPrint", "true")
				.enableCORS(true);

		log.info("Starting Camel Route MAIN FHIR Server = " + serverBase);


		rest("/config")
				.get("/http").to("direct:hello");

		from("direct:hello")
				.routeId("helloTest")
				.setHeader("Content-Type", constant("application/json"))
				.transform().constant("{ \"fhirServer\": \""+serverBase+"\", "
				+"\"messagingServer\": \""+messagingBase+"\", "
				+"\"keycloakauthserverurl\": \""+keycloakauthserverurl+"\", "
				+"\"keycloakclient_id\": \""+keycloakclient_id+"\", "
				+"\"keycloakclient_secret\": \""+keycloakclient_secret+"\", "
				+"\"keycloakrealm\": \""+keycloakrealm+"\", "
				+"\"keycloakrooturl\": \""+keycloakrooturl+"\", "
				+"\"oauth2client_id\": \""+oauth2client_id+"\", "
				+"\"oauth2client_secret\": \""+oauth2client_secret+"\", "
				+"\"oauth2cookie_domain\": \""+oauth2cookie_domain+"\""
				+ " }");



	}
}
