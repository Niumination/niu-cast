package e0;

import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;
import x4.t;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Interpolator, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4658b;

    public /* synthetic */ a(String str, int i8) {
        this.f4657a = i8;
        this.f4658b = str;
    }

    @Override // x4.t
    public Object construct() {
        int i8 = this.f4657a;
        String str = this.f4658b;
        switch (i8) {
            case 1:
                return x4.b.lambda$get$2(str);
            case 2:
                return x4.b.lambda$newDefaultConstructor$7(str);
            case 3:
                return x4.b.lambda$newDefaultConstructor$8(str);
            case 4:
                return x4.b.lambda$get$3(str);
            case 5:
                return x4.b.lambda$get$4(str);
            default:
                return x4.b.lambda$newUnsafeAllocator$20(str);
        }
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f) {
        return Transition.lambda$getInterpolator$0(this.f4658b, f);
    }
}
