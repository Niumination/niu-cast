package hf;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import k3.v8;
import ze.z;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    private final ze.f callOptions;
    private final ze.g channel;

    public e(ze.g gVar, ze.f fVar) {
        v8.i(gVar, "channel");
        this.channel = gVar;
        v8.i(fVar, "callOptions");
        this.callOptions = fVar;
    }

    public static <T extends e> T newStub(d dVar, ze.g gVar) {
        return (T) newStub(dVar, gVar, ze.f.f11346i);
    }

    public abstract e build(ze.g gVar, ze.f fVar);

    public final ze.f getCallOptions() {
        return this.callOptions;
    }

    public final ze.g getChannel() {
        return this.channel;
    }

    public final e withCallCredentials(ze.c cVar) {
        ze.g gVar = this.channel;
        ze.f fVar = this.callOptions;
        fVar.getClass();
        ze.d dVarB = ze.f.b(fVar);
        dVarB.getClass();
        return build(gVar, new ze.f(dVarB));
    }

    @Deprecated
    public final e withChannel(ze.g gVar) {
        return build(gVar, this.callOptions);
    }

    public final e withCompression(String str) {
        ze.g gVar = this.channel;
        ze.f fVar = this.callOptions;
        fVar.getClass();
        ze.d dVarB = ze.f.b(fVar);
        dVarB.f11337c = str;
        return build(gVar, new ze.f(dVarB));
    }

    public final e withDeadline(z zVar) {
        ze.g gVar = this.channel;
        ze.f fVar = this.callOptions;
        fVar.getClass();
        ze.d dVarB = ze.f.b(fVar);
        dVarB.f11335a = zVar;
        return build(gVar, new ze.f(dVarB));
    }

    public final e withDeadlineAfter(long j8, TimeUnit timeUnit) {
        ze.g gVar = this.channel;
        ze.f fVar = this.callOptions;
        fVar.getClass();
        z zVarA = z.a(j8, timeUnit, z.f11480d);
        ze.d dVarB = ze.f.b(fVar);
        dVarB.f11335a = zVarA;
        return build(gVar, new ze.f(dVarB));
    }

    public final e withExecutor(Executor executor) {
        ze.g gVar = this.channel;
        ze.f fVar = this.callOptions;
        fVar.getClass();
        ze.d dVarB = ze.f.b(fVar);
        dVarB.f11336b = executor;
        return build(gVar, new ze.f(dVarB));
    }

    public final e withInterceptors(ze.k... kVarArr) {
        ze.g gVar = this.channel;
        List listAsList = Arrays.asList(kVarArr);
        v8.i(gVar, "channel");
        Iterator it = listAsList.iterator();
        if (!it.hasNext()) {
            return build(gVar, this.callOptions);
        }
        if (it.next() != null) {
            throw new ClassCastException();
        }
        v8.i(null, "interceptor");
        throw null;
    }

    public final e withMaxInboundMessageSize(int i8) {
        return build(this.channel, this.callOptions.c(i8));
    }

    public final e withMaxOutboundMessageSize(int i8) {
        return build(this.channel, this.callOptions.d(i8));
    }

    public final <T> e withOption(ze.e eVar, T t3) {
        return build(this.channel, this.callOptions.e(eVar, t3));
    }

    public final e withWaitForReady() {
        ze.g gVar = this.channel;
        ze.f fVar = this.callOptions;
        fVar.getClass();
        ze.d dVarB = ze.f.b(fVar);
        dVarB.f = Boolean.TRUE;
        return build(gVar, new ze.f(dVarB));
    }

    public static <T extends e> T newStub(d dVar, ze.g gVar, ze.f fVar) {
        return (T) dVar.newStub(gVar, fVar);
    }
}
