package j2;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.MotionEvent;
import f2.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kn.l0;
import kn.n0;
import kn.w;
import lm.d0;
import lm.f0;
import lm.l2;
import org.json.JSONObject;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class e implements k2.b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @l
    public static final a f8484m = new a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @l
    public static final String f8485n = "AnimPlayer.MixAnimPlugin";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final f2.g f8486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public h2.b f8487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public h2.c f8488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public k f8489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m
    public j2.b f8490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @m
    public f f8493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public final d0 f8494i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8495j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @l
    public final Object f8496k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8497l;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8498a;

        static {
            int[] iArr = new int[j.d.values().length];
            iArr[j.d.IMG.ordinal()] = 1;
            iArr[j.d.TXT.ordinal()] = 2;
            f8498a = iArr;
        }
    }

    public static final class c extends n0 implements jn.l<Bitmap, l2> {
        final /* synthetic */ j $src;
        final /* synthetic */ e this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(j jVar, e eVar) {
            super(1);
            this.$src = jVar;
            this.this$0 = eVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Bitmap bitmap) {
            invoke2(bitmap);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@m Bitmap bitmap) {
            Bitmap bitmapA;
            j jVar = this.$src;
            if (bitmap == null) {
                l2.a.f9640a.b(e.f8485n, "fetch image " + this.$src.f8533a + " bitmap return null");
                bitmapA = l2.b.f9643a.a();
            } else {
                bitmapA = bitmap;
            }
            jVar.p(bitmapA);
            l2.a aVar = l2.a.f9640a;
            StringBuilder sb2 = new StringBuilder("fetch image ");
            sb2.append(this.$src.f8533a);
            sb2.append(" finish bitmap is ");
            sb2.append(bitmap == null ? null : Integer.valueOf(bitmap.hashCode()));
            aVar.e(e.f8485n, sb2.toString());
            this.this$0.y();
        }
    }

    public static final class d extends n0 implements jn.l<String, l2> {
        final /* synthetic */ j $src;
        final /* synthetic */ e this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(j jVar, e eVar) {
            super(1);
            this.$src = jVar;
            this.this$0 = eVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(String str) {
            invoke2(str);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@m String str) {
            this.$src.B(str == null ? "" : str);
            l2.a.f9640a.e(e.f8485n, "fetch text " + this.$src.f8533a + " finish txt is " + ((Object) str));
            this.this$0.y();
        }
    }

    /* JADX INFO: renamed from: j2.e$e, reason: collision with other inner class name */
    public static final class C0224e extends n0 implements jn.a<h> {
        public C0224e() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @l
        public final h invoke() {
            return new h(e.this);
        }
    }

    public e(@l f2.g gVar) {
        l0.p(gVar, "player");
        this.f8486a = gVar;
        this.f8491f = -1;
        this.f8494i = f0.b(new C0224e());
        this.f8495j = true;
        this.f8496k = new Object();
    }

    private final void k() {
        SparseArray<j2.c> sparseArray;
        HashMap<String, j> map;
        HashMap<String, j> map2;
        Collection<j> collectionValues;
        Bitmap bitmap;
        m();
        f2.a aVar = this.f8486a.f5754r.f5673b;
        if (aVar == null || aVar.f5659i) {
            ArrayList arrayList = new ArrayList();
            k kVar = this.f8489d;
            if (kVar != null && (map2 = kVar.f8551a) != null && (collectionValues = map2.values()) != null) {
                for (j jVar : collectionValues) {
                    f fVar = this.f8493h;
                    if (fVar != null) {
                        fVar.g(jVar.f8545m);
                    }
                    int i10 = b.f8498a[jVar.f8538f.ordinal()];
                    if (i10 == 1) {
                        l0.o(jVar, "src");
                        arrayList.add(new i(jVar));
                    } else if (i10 == 2 && (bitmap = jVar.f8546n) != null) {
                        bitmap.recycle();
                    }
                }
            }
            h2.b bVar = this.f8487b;
            if (bVar != null) {
                bVar.c(arrayList);
            }
            this.f8491f = -1;
            k kVar2 = this.f8489d;
            if (kVar2 != null && (map = kVar2.f8551a) != null) {
                map.clear();
            }
            j2.b bVar2 = this.f8490e;
            if (bVar2 == null || (sparseArray = bVar2.f8479a) == null) {
                return;
            }
            sparseArray.clear();
        }
    }

    public static final void v(e eVar, i iVar) {
        l0.p(eVar, "this$0");
        l0.p(iVar, "$resource");
        h2.c cVar = eVar.f8488c;
        if (cVar == null) {
            return;
        }
        cVar.a(iVar);
    }

    public final void A(int i10) {
        this.f8491f = i10;
    }

    public final void B(@m j2.b bVar) {
        this.f8490e = bVar;
    }

    public final void C(@m h2.c cVar) {
        this.f8488c = cVar;
    }

    public final void D(@m h2.b bVar) {
        this.f8487b = bVar;
    }

    public final void E(@m k kVar) {
        this.f8489d = kVar;
    }

    @Override // k2.b
    public void a(int i10) {
        SparseArray<j2.c> sparseArray;
        j2.c cVar;
        HashMap<String, j> map;
        f fVar;
        f2.a aVar = this.f8486a.f5754r.f5673b;
        if (aVar != null && aVar.f5659i) {
            this.f8491f = i10;
            j2.b bVar = this.f8490e;
            ArrayList<j2.a> arrayList = (bVar == null || (sparseArray = bVar.f8479a) == null || (cVar = sparseArray.get(i10)) == null) ? null : cVar.f8481b;
            if (arrayList == null) {
                return;
            }
            for (j2.a aVar2 : arrayList) {
                k kVar = this.f8489d;
                j jVar = (kVar == null || (map = kVar.f8551a) == null) ? null : map.get(aVar2.f8474b);
                if (jVar != null && (fVar = this.f8493h) != null) {
                    fVar.h(aVar, aVar2, jVar);
                }
            }
        }
    }

    @Override // k2.b
    public void b() {
        k();
    }

    @Override // k2.b
    public boolean c(@l MotionEvent motionEvent) {
        l0.p(motionEvent, "ev");
        f2.a aVar = this.f8486a.f5754r.f5673b;
        if (!(aVar == null || aVar.f5659i) || this.f8488c == null) {
            return k2.b.a.d(this, motionEvent);
        }
        final i iVarB = q().b(motionEvent);
        if (iVarB == null) {
            return true;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: j2.d
            @Override // java.lang.Runnable
            public final void run() {
                e.v(this.f8482a, iVarB);
            }
        });
        return true;
    }

    @Override // k2.b
    public void d() {
        k();
    }

    @Override // k2.b
    public int e(@l f2.a aVar) {
        HashMap<String, j> map;
        Collection<j> collectionValues;
        l0.p(aVar, "config");
        if (!aVar.f5659i) {
            return 0;
        }
        if (this.f8487b == null) {
            l2.a.f9640a.b(f8485n, "IFetchResource is empty");
            return 0;
        }
        x(aVar);
        w(aVar);
        l();
        if (!j()) {
            return o.f5791p;
        }
        l2.a.f9640a.e(f8485n, l0.C("load resource ", Integer.valueOf(this.f8492g)));
        k kVar = this.f8489d;
        if (kVar != null && (map = kVar.f8551a) != null && (collectionValues = map.values()) != null) {
            for (j jVar : collectionValues) {
                Bitmap bitmap = jVar.f8546n;
                if (bitmap == null) {
                    l2.a.f9640a.b(f8485n, l0.C("missing src ", jVar));
                    return o.f5791p;
                }
                if ((bitmap == null ? null : bitmap.getConfig()) == Bitmap.Config.ALPHA_8) {
                    l2.a.f9640a.b(f8485n, "src " + jVar + " bitmap must not be ALPHA_8");
                    return o.f5791p;
                }
            }
        }
        return 0;
    }

    @Override // k2.b
    public void f(int i10) {
    }

    @Override // k2.b
    public void g() {
        f2.a aVar = this.f8486a.f5754r.f5673b;
        if (aVar == null || aVar.f5659i) {
            l2.a.f9640a.e(f8485n, "mix render init");
            f fVar = new f(this);
            this.f8493h = fVar;
            fVar.f();
        }
    }

    public final boolean j() {
        HashMap<String, j> map;
        Collection<j> collectionValues;
        try {
            k kVar = this.f8489d;
            if (kVar != null && (map = kVar.f8551a) != null && (collectionValues = map.values()) != null) {
                for (j jVar : collectionValues) {
                    if (jVar.f8538f == j.d.TXT) {
                        l2.b bVar = l2.b.f9643a;
                        l0.o(jVar, "src");
                        jVar.p(bVar.b(jVar));
                    }
                }
            }
            return true;
        } catch (OutOfMemoryError e10) {
            l2.a.f9640a.c(f8485n, l0.C("draw text OOM ", e10), e10);
            return false;
        }
    }

    public final void l() {
        HashMap<String, j> map;
        HashMap<String, j> map2;
        Collection<j> collectionValues;
        synchronized (this.f8496k) {
            this.f8497l = false;
            l2 l2Var = l2.f10208a;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        k kVar = this.f8489d;
        int size = (kVar == null || (map = kVar.f8551a) == null) ? 0 : map.size();
        l2.a.f9640a.e(f8485n, l0.C("load resource totalSrc = ", Integer.valueOf(size)));
        this.f8492g = 0;
        k kVar2 = this.f8489d;
        if (kVar2 != null && (map2 = kVar2.f8551a) != null && (collectionValues = map2.values()) != null) {
            for (j jVar : collectionValues) {
                j.d dVar = jVar.f8538f;
                if (dVar == j.d.IMG) {
                    l2.a.f9640a.e(f8485n, l0.C("fetch image ", jVar.f8533a));
                    h2.b bVar = this.f8487b;
                    if (bVar != null) {
                        l0.o(jVar, "src");
                        bVar.a(new i(jVar), new c(jVar, this));
                    }
                } else if (dVar == j.d.TXT) {
                    l2.a.f9640a.e(f8485n, l0.C("fetch txt ", jVar.f8533a));
                    h2.b bVar2 = this.f8487b;
                    if (bVar2 != null) {
                        l0.o(jVar, "src");
                        bVar2.b(new i(jVar), new d(jVar, this));
                    }
                }
            }
        }
        synchronized (this.f8496k) {
            while (this.f8492g < size && !this.f8497l) {
                try {
                    this.f8496k.wait();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            l2 l2Var2 = l2.f10208a;
        }
        l2.a.f9640a.e(f8485n, "fetchResourceSync cost=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms");
    }

    public final void m() {
        synchronized (this.f8496k) {
            this.f8497l = true;
            this.f8496k.notifyAll();
            l2 l2Var = l2.f10208a;
        }
    }

    public final boolean n() {
        return this.f8495j;
    }

    public final int o() {
        return this.f8491f;
    }

    @m
    public final j2.b p() {
        return this.f8490e;
    }

    public final h q() {
        return (h) this.f8494i.getValue();
    }

    @l
    public final f2.g r() {
        return this.f8486a;
    }

    @m
    public final h2.c s() {
        return this.f8488c;
    }

    @m
    public final h2.b t() {
        return this.f8487b;
    }

    @m
    public final k u() {
        return this.f8489d;
    }

    public final void w(f2.a aVar) {
        JSONObject jSONObject = aVar.f5665o;
        if (jSONObject == null) {
            return;
        }
        this.f8490e = new j2.b(jSONObject);
    }

    public final void x(f2.a aVar) {
        JSONObject jSONObject = aVar.f5665o;
        if (jSONObject == null) {
            return;
        }
        this.f8489d = new k(jSONObject);
    }

    public final void y() {
        synchronized (this.f8496k) {
            this.f8492g++;
            this.f8496k.notifyAll();
            l2 l2Var = l2.f10208a;
        }
    }

    public final void z(boolean z10) {
        this.f8495j = z10;
    }
}
