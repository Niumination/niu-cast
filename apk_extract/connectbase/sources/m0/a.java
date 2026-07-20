package m0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import li.c;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f10287c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f10288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f10289b;

    public a(Context context) {
        this.f10289b = context.getApplicationContext();
    }

    public static synchronized a a(Context context) {
        try {
            if (f10287c == null) {
                f10287c = new a(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f10287c;
    }

    public void b(String str, int i10) {
        Context context = this.f10289b;
        if (context == null) {
            return;
        }
        if (this.f10288a == null) {
            this.f10288a = f(context);
        }
        SharedPreferences sharedPreferences = this.f10288a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putInt(str, i10).apply();
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
    }

    public void c(String str, String str2) throws Exception {
        Context context = this.f10289b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f10288a == null) {
            this.f10288a = f(context);
        }
        if (this.f10288a == null) {
            throw new Exception("sp is null");
        }
        if (!c.b().a(this.f10289b)) {
            throw new Exception("keystore encrypt error");
        }
        li.b bVar = new li.b();
        String strC = bVar.c(bVar.g(str2));
        if (TextUtils.isEmpty(strC)) {
            throw new Exception("rsaCrypter encrypt error");
        }
        SharedPreferences.Editor editorEdit = this.f10288a.edit();
        editorEdit.putString(str, strC);
        editorEdit.apply();
    }

    public boolean d(String str) {
        if (this.f10288a == null) {
            this.f10288a = f(this.f10289b);
        }
        SharedPreferences sharedPreferences = this.f10288a;
        return sharedPreferences != null && sharedPreferences.contains(str);
    }

    public int e(String str) {
        Context context = this.f10289b;
        if (context == null) {
            return -1;
        }
        if (this.f10288a == null) {
            this.f10288a = f(context);
        }
        SharedPreferences sharedPreferences = this.f10288a;
        if (sharedPreferences == null) {
            return -1;
        }
        try {
            return sharedPreferences.getInt(str, 0);
        } catch (Exception e10) {
            y3.b.d(e10.getMessage());
            return -1;
        }
    }

    public final SharedPreferences f(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("tcrypto", 0);
            this.f10288a = sharedPreferences;
            return sharedPreferences;
        } catch (Exception e10) {
            y3.b.d(e10.getMessage());
            return null;
        }
    }

    public void g(String str, String str2) {
        Context context = this.f10289b;
        if (context == null) {
            return;
        }
        if (this.f10288a == null) {
            this.f10288a = f(context);
        }
        SharedPreferences sharedPreferences = this.f10288a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putString(str, str2).apply();
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
    }

    public String h(String str) throws Exception {
        Context context = this.f10289b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f10288a == null) {
            this.f10288a = f(context);
        }
        if (this.f10288a == null) {
            throw new Exception("sp is null");
        }
        if (!c.b().a(this.f10289b)) {
            throw new Exception("keystore decrypt error");
        }
        String string = this.f10288a.getString(str, "");
        if (TextUtils.isEmpty(string) || string.contains("_")) {
            return "";
        }
        String str2 = new String(new li.b().f(Base64.decode(string, 2)));
        if (TextUtils.isEmpty(str2)) {
            throw new Exception("rsaCrypter decrypt error");
        }
        return str2;
    }

    public String i(String str) {
        Context context = this.f10289b;
        if (context == null) {
            return "";
        }
        if (this.f10288a == null) {
            this.f10288a = f(context);
        }
        SharedPreferences sharedPreferences = this.f10288a;
        if (sharedPreferences == null) {
            return "";
        }
        try {
            return sharedPreferences.getString(str, "");
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
            return "";
        }
    }
}
