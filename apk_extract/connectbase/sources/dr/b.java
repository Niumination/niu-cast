package dr;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f3838c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f3839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f3840b;

    public b(Context context) {
        this.f3840b = context.getApplicationContext();
    }

    public static synchronized b b(Context context) {
        try {
            if (f3838c == null) {
                f3838c = new b(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f3838c;
    }

    public int a(String str) {
        Context context = this.f3840b;
        if (context == null) {
            return -1;
        }
        if (this.f3839a == null) {
            this.f3839a = e(context);
        }
        SharedPreferences sharedPreferences = this.f3839a;
        if (sharedPreferences == null) {
            return -1;
        }
        try {
            return sharedPreferences.getInt(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    public void c(String str, int i10) {
        Context context = this.f3840b;
        if (context == null) {
            return;
        }
        if (this.f3839a == null) {
            this.f3839a = e(context);
        }
        SharedPreferences sharedPreferences = this.f3839a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putInt(str, i10).apply();
        } catch (Exception e10) {
            ki.d.m(Log.getStackTraceString(e10));
        }
    }

    public void d(String str, String str2) throws Exception {
        Context context = this.f3840b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f3839a == null) {
            this.f3839a = e(context);
        }
        if (this.f3839a == null) {
            throw new Exception("sp is null");
        }
        try {
            if (!li.c.b().a(this.f3840b)) {
                throw new Exception("keystore encrypt error");
            }
            li.b bVar = new li.b();
            String strC = bVar.c(bVar.g(str2));
            if (TextUtils.isEmpty(strC)) {
                throw new Exception("rsaCrypter encrypt error");
            }
            SharedPreferences.Editor editorEdit = this.f3839a.edit();
            editorEdit.putString(str, strC);
            editorEdit.apply();
        } catch (Exception e10) {
            ki.d.m(Log.getStackTraceString(e10));
            throw e10;
        }
    }

    public final SharedPreferences e(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(ki.d.k(context) + "_tcrypto", 0);
            this.f3839a = sharedPreferences;
            return sharedPreferences;
        } catch (Exception unused) {
            return null;
        }
    }

    public String f(String str) throws Exception {
        Context context = this.f3840b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f3839a == null) {
            this.f3839a = e(context);
        }
        if (this.f3839a == null) {
            throw new Exception("sp is null");
        }
        try {
            if (!li.c.b().a(this.f3840b)) {
                throw new Exception("keystore decrypt error");
            }
            String string = this.f3839a.getString(str, "");
            if (!TextUtils.isEmpty(string) && !string.contains("_")) {
                String str2 = new String(new li.b().f(Base64.decode(string, 2)));
                if (TextUtils.isEmpty(str2)) {
                    throw new Exception("rsaCrypter decrypt error");
                }
                return str2;
            }
            return "";
        } catch (Exception e10) {
            ki.d.m(Log.getStackTraceString(e10));
            throw e10;
        }
    }

    public void g(String str, String str2) {
        Context context = this.f3840b;
        if (context == null) {
            return;
        }
        if (this.f3839a == null) {
            this.f3839a = e(context);
        }
        SharedPreferences sharedPreferences = this.f3839a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putString(str, str2).apply();
        } catch (Exception e10) {
            ki.d.m(Log.getStackTraceString(e10));
        }
    }

    public String h(String str) {
        Context context = this.f3840b;
        if (context == null) {
            return "";
        }
        if (this.f3839a == null) {
            this.f3839a = e(context);
        }
        SharedPreferences sharedPreferences = this.f3839a;
        if (sharedPreferences == null) {
            return "";
        }
        try {
            return sharedPreferences.getString(str, "");
        } catch (Exception e10) {
            ki.d.m(Log.getStackTraceString(e10));
            return "";
        }
    }
}
