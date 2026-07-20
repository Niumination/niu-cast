package i4;

import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f5561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ d f5562i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(d dVar, int i8) {
        super(dVar);
        this.f5561h = i8;
        this.f5562i = dVar;
    }

    @Override // i4.c
    public final Object b(int i8) {
        switch (this.f5561h) {
            case 0:
                k4 k4Var = this.f5562i.backingMap;
                v8.h(i8, k4Var.f5624c);
                return k4Var.f5622a[i8];
            default:
                k4 k4Var2 = this.f5562i.backingMap;
                v8.h(i8, k4Var2.f5624c);
                return new j4(k4Var2, i8);
        }
    }
}
