package i4;

/* JADX INFO: loaded from: classes.dex */
public final class k extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f5615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ o f5616i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(o oVar, int i8) {
        super(oVar);
        this.f5615h = i8;
        this.f5616i = oVar;
    }

    @Override // i4.c
    public final Object a(int i8) {
        switch (this.f5615h) {
            case 0:
                return o.access$100(this.f5616i, i8);
            case 1:
                return new m(this.f5616i, i8);
            default:
                return o.access$600(this.f5616i, i8);
        }
    }
}
