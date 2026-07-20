package m0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import li.c;
import y3.e;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f10290c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f10291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f10292b;

    public b(Context context) {
        this.f10292b = context.getApplicationContext();
    }

    public static synchronized b b(Context context) {
        try {
            if (f10290c == null) {
                f10290c = new b(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f10290c;
    }

    public String a(String str) throws Exception {
        Context context = this.f10292b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f10291a == null) {
            this.f10291a = d(context);
        }
        if (this.f10291a == null) {
            throw new Exception("sp is null");
        }
        if (!c.b().a(this.f10292b)) {
            throw new Exception("keystore decrypt error");
        }
        String string = this.f10291a.getString(str, "");
        if (TextUtils.isEmpty(string) || string.contains("_")) {
            return "";
        }
        String str2 = new String(new li.b().f(Base64.decode(string, 2)));
        if (TextUtils.isEmpty(str2)) {
            throw new Exception("rsaCrypter decrypt error");
        }
        return str2;
    }

    public void c(String str, String str2) throws Exception {
        Context context = this.f10292b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f10291a == null) {
            this.f10291a = d(context);
        }
        if (this.f10291a == null) {
            throw new Exception("sp is null");
        }
        try {
            if (!c.b().a(this.f10292b)) {
                throw new Exception("keystore encrypt error");
            }
            li.b bVar = new li.b();
            String strC = bVar.c(bVar.g(str2));
            if (TextUtils.isEmpty(strC)) {
                throw new Exception("rsaCrypter encrypt error");
            }
            SharedPreferences.Editor editorEdit = this.f10291a.edit();
            editorEdit.putString(str, strC);
            editorEdit.apply();
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
            throw e10;
        }
    }

    public final SharedPreferences d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(e.p(context) + "_tcrypto", 0);
            this.f10291a = sharedPreferences;
            return sharedPreferences;
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
            return null;
        }
    }
}
