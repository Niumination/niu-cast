package io.netty.handler.codec.socksx.v4;

import io.netty.util.internal.ObjectUtil;
import u.a;

/* JADX INFO: loaded from: classes3.dex */
public class Socks4CommandType implements Comparable<Socks4CommandType> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks4CommandType CONNECT = new Socks4CommandType(1, "CONNECT");
    public static final Socks4CommandType BIND = new Socks4CommandType(2, "BIND");

    public Socks4CommandType(int i10) {
        this(i10, "UNKNOWN");
    }

    public static Socks4CommandType valueOf(byte b10) {
        if (b10 != 1) {
            return b10 != 2 ? new Socks4CommandType(b10) : BIND;
        }
        return CONNECT;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks4CommandType) && this.byteValue == ((Socks4CommandType) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public String toString() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.name);
        sb2.append('(');
        String strA = a.a(sb2, this.byteValue & 255, ')');
        this.text = strA;
        return strA;
    }

    public Socks4CommandType(int i10, String str) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.byteValue = (byte) i10;
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks4CommandType socks4CommandType) {
        return this.byteValue - socks4CommandType.byteValue;
    }
}
