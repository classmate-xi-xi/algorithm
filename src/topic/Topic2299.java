package topic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ywx
 * @description 2299. 强密码检验器 II
 * @Date: 2023/01/19
 */

public class Topic2299 {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        List<Character> characters = new ArrayList<>();
        for (Character c : "!@#$%^&*()-+".toCharArray()) {
            characters.add(c);
        }
        int xx = 0, dx = 0, sz = 0, ts = 0;
        for (int i = 0; i < password.length(); i++) {
            if (i != password.length() - 1 && password.charAt(i) == password.charAt(i + 1)) {
                return false;
            }
            char c = password.charAt(i);
            if (characters.contains(c)) {
                ts++;
            }else if (Character.isDigit(c)) {
                sz++;
            }else if (Character.isLowerCase(c)) {
                dx++;
            }else if (Character.isLetter(c)) {
                xx++;
            }else {
                return false;
            }
        }
        return xx > 0 && dx > 0 && sz > 0 && ts > 0;
    }
}
