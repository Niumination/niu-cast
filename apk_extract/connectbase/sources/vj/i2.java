package vj;

import java.io.IOException;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
public abstract class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w.k<i2> f17163a = w.b0("io.grpc.Server");

    public abstract void b() throws InterruptedException;

    public abstract boolean g(long j10, TimeUnit timeUnit) throws InterruptedException;

    @e0("https://github.com/grpc/grpc-java/issues/2222")
    public List<t2> h() {
        return Collections.emptyList();
    }

    public List<? extends SocketAddress> i() {
        throw new UnsupportedOperationException();
    }

    @e0("https://github.com/grpc/grpc-java/issues/2222")
    public List<t2> l() {
        return Collections.emptyList();
    }

    public int o() {
        return -1;
    }

    @e0("https://github.com/grpc/grpc-java/issues/2222")
    public List<t2> p() {
        return Collections.emptyList();
    }

    public abstract boolean q();

    public abstract boolean r();

    public abstract i2 s();

    public abstract i2 t();

    public abstract i2 u() throws IOException;
}
