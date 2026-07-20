package lb;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.android.internal.annotations.VisibleForTesting;
import le.q1;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9777a = "f";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9778b = "service is Null";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9779c = "trancare_config";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9780d = "name";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9781e = "duration";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9782f = "version";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9783g = "e_s_t";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9784h = "__pts";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f9785i = "__cache";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9786j = "content://com.transsion.TrancareProvider/";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9787k = "__buried";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9788l = "__datacenter";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static q1 f9789m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static v8.e f9790n;

    public static class a {
        @VisibleForTesting
        public static fh.c a(String str) {
            if (fc.b.b(str)) {
                dc.e.f(f.f9777a, "TranThubTrancareProvider");
                q1 q1Var = f.f9789m;
                if (q1Var != null) {
                    return q1Var;
                }
                q1 q1Var2 = new q1();
                f.f9789m = q1Var2;
                return q1Var2;
            }
            dc.e.f(f.f9777a, "TranAospTrancareProvider");
            v8.e eVar = f.f9790n;
            if (eVar != null) {
                return eVar;
            }
            v8.e eVar2 = new v8.e();
            f.f9790n = eVar2;
            return eVar2;
        }
    }

    public static String f(String str) {
        return a.a(fc.b.a.f5983c).f(str);
    }

    public static String g(String str) {
        return a.a(fc.b.a.f5983c).a(str);
    }

    public static long h(ContentResolver contentResolver, long j10, String str) {
        return a.a(fc.b.a.f5983c).b(contentResolver, j10, str);
    }

    public static long i(ContentResolver contentResolver, String str) {
        return a.a(fc.b.a.f5983c).d(contentResolver, str);
    }

    @Deprecated
    public static Uri j(ContentResolver contentResolver, long j10, String str, long j11) {
        return a.a(fc.b.a.f5983c).k(contentResolver, j10, str, j11);
    }

    public static Uri k(ContentResolver contentResolver, long j10, String str, long j11, long j12) {
        return a.a(fc.b.a.f5986f).l(contentResolver, j10, str, j11, j12);
    }

    @Deprecated
    public static Uri l(ContentResolver contentResolver, String str, long j10) {
        return a.a(fc.b.a.f5983c).n(contentResolver, str, j10);
    }

    public static Uri m(ContentResolver contentResolver, String str, long j10, long j11) {
        return a.a(fc.b.a.f5986f).j(contentResolver, str, j10, j11);
    }

    public static Uri n(ContentResolver contentResolver, long j10, String str, ContentValues contentValues) {
        return a.a(fc.b.a.f5983c).q(contentResolver, j10, str, contentValues);
    }

    public static Uri o(ContentResolver contentResolver, String str, ContentValues contentValues) {
        return a.a(fc.b.a.f5983c).g(contentResolver, str, contentValues);
    }

    public static Uri p(ContentResolver contentResolver, long j10, String str, ContentValues contentValues) {
        return a.a(fc.b.a.f5983c).p(contentResolver, j10, str, contentValues);
    }

    public static Uri q(ContentResolver contentResolver, String str, ContentValues contentValues) {
        return a.a(fc.b.a.f5983c).o(contentResolver, str, contentValues);
    }

    public static boolean r(Context context) {
        return a.a(fc.b.a.f5983c).h(context);
    }

    public static Cursor s(ContentResolver contentResolver, long j10, String str, String[] strArr, String str2, String[] strArr2, String str3) {
        return a.a(fc.b.a.f5983c).m(contentResolver, j10, str, strArr, str2, strArr2, str3);
    }

    public static Cursor t(ContentResolver contentResolver, String str, String[] strArr, String str2, String[] strArr2, String str3) {
        return a.a(fc.b.a.f5983c).i(contentResolver, str, strArr, str2, strArr2, str3);
    }

    public static int u(ContentResolver contentResolver, long j10, String str, ContentValues contentValues, String str2, String[] strArr) {
        return a.a(fc.b.a.f5983c).e(contentResolver, j10, str, contentValues, str2, strArr);
    }

    public static int v(ContentResolver contentResolver, String str, ContentValues contentValues, String str2, String[] strArr) {
        return a.a(fc.b.a.f5983c).c(contentResolver, str, contentValues, str2, strArr);
    }
}
