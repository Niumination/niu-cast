package ai;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static e f256c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f257d = "gateway_core";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f259b;

    public e(Context context) {
        this.f259b = context.getApplicationContext();
    }

    public static synchronized e a(Context context) {
        try {
            if (f256c == null) {
                f256c = new e(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f256c;
    }

    public int b(String key) {
        Context context = this.f259b;
        if (context == null) {
            return -1;
        }
        if (this.f258a == null) {
            this.f258a = d(context);
        }
        SharedPreferences sharedPreferences = this.f258a;
        if (sharedPreferences == null) {
            return -1;
        }
        try {
            return sharedPreferences.getInt(key, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    public long c(String key) {
        Context context = this.f259b;
        if (context == null) {
            return -1L;
        }
        if (this.f258a == null) {
            this.f258a = d(context);
        }
        SharedPreferences sharedPreferences = this.f258a;
        if (sharedPreferences == null) {
            return -1L;
        }
        try {
            return sharedPreferences.getLong(key, 0L);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final SharedPreferences d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f257d, 0);
            this.f258a = sharedPreferences;
            return sharedPreferences;
        } catch (Exception unused) {
            return null;
        }
    }

    public String e(String key) {
        Context context = this.f259b;
        if (context == null) {
            return "";
        }
        if (this.f258a == null) {
            this.f258a = d(context);
        }
        SharedPreferences sharedPreferences = this.f258a;
        if (sharedPreferences == null) {
            return "";
        }
        try {
            return sharedPreferences.getString(key, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public void f(String key, int data) {
        Context context = this.f259b;
        if (context == null) {
            return;
        }
        if (this.f258a == null) {
            this.f258a = d(context);
        }
        SharedPreferences sharedPreferences = this.f258a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putInt(key, data).apply();
        } catch (Exception unused) {
        }
    }

    public void g(String key, long data) {
        Context context = this.f259b;
        if (context == null) {
            return;
        }
        if (this.f258a == null) {
            this.f258a = d(context);
        }
        SharedPreferences sharedPreferences = this.f258a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putLong(key, data).apply();
        } catch (Exception unused) {
        }
    }

    public void h(String key, String data) {
        Context context = this.f259b;
        if (context == null) {
            return;
        }
        if (this.f258a == null) {
            this.f258a = d(context);
        }
        SharedPreferences sharedPreferences = this.f258a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putString(key, data).apply();
        } catch (Exception unused) {
        }
    }
}
