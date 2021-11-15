package com.java.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfig {
	private static SessionFactory  sfactory = null;
	public static SessionFactory getSessionFactory(Class<?>...classes)
	{
		if(sfactory==null)
		{
			Configuration conf=new Configuration();
			conf.setProperties(mySqlDatabaseConfiguration());
			for (Class<?> cls : classes) { 
				conf.addAnnotatedClass(cls);
			}

			conf.addAnnotatedClass(Employee.class);

			ServiceRegistry serviceRegistery = new StandardServiceRegistryBuilder()
					.applySettings(conf.getProperties()).build();
			sfactory = conf.buildSessionFactory(serviceRegistery);
		}

		return sfactory;

	}
	private static Properties mySqlDatabaseConfiguration() {
		Properties props = new Properties();
		props.put(AvailableSettings.DRIVER,"com.mysql.jdbc.Driver");
		props.put(AvailableSettings.URL,"jdbc:mysql://localhost/ormdb");
		props.put(AvailableSettings.USER,"root");
		props.put(AvailableSettings.PASS,"root");
		props.put(AvailableSettings.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
		props.put(AvailableSettings.HBM2DDL_AUTO,"create");
		props.put(AvailableSettings.SHOW_SQL,true);

	
		return props;
	}


}
