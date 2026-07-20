package j9;

import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.content.ComponentName;
import android.os.Bundle;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8624c = "e";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final qb.e.a<e> f8625d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kc.b f8626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r6.b f8627b;

    public class a extends qb.e.a<e> {
        @Override // qb.e.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public e b() {
            return new e();
        }
    }

    public interface b {
        void a(ComponentName componentName, int i10, int i11, int i12, ComponentName componentName2);
    }

    public static e f() {
        return f8625d.c();
    }

    public int a(UsageStats usageStats) {
        if (usageStats != null) {
            return e(fc.b.a.f6001u).b(usageStats);
        }
        throw new IllegalArgumentException("UsageStats cannot be null");
    }

    public List<j9.a> b(long j10) throws ac.a {
        return e(fc.b.a.C).h(j10);
    }

    public List<j9.b> c(long j10) throws ac.a {
        return e(fc.b.a.C).f(j10);
    }

    public long d() throws ac.a {
        return e(fc.b.a.G).a();
    }

    public df.b e(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f8624c, "TranThubUsageStatsManager");
            kc.b bVar = this.f8626a;
            if (bVar != null) {
                return bVar;
            }
            kc.b bVar2 = new kc.b();
            this.f8626a = bVar2;
            return bVar2;
        }
        dc.e.f(f8624c, "TranAospUsageStatsManager");
        r6.b bVar3 = this.f8627b;
        if (bVar3 != null) {
            return bVar3;
        }
        r6.b bVar4 = new r6.b();
        this.f8627b = bVar4;
        return bVar4;
    }

    public Bundle g() throws ac.a {
        return e(fc.b.a.G).e();
    }

    @yb.a(level = 1)
    public UsageEvents h(long j10, long j11, int i10, String str, String str2) {
        return e(fc.b.a.f5989i).c(j10, j11, i10, str, str2);
    }

    public UsageEvents i(long j10, long j11, int i10, String str) {
        if (str != null) {
            return e(fc.b.a.C).g(j10, j11, i10, str);
        }
        throw new IllegalArgumentException("params cannot be null");
    }

    public void j(b bVar) throws ac.a {
        if (!fc.a.h()) {
            dc.e.c(f8624c, "the android platform is to low");
        } else if (bVar == null) {
            dc.e.c(f8624c, "the register listener is null");
        } else {
            e(fc.b.a.C).d(bVar);
        }
    }

    public void k() throws ac.a {
        if (fc.a.h()) {
            e(fc.b.a.C).i();
        } else {
            dc.e.c(f8624c, "the android platform is to low");
        }
    }
}
