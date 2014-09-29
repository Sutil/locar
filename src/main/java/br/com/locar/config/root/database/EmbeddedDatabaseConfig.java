package br.com.locar.config.root.database;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import br.com.locar.config.root.annotation.Teste;

@Teste
@Configuration
public class EmbeddedDatabaseConfig implements DatabaseConfig {

	@Bean
	@Override
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("integration");
		factoryBean.setDataSource(dataSource());
		return factoryBean;
	}

	@Bean
	@Override
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
	}
	
//	@Bean
//	@Override
//	public DataSource dataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setDriverClassName("org.postgresql.Driver");
//		dataSource.setUrl("jdbc:postgresql://localhost:5432/locar_teste");
//		dataSource.setUsername("postgres");
//		dataSource.setPassword("admin");
//		dataSource.setTestOnBorrow(true);
//		dataSource.setTestOnReturn(true);
//		dataSource.setTestWhileIdle(true);
//		dataSource.setTimeBetweenEvictionRunsMillis(1800000);
//		dataSource.setNumTestsPerEvictionRun(3);
//		dataSource.setMinEvictableIdleTimeMillis(1800000);
//		return dataSource;
//	}

}
