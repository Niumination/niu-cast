package re;

import android.graphics.Bitmap;
import com.transsion.hubsdk.view.TranUnionRenderEffect;

/* JADX INFO: loaded from: classes2.dex */
public class k implements lh.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranUnionRenderEffect f14476a;

    public k(boolean z10) {
        if (z10) {
            this.f14476a = new TranUnionRenderEffect();
        }
    }

    @Override // lh.j
    public boolean A() {
        return this.f14476a.isAutoInvalidate();
    }

    @Override // lh.j
    public void B(int i10) {
        this.f14476a.setApiMode(i10);
    }

    @Override // lh.j
    public void C() {
        this.f14476a.enableAutoInvalidateWhenCrossWindowUpdate();
    }

    @Override // lh.j
    public void D() {
        this.f14476a.enableCrossWindowBlur();
    }

    @Override // lh.j
    public void E() {
        this.f14476a.disableStaticBlur();
    }

    @Override // lh.j
    public void F(float f10) {
        this.f14476a.enableMaxCrossFadeRadius(f10);
    }

    @Override // lh.j
    public void G() {
        this.f14476a.disableBlendColorDark();
    }

    @Override // lh.j
    public boolean H(int i10) {
        return this.f14476a.requestFrameSpacing(i10);
    }

    @Override // lh.j
    public boolean I() {
        return this.f14476a.isBackdropBlur();
    }

    @Override // lh.j
    public boolean J() {
        return this.f14476a.requiresNoEffect();
    }

    @Override // lh.j
    public void K() {
        this.f14476a.disableMaxCrossFadeRadius();
    }

    public final TranUnionRenderEffect L() {
        return this.f14476a;
    }

    public void M(TranUnionRenderEffect tranUnionRenderEffect) {
        this.f14476a = tranUnionRenderEffect;
    }

    @Override // lh.j
    public void a() {
        this.f14476a.disableBlendColorLight();
    }

    @Override // lh.j
    public void b() {
        this.f14476a.disableBackdropBlur();
    }

    @Override // lh.j
    public void c() {
        this.f14476a.disableGlobalBlurRadius();
    }

    @Override // lh.j
    public void d(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f14476a.enableBlendColorLight(i10, i11, i12, i13, i14, i15);
    }

    @Override // lh.j
    public void e() {
        this.f14476a.disableMirrorScale();
    }

    @Override // lh.j
    public void f() {
        this.f14476a.disableUnionBlur();
    }

    @Override // lh.j
    public void g() {
        this.f14476a.disableRoundCorner();
    }

    @Override // lh.j
    public boolean h() {
        return this.f14476a.isUnionBlur();
    }

    @Override // lh.j
    public boolean i() {
        return this.f14476a.isStaticBlur();
    }

    @Override // lh.j
    public void j(float f10) {
        this.f14476a.enableLocalBlurRadius(f10);
    }

    @Override // lh.j
    public void k(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.f14476a.enableDynamicBlendColorDark(i10, i11, i12, i13, i14, i15, i16, i17, i18);
    }

    @Override // lh.j
    public TranUnionRenderEffect l() {
        return this.f14476a;
    }

    @Override // lh.j
    public void m(TranUnionRenderEffect.TranBlendColor tranBlendColor) {
        this.f14476a.enableBlendColorDark(tranBlendColor);
    }

    @Override // lh.j
    public void n(float f10) {
        this.f14476a.enableMirrorScale(f10);
    }

    @Override // lh.j
    public void o() {
        this.f14476a.disableLocalBlurRadius();
    }

    @Override // lh.j
    public void p() {
        this.f14476a.disableCrossWindowBlur();
    }

    @Override // lh.j
    public void q(int i10) {
        this.f14476a.setBlurAlgorithm(i10);
    }

    @Override // lh.j
    public void r(Bitmap bitmap, boolean z10, float f10) {
        this.f14476a.enableStaticBlur(bitmap, z10, f10);
    }

    @Override // lh.j
    public void s() {
        this.f14476a.disableAutoInvalidateWhenCrossWindowUpdate();
    }

    @Override // lh.j
    public void t(float f10, boolean z10, float f11) {
        this.f14476a.enableRoundCorner(f10, z10, f11);
    }

    @Override // lh.j
    public void u() {
        this.f14476a.enableUnionBlur();
    }

    @Override // lh.j
    public void v(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f14476a.enableBlendColorDark(i10, i11, i12, i13, i14, i15);
    }

    @Override // lh.j
    public void w(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.f14476a.enableDynamicBlendColorLight(i10, i11, i12, i13, i14, i15, i16, i17, i18);
    }

    @Override // lh.j
    public void x() {
        this.f14476a.enableBackdropBlur();
    }

    @Override // lh.j
    public void y(float f10) {
        this.f14476a.enableGlobalBlurRadius(f10);
    }

    @Override // lh.j
    public void z(TranUnionRenderEffect.TranBlendColor tranBlendColor) {
        this.f14476a.enableBlendColorLight(tranBlendColor);
    }
}
