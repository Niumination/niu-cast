package z5;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.transsion.connectx.sdk.TCCPSourceApi;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import k4.m;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f21838e = "NavModeManager";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f21839f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f21840g = "navigation_mode";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static b f21841h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedDeque<z5.a> f21843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ContentResolver f21844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ContentObserver f21845d;

    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            int iE = b.this.e();
            if (b.this.f21842a == iE) {
                return;
            }
            m.b(b.f21838e, "Nav mode contentResolver is change");
            b bVar = b.this;
            bVar.f21842a = iE;
            Iterator<z5.a> it = bVar.f21843b.iterator();
            while (it.hasNext()) {
                it.next().a(b.this.f21842a);
            }
        }
    }

    public b(ContentResolver contentResolver) {
        this.f21843b = new ConcurrentLinkedDeque<>();
        this.f21845d = new a(null);
        this.f21844c = contentResolver;
    }

    public static b f(Context context) {
        if (f21841h == null) {
            synchronized (TCCPSourceApi.class) {
                try {
                    if (f21841h == null) {
                        f21841h = new b(context.getContentResolver());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f21841h;
    }

    public void d() {
        if (this.f21844c == null) {
            return;
        }
        m.b(f21838e, "cancel nav mode observer");
        this.f21844c.unregisterContentObserver(this.f21845d);
    }

    public int e() {
        return Settings.Secure.getInt(this.f21844c, "navigation_mode", 0);
    }

    public boolean g() {
        return 2 == Settings.Secure.getInt(this.f21844c, "navigation_mode", 0);
    }

    public void h(z5.a aVar) {
        m.b(f21838e, "register nav mode change listener");
        this.f21843b.add(aVar);
    }

    public void i() {
        if (this.f21844c == null) {
            return;
        }
        m.b(f21838e, "start nav mode observer");
        this.f21842a = Settings.Secure.getInt(this.f21844c, "navigation_mode", 0);
        this.f21844c.registerContentObserver(Settings.Secure.getUriFor("navigation_mode"), false, this.f21845d);
    }

    public void j(z5.a aVar) {
        m.b(f21838e, "unregister nav mode change listener");
        this.f21843b.remove(aVar);
    }

    public b() {
        this.f21843b = new ConcurrentLinkedDeque<>();
        this.f21845d = new a(null);
        this.f21844c = null;
    }
}
