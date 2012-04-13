package arch.datasource.create;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import arch.datasource.jpa.DataItem;

public class DataItemCreation {

	private static final String PERSISTENCE_UNIT_NAME = "dataitems";
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		// Read the existing entries and write to console
		Query q = em.createQuery("select t from DataItem t");
		List<DataItem> dataItemList = q.getResultList();
		for (DataItem todo : dataItemList) {
			System.out.println(todo);
		}
		System.out.println("Size: " + dataItemList.size());

		// Create new todo
		em.getTransaction().begin();
		DataItem todo = new DataItem();
		todo.setCompany("BMW");
		todo.setRevenue(100);
		em.persist(todo);
		em.getTransaction().commit();

		em.close();
	}


}
