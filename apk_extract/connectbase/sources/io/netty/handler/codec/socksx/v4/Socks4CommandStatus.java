package io.netty.handler.codec.socksx.v4;

import io.netty.util.internal.ObjectUtil;
import ms.a;

/* JADX INFO: loaded from: classes3.dex */
public class Socks4CommandStatus implements Comparable<Socks4CommandStatus> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks4CommandStatus SUCCESS = new Socks4CommandStatus(90, "SUCCESS");
    public static final Socks4CommandStatus REJECTED_OR_FAILED = new Socks4CommandStatus(91, "REJECTED_OR_FAILED");
    public static final Socks4CommandStatus IDENTD_UNREACHABLE = new Socks4CommandStatus(92, "IDENTD_UNREACHABLE");
    public static final Socks4CommandStatus IDENTD_AUTH_FAILURE = new Socks4CommandStatus(93, "IDENTD_AUTH_FAILURE");

    public Socks4CommandStatus(int i10) {
        this(i10, "UNKNOWN");
    }

    public static Socks4CommandStatus valueOf(byte b10) {
        switch (b10) {
            case 90:
                return SUCCESS;
            case a.T /* 91 */:
                return REJECTED_OR_FAILED;
            case a.W /* 92 */:
                return IDENTD_UNREACHABLE;
            case a.U /* 93 */:
                return IDENTD_AUTH_FAILURE;
            default:
                return new Socks4CommandStatus(b10);
        }
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks4CommandStatus) && this.byteValue == ((Socks4CommandStatus) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public boolean isSuccess() {
        return this.byteValue == 90;
    }

    public String toString() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.name);
        sb2.append('(');
        String strA = u.a.a(sb2, this.byteValue & 255, ')');
        this.text = strA;
        return strA;
    }

    public Socks4CommandStatus(int i10, String str) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.byteValue = (byte) i10;
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks4CommandStatus socks4CommandStatus) {
        return this.byteValue - socks4CommandStatus.byteValue;
    }
}
