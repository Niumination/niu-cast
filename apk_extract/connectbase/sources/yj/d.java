package yj;

import com.transsion.connectx.mirror.source.receiver.HomeKeyReceiver;
import java.util.Arrays;
import vj.y2;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends k1.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q0.c f20885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y2 f20886d;

    public d(q0.c cVar, y2 y2Var) {
        this.f20885c = (q0.c) c1.h0.F(cVar, "stream");
        this.f20886d = (y2) c1.h0.F(y2Var, HomeKeyReceiver.f2161e);
    }

    public y2 d() {
        return this.f20886d;
    }

    public q0.c e() {
        return this.f20885c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return c1.b0.a(this.f20885c, dVar.f20885c) && c1.b0.a(this.f20886d, dVar.f20886d);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20885c, this.f20886d});
    }

    public String toString() {
        return c1.z.c(this).j("stream", this.f20885c).j(HomeKeyReceiver.f2161e, this.f20886d).toString();
    }
}
