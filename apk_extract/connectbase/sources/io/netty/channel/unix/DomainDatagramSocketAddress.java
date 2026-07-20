package io.netty.channel.unix;

import io.netty.util.CharsetUtil;

/* JADX INFO: loaded from: classes2.dex */
public final class DomainDatagramSocketAddress extends DomainSocketAddress {
    private static final long serialVersionUID = -5925732678737768223L;
    private final DomainDatagramSocketAddress localAddress;
    private final int receivedAmount;

    public DomainDatagramSocketAddress(byte[] bArr, int i10, DomainDatagramSocketAddress domainDatagramSocketAddress) {
        super(new String(bArr, CharsetUtil.UTF_8));
        this.localAddress = domainDatagramSocketAddress;
        this.receivedAmount = i10;
    }

    public DomainDatagramSocketAddress localAddress() {
        return this.localAddress;
    }

    public int receivedAmount() {
        return this.receivedAmount;
    }
}
