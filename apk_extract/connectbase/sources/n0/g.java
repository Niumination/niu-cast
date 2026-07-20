package n0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, List<v0.d>> f10936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, k> f10937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, s0.d> f10938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<s0.i> f10939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SparseArrayCompat<s0.e> f10940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LongSparseArray<v0.d> f10941h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<v0.d> f10942i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Rect f10943j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f10944k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f10945l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f10946m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10947n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f10934a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f10935b = new HashSet<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10948o = 0;

    @Deprecated
    public static class b {

        public static final class a implements l<g>, n0.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final r f10949a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f10950b;

            @Override // n0.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(g gVar) {
                if (this.f10950b) {
                    return;
                }
                this.f10949a.a(gVar);
            }

            @Override // n0.b
            public void cancel() {
                this.f10950b = true;
            }

            public a(r rVar) {
                this.f10950b = false;
                this.f10949a = rVar;
            }
        }

        @Deprecated
        public static n0.b a(Context context, String str, r rVar) {
            a aVar = new a(rVar);
            h.e(context, str).f(aVar);
            return aVar;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g b(Context context, String str) {
            return h.g(context, str).f11070a;
        }

        @Deprecated
        public static n0.b c(InputStream inputStream, r rVar) {
            a aVar = new a(rVar);
            h.j(inputStream, null).f(aVar);
            return aVar;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g d(InputStream inputStream) {
            return h.k(inputStream, null).f11070a;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g e(InputStream inputStream, boolean z10) {
            if (z10) {
                z0.d.e("Lottie now auto-closes input stream!");
            }
            return h.k(inputStream, null).f11070a;
        }

        @Deprecated
        public static n0.b f(y0.c cVar, r rVar) {
            a aVar = new a(rVar);
            h.m(cVar, null).f(aVar);
            return aVar;
        }

        @Deprecated
        public static n0.b g(String str, r rVar) {
            a aVar = new a(rVar);
            h.p(str, null).f(aVar);
            return aVar;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g h(Resources resources, JSONObject jSONObject) {
            return h.r(jSONObject, null).f11070a;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g i(String str) {
            return h.q(str, null).f11070a;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g j(y0.c cVar) {
            return h.n(cVar, null).f11070a;
        }

        @Deprecated
        public static n0.b k(Context context, @RawRes int i10, r rVar) {
            a aVar = new a(rVar);
            h.s(context, i10).f(aVar);
            return aVar;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        z0.d.e(str);
        this.f10935b.add(str);
    }

    public Rect b() {
        return this.f10943j;
    }

    public SparseArrayCompat<s0.e> c() {
        return this.f10940g;
    }

    public float d() {
        return (long) ((e() / this.f10946m) * 1000.0f);
    }

    public float e() {
        return this.f10945l - this.f10944k;
    }

    public float f() {
        return this.f10945l;
    }

    public Map<String, s0.d> g() {
        return this.f10938e;
    }

    public float h() {
        return this.f10946m;
    }

    public Map<String, k> i() {
        return this.f10937d;
    }

    public List<v0.d> j() {
        return this.f10942i;
    }

    @Nullable
    public s0.i k(String str) {
        int size = this.f10939f.size();
        for (int i10 = 0; i10 < size; i10++) {
            s0.i iVar = this.f10939f.get(i10);
            if (iVar.a(str)) {
                return iVar;
            }
        }
        return null;
    }

    public List<s0.i> l() {
        return this.f10939f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int m() {
        return this.f10948o;
    }

    public s n() {
        return this.f10934a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<v0.d> o(String str) {
        return this.f10936c.get(str);
    }

    public float p() {
        return this.f10944k;
    }

    public ArrayList<String> q() {
        HashSet<String> hashSet = this.f10935b;
        return new ArrayList<>(Arrays.asList(hashSet.toArray(new String[hashSet.size()])));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean r() {
        return this.f10947n;
    }

    public boolean s() {
        return !this.f10937d.isEmpty();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void t(int i10) {
        this.f10948o += i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("LottieComposition:\n");
        Iterator<v0.d> it = this.f10942i.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().w("\t"));
        }
        return sb2.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void u(Rect rect, float f10, float f11, float f12, List<v0.d> list, LongSparseArray<v0.d> longSparseArray, Map<String, List<v0.d>> map, Map<String, k> map2, SparseArrayCompat<s0.e> sparseArrayCompat, Map<String, s0.d> map3, List<s0.i> list2) {
        this.f10943j = rect;
        this.f10944k = f10;
        this.f10945l = f11;
        this.f10946m = f12;
        this.f10942i = list;
        this.f10941h = longSparseArray;
        this.f10936c = map;
        this.f10937d = map2;
        this.f10940g = sparseArrayCompat;
        this.f10938e = map3;
        this.f10939f = list2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public v0.d v(long j10) {
        return this.f10941h.get(j10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void w(boolean z10) {
        this.f10947n = z10;
    }

    public void x(boolean z10) {
        this.f10934a.g(z10);
    }
}
