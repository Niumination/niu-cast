package hi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import java.util.Locale;
import jq.e0;
import kn.l0;
import kn.r1;
import lm.c1;
import lm.d1;
import lm.i0;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nBridgePartnerResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BridgePartnerResolver.kt\ncom/transsion/padconnect/bridge/BridgePartnerResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,155:1\n1#2:156\n39#3,12:157\n39#3,12:169\n*S KotlinDebug\n*F\n+ 1 BridgePartnerResolver.kt\ncom/transsion/padconnect/bridge/BridgePartnerResolver\n*L\n131#1:157,12\n142#1:169,12\n*E\n"})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final e f7125a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f7126b = "padconnect_bridge_partner";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final String f7127c = "last_target_package";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final String f7128d = "BridgePartnerResolver";

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7129a;

        static {
            int[] iArr = new int[f.values().length];
            try {
                iArr[f.PUBLISHER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[f.CONSUMER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f7129a = iArr;
        }
    }

    public final void a(@os.l Context context) {
        l0.p(context, "context");
        try {
            c1.a aVar = c1.Companion;
            SharedPreferences sharedPreferences = context.getSharedPreferences(f7126b, 0);
            l0.o(sharedPreferences, "getSharedPreferences(...)");
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            l0.o(editorEdit, "editor");
            editorEdit.remove(f7127c);
            editorEdit.apply();
            c1.m59constructorimpl(l2.f10208a);
        } catch (Throwable th2) {
            c1.a aVar2 = c1.Companion;
            c1.m59constructorimpl(d1.a(th2));
        }
    }

    public final f b(Context context) {
        String packageName = context.getPackageName();
        l0.o(packageName, "getPackageName(...)");
        String lowerCase = packageName.toLowerCase(Locale.ROOT);
        l0.o(lowerCase, "toLowerCase(...)");
        return l0.g(lowerCase, b.f7120i) ? f.PUBLISHER : f.CONSUMER;
    }

    public final boolean c(@os.l Context context, @os.m String str) {
        PackageManager packageManager;
        l0.p(context, "context");
        if (str == null || e0.S1(str) || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(0L));
            } else {
                packageManager.getPackageInfo(str, 0);
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w(f7128d, "Package not found: " + str);
            return false;
        }
    }

    public final String d(Context context) {
        Object objM59constructorimpl;
        try {
            c1.a aVar = c1.Companion;
            objM59constructorimpl = c1.m59constructorimpl(context.getSharedPreferences(f7126b, 0).getString(f7127c, null));
        } catch (Throwable th2) {
            c1.a aVar2 = c1.Companion;
            objM59constructorimpl = c1.m59constructorimpl(d1.a(th2));
        }
        return (String) (c1.m64isFailureimpl(objM59constructorimpl) ? null : objM59constructorimpl);
    }

    public final void e(@os.l Context context, @os.l String str) {
        Object objM59constructorimpl;
        l0.p(context, "context");
        l0.p(str, "packageName");
        if (e0.S1(str)) {
            return;
        }
        try {
            c1.a aVar = c1.Companion;
            SharedPreferences sharedPreferences = context.getSharedPreferences(f7126b, 0);
            l0.o(sharedPreferences, "getSharedPreferences(...)");
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            l0.o(editorEdit, "editor");
            editorEdit.putString(f7127c, str);
            editorEdit.apply();
            objM59constructorimpl = c1.m59constructorimpl(l2.f10208a);
        } catch (Throwable th2) {
            c1.a aVar2 = c1.Companion;
            objM59constructorimpl = c1.m59constructorimpl(d1.a(th2));
        }
        Throwable thM62exceptionOrNullimpl = c1.m62exceptionOrNullimpl(objM59constructorimpl);
        if (thM62exceptionOrNullimpl != null) {
            Log.w(f7128d, "Failed to cache partner package", thM62exceptionOrNullimpl);
        }
    }

    public final String f(Context context, hi.a aVar) {
        f fVarB = aVar.f7111b;
        if (fVarB == null) {
            fVarB = b(context);
        }
        int i10 = a.f7129a[fVarB.ordinal()];
        if (i10 == 1) {
            return b.f7121j;
        }
        if (i10 == 2) {
            return b.f7120i;
        }
        throw new i0();
    }

    @os.m
    public final String g(@os.l Context context, @os.l hi.a aVar) {
        l0.p(context, "context");
        l0.p(aVar, "config");
        String str = aVar.f7110a;
        if (str != null) {
            if (e0.S1(str)) {
                str = null;
            }
            if (str != null) {
                e eVar = f7125a;
                if (eVar.c(context, str)) {
                    Log.d(f7128d, "Using configured target: ".concat(str));
                    eVar.e(context, str);
                    return str;
                }
                Log.w(f7128d, "Configured target not found: ".concat(str));
            }
        }
        String strD = d(context);
        if (strD != null) {
            e eVar2 = f7125a;
            if (eVar2.c(context, strD)) {
                Log.d(f7128d, "Using cached target: ".concat(strD));
                return strD;
            }
            Log.w(f7128d, "Cached target no longer valid, clearing: ".concat(strD));
            eVar2.a(context);
        }
        String strF = f(context, aVar);
        if (!c(context, strF)) {
            Log.w(f7128d, "Failed to resolve target package");
            return null;
        }
        Log.d(f7128d, "Using default target: " + strF);
        e(context, strF);
        return strF;
    }
}
