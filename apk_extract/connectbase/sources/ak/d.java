package ak;

import ak.d;
import c1.h0;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import vj.e0;
import vj.y;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
@gm.c
public abstract class d<S extends d<S>> {
    private final vj.e callOptions;
    private final vj.f channel;

    public interface a<T extends d<T>> {
        T newStub(vj.f fVar, vj.e eVar);
    }

    public d(vj.f fVar) {
        this(fVar, vj.e.f17085l);
    }

    public static <T extends d<T>> T newStub(a<T> aVar, vj.f fVar) {
        return (T) newStub(aVar, fVar, vj.e.f17085l);
    }

    public abstract S build(vj.f fVar, vj.e eVar);

    public final vj.e getCallOptions() {
        return this.callOptions;
    }

    public final vj.f getChannel() {
        return this.channel;
    }

    public final S withCallCredentials(vj.d dVar) {
        return (S) build(this.channel, this.callOptions.p(dVar));
    }

    @Deprecated
    public final S withChannel(vj.f fVar) {
        return (S) build(fVar, this.callOptions);
    }

    public final S withCompression(String str) {
        return (S) build(this.channel, this.callOptions.q(str));
    }

    public final S withDeadline(@gm.j y yVar) {
        return (S) build(this.channel, this.callOptions.r(yVar));
    }

    public final S withDeadlineAfter(long j10, TimeUnit timeUnit) {
        return (S) build(this.channel, this.callOptions.s(j10, timeUnit));
    }

    public final S withExecutor(Executor executor) {
        return (S) build(this.channel, this.callOptions.t(executor));
    }

    public final S withInterceptors(vj.l... lVarArr) {
        return (S) build(vj.m.c(this.channel, lVarArr), this.callOptions);
    }

    @e0("https://github.com/grpc/grpc-java/issues/2563")
    public final S withMaxInboundMessageSize(int i10) {
        return (S) build(this.channel, this.callOptions.u(i10));
    }

    @e0("https://github.com/grpc/grpc-java/issues/2563")
    public final S withMaxOutboundMessageSize(int i10) {
        return (S) build(this.channel, this.callOptions.v(i10));
    }

    @e0("https://github.com/grpc/grpc-java/issues/1869")
    public final <T> S withOption(vj.e.c<T> cVar, T t10) {
        return (S) build(this.channel, this.callOptions.x(cVar, t10));
    }

    public final S withWaitForReady() {
        return (S) build(this.channel, this.callOptions.z());
    }

    public d(vj.f fVar, vj.e eVar) {
        this.channel = (vj.f) h0.F(fVar, "channel");
        this.callOptions = (vj.e) h0.F(eVar, "callOptions");
    }

    public static <T extends d<T>> T newStub(a<T> aVar, vj.f fVar, vj.e eVar) {
        return (T) aVar.newStub(fVar, eVar);
    }
}
