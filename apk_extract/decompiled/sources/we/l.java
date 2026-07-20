package we;

import android.os.Message;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f10732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f10733d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Integer mToken, f fVar) {
        super(false, "TimeoutHandler");
        Intrinsics.checkNotNullParameter(mToken, "mToken");
        this.f10732c = mToken;
        this.f10733d = fVar;
    }

    @Override // we.g
    public final void b(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        int i8 = msg.what;
        f fVar = this.f10733d;
        Integer num = this.f10732c;
        if (i8 == 4096) {
            Runnable runnable = (Runnable) m.f10735b.remove(num);
            if (runnable != null && fVar != null) {
                fVar.post(runnable);
            }
            m.f10734a.remove(num);
            return;
        }
        if (i8 != 4097) {
            return;
        }
        Runnable runnable2 = (Runnable) TypeIntrinsics.asMutableMap(m.f10737d).remove(num);
        if (runnable2 != null && fVar != null) {
            fVar.post(runnable2);
        }
        TypeIntrinsics.asMutableMap(m.f10736c).remove(num);
    }
}
