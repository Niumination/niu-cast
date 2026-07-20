package o;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8340c;

    public /* synthetic */ e(int i8, Object obj, Object obj2) {
        this.f8338a = i8;
        this.f8339b = obj;
        this.f8340c = obj2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0507, code lost:
    
        if (r3.equals("com.welink.service.ACTION_NEAR_SERVICE_ACTIVATED") == false) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x054a, code lost:
    
        if (r3.equals("com.welink.service.ACTION_NEAR_SERVICE_DEACTIVATED") == false) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x054e, code lost:
    
        r0 = r1.getIntExtra("com.welink.service.EXTRA_NEAR_SERVICE_ENABLED", -1);
        r3 = 0;
        r2.f(new se.i5(r2, r0, r3));
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 2368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.e.run():void");
    }

    public /* synthetic */ e(Object obj, Object obj2, int i8, int i9) {
        this.f8338a = i9;
        this.f8339b = obj;
        this.f8340c = obj2;
    }
}
