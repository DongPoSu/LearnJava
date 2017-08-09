package learn.xml;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.xml
 * company: SiBu
 * create_date: 2017/08/01
 * description :
 */
public class JacsonXmlTest {
    public static void main(String[] args) throws IOException {
        // Important: create XmlMapper; it will use proper factories, workarounds
        ObjectMapper xmlMapper = new XmlMapper();
        Simple simple = new Simple();
        simple.setX(1);
        simple.setY(2);
        simple.setStr("");
        List<Simple> list = new ArrayList<>();
        list.add(simple);
        list.add(simple);
        list.add(simple);
        list.add(simple);
        xmlMapper.configure(MapperFeature.USE_GETTERS_AS_SETTERS, true);
        String xml = xmlMapper.writeValueAsString(simple);
// or
        xmlMapper.writeValue(new File("D:\\chrome_download\\stuff.xml"), list);
    }
}
