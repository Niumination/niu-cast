package wj;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public interface v extends Closeable {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public vj.h f19348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f19349b = "unknown-authority";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public vj.a f19350c = vj.a.f17046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @gm.j
        public String f19351d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @gm.j
        public vj.q0 f19352e;

        public String a() {
            return this.f19349b;
        }

        public vj.h b() {
            return this.f19348a;
        }

        public vj.a c() {
            return this.f19350c;
        }

        @gm.j
        public vj.q0 d() {
            return this.f19352e;
        }

        @gm.j
        public String e() {
            return this.f19351d;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f19349b.equals(aVar.f19349b) && this.f19350c.equals(aVar.f19350c) && c1.b0.a(this.f19351d, aVar.f19351d) && c1.b0.a(this.f19352e, aVar.f19352e);
        }

        public a f(String str) {
            this.f19349b = (String) c1.h0.F(str, "authority");
            return this;
        }

        public a g(vj.h hVar) {
            this.f19348a = hVar;
            return this;
        }

        public a h(vj.a aVar) {
            c1.h0.F(aVar, "eagAttributes");
            this.f19350c = aVar;
            return this;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f19349b, this.f19350c, this.f19351d, this.f19352e});
        }

        public a i(@gm.j vj.q0 q0Var) {
            this.f19352e = q0Var;
            return this;
        }

        public a j(@gm.j String str) {
            this.f19351d = str;
            return this;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v f19353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.j
        public final vj.d f19354b;

        public b(v vVar, @gm.j vj.d dVar) {
            this.f19353a = (v) c1.h0.F(vVar, "transportFactory");
            this.f19354b = dVar;
        }
    }

    x D(SocketAddress socketAddress, a aVar, vj.h hVar);

    @gm.j
    @gm.c
    b E1(vj.g gVar);

    Collection<Class<? extends SocketAddress>> a2();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    ScheduledExecutorService m();
}
