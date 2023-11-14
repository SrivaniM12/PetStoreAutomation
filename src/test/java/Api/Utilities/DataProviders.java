package Api.Utilities;



	import java.io.IOException;

import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	public class DataProviders {

	    @DataProvider( name= "Data")//this method gets all the data from the sheet..we will use in post
	    
	    public String[][] getAllData() throws IOException {
	        // Specify the path to your Excel file and the sheet name
	        String path = System.getProperty("user.dir")+"//excelDataDDt//testData.xlsx";
	        
	        XLUtility xl= new XLUtility(path);
	        int rowNum=xl.getRowCount("Sheet1");
	        int colCount=xl.getCellCount("Sheet1",1);
	        String apidata[][]=new String[rowNum][colCount];
	        for(int i=1;i<rowNum;i++) {
	        	for(int j=0;j<colCount;j++) {
	        		apidata[i-1][j]=xl.getCellData("Sheet1",i,j);
	        		
	        	}
	        }
	        return apidata;
	        
	    } 
	        @DataProvider(name="UserNames")//this method only gets usernames
	        public String[] getUserNames() throws IOException
	        {
	        	String path = System.getProperty("user.dir")+"//excelDataDDt//testData.xlsx";
		        
		        XLUtility xl= new XLUtility(path);
		        int rowNum=xl.getRowCount("Sheet1");
		        String apidata[]=new String[rowNum];
		        for(int i=1;i<=rowNum;i++) {
		        	
		        
		        apidata[i-1]=xl.getCellData("Sheet1",i,1);
		        
	        }
		        return apidata;
	}


}