package br.com.fredericci.hystrix;

import java.io.File;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Just start Jetty Server with war file
 * 
 * http://www.eclipse.org/jetty/documentation/current/embedding-jetty.html
 * 
 * @author Dennys Fredericci
 */
public class Main {

	public static void main(String[] args) throws Exception {
		
		File warFile = new File(args[0]);

		String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

		
		Server server = new Server(Integer.valueOf(webPort));

		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath("/");
		webapp.setWar(warFile.getAbsolutePath());
		server.setHandler(webapp);
		
		server.start();
		server.join();

	}
}
