package learn.io.byteStream.objectStream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author suzheng
 * @version v.1.0
 */
@Data
@AllArgsConstructor
public class ObjectBean1 extends BaseObjectBean implements Serializable {
    private static final long serialVersionUID = -5747402125297698490L;
    private String name;
}
