package wj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class e2 extends vj.o1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vj.o1.f f18592g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public vj.o1.j f18593h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public vj.u f18594i = vj.u.IDLE;

    public class a implements vj.o1.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.o1.j f18595a;

        public a(vj.o1.j jVar) {
            this.f18595a = jVar;
        }

        @Override // vj.o1.l
        public void a(vj.v vVar) {
            e2.this.j(this.f18595a, vVar);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18597a;

        static {
            int[] iArr = new int[vj.u.values().length];
            f18597a = iArr;
            try {
                iArr[vj.u.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18597a[vj.u.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18597a[vj.u.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18597a[vj.u.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.j
        public final Boolean f18598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.j
        public final Long f18599b;

        public c(@gm.j Boolean bool) {
            this(bool, null);
        }

        public c(@gm.j Boolean bool, @gm.j Long l10) {
            this.f18598a = bool;
            this.f18599b = l10;
        }
    }

    public static final class d extends vj.o1.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.o1.g f18600a;

        public d(vj.o1.g gVar) {
            this.f18600a = (vj.o1.g) c1.h0.F(gVar, "result");
        }

        @Override // vj.o1.k
        public vj.o1.g a(vj.o1.h hVar) {
            return this.f18600a;
        }

        public String toString() {
            return c1.z.b(d.class).j("result", this.f18600a).toString();
        }
    }

    public final class e extends vj.o1.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.o1.j f18601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f18602b = new AtomicBoolean(false);

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f18601a.g();
            }
        }

        public e(vj.o1.j jVar) {
            this.f18601a = (vj.o1.j) c1.h0.F(jVar, "subchannel");
        }

        @Override // vj.o1.k
        public vj.o1.g a(vj.o1.h hVar) {
            if (this.f18602b.compareAndSet(false, true)) {
                e2.this.f18592g.m().execute(new a());
            }
            return vj.o1.g.g();
        }
    }

    public e2(vj.o1.f fVar) {
        this.f18592g = (vj.o1.f) c1.h0.F(fVar, "helper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(vj.o1.j jVar, vj.v vVar) {
        vj.o1.k eVar;
        vj.o1.k dVar;
        vj.u uVar = vVar.f17279a;
        if (uVar == vj.u.SHUTDOWN) {
            return;
        }
        vj.u uVar2 = vj.u.TRANSIENT_FAILURE;
        if (uVar == uVar2 || uVar == vj.u.IDLE) {
            this.f18592g.p();
        }
        if (this.f18594i == uVar2) {
            if (uVar == vj.u.CONNECTING) {
                return;
            }
            if (uVar == vj.u.IDLE) {
                f();
                return;
            }
        }
        int i10 = b.f18597a[uVar.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                dVar = new d(vj.o1.g.g());
            } else if (i10 == 3) {
                eVar = new d(vj.o1.g.h(jVar));
            } else {
                if (i10 != 4) {
                    throw new IllegalArgumentException("Unsupported state:" + uVar);
                }
                dVar = new d(vj.o1.g.f(vVar.f17280b));
            }
            k(uVar, dVar);
        }
        eVar = new e(jVar);
        dVar = eVar;
        k(uVar, dVar);
    }

    private void k(vj.u uVar, vj.o1.k kVar) {
        this.f18594i = uVar;
        this.f18592g.q(uVar, kVar);
    }

    @Override // vj.o1
    public vj.y2 a(vj.o1.i iVar) {
        c cVar;
        Boolean bool;
        List<vj.d0> list = iVar.f17217a;
        if (list.isEmpty()) {
            vj.y2 y2VarU = vj.y2.f17563t.u("NameResolver returned no usable address. addrs=" + iVar.f17217a + ", attrs=" + iVar.f17218b);
            c(y2VarU);
            return y2VarU;
        }
        Object obj = iVar.f17219c;
        if ((obj instanceof c) && (bool = (cVar = (c) obj).f18598a) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(list);
            Collections.shuffle(arrayList, cVar.f18599b != null ? new Random(cVar.f18599b.longValue()) : new Random());
            list = arrayList;
        }
        vj.o1.j jVar = this.f18593h;
        if (jVar == null) {
            vj.o1.j jVarF = this.f18592g.f(new vj.o1.b.a().e(list).c());
            jVarF.i(new a(jVarF));
            this.f18593h = jVarF;
            k(vj.u.CONNECTING, new d(vj.o1.g.h(jVarF)));
            jVarF.g();
        } else {
            jVar.j(list);
        }
        return vj.y2.f17548e;
    }

    @Override // vj.o1
    public void c(vj.y2 y2Var) {
        vj.o1.j jVar = this.f18593h;
        if (jVar != null) {
            jVar.h();
            this.f18593h = null;
        }
        k(vj.u.TRANSIENT_FAILURE, new d(vj.o1.g.f(y2Var)));
    }

    @Override // vj.o1
    public void f() {
        vj.o1.j jVar = this.f18593h;
        if (jVar != null) {
            jVar.g();
        }
    }

    @Override // vj.o1
    public void g() {
        vj.o1.j jVar = this.f18593h;
        if (jVar != null) {
            jVar.h();
        }
    }
}
