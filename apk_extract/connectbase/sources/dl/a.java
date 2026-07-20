package dl;

import ik.l1;
import ik.p0;
import io.netty.handler.codec.http2.Http2Headers;
import java.net.InetSocketAddress;
import jq.h0;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final Http2Headers f3722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public final InetSocketAddress f3723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public final InetSocketAddress f3724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final p0 f3725d;

    public a(@l Http2Headers http2Headers, @m InetSocketAddress inetSocketAddress, @m InetSocketAddress inetSocketAddress2) {
        l0.p(http2Headers, "nettyHeaders");
        this.f3722a = http2Headers;
        this.f3723b = inetSocketAddress;
        this.f3724c = inetSocketAddress2;
        CharSequence charSequenceMethod = http2Headers.method();
        p0 p0VarI = charSequenceMethod == null ? null : p0.f8135b.i(charSequenceMethod.toString());
        if (p0VarI == null) {
            p0.f8135b.getClass();
            p0VarI = p0.f8136c;
        }
        this.f3725d = p0VarI;
    }

    @Override // ik.l1
    public int a() {
        String string;
        String strL5;
        CharSequence charSequenceAuthority = this.f3722a.authority();
        Integer numValueOf = null;
        if (charSequenceAuthority != null && (string = charSequenceAuthority.toString()) != null && (strL5 = h0.l5(string, ":", "")) != null) {
            if (strL5.length() <= 0) {
                strL5 = null;
            }
            if (strL5 != null) {
                numValueOf = Integer.valueOf(Integer.parseInt(strL5));
            }
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        InetSocketAddress inetSocketAddress = this.f3723b;
        if (inetSocketAddress == null) {
            return 80;
        }
        return inetSocketAddress.getPort();
    }

    @Override // ik.l1
    @l
    public String b() {
        String string;
        String strV5;
        CharSequence charSequenceAuthority = this.f3722a.authority();
        return (charSequenceAuthority == null || (string = charSequenceAuthority.toString()) == null || (strV5 = h0.v5(string, ":", null, 2, null)) == null) ? "localhost" : strV5;
    }

    @Override // ik.l1
    @l
    public String c() {
        InetSocketAddress inetSocketAddress = this.f3724c;
        if (inetSocketAddress == null) {
            return "unknown";
        }
        String hostName = inetSocketAddress.getHostName();
        if (hostName == null) {
            hostName = inetSocketAddress.getAddress().getHostAddress();
        }
        return hostName == null ? "unknown" : hostName;
    }

    @Override // ik.l1
    @l
    public String d() {
        String string;
        CharSequence charSequenceScheme = this.f3722a.scheme();
        return (charSequenceScheme == null || (string = charSequenceScheme.toString()) == null) ? "http" : string;
    }

    @Override // ik.l1
    @l
    public p0 getMethod() {
        return this.f3725d;
    }

    @Override // ik.l1
    @l
    public String getUri() {
        String string;
        CharSequence charSequencePath = this.f3722a.path();
        return (charSequencePath == null || (string = charSequencePath.toString()) == null) ? "/" : string;
    }

    @Override // ik.l1
    @l
    public String getVersion() {
        return "HTTP/2";
    }
}
