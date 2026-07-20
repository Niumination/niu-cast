package u6;

import af.l1;
import af.p5;
import af.r5;
import af.z5;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import bb.o;
import com.transsion.athena.data.AppIdData;
import com.transsion.base.arch.mvvm.VmOwnerApplication;
import com.transsion.core.log.ObjectLogUtils;
import com.transsion.iotservice.multiscreen.pc.ui.SharedViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.BaseSearchFragment;
import d2.l;
import dj.m;
import h4.v;
import i2.i;
import i2.j;
import j2.f;
import j2.h;
import java.io.File;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import k3.v8;
import k3.y0;
import kotlin.jvm.internal.Intrinsics;
import m3.g0;
import mg.a0;
import se.g;
import tj.w;
import xg.y;
import y6.k;
import ze.d2;
import ze.g2;
import ze.l2;
import ze.m2;
import ze.n1;
import ze.q2;
import ze.r1;
import ze.s;
import ze.s2;
import ze.v0;
import zf.z;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements z5, f2.b, f, r4.a, wg.c {
    public static volatile a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f10378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f10379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f10380d;

    public /* synthetic */ a(int i8, boolean z2) {
        this.f10377a = i8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a h(Context context) {
        int i8 = 0;
        Object[] objArr = 0;
        if (e == null) {
            synchronized (a.class) {
                try {
                    if (e == null) {
                        a aVar = new a(i8, objArr == true ? 1 : 0);
                        try {
                            aVar.f10378b = context;
                            aVar.f10379c = c.e(context);
                            aVar.f10380d = context.getFilesDir().getPath();
                        } catch (Exception e4) {
                            ObjectLogUtils objectLogUtils = z6.a.f11258a;
                            z6.a.c(Log.getStackTraceString(e4));
                        }
                        e = aVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return e;
    }

    public ViewModel A(FragmentActivity activity, Class modelClass) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (((ViewModelProvider) this.f10379c) == null) {
            this.f10379c = new ViewModelProvider(activity);
        }
        ViewModelProvider viewModelProvider = (ViewModelProvider) this.f10379c;
        Intrinsics.checkNotNull(viewModelProvider);
        return viewModelProvider.get(modelClass);
    }

    public ViewModel B(BaseSearchFragment fragment, Class modelClass) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        return A(fragmentActivityRequireActivity, modelClass);
    }

    public ViewModel C(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(SharedViewModel.class, "modelClass");
        try {
            Application application = activity.getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.transsion.base.arch.mvvm.VmOwnerApplication");
            VmOwnerApplication application2 = (VmOwnerApplication) application;
            Intrinsics.checkNotNullParameter(application2, "application");
            Intrinsics.checkNotNullParameter(SharedViewModel.class, "modelClass");
            if (((ViewModelProvider) this.f10380d) == null) {
                this.f10380d = new ViewModelProvider(application2);
            }
            ViewModelProvider viewModelProvider = (ViewModelProvider) this.f10380d;
            Intrinsics.checkNotNull(viewModelProvider);
            return viewModelProvider.get(SharedViewModel.class);
        } catch (ClassCastException e4) {
            e4.printStackTrace();
            throw new RuntimeException("you should make your application implements ViewModelStoreOwner");
        }
    }

    public ViewModel D(BaseSearchFragment fragment, Class modelClass) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (((ViewModelProvider) this.f10378b) == null) {
            this.f10378b = new ViewModelProvider(fragment);
        }
        ViewModelProvider viewModelProvider = (ViewModelProvider) this.f10378b;
        Intrinsics.checkNotNull(viewModelProvider);
        return viewModelProvider.get(modelClass);
    }

    @Override // wg.a
    public ka.d a() {
        return ((wg.c) this.f10380d).a();
    }

    @Override // j2.f
    public Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        a2.b bVar = h.e;
        while (cursor.moveToNext()) {
            long j8 = cursor.getLong(0);
            boolean z2 = cursor.getInt(7) != 0;
            d2.a aVar = new d2.a();
            aVar.f4261h = new HashMap();
            String string = cursor.getString(1);
            if (string == null) {
                throw new NullPointerException("Null transportName");
            }
            aVar.f4257a = string;
            aVar.f4260d = Long.valueOf(cursor.getLong(2));
            aVar.e = Long.valueOf(cursor.getLong(3));
            if (z2) {
                String string2 = cursor.getString(4);
                aVar.f4259c = new d2.f(string2 == null ? h.e : new a2.b(string2), cursor.getBlob(5));
            } else {
                String string3 = cursor.getString(4);
                aVar.f4259c = new d2.f(string3 == null ? h.e : new a2.b(string3), (byte[]) h.k(((h) this.f10378b).a().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j8)}, null, null, "sequence_num"), j2.e.f6043b));
            }
            if (!cursor.isNull(6)) {
                aVar.f4258b = Integer.valueOf(cursor.getInt(6));
            }
            ((ArrayList) this.f10379c).add(new j2.b(j8, (d2.d) this.f10380d, aVar.b()));
        }
        return null;
    }

    @Override // wg.a
    public boolean b() {
        return ((wg.c) this.f10380d).b();
    }

    @Override // wg.a
    public mg.b c() {
        return (y) this.f10378b;
    }

    @Override // r4.a
    public /* bridge */ /* synthetic */ r4.a d(Class cls, q4.d dVar) {
        switch (this.f10377a) {
            case 8:
                ((HashMap) this.f10378b).put(cls, dVar);
                ((HashMap) this.f10379c).remove(cls);
                break;
            default:
                ((HashMap) this.f10378b).put(cls, dVar);
                ((HashMap) this.f10379c).remove(cls);
                break;
        }
        return this;
    }

    @Override // wg.c
    public wg.b e() {
        return (wg.b) this.f10379c;
    }

    @Override // wg.a
    public wg.d f() {
        return ((wg.c) this.f10380d).f();
    }

    @Override // wg.a
    public z g() {
        return ((wg.c) this.f10380d).g();
    }

    @Override // yh.a
    public Object get() {
        switch (this.f10377a) {
            case 4:
                return new l(new n5.a(), new a0(), (h2.b) ((r5) this.f10378b).get(), (i) ((d2.a) this.f10379c).get(), (j) ((m) this.f10380d).get());
            default:
                return new i2.d((Context) ((w) this.f10378b).f10262b, (j2.c) ((yh.a) this.f10379c).get(), (i2.b) ((g) this.f10380d).get());
        }
    }

    @Override // af.j6
    public void j(a8.a aVar) {
        ph.b.d();
        try {
            ph.c cVar = ((p5) this.f10378b).f512c;
            ph.b.a();
            z(aVar);
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public synchronized void k(long j8, e0.b bVar) {
        try {
            String str = ((String) this.f10380d) + File.separator + s6.d.f9546k;
            if (new File(str).exists()) {
                ArrayList<File> arrayList = new ArrayList();
                g0.f(str, arrayList, String.valueOf(j8));
                if (arrayList.size() > 0) {
                    Collections.sort(arrayList, new o(5));
                }
                for (File file : arrayList) {
                    if (!file.getName().contains("upload")) {
                        if (file.getName().startsWith("f_") || file.getName().startsWith("r_")) {
                            File file2 = new File(file.getPath() + "upload" + System.currentTimeMillis());
                            file = !file.renameTo(file2) ? null : file2;
                        }
                    }
                    if (file != null) {
                        y6.g.a().b(new k(j8, file, m6.a.f().c(j8)));
                    }
                }
            }
            String str2 = ((String) this.f10380d) + File.separator + s6.d.f9547l;
            if (new File(str2).exists()) {
                try {
                    g0.e((Context) this.f10378b, str2);
                } catch (Exception e4) {
                    z6.a.c(Log.getStackTraceString(e4));
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void m(AppIdData appIdData) {
        try {
            ((c) this.f10379c).h(b.f10384d, appIdData);
        } catch (e8.d e4) {
            int i8 = e8.d.f4719a;
            e8.g.f4735b.a(e4);
        }
    }

    @Override // af.z5
    public void n() {
        ph.b.d();
        try {
            ph.c cVar = ((p5) this.f10378b).f512c;
            ph.b.a();
            if (((p5) this.f10378b).f515h) {
                ph.b.f8887a.getClass();
            } else {
                ((ze.i) this.f10379c).k();
                ph.b.f8887a.getClass();
            }
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public synchronized void o(ArrayList arrayList, boolean z2, e0.b bVar) {
        if (z2) {
            try {
                String str = ((String) this.f10380d) + File.separator + s6.d.f9546k;
                if (new File(str).exists()) {
                    ArrayList<File> arrayList2 = new ArrayList();
                    g0.f(str, arrayList2, null);
                    if (arrayList2.size() > 0) {
                        try {
                            Collections.sort(arrayList2, new o(4));
                        } catch (Exception e4) {
                            z6.a.c(Log.getStackTraceString(e4));
                        }
                    }
                    for (File file : arrayList2) {
                        String name = file.getName();
                        if (!name.startsWith("f_") && !name.startsWith("r_")) {
                            z6.a.a("cleanupEvents deleteFile " + name + " " + g0.j((Context) this.f10378b, file));
                        } else if (arrayList.contains(Long.valueOf(Long.parseLong(name.substring(2, name.indexOf(45)))))) {
                            z6.a.a("cleanupEvents deleteFile " + name + " " + g0.j((Context) this.f10378b, file));
                        }
                    }
                }
                String str2 = ((String) this.f10380d) + File.separator + s6.d.f9547l;
                if (new File(str2).exists()) {
                    try {
                        g0.e((Context) this.f10378b, str2);
                    } catch (Exception e10) {
                        z6.a.c(Log.getStackTraceString(e10));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        try {
            ((c) this.f10379c).j(b.f10381a, arrayList, bVar);
        } catch (e8.d e11) {
            int i8 = e8.d.f4719a;
            e8.g.f4735b.a(e11);
        }
    }

    @Override // af.z5
    public void p(q2 q2Var) {
        ph.b.d();
        try {
            ph.c cVar = ((p5) this.f10378b).f512c;
            ph.b.a();
            x(q2Var);
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // af.j6
    public void q() {
        ph.b.d();
        try {
            ph.c cVar = ((p5) this.f10378b).f512c;
            ph.b.a();
            if (((p5) this.f10378b).f515h) {
                ph.b.f8887a.getClass();
            } else {
                ((ze.i) this.f10379c).m();
                ph.b.f8887a.getClass();
            }
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public synchronized void r(List list) {
        try {
            ((c) this.f10379c).l(b.f10384d, list);
        } catch (e8.d e4) {
            int i8 = e8.d.f4719a;
            e8.g.f4735b.a(e4);
        }
    }

    public synchronized void s(s6.c cVar, boolean z2) {
        try {
            ((c) this.f10379c).o(b.f10384d, cVar, z2);
        } catch (e8.d e4) {
            int i8 = e8.d.f4719a;
            e8.g.f4735b.a(e4);
        }
    }

    public synchronized void t() {
        c cVar = (c) this.f10379c;
        cVar.getClass();
        z6.a.a("deleteDB");
        try {
            d dVar = (d) cVar.f10388c;
            dVar.close();
            if (dVar.f10397a.delete()) {
                z6.a.a("mDatabaseFile deleted");
                try {
                    Context context = (Context) this.f10378b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append((String) this.f10380d);
                    String str = File.separator;
                    sb2.append(str);
                    sb2.append(s6.d.f9546k);
                    g0.e(context, sb2.toString());
                    g0.e((Context) this.f10378b, ((String) this.f10380d) + str + s6.d.f9547l);
                } catch (Exception e4) {
                    z6.a.c(Log.getStackTraceString(e4));
                }
            } else {
                Context context2 = (Context) this.f10378b;
                StringBuilder sb3 = new StringBuilder();
                sb3.append((String) this.f10380d);
                String str2 = File.separator;
                sb3.append(str2);
                sb3.append(s6.d.f9546k);
                g0.e(context2, sb3.toString());
                g0.e((Context) this.f10378b, ((String) this.f10380d) + str2 + s6.d.f9547l);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        throw th;
    }

    public void u(r1 r1Var, d2 d2Var) {
        v8.i(r1Var, "method must not be null");
        v(new g2(r1Var, d2Var));
    }

    public void v(g2 g2Var) {
        r1 r1Var = g2Var.f11353a;
        String str = r1Var.f11424c;
        String str2 = (String) this.f10380d;
        boolean zEquals = str2.equals(str);
        String str3 = r1Var.f11423b;
        v8.g(zEquals, "Method name should be prefixed with service name and separated with '/'. Expected service name: '%s'. Actual fully qualifed method name: '%s'.", str2, str3);
        HashMap map = (HashMap) this.f10379c;
        v8.l("Method by same name already registered: %s", !map.containsKey(str3), str3);
        map.put(str3, g2Var);
    }

    public l2 w() {
        HashMap map = (HashMap) this.f10379c;
        m2 m2Var = (m2) this.f10378b;
        if (m2Var == null) {
            ArrayList arrayList = new ArrayList(map.size());
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                arrayList.add(((g2) it.next()).f11353a);
            }
            tc.d dVarA = m2.a((String) this.f10380d);
            ((ArrayList) dVarA.f10210b).addAll(arrayList);
            m2Var = new m2(dVarA);
        }
        HashMap map2 = new HashMap(map);
        for (r1 r1Var : m2Var.f11384b) {
            g2 g2Var = (g2) map2.remove(r1Var.f11423b);
            String str = r1Var.f11423b;
            if (g2Var == null) {
                throw new IllegalStateException(h0.a.i("No method bound for descriptor entry ", str));
            }
            if (g2Var.f11353a != r1Var) {
                throw new IllegalStateException(h0.a.j("Bound method for ", str, " not same instance as method in service descriptor"));
            }
        }
        if (map2.size() <= 0) {
            return new l2(m2Var, map);
        }
        throw new IllegalStateException("No entry in descriptor matching bound method " + ((g2) map2.values().iterator().next()).f11353a.f11423b);
    }

    public void x(q2 q2Var) {
        s2 s2Var = null;
        try {
            if (q2Var.e()) {
                ((ze.i) this.f10379c).j();
            } else {
                ((p5) this.f10378b).f515h = true;
                ((ze.i) this.f10379c).i();
                q2 q2VarH = q2.f.h("RPC cancelled");
                n1 n1Var = v0.f11451a;
                s2Var = new s2(q2VarH, null, false);
            }
        } finally {
            ((s) this.f10380d).t(null);
        }
    }

    public byte[] y(byte[] bArr) throws Exception {
        try {
            if (((Key) this.f10379c) == null || ((PublicKey) this.f10380d) == null) {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                keyStore.load(null);
                this.f10379c = keyStore.getKey("crypto", null);
                this.f10380d = keyStore.getCertificate("crypto").getPublicKey();
            }
            if (((Cipher) this.f10378b) == null) {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, (Key) this.f10379c);
                this.f10378b = cipher;
            }
            return ((Cipher) this.f10378b).doFinal(bArr);
        } catch (NoClassDefFoundError unused) {
            throw new Exception("NoClassDefFound...");
        }
    }

    public void z(a8.a aVar) {
        if (((p5) this.f10378b).f515h) {
            Logger logger = l1.f410a;
            while (true) {
                InputStream inputStreamF = aVar.f();
                if (inputStreamF == null) {
                    return;
                } else {
                    l1.b(inputStreamF);
                }
            }
        } else {
            while (true) {
                try {
                    InputStream inputStreamF2 = aVar.f();
                    if (inputStreamF2 == null) {
                        return;
                    }
                    try {
                        ((ze.i) this.f10379c).l(((p5) this.f10378b).f511b.f11425d.a(inputStreamF2));
                        inputStreamF2.close();
                    } catch (Throwable th2) {
                        l1.b(inputStreamF2);
                        throw th2;
                    }
                } catch (Throwable th3) {
                    Logger logger2 = l1.f410a;
                    while (true) {
                        InputStream inputStreamF3 = aVar.f();
                        if (inputStreamF3 == null) {
                            v.a(th3);
                            throw new RuntimeException(th3);
                        }
                        l1.b(inputStreamF3);
                    }
                }
            }
        }
    }

    public /* synthetic */ a(Object obj, int i8, Object obj2, Object obj3) {
        this.f10377a = i8;
        this.f10378b = obj;
        this.f10379c = obj2;
        this.f10380d = obj3;
    }

    public a(y call, wg.b pipeline, wg.c engineResponse) {
        this.f10377a = 14;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(pipeline, "pipeline");
        Intrinsics.checkNotNullParameter(engineResponse, "engineResponse");
        this.f10378b = call;
        this.f10379c = pipeline;
        this.f10380d = engineResponse;
    }

    public a(m2 m2Var) {
        this.f10377a = 15;
        this.f10379c = new HashMap();
        v8.i(m2Var, "serviceDescriptor");
        this.f10378b = m2Var;
        this.f10380d = m2Var.f11383a;
    }

    public a(int i8) {
        this.f10377a = i8;
        switch (i8) {
            case 8:
                this.f10378b = new HashMap();
                this.f10379c = new HashMap();
                this.f10380d = y0.f6718c;
                break;
            case 9:
            default:
                String boundary = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(boundary, "UUID.randomUUID().toString()");
                Intrinsics.checkNotNullParameter(boundary, "boundary");
                qj.j.Companion.getClass();
                this.f10378b = qj.i.b(boundary);
                this.f10379c = dj.z.e;
                this.f10380d = new ArrayList();
                break;
            case 10:
                this.f10378b = new HashMap();
                this.f10379c = new HashMap();
                this.f10380d = m3.g.f7677c;
                break;
        }
    }

    public a(p5 p5Var, ze.i iVar, s sVar) {
        this.f10377a = 2;
        v8.i(p5Var, NotificationCompat.CATEGORY_CALL);
        this.f10378b = p5Var;
        this.f10379c = iVar;
        this.f10380d = sVar;
        sVar.a(new se.e(this, 3), m4.k.INSTANCE);
    }
}
