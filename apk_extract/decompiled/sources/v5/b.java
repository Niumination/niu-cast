package v5;

import o4.u;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements o4.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ b f10501b = new b(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ b f10502c = new b(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10503a;

    public /* synthetic */ b(int i8) {
        this.f10503a = i8;
    }

    @Override // o4.c
    public final Object a(u uVar) {
        switch (this.f10503a) {
            case 0:
                return new d((p5.f) uVar.a(p5.f.class));
            default:
                return new c((d) uVar.a(d.class), (p5.d) uVar.a(p5.d.class), (p5.f) uVar.a(p5.f.class));
        }
    }
}
