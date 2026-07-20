package ni;

import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import li.s2;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends m {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f8328o;

    public y(int i8, c cVar, Function1 function1) {
        super(i8, function1);
        this.f8328o = cVar;
        if (cVar != c.SUSPEND) {
            if (i8 < 1) {
                throw new IllegalArgumentException(h0.a.h(i8, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(m.class).getSimpleName() + " instead").toString());
        }
    }

    public final Object L(Object obj, boolean z2) {
        v vVar;
        s sVar;
        Function1 function1;
        qi.c0 c0VarB;
        if (this.f8328o == c.DROP_LATEST) {
            Object objF = super.f(obj);
            if (!(objF instanceof t) || (objF instanceof s)) {
                return objF;
            }
            if (!z2 || (function1 = this.f8304b) == null || (c0VarB = qi.g.b(function1, obj, null)) == null) {
                return Unit.INSTANCE;
            }
            throw c0VarB;
        }
        jd.f fVar = o.f8309d;
        v vVar2 = (v) m.f8298j.get(this);
        while (true) {
            long andIncrement = m.f8295d.getAndIncrement(this);
            long j8 = andIncrement & 1152921504606846975L;
            boolean zV = v(andIncrement, false);
            int i8 = o.f8307b;
            long j10 = i8;
            long j11 = j8 / j10;
            int i9 = (int) (j8 % j10);
            if (vVar2.f9170c != j11) {
                v vVarA = m.a(this, j11, vVar2);
                if (vVarA != null) {
                    vVar = vVarA;
                } else if (zV) {
                    sVar = new s(s());
                    break;
                }
            } else {
                vVar = vVar2;
            }
            int iC = m.c(this, vVar, i9, obj, j8, fVar, zV);
            if (iC == 0) {
                vVar.b();
            } else if (iC != 1) {
                if (iC == 2) {
                    if (zV) {
                        vVar.i();
                        sVar = new s(s());
                        break;
                    }
                    s2 s2Var = fVar instanceof s2 ? (s2) fVar : null;
                    if (s2Var != null) {
                        s2Var.c(vVar, i9 + i8);
                    }
                    k((vVar.f9170c * j10) + ((long) i9));
                    return Unit.INSTANCE;
                }
                if (iC == 3) {
                    throw new IllegalStateException("unexpected");
                }
                if (iC == 4) {
                    if (j8 < m.e.get(this)) {
                        vVar.b();
                    }
                    sVar = new s(s());
                    break;
                }
                if (iC == 5) {
                    vVar.b();
                }
                vVar2 = vVar;
            }
            return Unit.INSTANCE;
        }
        return sVar;
    }

    @Override // ni.m, ni.g0
    public final Object f(Object obj) {
        return L(obj, false);
    }

    @Override // ni.m, ni.g0
    public final Object r(Object obj, Continuation continuation) throws Throwable {
        qi.c0 c0VarB;
        Object objL = L(obj, true);
        if (!(objL instanceof s)) {
            return Unit.INSTANCE;
        }
        u.a(objL);
        Function1 function1 = this.f8304b;
        if (function1 == null || (c0VarB = qi.g.b(function1, obj, null)) == null) {
            throw s();
        }
        ExceptionsKt.addSuppressed(c0VarB, s());
        throw c0VarB;
    }

    @Override // ni.m
    public final boolean y() {
        return this.f8328o == c.DROP_OLDEST;
    }
}
