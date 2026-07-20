package hf;

import com.google.protobuf.MessageLite;
import java.util.concurrent.ArrayBlockingQueue;
import k3.v8;
import ze.p1;
import ze.q2;
import ze.s2;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5299a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f5300b;

    public f(g gVar) {
        this.f5300b = gVar;
    }

    @Override // ze.f0
    public final void f(q2 q2Var, p1 p1Var) {
        v8.n(!this.f5299a, "ClientCall already closed");
        boolean zE = q2Var.e();
        g gVar = this.f5300b;
        if (zE) {
            ((ArrayBlockingQueue) gVar.f5303c).add(gVar);
        } else {
            ((ArrayBlockingQueue) gVar.f5303c).add(new s2(q2Var, p1Var));
        }
        this.f5299a = true;
    }

    @Override // ze.f0
    public final void h(p1 p1Var) {
    }

    @Override // ze.f0
    public final void i(MessageLite messageLite) {
        v8.n(!this.f5299a, "ClientCall already closed");
        ((ArrayBlockingQueue) this.f5300b.f5303c).add(messageLite);
    }

    @Override // hf.j
    public final void n() {
        ((ze.j) this.f5300b.e).d(1);
    }
}
