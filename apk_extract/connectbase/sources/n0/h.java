package n0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import cr.v.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, q<n0.g>> f10951a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f10952b = {80, 75, 3, 4};

    public class a implements l<n0.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f10953a;

        public a(String str) {
            this.f10953a = str;
        }

        @Override // n0.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(n0.g gVar) {
            h.f10951a.remove(this.f10953a);
        }
    }

    public class b implements l<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f10954a;

        public b(String str) {
            this.f10954a = str;
        }

        @Override // n0.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2) {
            h.f10951a.remove(this.f10954a);
        }
    }

    public class c implements Callable<p<n0.g>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f10955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f10957c;

        public c(Context context, String str, String str2) {
            this.f10955a = context;
            this.f10956b = str;
            this.f10957c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p<n0.g> call() {
            p<n0.g> pVarC = n0.e.d(this.f10955a).c(this.f10956b, this.f10957c);
            if (this.f10957c != null && pVarC.f11070a != null) {
                s0.h.c().d(this.f10957c, pVarC.f11070a);
            }
            return pVarC;
        }
    }

    public class d implements Callable<p<n0.g>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f10958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f10960c;

        public d(Context context, String str, String str2) {
            this.f10958a = context;
            this.f10959b = str;
            this.f10960c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p<n0.g> call() {
            return h.h(this.f10958a, this.f10959b, this.f10960c);
        }
    }

    public class e implements Callable<p<n0.g>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f10961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f10962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f10963c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f10964d;

        public e(WeakReference weakReference, Context context, int i10, String str) {
            this.f10961a = weakReference;
            this.f10962b = context;
            this.f10963c = i10;
            this.f10964d = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p<n0.g> call() {
            Context context = (Context) this.f10961a.get();
            if (context == null) {
                context = this.f10962b;
            }
            return h.v(context, this.f10963c, this.f10964d);
        }
    }

    public class f implements Callable<p<n0.g>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f10965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10966b;

        public f(InputStream inputStream, String str) {
            this.f10965a = inputStream;
            this.f10966b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p<n0.g> call() {
            return h.k(this.f10965a, this.f10966b);
        }
    }

    public class g implements Callable<p<n0.g>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f10967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10968b;

        public g(JSONObject jSONObject, String str) {
            this.f10967a = jSONObject;
            this.f10968b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p<n0.g> call() {
            return h.r(this.f10967a, this.f10968b);
        }
    }

    /* JADX INFO: renamed from: n0.h$h, reason: collision with other inner class name */
    public class CallableC0287h implements Callable<p<n0.g>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f10969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10970b;

        public CallableC0287h(String str, String str2) {
            this.f10969a = str;
            this.f10970b = str2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p<n0.g> call() {
            return h.q(this.f10969a, this.f10970b);
        }
    }

    public class i implements Callable<p<n0.g>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0.c f10971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10972b;

        public i(y0.c cVar, String str) {
            this.f10971a = cVar;
            this.f10972b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p<n0.g> call() {
            return h.n(this.f10971a, this.f10972b);
        }
    }

    public class j implements Callable<p<n0.g>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ZipInputStream f10973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10974b;

        public j(ZipInputStream zipInputStream, String str) {
            this.f10973a = zipInputStream;
            this.f10974b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p<n0.g> call() {
            return h.B(this.f10973a, this.f10974b);
        }
    }

    public class k implements Callable<p<n0.g>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n0.g f10975a;

        public k(n0.g gVar) {
            this.f10975a = gVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p<n0.g> call() {
            return new p<>(this.f10975a);
        }
    }

    public static q<n0.g> A(ZipInputStream zipInputStream, @Nullable String str) {
        return b(str, new j(zipInputStream, str));
    }

    @WorkerThread
    public static p<n0.g> B(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return C(zipInputStream, str);
        } finally {
            z0.h.c(zipInputStream);
        }
    }

    @WorkerThread
    public static p<n0.g> C(ZipInputStream zipInputStream, @Nullable String str) {
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            n0.g gVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    gVar = o(y0.c.E(new cr.v(cr.p.l(zipInputStream))), null, false).f11070a;
                } else if (name.contains(".png") || name.contains(".webp")) {
                    String[] strArrSplit = name.split("/");
                    map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (gVar == null) {
                return new p<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                n0.k kVarD = d(gVar, (String) entry.getKey());
                if (kVarD != null) {
                    kVarD.h(z0.h.m((Bitmap) entry.getValue(), kVarD.f(), kVarD.d()));
                }
            }
            for (Map.Entry<String, n0.k> entry2 : gVar.i().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new p<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().c()));
                }
            }
            if (str != null) {
                s0.h.c().d(str, gVar);
            }
            return new p<>(gVar);
        } catch (IOException e10) {
            return new p<>((Throwable) e10);
        }
    }

    public static boolean D(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static Boolean E(cr.e eVar) {
        try {
            cr.e eVarPeek = eVar.peek();
            for (byte b10 : f10952b) {
                if (eVarPeek.readByte() != b10) {
                    return Boolean.FALSE;
                }
            }
            eVarPeek.close();
            return Boolean.TRUE;
        } catch (Exception e10) {
            z0.d.c("Failed to check zip file header", e10);
            return Boolean.FALSE;
        }
    }

    public static String F(Context context, @RawRes int i10) {
        StringBuilder sb2 = new StringBuilder("rawRes");
        sb2.append(D(context) ? "_night_" : "_day_");
        sb2.append(i10);
        return sb2.toString();
    }

    public static void G(int i10) {
        s0.h.c().e(i10);
    }

    public static q<n0.g> b(@Nullable String str, Callable<p<n0.g>> callable) {
        n0.g gVarB = str == null ? null : s0.h.c().b(str);
        if (gVarB != null) {
            return new q<>(new k(gVarB), false);
        }
        if (str != null) {
            Map<String, q<n0.g>> map = f10951a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        q<n0.g> qVar = new q<>(callable, false);
        if (str != null) {
            qVar.f(new a(str));
            qVar.e(new b(str));
            f10951a.put(str, qVar);
        }
        return qVar;
    }

    public static void c(Context context) {
        f10951a.clear();
        s0.h.c().a();
        n0.e.c(context).a();
    }

    @Nullable
    public static n0.k d(n0.g gVar, String str) {
        for (n0.k kVar : gVar.i().values()) {
            if (kVar.c().equals(str)) {
                return kVar;
            }
        }
        return null;
    }

    public static q<n0.g> e(Context context, String str) {
        return f(context, str, "asset_" + str);
    }

    public static q<n0.g> f(Context context, String str, @Nullable String str2) {
        return b(str2, new d(context.getApplicationContext(), str, str2));
    }

    @WorkerThread
    public static p<n0.g> g(Context context, String str) {
        return h(context, str, "asset_" + str);
    }

    @WorkerThread
    public static p<n0.g> h(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return l(context.getAssets().open(str), str2, true);
            }
            return B(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e10) {
            return new p<>((Throwable) e10);
        }
    }

    @Deprecated
    public static q<n0.g> i(JSONObject jSONObject, @Nullable String str) {
        return b(str, new g(jSONObject, str));
    }

    public static q<n0.g> j(InputStream inputStream, @Nullable String str) {
        return b(str, new f(inputStream, str));
    }

    @WorkerThread
    public static p<n0.g> k(InputStream inputStream, @Nullable String str) {
        return l(inputStream, str, true);
    }

    @WorkerThread
    public static p<n0.g> l(InputStream inputStream, @Nullable String str, boolean z10) {
        try {
            return o(y0.c.E(new cr.v(cr.p.l(inputStream))), str, true);
        } finally {
            if (z10) {
                z0.h.c(inputStream);
            }
        }
    }

    public static q<n0.g> m(y0.c cVar, @Nullable String str) {
        return b(str, new i(cVar, str));
    }

    @WorkerThread
    public static p<n0.g> n(y0.c cVar, @Nullable String str) {
        return o(cVar, str, true);
    }

    public static p<n0.g> o(y0.c cVar, @Nullable String str, boolean z10) {
        try {
            n0.g gVarA = x0.t.a(cVar);
            if (str != null) {
                s0.h.c().d(str, gVarA);
            }
            return new p<>(gVarA);
        } catch (Exception e10) {
            return new p<>((Throwable) e10);
        } finally {
            if (z10) {
                z0.h.c(cVar);
            }
        }
    }

    public static q<n0.g> p(String str, @Nullable String str2) {
        return b(str2, new CallableC0287h(str, str2));
    }

    @WorkerThread
    public static p<n0.g> q(String str, @Nullable String str2) {
        return o(y0.c.E(new cr.v(cr.p.l(new ByteArrayInputStream(str.getBytes())))), str2, true);
    }

    @WorkerThread
    @Deprecated
    public static p<n0.g> r(JSONObject jSONObject, @Nullable String str) {
        return q(jSONObject.toString(), str);
    }

    public static q<n0.g> s(Context context, @RawRes int i10) {
        return t(context, i10, F(context, i10));
    }

    public static q<n0.g> t(Context context, @RawRes int i10, @Nullable String str) {
        return b(str, new e(new WeakReference(context), context.getApplicationContext(), i10, str));
    }

    @WorkerThread
    public static p<n0.g> u(Context context, @RawRes int i10) {
        return v(context, i10, F(context, i10));
    }

    @WorkerThread
    public static p<n0.g> v(Context context, @RawRes int i10, @Nullable String str) {
        try {
            cr.v vVar = new cr.v(cr.p.l(context.getResources().openRawResource(i10)));
            return E(vVar).booleanValue() ? B(new ZipInputStream(vVar.new a()), str) : l(vVar.new a(), str, true);
        } catch (Resources.NotFoundException e10) {
            return new p<>((Throwable) e10);
        }
    }

    public static q<n0.g> w(Context context, String str) {
        return x(context, str, "url_" + str);
    }

    public static q<n0.g> x(Context context, String str, @Nullable String str2) {
        return b(str2, new c(context, str, str2));
    }

    @WorkerThread
    public static p<n0.g> y(Context context, String str) {
        return z(context, str, str);
    }

    @WorkerThread
    public static p<n0.g> z(Context context, String str, @Nullable String str2) {
        p<n0.g> pVarC = n0.e.d(context).c(str, str2);
        if (str2 != null && pVarC.f11070a != null) {
            s0.h.c().d(str2, pVarC.f11070a);
        }
        return pVarC;
    }
}
