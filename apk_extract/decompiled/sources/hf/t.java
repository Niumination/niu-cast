package hf;

import com.google.protobuf.MessageLite;
import ze.c2;
import ze.p1;
import ze.q2;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends ze.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c2 f5327d;
    public final o e;
    public boolean f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MessageLite f5329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ u f5330i;

    public t(u uVar, o oVar, c2 c2Var) {
        this.f5330i = uVar;
        this.f5327d = c2Var;
        this.e = oVar;
    }

    @Override // ze.i
    public final void i() {
        this.e.getClass();
        this.e.f5322c = true;
    }

    @Override // ze.i
    public final void j() {
        this.e.getClass();
    }

    @Override // ze.i
    public final void k() {
        if (this.f) {
            MessageLite messageLite = this.f5329h;
            if (messageLite == null) {
                this.f5327d.a(q2.f11410m.h("Half-closed without a request"), new p1());
            } else {
                ((r) this.f5330i.f5332b).invoke(messageLite, this.e);
                this.f5329h = null;
                if (this.f5328g) {
                    m();
                }
            }
        }
    }

    @Override // ze.i
    public final void l(MessageLite messageLite) {
        if (this.f5329h == null) {
            this.f5329h = messageLite;
            return;
        }
        this.f5327d.a(q2.f11410m.h("Too many requests"), new p1());
        this.f = false;
    }

    @Override // ze.i
    public final void m() {
        this.f5328g = true;
        this.e.getClass();
    }
}
