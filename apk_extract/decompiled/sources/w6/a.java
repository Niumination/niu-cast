package w6;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static volatile a f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f10666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f10669d;
    public volatile boolean e;

    public static a c() {
        if (f == null) {
            synchronized (a.class) {
                try {
                    if (f == null) {
                        a aVar = new a();
                        aVar.f10669d = -1L;
                        f = aVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f;
    }

    public final void a(t6.a aVar) {
        if (!this.f10668c) {
            if (TextUtils.isEmpty(this.f10667b)) {
                return;
            }
            aVar.f10172h = this.f10667b;
        } else {
            b bVar = this.f10666a;
            long j8 = (aVar.f10171g - bVar.f10671b) + bVar.f10670a;
            if (j8 < 1633017600000L) {
                j8 = aVar.f;
            }
            aVar.f = j8;
        }
    }

    public final boolean b(long j8) {
        this.e = false;
        this.f10669d = -1L;
        if (j8 > 1633017600000L) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f10666a = new b(j8, SystemClock.elapsedRealtime(), this.f10667b);
            if (Math.abs(jCurrentTimeMillis - j8) > 600000) {
                this.f10668c = true;
            }
            try {
                if (!TextUtils.isEmpty(this.f10667b)) {
                    i1.a aVarA = i1.a.a(e8.b.f4712i);
                    b bVar = this.f10666a;
                    bVar.getClass();
                    aVarA.g("base_time", new JSONObject().put("serverTime", bVar.f10670a).put("elapsedRealtime", bVar.f10671b).put("bootId", bVar.f10672c).toString());
                }
            } catch (Exception e) {
                z6.a.c(Log.getStackTraceString(e));
            }
        } else {
            this.f10666a = new b(System.currentTimeMillis(), SystemClock.elapsedRealtime(), this.f10667b);
            this.f10668c = false;
        }
        return this.f10668c;
    }
}
