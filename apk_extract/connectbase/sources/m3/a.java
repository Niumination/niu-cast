package m3;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileInputStream;
import java.io.IOException;
import k6.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @b.a({"StaticFieldLeak"})
    public static volatile a f10363f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f10364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f10367d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f10368e;

    public static a f() {
        if (f10363f == null) {
            synchronized (a.class) {
                try {
                    if (f10363f == null) {
                        f10363f = new a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f10363f;
    }

    public long a(long j10, long j11) {
        if (!this.f10366c) {
            return j10;
        }
        b bVar = this.f10364a;
        return (bVar.f10369a + j11) - bVar.f10370b;
    }

    public String b() {
        return this.f10365b;
    }

    public void c(t3.a aVar) {
        if (!this.f10366c) {
            if (TextUtils.isEmpty(this.f10365b)) {
                return;
            }
            aVar.j(this.f10365b);
        } else {
            long jG = (aVar.g() - this.f10364a.f10370b) + this.f10364a.f10369a;
            if (jG < 1633017600000L) {
                jG = aVar.i();
            }
            aVar.r(jG);
        }
    }

    public void d(boolean z10) {
        this.f10368e = z10;
        if (z10) {
            this.f10367d = SystemClock.elapsedRealtime();
        }
    }

    public boolean e(long j10) {
        this.f10368e = false;
        this.f10367d = -1L;
        if (j10 > 1633017600000L) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f10364a = new b(j10, SystemClock.elapsedRealtime(), this.f10365b);
            if (Math.abs(jCurrentTimeMillis - j10) > 600000) {
                this.f10366c = true;
            }
            try {
                if (!TextUtils.isEmpty(this.f10365b)) {
                    m0.a aVarA = m0.a.a(g.h0());
                    b bVar = this.f10364a;
                    bVar.getClass();
                    aVarA.g("base_time", new JSONObject().put("serverTime", bVar.f10369a).put("elapsedRealtime", bVar.f10370b).put("bootId", bVar.f10371c).toString());
                }
            } catch (Exception e10) {
                y3.b.d(Log.getStackTraceString(e10));
            }
        } else {
            this.f10364a = new b(System.currentTimeMillis(), SystemClock.elapsedRealtime(), this.f10365b);
            this.f10366c = false;
        }
        return this.f10366c;
    }

    public long g() {
        b bVar = this.f10364a;
        if (bVar != null) {
            return bVar.f10369a - bVar.f10370b;
        }
        return 0L;
    }

    public void h() {
        FileInputStream fileInputStream;
        String strTrim;
        try {
            String strI = m0.a.a(g.h0()).i("base_time");
            y3.b.b("baseTimeJs = " + strI);
            if (!TextUtils.isEmpty(strI)) {
                this.f10364a = new b(strI);
            }
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream("/proc/sys/kernel/random/boot_id");
            try {
                byte[] bArr = new byte[1024];
                int i10 = fileInputStream.read(bArr);
                if (i10 > 0) {
                    strTrim = new String(bArr, 0, i10).trim();
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                } else {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                    strTrim = null;
                }
            } catch (Exception unused3) {
                if (fileInputStream != null) {
                }
                strTrim = null;
                this.f10365b = strTrim;
                if (this.f10364a != null) {
                    return;
                } else {
                    return;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
        }
        this.f10365b = strTrim;
        if (this.f10364a != null || TextUtils.isEmpty(strTrim)) {
            return;
        }
        if (!this.f10365b.equals(this.f10364a.f10371c)) {
            this.f10364a = null;
            m0.a.a(g.f9114q).g("base_time", "");
            return;
        }
        if (Math.abs(((SystemClock.elapsedRealtime() - this.f10364a.f10370b) + this.f10364a.f10369a) - System.currentTimeMillis()) > 600000) {
            this.f10366c = true;
        }
    }

    public boolean i() {
        return this.f10368e;
    }

    public boolean j() {
        if (this.f10367d > 0 && SystemClock.elapsedRealtime() - this.f10367d > 60000) {
            return false;
        }
        b bVar = this.f10364a;
        return bVar == null || !TextUtils.equals(bVar.f10371c, this.f10365b);
    }
}
