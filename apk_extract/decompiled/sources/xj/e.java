package xj;

import af.w0;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vj.a f11011b;

    public e(int i8) {
        this.f11010a = i8;
        switch (i8) {
            case 1:
                this.f11011b = new w0();
                new ConcurrentHashMap();
                new ThreadLocal();
                new b();
                break;
            default:
                this.f11011b = new se.h();
                new ConcurrentHashMap();
                break;
        }
    }
}
