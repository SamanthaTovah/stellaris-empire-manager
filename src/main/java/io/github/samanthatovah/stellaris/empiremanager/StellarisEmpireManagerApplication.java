package io.github.samanthatovah.stellaris.empiremanager;

import io.github.samanthatovah.stellaris.empiremanager.domain.empire.Empire;
import io.github.samanthatovah.stellaris.empiremanager.infrastructure.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("io.github.samanthatovah.stellaris.empiremanager.domain")
@EnableJpaRepositories(basePackages = "io.github.samanthatovah.stellaris.empiremanager.domain")
@Import(SecurityConfig.class)
public class StellarisEmpireManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StellarisEmpireManagerApplication.class, args);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setPackagesToScan(Empire.class.getPackage().getName());
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setPackagesToScan("io.github.samanthatovah.stellaris.empiremanager.domain");
        return entityManagerFactory;
    }

}
