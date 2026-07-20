package io.netty.channel.local;

import dc.d;
import el.b0;
import io.netty.channel.Channel;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;
import java.util.UUID;
import m.a;
import n1.e;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalAddress extends SocketAddress implements Comparable<LocalAddress> {
    public static final LocalAddress ANY = new LocalAddress("ANY");
    private static final long serialVersionUID = 4644331421130916435L;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f8298id;
    private final String strVal;

    public LocalAddress(Channel channel) {
        StringBuilder sb2 = new StringBuilder(16);
        sb2.append("local:E");
        sb2.append(Long.toHexString((((long) channel.hashCode()) & 4294967295L) | 4294967296L));
        sb2.setCharAt(7, e.f11184d);
        this.f8298id = sb2.substring(6);
        this.strVal = sb2.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocalAddress) {
            return this.f8298id.equals(((LocalAddress) obj).f8298id);
        }
        return false;
    }

    public int hashCode() {
        return this.f8298id.hashCode();
    }

    public String id() {
        return this.f8298id;
    }

    public String toString() {
        return this.strVal;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalAddress localAddress) {
        return this.f8298id.compareTo(localAddress.f8298id);
    }

    public LocalAddress(String str) {
        String lowerCase = ObjectUtil.checkNonEmptyAfterTrim(str, d.f3692w).toLowerCase();
        this.f8298id = lowerCase;
        this.strVal = a.a("local:", lowerCase);
    }

    public LocalAddress(Class<?> cls) {
        this(cls.getSimpleName() + b0.f4502a + UUID.randomUUID());
    }
}
