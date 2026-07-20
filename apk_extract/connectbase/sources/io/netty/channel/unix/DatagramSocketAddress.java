package io.netty.channel.unix;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
public final class DatagramSocketAddress extends InetSocketAddress {
    private static final long serialVersionUID = 3094819287843178401L;
    private final DatagramSocketAddress localAddress;
    private final int receivedAmount;

    public DatagramSocketAddress(byte[] bArr, int i10, int i11, int i12, DatagramSocketAddress datagramSocketAddress) throws UnknownHostException {
        super(newAddress(bArr, i10), i11);
        this.receivedAmount = i12;
        this.localAddress = datagramSocketAddress;
    }

    private static InetAddress newAddress(byte[] bArr, int i10) throws UnknownHostException {
        return bArr.length == 4 ? InetAddress.getByAddress(bArr) : Inet6Address.getByAddress((String) null, bArr, i10);
    }

    public DatagramSocketAddress localAddress() {
        return this.localAddress;
    }

    public int receivedAmount() {
        return this.receivedAmount;
    }
}
