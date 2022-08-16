package topic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ywx
 * @description 设计有序流
 * @Date: 2022/08/16
 */

public class Topic1656 {
    class OrderedStream {
        private String[] stream;
        private int ptr;
        public OrderedStream(int n) {
            stream = new String[n + 1];
            ptr = 1;
        }

        public List<String> insert(int idKey, String value) {
            stream[idKey] = value;
            List<String> res = new ArrayList<String>();
            while (ptr < stream.length && stream[ptr] != null) {
                res.add(stream[ptr]);
                ++ptr;
            }
            return res;
        }
    }
}
