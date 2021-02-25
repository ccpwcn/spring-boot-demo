package cn.srwasu.commons;

import cn.srwasu.commons.utils.Md4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JetbrainsAgentGenerator {
    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    @org.junit.Test
    public void normal() {
        System.out.printf("%s starting...\n", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        String s = "18";
        final int count = 200000000;
        try {
            // 获取MD2加密工具
            for (int i = 0; i < count; i++) {
                // 加密
                s = Md4.getMd4ofStr(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s);
        System.out.printf("%s end\n", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
    }

    private String toHexString(byte[] b) {
        return toHexString(b, b.length);
    }

    private String toHexString(byte[] b, int len) {
        char[] buf = new char[len * 2];
        for (int i = 0, j = 0, k; i < len;) {
            k = b[i++];
            buf[j++] = HEX_DIGITS[(k >>> 4) & 0x0F];
            buf[j++] = HEX_DIGITS[k & 0x0F];
        }
        return new String(buf);
    }
}