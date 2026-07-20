package gb;

import android.content.Context;
import android.util.Log;
import bb.s;
import com.transsion.iotservice.multiscreen.pc.R$string;
import k3.ee;
import k3.f2;
import k3.gc;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import y6.g;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f5133a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f5134b = LazyKt.lazy(new s(13));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f5135c;

    public f() {
        c.f5123b.getClass();
        d dVar = c.f5125d;
        this.f5135c = dVar == null ? new d("", 0, 0, 0, 0) : dVar;
    }

    public final g a() {
        String strG;
        d dVar = this.f5135c;
        String log = o.d.f(dVar.f5130d, dVar.e, "buildSending, progress: ", "/");
        Intrinsics.checkNotNullParameter("Atomic-SendBuilder", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("Atomic-SendBuilder"), log);
        }
        c.f5123b.getClass();
        d dVar2 = c.f5125d;
        if (dVar2 != null) {
            this.f5135c = dVar2;
        }
        d dVar3 = this.f5135c;
        int i8 = dVar3.e;
        if (i8 == 1) {
            strG = h0.a.g(dVar3.f5127a, "%");
        } else {
            strG = dVar3.f5130d + "/" + i8;
        }
        String strA = this.f5135c.f5129c == 5 ? ee.a(b(), R$string.md_copying, strG) : ee.a(b(), R$string.md_transfering, strG);
        String strA2 = this.f5135c.f5129c == 5 ? ee.a(b(), R$string.md_share_to_device, this.f5135c.f5128b) : ee.a(b(), R$string.md_transfer_to_device, this.f5135c.f5128b);
        g gVar = this.f5133a;
        f2.c(gVar, strG, null);
        f2.b(gVar, strA, strA2, new e("cancel", "pcconnect.intent.dynamic.ACTION_CANCEL_TRANSFER"));
        return gVar;
    }

    public final Context b() {
        return (Context) this.f5134b.getValue();
    }
}
