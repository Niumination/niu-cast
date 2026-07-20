package af;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class g4 extends ze.b1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ze.f0 f292d;
    public ze.i e;
    public ze.q f = ze.q.IDLE;

    public g4(ze.f0 f0Var) {
        this.f292d = f0Var;
    }

    @Override // ze.b1
    public final ze.q2 a(ze.y0 y0Var) {
        Boolean bool;
        List list = y0Var.f11477a;
        if (list.isEmpty()) {
            ze.q2 q2VarH = ze.q2.f11411n.h("NameResolver returned no usable address. addrs=" + list + ", attrs=" + y0Var.f11478b);
            c(q2VarH);
            return q2VarH;
        }
        Object obj = y0Var.f11479c;
        if ((obj instanceof d4) && (bool = ((d4) obj).f218a) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(list);
            Collections.shuffle(arrayList, new Random());
            list = arrayList;
        }
        ze.i iVar = this.e;
        if (iVar == null) {
            ze.b bVar = ze.b.f11321b;
            Object[][] objArr = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
            v8.c("addrs is empty", !list.isEmpty());
            qf.c cVar = new qf.c(Collections.unmodifiableList(new ArrayList(list)), bVar, objArr);
            ze.f0 f0Var = this.f292d;
            ze.i iVarA = f0Var.a(cVar);
            iVarA.r(new l6(4, this, iVarA));
            this.e = iVarA;
            ze.q qVar = ze.q.CONNECTING;
            e4 e4Var = new e4(ze.x0.b(iVarA, null));
            this.f = qVar;
            f0Var.m(qVar, e4Var);
            iVarA.o();
        } else {
            iVar.t(list);
        }
        return ze.q2.e;
    }

    @Override // ze.b1
    public final void c(ze.q2 q2Var) {
        ze.i iVar = this.e;
        if (iVar != null) {
            iVar.p();
            this.e = null;
        }
        ze.q qVar = ze.q.TRANSIENT_FAILURE;
        e4 e4Var = new e4(ze.x0.a(q2Var));
        this.f = qVar;
        this.f292d.m(qVar, e4Var);
    }

    @Override // ze.b1
    public final void e() {
        ze.i iVar = this.e;
        if (iVar != null) {
            iVar.o();
        }
    }

    @Override // ze.b1
    public final void f() {
        ze.i iVar = this.e;
        if (iVar != null) {
            iVar.p();
        }
    }
}
