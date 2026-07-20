package a8;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f45a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f46b;

    public /* synthetic */ b(Runnable runnable, int i8) {
        this.f45a = i8;
        this.f46b = runnable;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j8) {
        switch (this.f45a) {
            case 0:
                ((a4.c) this.f46b).run();
                break;
            default:
                ((m.c) this.f46b).run();
                break;
        }
    }
}
