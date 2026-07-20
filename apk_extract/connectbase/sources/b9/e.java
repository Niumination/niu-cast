package b9;

import android.content.Context;
import android.view.InputEvent;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public class e implements lh.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f761b = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f762a = bc.a.a();

    @Override // lh.f
    public MotionEvent a(long j10, long j11, int i10, int i11, MotionEvent.PointerProperties[] pointerPropertiesArr, MotionEvent.PointerCoords[] pointerCoordsArr, int i12, int i13, float f10, float f11, int i14, int i15, int i16, int i17, int i18) {
        Class cls = Long.TYPE;
        Class cls2 = Integer.TYPE;
        Class cls3 = Float.TYPE;
        Object objJ = cc.a.j(cc.a.g(MotionEvent.class, "obtain", cls, cls, cls2, cls2, MotionEvent.PointerProperties[].class, MotionEvent.PointerCoords[].class, cls2, cls2, cls3, cls3, cls2, cls2, cls2, cls2, cls2), MotionEvent.class, Long.valueOf(j10), Long.valueOf(j11), Integer.valueOf(i10), Integer.valueOf(i11), pointerPropertiesArr, pointerCoordsArr, Integer.valueOf(i12), Integer.valueOf(i13), Float.valueOf(f10), Float.valueOf(f11), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        if (objJ instanceof MotionEvent) {
            return (MotionEvent) objJ;
        }
        return null;
    }

    @Override // lh.f
    public void b(InputEvent inputEvent, boolean z10) {
        try {
            cc.a.j(cc.a.g(MotionEvent.class, "setTouchFromConnect", Boolean.TYPE), inputEvent, Boolean.valueOf(z10));
        } catch (Exception e10) {
            throw new AssertionError(e10);
        }
    }
}
