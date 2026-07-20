package ta;

import android.app.NotificationManager;
import gm.i;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public td.b f15548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c8.b f15549b;

    public boolean a(@i NotificationManager.Policy policy) {
        return b(fc.b.a.f5998r).a(policy);
    }

    public ng.b b(String str) {
        if (fc.b.b(str)) {
            td.b bVar = this.f15548a;
            if (bVar != null) {
                return bVar;
            }
            td.b bVar2 = new td.b();
            this.f15548a = bVar2;
            return bVar2;
        }
        c8.b bVar3 = this.f15549b;
        if (bVar3 != null) {
            return bVar3;
        }
        c8.b bVar4 = new c8.b();
        this.f15549b = bVar4;
        return bVar4;
    }
}
