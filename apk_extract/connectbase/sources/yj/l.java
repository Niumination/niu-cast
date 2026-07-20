package yj;

import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.http2.Http2ConnectionDecoder;
import io.netty.handler.codec.http2.Http2ConnectionEncoder;
import io.netty.handler.codec.http2.Http2ConnectionHandler;
import io.netty.handler.codec.http2.Http2Settings;

/* JADX INFO: loaded from: classes2.dex */
@vj.t0
public abstract class l extends Http2ConnectionHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21083c = 1024;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ByteToMessageDecoder.Cumulator f21084d = new d0(1024);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gm.j
    public final ChannelPromise f21085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vj.h f21086b;

    public l(ChannelPromise channelPromise, Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, vj.h hVar) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings);
        this.f21085a = channelPromise;
        this.f21086b = hVar;
        setCumulator(f21084d);
    }

    public String b() {
        throw new UnsupportedOperationException();
    }

    public vj.a c() {
        return vj.a.f17046c;
    }

    public vj.h k() {
        c1.h0.h0(this.f21086b != null, "NegotiationLogger must not be null");
        return this.f21086b;
    }

    @Deprecated
    public void n(vj.a aVar) {
        o(aVar, null);
    }

    public void o(vj.a aVar, vj.v0.f fVar) {
    }

    public void p() {
        this.f21085a.setSuccess((Void) null);
    }
}
