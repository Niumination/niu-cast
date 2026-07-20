package md;

import com.transsion.hubsdk.internal.widget.TranLockPatternView;

/* JADX INFO: loaded from: classes2.dex */
public class b implements gg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranLockPatternView f10635a = new TranLockPatternView();

    @Override // gg.a
    public void a(Object obj, int i10) {
        TranLockPatternView tranLockPatternView = this.f10635a;
        if (tranLockPatternView != null) {
            tranLockPatternView.setPathWidth(obj, i10);
        }
    }

    @Override // gg.a
    public void b(Object obj, int i10) {
        TranLockPatternView tranLockPatternView = this.f10635a;
        if (tranLockPatternView != null) {
            tranLockPatternView.setDotSize(obj, i10);
        }
    }

    @Override // gg.a
    public void c(Object obj, int i10, int i11, int i12) {
        TranLockPatternView tranLockPatternView = this.f10635a;
        if (tranLockPatternView != null) {
            tranLockPatternView.setColors(obj, i10, i11, i12);
        }
    }
}
