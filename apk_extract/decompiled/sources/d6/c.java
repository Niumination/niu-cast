package d6;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f4308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e6.b f4309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f4310d;

    public /* synthetic */ c(d dVar, e6.b bVar, boolean z2, int i8) {
        this.f4307a = i8;
        this.f4308b = dVar;
        this.f4309c = bVar;
        this.f4310d = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        switch (this.f4307a) {
            case 0:
                d this$0 = this.f4308b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                e6.b fileContainer = this.f4309c;
                Intrinsics.checkNotNullParameter(fileContainer, "$fileContainer");
                int iK = this$0.f4323o.k(fileContainer, this$0.f4317i, this$0.f4315g);
                if (iK == 0) {
                    sj.a aVar = this$0.f4323o;
                    String msg = Intrinsics.stringPlus("parse ", (a) aVar.f10138c);
                    Intrinsics.checkNotNullParameter("AnimPlayer.AnimPlayer", "tag");
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    a aVar2 = (a) aVar.f10138c;
                    if (aVar2 != null && (aVar2.f4302k || ((fVar = this$0.f4313c) != null && fVar.f(aVar2)))) {
                        this$0.b(fileContainer, this.f4310d);
                    } else {
                        Intrinsics.checkNotNullParameter("AnimPlayer.AnimPlayer", "tag");
                        Intrinsics.checkNotNullParameter("onVideoConfigReady return false", NotificationCompat.CATEGORY_MESSAGE);
                    }
                    break;
                } else {
                    this$0.f4321m = false;
                    t tVar = this$0.f4314d;
                    if (tVar != null) {
                        tVar.c(iK, m.a(iK));
                    }
                    t tVar2 = this$0.f4314d;
                    if (tVar2 != null) {
                        tVar2.a();
                        break;
                    }
                }
                break;
            default:
                d this$1 = this.f4308b;
                Intrinsics.checkNotNullParameter(this$1, "this$0");
                e6.b fileContainer2 = this.f4309c;
                Intrinsics.checkNotNullParameter(fileContainer2, "$fileContainer");
                this$1.b(fileContainer2, this.f4310d);
                break;
        }
    }
}
