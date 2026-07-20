package wj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@hm.c
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<a> f19562a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile vj.u f19563b = vj.u.IDLE;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f19564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f19565b;

        public a(Runnable runnable, Executor executor) {
            this.f19564a = runnable;
            this.f19565b = executor;
        }

        public void a() {
            this.f19565b.execute(this.f19564a);
        }
    }

    public vj.u a() {
        vj.u uVar = this.f19563b;
        if (uVar != null) {
            return uVar;
        }
        throw new UnsupportedOperationException("Channel state API is not implemented");
    }

    public void b(@gm.i vj.u uVar) {
        c1.h0.F(uVar, "newState");
        if (this.f19563b == uVar || this.f19563b == vj.u.SHUTDOWN) {
            return;
        }
        this.f19563b = uVar;
        if (this.f19562a.isEmpty()) {
            return;
        }
        ArrayList<a> arrayList = this.f19562a;
        this.f19562a = new ArrayList<>();
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void c(Runnable runnable, Executor executor, vj.u uVar) {
        c1.h0.F(runnable, "callback");
        c1.h0.F(executor, "executor");
        c1.h0.F(uVar, "source");
        a aVar = new a(runnable, executor);
        if (this.f19563b != uVar) {
            aVar.a();
        } else {
            this.f19562a.add(aVar);
        }
    }
}
