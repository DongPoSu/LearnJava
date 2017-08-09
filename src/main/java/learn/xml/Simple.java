package learn.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.xml
 * company: SiBu
 * create_date: 2017/08/01
 * description :
 */
@JacksonXmlRootElement(localName = "root")
@Data
public class Simple {
    private String str;
    private int x;
    @JacksonXmlProperty(localName = "h23")
    private int y;
}