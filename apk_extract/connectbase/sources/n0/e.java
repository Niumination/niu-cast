package n0;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f10921a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10922b = "LOTTIE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10923c = 20;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f10924d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String[] f10925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long[] f10926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f10927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f10928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static w0.f f10929i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static w0.e f10930j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile w0.h f10931k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile w0.g f10932l;

    public class a implements w0.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f10933a;

        public a(Context context) {
            this.f10933a = context;
        }

        @Override // w0.e
        @NonNull
        public File a() {
            return new File(this.f10933a.getCacheDir(), "lottie_network_cache");
        }
    }

    public static void a(String str) {
        if (f10924d) {
            int i10 = f10927g;
            if (i10 == 20) {
                f10928h++;
                return;
            }
            f10925e[i10] = str;
            f10926f[i10] = System.nanoTime();
            TraceCompat.beginSection(str);
            f10927g++;
        }
    }

    public static float b(String str) {
        int i10 = f10928h;
        if (i10 > 0) {
            f10928h = i10 - 1;
            return 0.0f;
        }
        if (!f10924d) {
            return 0.0f;
        }
        int i11 = f10927g - 1;
        f10927g = i11;
        if (i11 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(f10925e[i11])) {
            throw new IllegalStateException(j.c.a(e.a.a("Unbalanced trace call ", str, ". Expected "), f10925e[f10927g], "."));
        }
        TraceCompat.endSection();
        return (System.nanoTime() - f10926f[f10927g]) / 1000000.0f;
    }

    @NonNull
    public static w0.g c(@NonNull Context context) {
        w0.g gVar = f10932l;
        if (gVar == null) {
            synchronized (w0.g.class) {
                try {
                    gVar = f10932l;
                    if (gVar == null) {
                        w0.e aVar = f10930j;
                        if (aVar == null) {
                            aVar = new a(context);
                        }
                        gVar = new w0.g(aVar);
                        f10932l = gVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return gVar;
    }

    @NonNull
    public static w0.h d(@NonNull Context context) {
        w0.h hVar = f10931k;
        if (hVar == null) {
            synchronized (w0.h.class) {
                try {
                    hVar = f10931k;
                    if (hVar == null) {
                        w0.g gVarC = c(context);
                        w0.f bVar = f10929i;
                        if (bVar == null) {
                            bVar = new w0.b();
                        }
                        hVar = new w0.h(gVarC, bVar);
                        f10931k = hVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return hVar;
    }

    public static void e(w0.e eVar) {
        f10930j = eVar;
    }

    public static void f(w0.f fVar) {
        f10929i = fVar;
    }

    public static void g(boolean z10) {
        if (f10924d == z10) {
            return;
        }
        f10924d = z10;
        if (z10) {
            f10925e = new String[20];
            f10926f = new long[20];
        }
    }
}
