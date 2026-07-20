package hf;

import com.google.protobuf.MessageLite;
import ze.p1;
import ze.q2;
import ze.s2;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5314d;

    public k(i iVar) {
        this.f5311a = 1;
        this.f5312b = false;
        this.f5313c = iVar;
    }

    private final void o(p1 p1Var) {
    }

    private final void p(p1 p1Var) {
    }

    @Override // ze.f0
    public final void f(q2 q2Var, p1 p1Var) {
        switch (this.f5311a) {
            case 0:
                boolean zE = q2Var.e();
                v vVar = (v) this.f5313c;
                if (!zE) {
                    vVar.onError(new s2(q2Var, p1Var));
                } else {
                    vVar.onCompleted();
                }
                break;
            default:
                boolean zE2 = q2Var.e();
                i iVar = (i) this.f5313c;
                if (!zE2) {
                    if (m4.j.f7929h.b(iVar, null, new m4.c(new s2(q2Var, p1Var)))) {
                        m4.j.c(iVar, false);
                    }
                } else {
                    if (!this.f5312b) {
                        if (m4.j.f7929h.b(iVar, null, new m4.c(new s2(q2.f11410m.h("No value received for unary call"), p1Var)))) {
                            m4.j.c(iVar, false);
                        }
                    }
                    Object obj = (MessageLite) this.f5314d;
                    if (obj == null) {
                        obj = m4.j.f7930i;
                    }
                    if (m4.j.f7929h.b(iVar, null, obj)) {
                        m4.j.c(iVar, false);
                    }
                }
                break;
        }
    }

    @Override // ze.f0
    public final void h(p1 p1Var) {
        int i8 = this.f5311a;
    }

    @Override // ze.f0
    public final void i(MessageLite messageLite) {
        switch (this.f5311a) {
            case 0:
                boolean z2 = this.f5312b;
                h hVar = (h) this.f5314d;
                boolean z3 = hVar.f5307b;
                if (z2 && !z3) {
                    throw new s2(q2.f11410m.h("More than one responses received for unary or client-streaming call"));
                }
                this.f5312b = true;
                ((v) this.f5313c).onNext(messageLite);
                if (z3) {
                    ze.j jVar = hVar.f5306a;
                    if (z3) {
                        jVar.d(1);
                        return;
                    } else {
                        jVar.d(2);
                        return;
                    }
                }
                return;
            default:
                if (this.f5312b) {
                    throw new s2(q2.f11410m.h("More than one value received for unary call"));
                }
                this.f5314d = messageLite;
                this.f5312b = true;
                return;
        }
    }

    @Override // ze.f0
    public void j() {
        switch (this.f5311a) {
            case 0:
                ((h) this.f5314d).getClass();
                break;
        }
    }

    @Override // hf.j
    public final void n() {
        switch (this.f5311a) {
            case 0:
                h hVar = (h) this.f5314d;
                boolean z2 = hVar.f5307b;
                ze.j jVar = hVar.f5306a;
                if (!z2) {
                    jVar.d(2);
                } else {
                    jVar.d(1);
                }
                break;
            default:
                ((i) this.f5313c).f5310j.d(2);
                break;
        }
    }

    public k(v vVar, h hVar) {
        this.f5311a = 0;
        this.f5313c = vVar;
        this.f5314d = hVar;
    }
}
