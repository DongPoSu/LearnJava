package learn.java.guava.collect;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.java.guava.util
 * company: SiBu
 * create_date: 2017/07/31
 * description :
 */
@Data
public class LiveSortedImgResponse implements Serializable{
    private static final long serialVersionUID = -5339564095351362791L;

    @JsonIgnore
    private Integer sorted;
    private String type;
    private String content;

    public LiveSortedImgResponse(Integer sorted) {
        this.sorted = sorted;
    }
}
