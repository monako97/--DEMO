package blog.monako.util;

public class TextUtils {
    /**
     * 判断某一字符串是否存在
     * @param charSequence
     * @return boolean
     * */
    public static boolean isEmpty(CharSequence charSequence){
        return charSequence == null || charSequence.length() == 0;
    }
}
