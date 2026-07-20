package eb;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class z1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f4835b;

    public /* synthetic */ z1(int i8, Function0 function0) {
        this.f4834a = i8;
        this.f4835b = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4834a) {
            case 0:
                this.f4835b.invoke();
                break;
            default:
                this.f4835b.invoke();
                break;
        }
    }
}
