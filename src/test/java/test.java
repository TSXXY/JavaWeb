import com.alibaba.druid.support.json.JSONUtils;
import com.tan.javaweb.dao.impl.FilmDaoImpl;
import com.tan.javaweb.pojo.Film;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test {
    public static void main(String[] args) {
        HashMap<String, Object> stringIntegerHashMap = new HashMap<>();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(12);
        integers.add(134);
        integers.add(153);
        stringIntegerHashMap.put("id",1);
        stringIntegerHashMap.put("sdad",1);
        stringIntegerHashMap.put("idsadad",1);
        stringIntegerHashMap.put("idsadasd",integers);
        String s = JSONUtils.toJSONString(stringIntegerHashMap);
        System.out.println(s);


    }
}
