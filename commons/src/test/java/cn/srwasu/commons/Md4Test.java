package cn.srwasu.commons;

public class Md4Test {

    @org.junit.Test
    public void getMd4ofStr() {
        String s = "李兆廷";
        final int count = 100000000;
        for (int i = 0; i < count; i++) {
            s = Md4.getMd4ofStr(s);
        }
        System.out.println(s);
    }

    @org.junit.Test
    public void testGetMd4ofStr() {
    }

    @org.junit.Test
    public void getMd4ofBytes() {
    }

    @org.junit.Test
    public void testGetMd4ofBytes() {
    }
}