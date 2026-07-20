package si;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import ui.c;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f15073f = "TrackDelegator";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile b f15074g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f15075a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public si.a f15077c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ContentObserver f15079e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15076b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15078d = false;

    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            b bVar = b.this;
            bVar.f15076b = Settings.System.getInt(bVar.f15075a.getContentResolver(), "user_experience", 0) == 1;
            c.e(b.f15073f, "user_experience:" + b.this.f15076b, null, null, null);
            try {
                b bVar2 = b.this;
                bVar2.f15077c.b(bVar2.f15076b);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: si.b$b, reason: collision with other inner class name */
    public static class C0370b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bundle f15081a = new Bundle();

        public C0370b a(String str, Object obj) {
            if (obj instanceof String) {
                this.f15081a.putString(str, (String) obj);
            } else if (obj instanceof Integer) {
                this.f15081a.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                this.f15081a.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Long) {
                this.f15081a.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                this.f15081a.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Bundle) {
                this.f15081a.putAll((Bundle) obj);
            }
            return this;
        }

        public C0370b b(String str, Object obj) {
            return a(str, obj);
        }

        public Bundle c() {
            return this.f15081a;
        }
    }

    public b(Context context) {
        a aVar = new a(new Handler(Looper.getMainLooper()));
        this.f15079e = aVar;
        this.f15075a = context;
        if (this.f15078d) {
            this.f15077c = new ti.b();
        } else {
            this.f15077c = new ti.a(context);
        }
        this.f15075a.getContentResolver().registerContentObserver(Settings.System.getUriFor("user_experience"), true, aVar);
        aVar.onChange(true);
    }

    public static b e(Context context) {
        if (f15074g == null) {
            synchronized (b.class) {
                try {
                    if (f15074g == null) {
                        f15074g = new b(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f15074g;
    }

    public void f() {
        if (this.f15076b) {
            c.e(null, "trackWidgetsVersion", null, null, null);
            this.f15077c.a("v", new C0370b().a("widget", "13a").c(), ti.a.f15566d);
        }
    }
}
