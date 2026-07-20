package af;

import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 extends ze.f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.f0 f522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f524c = new ArrayList();

    public q0(ze.f0 f0Var) {
        this.f522a = f0Var;
    }

    @Override // ze.f0
    public final void f(ze.q2 q2Var, ze.p1 p1Var) {
        n(new m0(this, 1, q2Var, p1Var));
    }

    @Override // ze.f0
    public final void h(ze.p1 p1Var) {
        if (this.f523b) {
            this.f522a.h(p1Var);
        } else {
            n(new e(4, this, p1Var));
        }
    }

    @Override // ze.f0
    public final void i(MessageLite messageLite) {
        if (this.f523b) {
            this.f522a.i(messageLite);
        } else {
            n(new e(5, this, messageLite));
        }
    }

    @Override // ze.f0
    public final void j() {
        if (this.f523b) {
            this.f522a.j();
        } else {
            n(new f(this, 1));
        }
    }

    public final void n(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.f523b) {
                    runnable.run();
                } else {
                    this.f524c.add(runnable);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
