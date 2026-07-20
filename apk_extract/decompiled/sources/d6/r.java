package d6;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.view.Surface;
import androidx.core.app.NotificationCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f4342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MediaCodec f4344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MediaExtractor f4345d;

    public /* synthetic */ r(t tVar, boolean z2, MediaCodec mediaCodec, MediaExtractor mediaExtractor) {
        this.f4342a = tVar;
        this.f4343b = z2;
        this.f4344c = mediaCodec;
        this.f4345d = mediaExtractor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w wVar;
        t this$0 = this.f4342a;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((this$0.f4360s || !this.f4343b) && (wVar = this$0.f4347b) != null) {
            wVar.a();
        }
        try {
            Intrinsics.checkNotNullParameter("AnimPlayer.HardDecoder", "tag");
            Intrinsics.checkNotNullParameter("release", NotificationCompat.CATEGORY_MESSAGE);
            MediaCodec mediaCodec = this.f4344c;
            if (mediaCodec != null) {
                mediaCodec.stop();
                mediaCodec.release();
            }
            MediaExtractor mediaExtractor = this.f4345d;
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            SurfaceTexture surfaceTexture = this$0.f4356m;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
            this$0.f4356m = null;
            j6.l lVar = (j6.l) this$0.f4354k.getValue();
            lVar.f6123a = 0L;
            lVar.f6124b = 0L;
            ef.g gVar = this$0.f4346a.p;
            gVar.getClass();
            Intrinsics.checkNotNullParameter("AnimPlayer.AnimPluginManager", "tag");
            Intrinsics.checkNotNullParameter("onRelease", NotificationCompat.CATEGORY_MESSAGE);
            Iterator it = ((List) gVar.e).iterator();
            while (it.hasNext()) {
                ((i6.a) it.next()).e();
            }
            w wVar2 = this$0.f4347b;
            if (wVar2 != null) {
                wVar2.b();
            }
            Surface surface = this$0.f4355l;
            if (surface != null) {
                surface.release();
            }
            this$0.f4355l = null;
        } catch (Throwable tr) {
            String msg = Intrinsics.stringPlus("release e=", tr);
            Intrinsics.checkNotNullParameter("AnimPlayer.HardDecoder", "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
        }
        this$0.f4352i = false;
        this$0.a();
        if (this$0.f4358o) {
            this$0.g();
        }
    }
}
