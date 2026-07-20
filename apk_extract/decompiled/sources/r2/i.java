package r2;

import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Feature[] f9335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f9338d;

    public i a() {
        u2.l.a("execute parameter required", ((h) this.f9338d) != null);
        Feature[] featureArr = this.f9335a;
        boolean z2 = this.f9336b;
        int i8 = this.f9337c;
        i iVar = new i();
        iVar.f9338d = this;
        iVar.f9335a = featureArr;
        boolean z3 = false;
        if (featureArr != null && z2) {
            z3 = true;
        }
        iVar.f9336b = z3;
        iVar.f9337c = i8;
        return iVar;
    }
}
