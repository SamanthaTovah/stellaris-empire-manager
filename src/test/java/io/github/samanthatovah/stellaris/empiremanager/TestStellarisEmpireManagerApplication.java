package io.github.samanthatovah.stellaris.empiremanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestStellarisEmpireManagerApplication {

	public static void main(String[] args) {
		SpringApplication.from(StellarisEmpireManagerApplication::main).with(TestStellarisEmpireManagerApplication.class).run(args);
	}

}
