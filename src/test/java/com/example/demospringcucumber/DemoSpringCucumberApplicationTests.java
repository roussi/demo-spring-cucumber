package com.example.demospringcucumber;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.net.ServerSocket;


@SpringBootConfiguration
@SpringBootApplication(scanBasePackageClasses = DemoSpringCucumberApplication.class)
public class DemoSpringCucumberApplicationTests {

	public static int port;

	{
		tryFindingAvailablePort();
	}

	private void tryFindingAvailablePort() {
		try {
			ServerSocket serverSocket = new ServerSocket(0);
			port = serverSocket.getLocalPort();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		@Override
		public void initialize(ConfigurableApplicationContext applicationContext) {
			TestPropertyValues.of("server.port=" + port).applyTo(applicationContext);
		}
	}

}
