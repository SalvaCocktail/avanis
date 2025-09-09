package avanis.eventos.admin.portlet.util;

import com.liferay.petra.string.StringPool;

public class ColorUtil {

    public static String toHexString(int color) {
        return StringPool.POUND.concat(String.format("%06X", 0xFFFFFF & color));
    }

}
