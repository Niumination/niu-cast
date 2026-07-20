package n9;

import android.content.BroadcastReceiver;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hf.a f11424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public hf.a f11425b;

    public int a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return -1;
        }
        return b(fc.b.a.E).a(broadcastReceiver);
    }

    public hf.a b(String str) {
        if (fc.b.b(str)) {
            hf.a aVar = this.f11424a;
            if (aVar != null) {
                return aVar;
            }
            oc.a aVar2 = new oc.a();
            this.f11424a = aVar2;
            return aVar2;
        }
        hf.a aVar3 = this.f11425b;
        if (aVar3 != null) {
            return aVar3;
        }
        v6.a aVar4 = new v6.a();
        this.f11425b = aVar4;
        return aVar4;
    }
}
