package io.netty.handler.codec.socksx.v5;

/* JADX INFO: loaded from: classes3.dex */
public interface Socks5CommandResponse extends Socks5Message {
    String bndAddr();

    Socks5AddressType bndAddrType();

    int bndPort();

    Socks5CommandStatus status();
}
