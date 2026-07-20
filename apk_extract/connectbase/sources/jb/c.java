package jb;

import android.telephony.NetworkRegistrationInfo;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8637c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public je.f f8638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t8.c f8639b;

    public dh.c a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f8637c, "TranThubNetworkRegistrationInfo");
            je.f fVar = this.f8638a;
            if (fVar != null) {
                return fVar;
            }
            je.f fVar2 = new je.f();
            this.f8638a = fVar2;
            return fVar2;
        }
        dc.e.f(f8637c, "TranAospNetworkRegistrationInfo");
        t8.c cVar = this.f8639b;
        if (cVar != null) {
            return cVar;
        }
        t8.c cVar2 = new t8.c();
        this.f8639b = cVar2;
        return cVar2;
    }

    public boolean b(NetworkRegistrationInfo networkRegistrationInfo) {
        if (networkRegistrationInfo != null) {
            return a(fc.b.a.f6001u).a(networkRegistrationInfo);
        }
        throw new IllegalArgumentException("NetworkRegistrationInfo is null");
    }
}
