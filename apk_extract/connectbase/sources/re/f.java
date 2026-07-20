package re;

import android.view.InputEvent;
import android.view.MotionEvent;
import com.transsion.hubsdk.hardware.input.TranMotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public class f implements lh.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f14469b = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranMotionEvent f14470a;

    @Override // lh.f
    public MotionEvent a(long j10, long j11, int i10, int i11, MotionEvent.PointerProperties[] pointerPropertiesArr, MotionEvent.PointerCoords[] pointerCoordsArr, int i12, int i13, float f10, float f11, int i14, int i15, int i16, int i17, int i18) {
        return TranMotionEvent.obtain(j10, j11, i10, i11, pointerPropertiesArr, pointerCoordsArr, i12, i13, f10, f11, i14, i15, i16, i17, i18);
    }

    @Override // lh.f
    public void b(InputEvent inputEvent, boolean z10) {
        c().setTouchFromConnect(inputEvent, z10);
    }

    public final TranMotionEvent c() {
        if (this.f14470a == null) {
            this.f14470a = new TranMotionEvent();
        }
        return this.f14470a;
    }
}
