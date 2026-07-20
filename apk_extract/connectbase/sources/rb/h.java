package rb;

import android.view.InputEvent;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14388c = "h";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f14389d = 524288;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14390e = 2097152;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f14391f = 4194304;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.f f14392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.e f14393b;

    public lh.f a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f14388c, "TranThubMotionEventManager");
            re.f fVar = this.f14392a;
            if (fVar != null) {
                return fVar;
            }
            re.f fVar2 = new re.f();
            this.f14392a = fVar2;
            return fVar2;
        }
        dc.e.f(f14388c, "TranAospMotionEventManager");
        b9.e eVar = this.f14393b;
        if (eVar != null) {
            return eVar;
        }
        b9.e eVar2 = new b9.e();
        this.f14393b = eVar2;
        return eVar2;
    }

    public int b() {
        return 524288;
    }

    public int c() {
        return 4194304;
    }

    public int d() {
        return 2097152;
    }

    public MotionEvent e(long j10, long j11, int i10, int i11, MotionEvent.PointerProperties[] pointerPropertiesArr, MotionEvent.PointerCoords[] pointerCoordsArr, int i12, int i13, float f10, float f11, int i14, int i15, int i16, int i17, int i18) {
        return a(fc.b.a.f5989i).a(j10, j11, i10, i11, pointerPropertiesArr, pointerCoordsArr, i12, i13, f10, f11, i14, i15, i16, i17, i18);
    }

    public void f(InputEvent inputEvent, boolean z10) {
        a(fc.b.a.f5989i).b(inputEvent, z10);
    }
}
