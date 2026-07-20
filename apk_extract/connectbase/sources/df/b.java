package df;

import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.os.Bundle;
import j9.e;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    long a() throws ac.a;

    int b(UsageStats usageStats);

    UsageEvents c(long j10, long j11, int i10, String str, String str2);

    void d(e.b bVar) throws ac.a;

    Bundle e() throws ac.a;

    List<j9.b> f(long j10) throws ac.a;

    UsageEvents g(long j10, long j11, int i10, String str);

    List<j9.a> h(long j10) throws ac.a;

    void i() throws ac.a;
}
