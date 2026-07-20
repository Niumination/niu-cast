package v9;

import com.transsion.hubsdk.view.TranUnionRenderEffect;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ga.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranUnionRenderEffect f10527a;

    public a(boolean z2) {
        if (z2) {
            this.f10527a = new TranUnionRenderEffect();
        }
    }

    @Override // ga.a
    public final void a(int i8, int i9, int i10, int i11, int i12, int i13) {
        this.f10527a.enableBlendColorLight(i8, i9, i10, i11, i12, i13);
    }

    @Override // ga.a
    public final void b(float f) {
        this.f10527a.enableLocalBlurRadius(f);
    }

    @Override // ga.a
    public final TranUnionRenderEffect c() {
        return this.f10527a;
    }

    @Override // ga.a
    public final void d() {
        this.f10527a.setRequestWindowType(1);
    }

    @Override // ga.a
    public final void e() {
        this.f10527a.enableUnionBlur();
    }

    @Override // ga.a
    public final void f(int i8, int i9, int i10, int i11, int i12, int i13) {
        this.f10527a.enableBlendColorDark(i8, i9, i10, i11, i12, i13);
    }

    @Override // ga.a
    public final void g() {
        this.f10527a.enableCrossWindowBlur();
    }
}
