package io.netty.handler.codec.socksx.v5;

import io.netty.util.internal.ObjectUtil;
import u.a;

/* JADX INFO: loaded from: classes3.dex */
public class Socks5PasswordAuthStatus implements Comparable<Socks5PasswordAuthStatus> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks5PasswordAuthStatus SUCCESS = new Socks5PasswordAuthStatus(0, "SUCCESS");
    public static final Socks5PasswordAuthStatus FAILURE = new Socks5PasswordAuthStatus(255, "FAILURE");

    public Socks5PasswordAuthStatus(int i10) {
        this(i10, "UNKNOWN");
    }

    public static Socks5PasswordAuthStatus valueOf(byte b10) {
        if (b10 != -1) {
            return b10 != 0 ? new Socks5PasswordAuthStatus(b10) : SUCCESS;
        }
        return FAILURE;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks5PasswordAuthStatus) && this.byteValue == ((Socks5PasswordAuthStatus) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public boolean isSuccess() {
        return this.byteValue == 0;
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

    public Socks5PasswordAuthStatus(int i10, String str) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.byteValue = (byte) i10;
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks5PasswordAuthStatus socks5PasswordAuthStatus) {
        return this.byteValue - socks5PasswordAuthStatus.byteValue;
    }
}
