package arch.datasource4;

import arch.datasourceinterface.IDataSourceService;

public class RegisterComponent {

	private DataSource4 dataSource = null;
	
    protected void setDataSourceService(IDataSourceService dataSourceService) {
    	dataSource = new DataSource4();
    	dataSourceService.addDataSource(dataSource);     
    }

    protected void unsetDataSourceService(IDataSourceService dataSourceService) {
    	dataSourceService.removeDataSource(dataSource);
    	dataSource = null;
    }
}
