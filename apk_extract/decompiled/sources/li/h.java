package li;

import java.util.concurrent.ScheduledFuture;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f7457b;

    public /* synthetic */ h(Object obj, int i8) {
        this.f7456a = i8;
        this.f7457b = obj;
    }

    @Override // li.i
    public final void a(Throwable th2) {
        switch (this.f7456a) {
            case 0:
                ((ScheduledFuture) this.f7457b).cancel(false);
                break;
            case 1:
                ((Function1) this.f7457b).invoke(th2);
                break;
            default:
                ((x0) this.f7457b).dispose();
                break;
        }
    }

    public final String toString() {
        switch (this.f7456a) {
            case 0:
                return "CancelFutureOnCancel[" + ((ScheduledFuture) this.f7457b) + ']';
            case 1:
                return "CancelHandler.UserSupplied[" + ((Function1) this.f7457b).getClass().getSimpleName() + '@' + l0.j(this) + ']';
            default:
                return "DisposeOnCancel[" + ((x0) this.f7457b) + ']';
        }
    }
}
