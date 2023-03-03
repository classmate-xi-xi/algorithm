package topic;

import java.util.HashMap;

/**
 * @author: ywx
 * @description 保证文件名唯一
 * @Date: 2023/03/03
 */

public class Topic1487 {
    /**
     * 解释：文件系统将会这样创建文件名：
     * "pes" --> 之前未分配，仍为 "pes"
     * "fifa" --> 之前未分配，仍为 "fifa"
     * "gta" --> 之前未分配，仍为 "gta"
     * "pes(2019)" --> 之前未分配，仍为 "pes(2019)"
     *
     * @param names names = ["pes","fifa","gta","pes(2019)"]
     * @return ["pes","fifa","gta","pes(2019)"]
     */
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (hashMap.containsKey(names[i])) {
                int num = hashMap.get(names[i]);
                while (hashMap.containsKey(names[i] + "(" + num + ")")) {
                    num++;
                }
                hashMap.put(names[i], num);
                names[i] = names[i] + "(" + num + ")";
            }
            hashMap.put(names[i], 1);
        }
        return names;
    }
}
