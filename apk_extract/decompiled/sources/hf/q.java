package hf;

import com.google.protobuf.MessageLite;
import ze.c2;
import ze.q2;
import ze.s2;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends ze.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f5325d;
    public final o e;
    public final c2 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5326g = false;

    public q(v vVar, o oVar, c2 c2Var) {
        this.f5325d = vVar;
        this.e = oVar;
        this.f = c2Var;
    }

    @Override // ze.i
    public final void i() {
        this.e.f5322c = true;
        if (this.f5326g) {
            return;
        }
        this.f5325d.onError(new s2(q2.f.h("client cancelled")));
    }

    @Override // ze.i
    public final void j() {
        this.e.getClass();
    }

    @Override // ze.i
    public final void k() {
        this.f5326g = true;
        this.f5325d.onCompleted();
    }

    @Override // ze.i
    public final void l(MessageLite messageLite) {
        this.f5325d.onNext(messageLite);
        this.f.b(1);
    }

    @Override // ze.i
    public final void m() {
        this.e.getClass();
    }
}
