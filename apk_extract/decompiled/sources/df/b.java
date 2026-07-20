package df;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f4431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f4432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4433d;

    public b(boolean z2) {
        this.f4430a = z2;
    }

    public final void a(a... aVarArr) {
        if (!this.f4430a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        String[] strArr = new String[aVarArr.length];
        for (int i8 = 0; i8 < aVarArr.length; i8++) {
            strArr[i8] = aVarArr[i8].javaName;
        }
        this.f4431b = strArr;
    }

    public final void b(n... nVarArr) {
        if (!this.f4430a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        if (nVarArr.length == 0) {
            throw new IllegalArgumentException("At least one TlsVersion is required");
        }
        String[] strArr = new String[nVarArr.length];
        for (int i8 = 0; i8 < nVarArr.length; i8++) {
            strArr[i8] = nVarArr[i8].javaName;
        }
        this.f4432c = strArr;
    }

    public b(c cVar) {
        this.f4430a = cVar.f4434a;
        this.f4431b = cVar.f4435b;
        this.f4432c = cVar.f4436c;
        this.f4433d = cVar.f4437d;
    }
}
