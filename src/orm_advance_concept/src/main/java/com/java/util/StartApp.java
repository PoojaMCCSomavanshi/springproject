package com.java.util;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;



public class StartApp {

	public static void main(String[] args) {
		
		SessionFactory sessionfactory=HibernateConfig.getSessionFactory(Employee.class);
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		Employee e1=new Employee(111,"BBB","BBBB","aaa@gmail.com",26);
		Employee e2=new Employee(222,"AAA","AAAA","bbb@gmail.com",23);
		Employee e3=new Employee(333,"DDD","FFFF","ccc@gmail.com",25);
		 session.save(e1);
		 session.save(e2);
		 session.save(e3);
		 
		 System.out.println("------------------------------");
		 Criteria cr=session.createCriteria(Employee.class);
		 cr.setFirstResult(1);
		 cr.setMaxResults(10);
		 List result=cr.list();
		 
		 
		 System.out.println("USING RESTRICTIONS------------------------------");
		 cr.add(Restrictions.gt("empAge",23));
		 
		 System.out.println(" USING ORDER------------------------------");
		 cr.addOrder(Order.desc("empName"));
		 cr.addOrder(Order.asc("empAge"));
		 List results=cr.list();
		 System.out.println(results);
		 
		 System.out.println(" USING PROJECTIONS------------------------------");
		 cr.setProjection(Projections.rowCount());
		 cr.setProjection(Projections.countDistinct("empName"));
		 List results1=cr.list();
		 System.out.println(results1);
		 
		 
		 session.flush();
		 tr.commit();
	}
}
