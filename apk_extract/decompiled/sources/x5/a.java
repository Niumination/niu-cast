package x5;

import android.os.SystemClock;
import android.util.Log;
import androidx.lifecycle.CoroutineLiveDataKt;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import u2.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final tc.d f10861c = new tc.d("StreamingFormatChecker", "");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f10862a = new LinkedList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10863b = -1;

    public final void a(w5.a aVar) {
        if (aVar.f != -1) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        LinkedList linkedList = this.f10862a;
        linkedList.add(Long.valueOf(jElapsedRealtime));
        if (linkedList.size() > 5) {
            linkedList.removeFirst();
        }
        if (linkedList.size() == 5) {
            Long l4 = (Long) linkedList.peekFirst();
            l.e(l4);
            if (jElapsedRealtime - l4.longValue() < CoroutineLiveDataKt.DEFAULT_TIMEOUT) {
                long j8 = this.f10863b;
                if (j8 == -1 || jElapsedRealtime - j8 >= TimeUnit.SECONDS.toMillis(5L)) {
                    this.f10863b = jElapsedRealtime;
                    tc.d dVar = f10861c;
                    if (Log.isLoggable((String) dVar.f10209a, 5)) {
                        Log.w("StreamingFormatChecker", dVar.l("ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit."));
                    }
                }
            }
        }
    }
}
