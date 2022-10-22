package core;

import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class JSONDataProvider implements ITestData{

	private Reader reader;
    private Gson gson;

    public JSONDataProvider (String filePath) throws Exception {
        reader = new FileReader(filePath);
        gson = new Gson();
    }
   
    @SuppressWarnings({ "rawtypes", "serial", "unchecked" })
	public List<Map<String,String>> getAllData(String testName) {
        Type type = new TypeToken<HashMap<String, ArrayList<HashMap>>>(){}.getType();
        HashMap<String, ArrayList<HashMap>> testData = gson.fromJson(reader, type);
        ArrayList testDataList = testData.get("testdata");
        for(Object test :  testDataList){
            if(((Map) test).get("testname").equals(testName)){
                return (List<Map<String,String>>) ((Map) test).get("iteration");
            }
        }
        return null;
    }
}
