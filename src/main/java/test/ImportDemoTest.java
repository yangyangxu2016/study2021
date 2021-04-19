package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.HashMap;
import java.util.Map;

/**
 * todo
 * author：xuyy
 * date：2021/3/8  10:58 上午
 */
@Import({MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class ImportDemoTest {

    @Bean
    private AutoConfigTwo init3() {

        return new AutoConfigTwo();
    }

    public static void main(String[] args) {
        String a = "amanaplanacanalpanama";
        Boolean isHuiWenString = isHuiWenString(a);
        System.out.println("是否回文字符串：" + isHuiWenString);
    }

    private static Boolean isHuiWenString(String str) {
        //校验
        str = filterStr(str);
        if (str == null || "".equals(str)) {
            return true;
        }
        //字符数组
        char[] chars = str.toCharArray();
        //双指针
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    private static String filterStr(String str) {

        return null;
    }


    public int fib(int n) {
        return fib(n, new HashMap<>());
    }

    private int fib(int n, Map<Integer, Integer> map) {
        if (n < 2) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int first = fib(n - 1,map) % 1000000007;
        map.put(n - 1, first);
        int second = fib(n - 2,map) % 1000000007;
        map.put(n - 2, second);
        int res = (first + second) % 1000000007;
        map.put(n, res);
        return res;
    }


}
