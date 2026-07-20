package io.netty.handler.proxy;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;

/* JADX INFO: loaded from: classes3.dex */
public final class ProxyConnectionEvent {
    private final String authScheme;
    private final SocketAddress destinationAddress;
    private final String protocol;
    private final SocketAddress proxyAddress;
    private String strVal;

    public ProxyConnectionEvent(String str, String str2, SocketAddress socketAddress, SocketAddress socketAddress2) {
        this.protocol = (String) ObjectUtil.checkNotNull(str, "protocol");
        this.authScheme = (String) ObjectUtil.checkNotNull(str2, "authScheme");
        this.proxyAddress = (SocketAddress) ObjectUtil.checkNotNull(socketAddress, "proxyAddress");
        this.destinationAddress = (SocketAddress) ObjectUtil.checkNotNull(socketAddress2, "destinationAddress");
    }

    public String authScheme() {
        return this.authScheme;
    }

    public <T extends SocketAddress> T destinationAddress() {
        return (T) this.destinationAddress;
    }

    public String protocol() {
        return this.protocol;
    }

    public <T extends SocketAddress> T proxyAddress() {
        return (T) this.proxyAddress;
    }

    public String toString() {
        String str = this.strVal;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(StringUtil.simpleClassName(this));
        sb2.append('(');
        sb2.append(this.protocol);
        sb2.append(", ");
        sb2.append(this.authScheme);
        sb2.append(", ");
        sb2.append(this.proxyAddress);
        sb2.append(" => ");
        sb2.append(this.destinationAddress);
        sb2.append(')');
        String string = sb2.toString();
        this.strVal = string;
        return string;
    }
}
