package com.Practice.Selenium;

import com.Practice.Selenium.BaseMethods.BaseTestUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FetchingDataFromCSV extends BaseTestUtils {

    @Test(dataProvider = "TestData")
    public void testCSVData(String s1, String s2, String s3) {

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }


    @DataProvider(name = "TestData")
    public Object[][] getDataFromCSV() throws IOException {
            List<Object[]> list = new LinkedList<>();

            File file = new File(System.getProperty("user.dir") + "\\Resources\\Test.csv");
            InputStream stream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            boolean header = true;
            String line;

            while ((line = reader.readLine()) != null) {
                if (header) {
                    header = false;
                    continue;
                }
                String[] str = line.split(",");
                for (int i = 0; i < str.length; i++) {
                    str[i] = str[i].trim();
                }
                list.add(str);
            }

            return list.toArray(new Object[list.size()][]);
        }
}
