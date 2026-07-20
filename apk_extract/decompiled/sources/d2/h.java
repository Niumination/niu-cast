package d2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4280b;

    public /* synthetic */ h(Object obj, int i8) {
        this.f4279a = i8;
        this.f4280b = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f4279a) {
            case 0:
                ((ExecutorService) this.f4280b).execute(new af.f(runnable, 15));
                break;
            case 1:
                ((h3.e) this.f4280b).post(runnable);
                break;
            case 2:
                ((h3.e) this.f4280b).post(runnable);
                break;
            default:
                ((Handler) this.f4280b).post(runnable);
                break;
        }
    }

    public h(int i8) {
        this.f4279a = i8;
        switch (i8) {
            case 3:
                this.f4280b = new Handler(Looper.getMainLooper());
                break;
            default:
                this.f4280b = new h3.e(Looper.getMainLooper(), 3);
                break;
        }
    }
}
