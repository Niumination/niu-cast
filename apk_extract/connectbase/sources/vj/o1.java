package vj;

import androidx.core.app.NotificationCompat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@hm.c
@e0("https://github.com/grpc/grpc-java/issues/1771")
public abstract class o1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @t0
    public static final vj.a.c<Map<String, ?>> f17196b = new vj.a.c<>("internal:health-checking-config");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @t0
    public static final b.C0454b<l> f17197c = b.C0454b.b("internal:health-check-consumer-listener");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @t0
    public static final vj.a.c<Boolean> f17198d = new vj.a.c<>("internal:has-health-check-producer-listener");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final vj.a.c<Boolean> f17199e = new vj.a.c<>("io.grpc.IS_PETIOLE_POLICY");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final k f17200f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17201a;

    public class a extends k {
        @Override // vj.o1.k
        public g a(h hVar) {
            return g.g();
        }

        public String toString() {
            return "EMPTY_PICKER";
        }
    }

    @e0("https://github.com/grpc/grpc-java/issues/1771")
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<d0> f17202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vj.a f17203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object[][] f17204c;

        @e0("https://github.com/grpc/grpc-java/issues/1771")
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List<d0> f17205a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public vj.a f17206b = vj.a.f17046c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object[][] f17207c = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);

            public <T> a b(C0454b<T> c0454b, T t10) {
                c1.h0.F(c0454b, cb.b.c.f1408o);
                c1.h0.F(t10, "value");
                int length = 0;
                while (true) {
                    Object[][] objArr = this.f17207c;
                    if (length >= objArr.length) {
                        length = -1;
                        break;
                    }
                    if (c0454b.equals(objArr[length][0])) {
                        break;
                    }
                    length++;
                }
                if (length == -1) {
                    Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f17207c.length + 1, 2);
                    Object[][] objArr3 = this.f17207c;
                    System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                    this.f17207c = objArr2;
                    length = objArr2.length - 1;
                }
                this.f17207c[length] = new Object[]{c0454b, t10};
                return this;
            }

            public b c() {
                return new b(this.f17205a, this.f17206b, this.f17207c);
            }

            public final a d(Object[][] objArr) {
                Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, objArr.length, 2);
                this.f17207c = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                return this;
            }

            public a e(List<d0> list) {
                c1.h0.e(!list.isEmpty(), "addrs is empty");
                this.f17205a = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public a f(d0 d0Var) {
                this.f17205a = Collections.singletonList(d0Var);
                return this;
            }

            public a g(vj.a aVar) {
                this.f17206b = (vj.a) c1.h0.F(aVar, "attrs");
                return this;
            }
        }

        /* JADX INFO: renamed from: vj.o1$b$b, reason: collision with other inner class name */
        @e0("https://github.com/grpc/grpc-java/issues/1771")
        public static final class C0454b<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f17208a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final T f17209b;

            public C0454b(String str, T t10) {
                this.f17208a = str;
                this.f17209b = t10;
            }

            public static <T> C0454b<T> b(String str) {
                c1.h0.F(str, "debugString");
                return new C0454b<>(str, null);
            }

            public static <T> C0454b<T> c(String str, T t10) {
                c1.h0.F(str, "debugString");
                return new C0454b<>(str, t10);
            }

            public T d() {
                return this.f17209b;
            }

            public String toString() {
                return this.f17208a;
            }
        }

        public /* synthetic */ b(List list, vj.a aVar, Object[][] objArr, a aVar2) {
            this(list, aVar, objArr);
        }

        public static a d() {
            return new a();
        }

        public List<d0> a() {
            return this.f17202a;
        }

        public vj.a b() {
            return this.f17203b;
        }

        public <T> T c(C0454b<T> c0454b) {
            c1.h0.F(c0454b, cb.b.c.f1408o);
            int i10 = 0;
            while (true) {
                Object[][] objArr = this.f17204c;
                if (i10 >= objArr.length) {
                    return c0454b.f17209b;
                }
                if (c0454b.equals(objArr[i10][0])) {
                    return (T) this.f17204c[i10][1];
                }
                i10++;
            }
        }

        public a e() {
            return new a().e(this.f17202a).g(this.f17203b).d(this.f17204c);
        }

        public String toString() {
            return c1.z.c(this).j("addrs", this.f17202a).j("attrs", this.f17203b).j("customOptions", Arrays.deepToString(this.f17204c)).toString();
        }

        public b(List<d0> list, vj.a aVar, Object[][] objArr) {
            this.f17202a = (List) c1.h0.F(list, "addresses are not set");
            this.f17203b = (vj.a) c1.h0.F(aVar, "attrs");
            this.f17204c = (Object[][]) c1.h0.F(objArr, "customOptions");
        }
    }

    @Deprecated
    public static final class c extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y2 f17210a;

        public c(y2 y2Var) {
            this.f17210a = (y2) c1.h0.F(y2Var, "error");
        }

        @Override // vj.o1.k
        public g a(h hVar) {
            return g.f(this.f17210a);
        }

        public String toString() {
            return c1.z.c(this).j("error", this.f17210a).toString();
        }
    }

    @hm.d
    @e0("https://github.com/grpc/grpc-java/issues/1771")
    public static abstract class d {
        public abstract o1 a(f fVar);
    }

    public static final class e extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f17211a;

        public e(g gVar) {
            this.f17211a = (g) c1.h0.F(gVar, "result");
        }

        @Override // vj.o1.k
        public g a(h hVar) {
            return this.f17211a;
        }

        public String toString() {
            return "FixedResultPicker(" + this.f17211a + ")";
        }
    }

    @hm.d
    @e0("https://github.com/grpc/grpc-java/issues/1771")
    public static abstract class f {
        public r1 a(List<d0> list, String str) {
            throw new UnsupportedOperationException();
        }

        public abstract r1 b(d0 d0Var, String str);

        public r1 c(String str) {
            return d(str).b();
        }

        @Deprecated
        public s1<?> d(String str) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public s1<?> e(String str, vj.g gVar) {
            throw new UnsupportedOperationException();
        }

        public j f(b bVar) {
            throw new UnsupportedOperationException();
        }

        public abstract String g();

        public vj.g h() {
            return n().a();
        }

        public vj.h i() {
            throw new UnsupportedOperationException();
        }

        public x1.b j() {
            throw new UnsupportedOperationException();
        }

        public z1 k() {
            throw new UnsupportedOperationException();
        }

        public ScheduledExecutorService l() {
            throw new UnsupportedOperationException();
        }

        public c3 m() {
            throw new UnsupportedOperationException();
        }

        public vj.g n() {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        @e0("https://github.com/grpc/grpc-java/issues/8088")
        public void o() {
        }

        public void p() {
            throw new UnsupportedOperationException();
        }

        public abstract void q(@gm.i u uVar, @gm.i k kVar);

        public void r(r1 r1Var, List<d0> list) {
            throw new UnsupportedOperationException();
        }

        public void s(r1 r1Var, d0 d0Var) {
            throw new UnsupportedOperationException();
        }
    }

    @hm.b
    @e0("https://github.com/grpc/grpc-java/issues/1771")
    public static final class g {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final g f17212e = new g(null, null, y2.f17548e, false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.j
        public final j f17213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.j
        public final n.a f17214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final y2 f17215c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f17216d;

        public g(@gm.j j jVar, @gm.j n.a aVar, y2 y2Var, boolean z10) {
            this.f17213a = jVar;
            this.f17214b = aVar;
            this.f17215c = (y2) c1.h0.F(y2Var, NotificationCompat.CATEGORY_STATUS);
            this.f17216d = z10;
        }

        public static g e(y2 y2Var) {
            c1.h0.e(!y2Var.r(), "drop status shouldn't be OK");
            return new g(null, null, y2Var, true);
        }

        public static g f(y2 y2Var) {
            c1.h0.e(!y2Var.r(), "error status shouldn't be OK");
            return new g(null, null, y2Var, false);
        }

        public static g g() {
            return f17212e;
        }

        public static g h(j jVar) {
            return i(jVar, null);
        }

        public static g i(j jVar, @gm.j n.a aVar) {
            return new g((j) c1.h0.F(jVar, "subchannel"), aVar, y2.f17548e, false);
        }

        public y2 a() {
            return this.f17215c;
        }

        @gm.j
        public n.a b() {
            return this.f17214b;
        }

        @gm.j
        public j c() {
            return this.f17213a;
        }

        public boolean d() {
            return this.f17216d;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return c1.b0.a(this.f17213a, gVar.f17213a) && c1.b0.a(this.f17215c, gVar.f17215c) && c1.b0.a(this.f17214b, gVar.f17214b) && this.f17216d == gVar.f17216d;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f17213a, this.f17215c, this.f17214b, Boolean.valueOf(this.f17216d)});
        }

        public String toString() {
            return c1.z.c(this).j("subchannel", this.f17213a).j("streamTracerFactory", this.f17214b).j(NotificationCompat.CATEGORY_STATUS, this.f17215c).g("drop", this.f17216d).toString();
        }
    }

    @e0("https://github.com/grpc/grpc-java/issues/1771")
    public static abstract class h {
        public abstract vj.e a();

        public abstract v1 b();

        public abstract w1<?, ?> c();
    }

    @e0("https://github.com/grpc/grpc-java/issues/1771")
    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<d0> f17217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vj.a f17218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.j
        public final Object f17219c;

        @e0("https://github.com/grpc/grpc-java/issues/1771")
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List<d0> f17220a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public vj.a f17221b = vj.a.f17046c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @gm.j
            public Object f17222c;

            public i a() {
                return new i(this.f17220a, this.f17221b, this.f17222c);
            }

            public a b(List<d0> list) {
                this.f17220a = list;
                return this;
            }

            public a c(vj.a aVar) {
                this.f17221b = aVar;
                return this;
            }

            public a d(@gm.j Object obj) {
                this.f17222c = obj;
                return this;
            }
        }

        public /* synthetic */ i(List list, vj.a aVar, Object obj, a aVar2) {
            this(list, aVar, obj);
        }

        public static a d() {
            return new a();
        }

        public List<d0> a() {
            return this.f17217a;
        }

        public vj.a b() {
            return this.f17218b;
        }

        @gm.j
        public Object c() {
            return this.f17219c;
        }

        public a e() {
            a aVar = new a();
            aVar.f17220a = this.f17217a;
            aVar.f17221b = this.f17218b;
            aVar.f17222c = this.f17219c;
            return aVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return c1.b0.a(this.f17217a, iVar.f17217a) && c1.b0.a(this.f17218b, iVar.f17218b) && c1.b0.a(this.f17219c, iVar.f17219c);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f17217a, this.f17218b, this.f17219c});
        }

        public String toString() {
            return c1.z.c(this).j("addresses", this.f17217a).j("attributes", this.f17218b).j("loadBalancingPolicyConfig", this.f17219c).toString();
        }

        public i(List<d0> list, vj.a aVar, Object obj) {
            this.f17217a = Collections.unmodifiableList(new ArrayList((Collection) c1.h0.F(list, "addresses")));
            this.f17218b = (vj.a) c1.h0.F(aVar, "attributes");
            this.f17219c = obj;
        }
    }

    @e0("https://github.com/grpc/grpc-java/issues/1771")
    public static abstract class j {
        @t0
        public vj.f a() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Code duplicated, block: B:7:0x000f  */
        public final d0 b() {
            boolean z10;
            List<d0> listC = c();
            if (listC != null) {
                z10 = listC.size() == 1;
            }
            c1.h0.x0(z10, "%s does not have exactly one group", listC);
            return listC.get(0);
        }

        public List<d0> c() {
            throw new UnsupportedOperationException();
        }

        public abstract vj.a d();

        public vj.h e() {
            throw new UnsupportedOperationException();
        }

        @t0
        public Object f() {
            throw new UnsupportedOperationException();
        }

        public abstract void g();

        public abstract void h();

        public void i(l lVar) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public void j(List<d0> list) {
            throw new UnsupportedOperationException();
        }
    }

    @hm.d
    @e0("https://github.com/grpc/grpc-java/issues/1771")
    public static abstract class k {
        public abstract g a(h hVar);

        @Deprecated
        public void b() {
        }
    }

    public interface l {
        void a(v vVar);
    }

    public y2 a(i iVar) {
        if (!iVar.f17217a.isEmpty() || b()) {
            int i10 = this.f17201a;
            this.f17201a = i10 + 1;
            if (i10 == 0) {
                d(iVar);
            }
            this.f17201a = 0;
            return y2.f17548e;
        }
        y2 y2VarU = y2.f17563t.u("NameResolver returned no usable address. addrs=" + iVar.f17217a + ", attrs=" + iVar.f17218b);
        c(y2VarU);
        return y2VarU;
    }

    public boolean b() {
        return false;
    }

    public abstract void c(y2 y2Var);

    public void d(i iVar) {
        int i10 = this.f17201a;
        this.f17201a = i10 + 1;
        if (i10 == 0) {
            a(iVar);
        }
        this.f17201a = 0;
    }

    @Deprecated
    public void e(j jVar, v vVar) {
    }

    public void f() {
    }

    public abstract void g();
}
