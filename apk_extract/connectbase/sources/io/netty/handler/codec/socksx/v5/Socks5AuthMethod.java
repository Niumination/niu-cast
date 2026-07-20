package io.netty.handler.codec.socksx.v5;

import io.netty.util.internal.ObjectUtil;
import u.a;

/* JADX INFO: loaded from: classes3.dex */
public class Socks5AuthMethod implements Comparable<Socks5AuthMethod> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks5AuthMethod NO_AUTH = new Socks5AuthMethod(0, "NO_AUTH");
    public static final Socks5AuthMethod GSSAPI = new Socks5AuthMethod(1, "GSSAPI");
    public static final Socks5AuthMethod PASSWORD = new Socks5AuthMethod(2, "PASSWORD");
    public static final Socks5AuthMethod UNACCEPTED = new Socks5AuthMethod(255, "UNACCEPTED");

    public Socks5AuthMethod(int i10) {
        this(i10, "UNKNOWN");
    }

    public static Socks5AuthMethod valueOf(byte b10) {
        if (b10 == -1) {
            return UNACCEPTED;
        }
        if (b10 == 0) {
            return NO_AUTH;
        }
        if (b10 != 1) {
            return b10 != 2 ? new Socks5AuthMethod(b10) : PASSWORD;
        }
        return GSSAPI;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks5AuthMethod) && this.byteValue == ((Socks5AuthMethod) obj).byteValue;
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

    public Socks5AuthMethod(int i10, String str) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.byteValue = (byte) i10;
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks5AuthMethod socks5AuthMethod) {
        return this.byteValue - socks5AuthMethod.byteValue;
    }
}
