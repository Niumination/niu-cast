package ik;

import af.s1;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends s1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5904c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(int i8) {
        super((byte) 0, 1);
        this.f5904c = i8;
    }

    @Override // af.s1
    public final Object f() {
        switch (this.f5904c) {
            case 0:
                return new kk.o(s.f5906b);
            default:
                return new kk.j(s.f5906b);
        }
    }
}
