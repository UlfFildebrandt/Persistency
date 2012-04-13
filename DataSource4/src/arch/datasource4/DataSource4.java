package arch.datasource4;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import arch.datasourceinterface.DefaultDataItem;
import arch.datasourceinterface.IDataItem;
import arch.datasourceinterface.IDataSource;

public class DataSource4 implements IDataSource {

    private static String[] companies = { "BMW", "Chrysler", "Ford" };

    private List<IDataItem> itemsList = null;
    
	private static final String PERSISTENCE_UNIT_NAME = "dataitems";
	private static EntityManagerFactory factory;

    public List<IDataItem> getData() {
        if (this.itemsList != null)
            return this.itemsList;
        this.itemsList = new ArrayList<IDataItem>();

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		// Read the existing entries and write to console
		Query q = em.createQuery("select t from DataItem t");
		List<DataItem> dataItemList = q.getResultList();
		for (DataItem item : dataItemList) {
			IDataItem di = new DefaultDataItem(item.getCompany(), item.getRevenue());
            di.setArea(getArea());
            this.itemsList.add(di);
		}
        /*Random r = new Random();

        for (int i = 0; i < companies.length; i++) {
            IDataItem di = new DefaultDataItem(companies[i], (int) (r.nextFloat() * 100000));
            di.setArea(getArea());
            this.itemsList.add(di);
        }*/

        return this.itemsList;
    }

    public String getArea() {
        return "USA-2";
    }
}
