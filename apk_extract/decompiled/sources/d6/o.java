package d6;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HandlerThread f4334a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f4335b = null;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return Intrinsics.areEqual(this.f4334a, oVar.f4334a) && Intrinsics.areEqual(this.f4335b, oVar.f4335b);
    }

    public final int hashCode() {
        HandlerThread handlerThread = this.f4334a;
        int iHashCode = (handlerThread == null ? 0 : handlerThread.hashCode()) * 31;
        Handler handler = this.f4335b;
        return iHashCode + (handler != null ? handler.hashCode() : 0);
    }

    public final String toString() {
        return "HandlerHolder(thread=" + this.f4334a + ", handler=" + this.f4335b + ')';
    }
}
