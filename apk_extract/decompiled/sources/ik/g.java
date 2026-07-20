package ik;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements ek.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ek.g f5889b;

    public /* synthetic */ g(ek.g gVar, int i8) {
        this.f5888a = i8;
        this.f5889b = gVar;
    }

    @Override // ek.g
    public final Object call(Object obj) {
        switch (this.f5888a) {
            case 0:
                ck.c cVar = (ck.c) obj;
                l lVar = n.RETURNS_VOID;
                cVar.getClass();
                return (ck.c) this.f5889b.call(cVar.a(new a8.a(lVar, 7)));
            default:
                ck.c cVar2 = (ck.c) obj;
                c cVar3 = n.ERROR_EXTRACTOR;
                cVar2.getClass();
                return (ck.c) this.f5889b.call(cVar2.a(new a8.a(cVar3, 7)));
        }
    }
}
