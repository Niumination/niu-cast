package p9;

import android.content.pm.PackageInstaller;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13038c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jf.c f13039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public jf.c f13040b;

    public jf.c a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f13038c, "TranThubPackageInstaller");
            jf.c cVar = this.f13039a;
            if (cVar != null) {
                return cVar;
            }
            qc.c cVar2 = new qc.c();
            this.f13039a = cVar2;
            return cVar2;
        }
        dc.e.f(f13038c, "TranAospPackageInstaller");
        jf.c cVar3 = this.f13040b;
        if (cVar3 != null) {
            return cVar3;
        }
        x6.c cVar4 = new x6.c();
        this.f13040b = cVar4;
        return cVar4;
    }

    public void b(PackageInstaller.SessionParams sessionParams, boolean z10) {
        if (sessionParams == null) {
            throw new IllegalArgumentException("param cannot be null");
        }
        a(fc.b.a.f5986f).a(sessionParams, z10);
    }
}
