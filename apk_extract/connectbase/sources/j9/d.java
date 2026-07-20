package j9;

import android.app.usage.UsageEvents;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8621c = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kc.a f8622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r6.a f8623b;

    public String a(UsageEvents.Event event) {
        if (event != null) {
            return b(fc.b.a.f6001u).a(event);
        }
        throw new IllegalArgumentException("event cannot be null");
    }

    public df.a b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f8621c, "TranThubUsageEvents");
            kc.a aVar = this.f8622a;
            if (aVar != null) {
                return aVar;
            }
            kc.a aVar2 = new kc.a();
            this.f8622a = aVar2;
            return aVar2;
        }
        dc.e.f(f8621c, "TranAospUsageEvents");
        r6.a aVar3 = this.f8623b;
        if (aVar3 != null) {
            return aVar3;
        }
        r6.a aVar4 = new r6.a();
        this.f8623b = aVar4;
        return aVar4;
    }
}
