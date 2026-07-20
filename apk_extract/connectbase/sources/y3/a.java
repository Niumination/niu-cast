package y3;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f20686a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f20687b = false;

    public static String a() {
        if (!TextUtils.isEmpty(f20686a)) {
            return f20686a;
        }
        if (ki.a.f9177c) {
            b.b("OneID isEnable = true");
            f20686a = f20687b ? ki.a.f().c() : "";
        }
        return f20686a;
    }

    public static void b(Context context) {
        if (TextUtils.isEmpty(f20686a)) {
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(string)) {
                    f20686a = UUID.nameUUIDFromBytes((context.getPackageName() + string).getBytes()).toString();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (TextUtils.isEmpty(f20686a)) {
                f20686a = UUID.randomUUID().toString();
            }
            try {
                m0.b.b(context).c("vaid", f20686a);
            } catch (Exception e11) {
                b.d(Log.getStackTraceString(e11));
            }
        }
    }

    public static void c(Context context, int i10, int i11) {
        try {
            ki.a.e(context, i10, i11);
            f20687b = true;
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
        }
    }

    public static String d(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (!TextUtils.isEmpty(f20686a)) {
                return f20686a;
            }
            if (ki.a.f9177c) {
                b.b("OneID isEnable = true");
                f20686a = f20687b ? ki.a.f().c() : "";
            }
            if (TextUtils.isEmpty(f20686a)) {
                f20686a = m0.b.b(context).a("vaid");
                b(context);
            }
            b.b("*******************/ vaid cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " /*******************");
            return f20686a;
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
            b(context);
        }
    }
}
