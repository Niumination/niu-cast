package vj;

import androidx.core.app.NotificationCompat;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@e0("https://github.com/grpc/grpc-java/issues/1770")
public abstract class x1 {

    public class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f17512a;

        public a(f fVar) {
            this.f17512a = fVar;
        }

        @Override // vj.x1.e, vj.x1.f
        public void a(y2 y2Var) {
            this.f17512a.a(y2Var);
        }

        @Override // vj.x1.e
        public void c(g gVar) {
            this.f17512a.b(gVar.f17533a, gVar.f17534b);
        }
    }

    @e0("https://github.com/grpc/grpc-java/issues/1770")
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g2 f17515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c3 f17516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final i f17517d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @gm.j
        public final ScheduledExecutorService f17518e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @gm.j
        public final vj.h f17519f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @gm.j
        public final Executor f17520g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @gm.j
        public final String f17521h;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Integer f17522a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public g2 f17523b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public c3 f17524c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public i f17525d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public ScheduledExecutorService f17526e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public vj.h f17527f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public Executor f17528g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String f17529h;

            public b a() {
                return new b(this.f17522a, this.f17523b, this.f17524c, this.f17525d, this.f17526e, this.f17527f, this.f17528g, this.f17529h);
            }

            @e0("https://github.com/grpc/grpc-java/issues/6438")
            public a b(vj.h hVar) {
                hVar.getClass();
                this.f17527f = hVar;
                return this;
            }

            public a c(int i10) {
                this.f17522a = Integer.valueOf(i10);
                return this;
            }

            public a d(Executor executor) {
                this.f17528g = executor;
                return this;
            }

            @e0("https://github.com/grpc/grpc-java/issues/9406")
            public a e(String str) {
                this.f17529h = str;
                return this;
            }

            public a f(g2 g2Var) {
                g2Var.getClass();
                this.f17523b = g2Var;
                return this;
            }

            @e0("https://github.com/grpc/grpc-java/issues/6454")
            public a g(ScheduledExecutorService scheduledExecutorService) {
                scheduledExecutorService.getClass();
                this.f17526e = scheduledExecutorService;
                return this;
            }

            public a h(i iVar) {
                iVar.getClass();
                this.f17525d = iVar;
                return this;
            }

            public a i(c3 c3Var) {
                c3Var.getClass();
                this.f17524c = c3Var;
                return this;
            }
        }

        public /* synthetic */ b(Integer num, g2 g2Var, c3 c3Var, i iVar, ScheduledExecutorService scheduledExecutorService, vj.h hVar, Executor executor, String str, a aVar) {
            this(num, g2Var, c3Var, iVar, scheduledExecutorService, hVar, executor, str);
        }

        public static a i() {
            return new a();
        }

        @e0("https://github.com/grpc/grpc-java/issues/6438")
        public vj.h a() {
            vj.h hVar = this.f17519f;
            if (hVar != null) {
                return hVar;
            }
            throw new IllegalStateException("ChannelLogger is not set in Builder");
        }

        public int b() {
            return this.f17514a;
        }

        @gm.j
        public Executor c() {
            return this.f17520g;
        }

        @gm.j
        @e0("https://github.com/grpc/grpc-java/issues/9406")
        public String d() {
            return this.f17521h;
        }

        public g2 e() {
            return this.f17515b;
        }

        @e0("https://github.com/grpc/grpc-java/issues/6454")
        public ScheduledExecutorService f() {
            ScheduledExecutorService scheduledExecutorService = this.f17518e;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService;
            }
            throw new IllegalStateException("ScheduledExecutorService not set in Builder");
        }

        public i g() {
            return this.f17517d;
        }

        public c3 h() {
            return this.f17516c;
        }

        public a j() {
            a aVar = new a();
            aVar.c(this.f17514a);
            aVar.f(this.f17515b);
            aVar.i(this.f17516c);
            aVar.h(this.f17517d);
            aVar.g(this.f17518e);
            aVar.b(this.f17519f);
            aVar.f17528g = this.f17520g;
            aVar.f17529h = this.f17521h;
            return aVar;
        }

        public String toString() {
            return c1.z.c(this).d("defaultPort", this.f17514a).j("proxyDetector", this.f17515b).j("syncContext", this.f17516c).j("serviceConfigParser", this.f17517d).j("scheduledExecutorService", this.f17518e).j("channelLogger", this.f17519f).j("executor", this.f17520g).j("overrideAuthority", this.f17521h).toString();
        }

        public b(Integer num, g2 g2Var, c3 c3Var, i iVar, @gm.j ScheduledExecutorService scheduledExecutorService, @gm.j vj.h hVar, @gm.j Executor executor, @gm.j String str) {
            this.f17514a = ((Integer) c1.h0.F(num, "defaultPort not set")).intValue();
            this.f17515b = (g2) c1.h0.F(g2Var, "proxyDetector not set");
            this.f17516c = (c3) c1.h0.F(c3Var, "syncContext not set");
            this.f17517d = (i) c1.h0.F(iVar, "serviceConfigParser not set");
            this.f17518e = scheduledExecutorService;
            this.f17519f = hVar;
            this.f17520g = executor;
            this.f17521h = str;
        }
    }

    @e0("https://github.com/grpc/grpc-java/issues/1770")
    public static abstract class d {
        public abstract String a();

        public abstract x1 b(URI uri, b bVar);
    }

    @e0("https://github.com/grpc/grpc-java/issues/1770")
    public static abstract class e implements f {
        @Override // vj.x1.f
        public abstract void a(y2 y2Var);

        @Override // vj.x1.f
        @t1.l(imports = {"io.grpc.NameResolver.ResolutionResult"}, replacement = "this.onResult(ResolutionResult.newBuilder().setAddresses(servers).setAttributes(attributes).build())")
        @Deprecated
        public final void b(List<d0> list, vj.a aVar) {
            g.a aVar2 = new g.a();
            aVar2.f17536a = list;
            aVar2.f17537b = aVar;
            c(aVar2.a());
        }

        public abstract void c(g gVar);
    }

    @hm.d
    @e0("https://github.com/grpc/grpc-java/issues/1770")
    public interface f {
        void a(y2 y2Var);

        void b(List<d0> list, vj.a aVar);
    }

    @e0("https://github.com/grpc/grpc-java/issues/1770")
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<d0> f17533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vj.a f17534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.j
        public final c f17535c;

        @e0("https://github.com/grpc/grpc-java/issues/1770")
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List<d0> f17536a = Collections.emptyList();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public vj.a f17537b = vj.a.f17046c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @gm.j
            public c f17538c;

            public g a() {
                return new g(this.f17536a, this.f17537b, this.f17538c);
            }

            public a b(List<d0> list) {
                this.f17536a = list;
                return this;
            }

            public a c(vj.a aVar) {
                this.f17537b = aVar;
                return this;
            }

            public a d(@gm.j c cVar) {
                this.f17538c = cVar;
                return this;
            }
        }

        public g(List<d0> list, vj.a aVar, c cVar) {
            this.f17533a = Collections.unmodifiableList(new ArrayList(list));
            this.f17534b = (vj.a) c1.h0.F(aVar, "attributes");
            this.f17535c = cVar;
        }

        public static a d() {
            return new a();
        }

        public List<d0> a() {
            return this.f17533a;
        }

        public vj.a b() {
            return this.f17534b;
        }

        @gm.j
        public c c() {
            return this.f17535c;
        }

        public a e() {
            a aVar = new a();
            aVar.f17536a = this.f17533a;
            aVar.f17537b = this.f17534b;
            aVar.f17538c = this.f17535c;
            return aVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return c1.b0.a(this.f17533a, gVar.f17533a) && c1.b0.a(this.f17534b, gVar.f17534b) && c1.b0.a(this.f17535c, gVar.f17535c);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f17533a, this.f17534b, this.f17535c});
        }

        public String toString() {
            return c1.z.c(this).j("addresses", this.f17533a).j("attributes", this.f17534b).j(wj.f0.f18629w, this.f17535c).toString();
        }
    }

    @e0("https://github.com/grpc/grpc-java/issues/4972")
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface h {
    }

    @e0("https://github.com/grpc/grpc-java/issues/1770")
    public static abstract class i {
        public abstract c a(Map<String, ?> map);
    }

    public abstract String a();

    public void b() {
    }

    public abstract void c();

    public void d(e eVar) {
        e(eVar);
    }

    public void e(f fVar) {
        if (fVar instanceof e) {
            d((e) fVar);
        } else {
            d(new a(fVar));
        }
    }

    @e0("https://github.com/grpc/grpc-java/issues/1770")
    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ boolean f17530c = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y2 f17531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f17532b;

        public c(Object obj) {
            this.f17532b = c1.h0.F(obj, "config");
            this.f17531a = null;
        }

        public static c a(Object obj) {
            return new c(obj);
        }

        public static c b(y2 y2Var) {
            return new c(y2Var);
        }

        @gm.j
        public Object c() {
            return this.f17532b;
        }

        @gm.j
        public y2 d() {
            return this.f17531a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return c1.b0.a(this.f17531a, cVar.f17531a) && c1.b0.a(this.f17532b, cVar.f17532b);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f17531a, this.f17532b});
        }

        public String toString() {
            return this.f17532b != null ? c1.z.c(this).j("config", this.f17532b).toString() : c1.z.c(this).j("error", this.f17531a).toString();
        }

        public c(y2 y2Var) {
            this.f17532b = null;
            this.f17531a = (y2) c1.h0.F(y2Var, NotificationCompat.CATEGORY_STATUS);
            c1.h0.u(!y2Var.r(), "cannot use OK status: %s", y2Var);
        }
    }
}
