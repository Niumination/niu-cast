package ki;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.sdk.oneid.data.AppIdInfo;
import dr.l;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static transient boolean f9177c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f9178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f9179e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.transsion.sdk.oneid.a f9180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f9181b;

    /* JADX INFO: renamed from: ki.a$a, reason: collision with other inner class name */
    public class C0240a extends c2.a<ConcurrentHashMap<Integer, AppIdInfo>> {
        public C0240a(a aVar) {
        }
    }

    public a(Context context) {
        this.f9181b = context;
        this.f9180a = com.transsion.sdk.oneid.a.a(context.getApplicationContext());
        ai.a.b(context.getApplicationContext());
    }

    public static void d(Context context, int i10) {
        com.transsion.sdk.oneid.a aVar;
        if (context != null && f9179e == null) {
            synchronized (a.class) {
                try {
                    if (f9179e == null) {
                        f9179e = new a(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        a aVar2 = f9179e;
        if (aVar2.f9181b == null || (aVar = aVar2.f9180a) == null) {
            return;
        }
        aVar.c(i10);
    }

    public static void e(Context context, int i10, int i11) {
        if (f9178d == 0) {
            f9178d = i11;
        }
        d(context, i10);
    }

    public static a f() {
        if (f9179e != null) {
            return f9179e;
        }
        throw new IllegalStateException("You should call OneID.init first!");
    }

    public static boolean g() {
        return f9177c;
    }

    public static void i(boolean z10) {
        f9177c = z10;
    }

    public static void j(boolean z10) {
        l.e().b(z10);
    }

    @Deprecated
    public String a() {
        com.transsion.sdk.oneid.a aVar = this.f9180a;
        return aVar != null ? aVar.b() : "";
    }

    public String b(int i10) throws b {
        AppIdInfo appIdInfo;
        if (this.f9181b == null) {
            throw new b("OneID not init yet");
        }
        com.transsion.sdk.oneid.a aVar = this.f9180a;
        String str = "";
        String strK = aVar != null ? aVar.k(i10) : "";
        if (!TextUtils.isEmpty(strK)) {
            return strK;
        }
        try {
            String strH = dr.b.b(this.f9181b).h("appid_info_list");
            if (!TextUtils.isEmpty(strH) && (appIdInfo = (AppIdInfo) ((ConcurrentHashMap) new v1.e().fromJson(strH, new C0240a().getType())).get(Integer.valueOf(i10))) != null) {
                strK = appIdInfo.odid;
                str = appIdInfo.msg;
            }
        } catch (Exception e10) {
            d.m(Log.getStackTraceString(e10));
        }
        if (!TextUtils.isEmpty(strK)) {
            return strK;
        }
        if (TextUtils.isEmpty(str)) {
            str = "Please try later";
        }
        throw new b(str);
    }

    @Deprecated
    public String c() {
        com.transsion.sdk.oneid.a aVar = this.f9180a;
        return aVar != null ? aVar.j() : "";
    }

    @Deprecated
    public void h(String str, String str2) {
        com.transsion.sdk.oneid.a aVar = this.f9180a;
        if (aVar != null) {
            aVar.i(str, str2);
        }
    }

    @Deprecated
    public void k(String str, String str2) {
        com.transsion.sdk.oneid.a aVar = this.f9180a;
        if (aVar != null) {
            aVar.l(str, str2);
        }
    }
}
