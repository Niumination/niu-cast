package jb;

import android.telephony.ServiceState;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8643c = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public je.g f8644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t8.d f8645b;

    public int a(ServiceState serviceState) {
        if (serviceState != null) {
            return b(fc.b.a.f6001u).a(serviceState);
        }
        throw new IllegalArgumentException("ServiceState is null");
    }

    public dh.d b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f8643c, "TranThubServiceState");
            je.g gVar = this.f8644a;
            if (gVar != null) {
                return gVar;
            }
            je.g gVar2 = new je.g();
            this.f8644a = gVar2;
            return gVar2;
        }
        dc.e.f(f8643c, "TranAospServiceState");
        t8.d dVar = this.f8645b;
        if (dVar != null) {
            return dVar;
        }
        t8.d dVar2 = new t8.d();
        this.f8645b = dVar2;
        return dVar2;
    }

    public int c(ServiceState serviceState) {
        if (serviceState != null) {
            return b(fc.b.a.f6001u).b(serviceState);
        }
        throw new IllegalArgumentException("ServiceState is null");
    }
}
