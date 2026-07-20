package wp;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import vp.a1;
import vp.b1;
import vp.c1;
import vp.f0;
import vp.j1;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class y {
    public static final f0 a(f0 f0Var) {
        return aq.b.a(f0Var).f676b;
    }

    public static final String b(a1 a1Var) {
        StringBuilder sb2 = new StringBuilder();
        c(l0.C("type: ", a1Var), sb2);
        c(l0.C("hashCode: ", Integer.valueOf(a1Var.hashCode())), sb2);
        c(l0.C("javaClass: ", a1Var.getClass().getCanonicalName()), sb2);
        for (eo.m mVarD = a1Var.d(); mVarD != null; mVarD = mVarD.b()) {
            c(l0.C("fqName: ", gp.c.f6767g.s(mVarD)), sb2);
            c(l0.C("javaClass: ", mVarD.getClass().getCanonicalName()), sb2);
        }
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final StringBuilder c(String str, StringBuilder sb2) {
        l0.p(str, "<this>");
        sb2.append(str);
        l0.o(sb2, "append(value)");
        sb2.append('\n');
        l0.o(sb2, "append('\\n')");
        return sb2;
    }

    @os.m
    public static final f0 d(@os.l f0 f0Var, @os.l f0 f0Var2, @os.l v vVar) {
        l0.p(f0Var, "subtype");
        l0.p(f0Var2, "supertype");
        l0.p(vVar, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new s(f0Var, null));
        a1 a1VarG0 = f0Var2.G0();
        while (!arrayDeque.isEmpty()) {
            s sVar = (s) arrayDeque.poll();
            f0 f0VarA = sVar.f19876a;
            a1 a1VarG1 = f0VarA.G0();
            if (vVar.a(a1VarG1, a1VarG0)) {
                boolean zH0 = f0VarA.H0();
                for (s sVar2 = sVar.f19877b; sVar2 != null; sVar2 = sVar2.f19877b) {
                    f0 f0Var3 = sVar2.f19876a;
                    List<c1> listF0 = f0Var3.F0();
                    if (!(listF0 instanceof Collection) || !listF0.isEmpty()) {
                        Iterator<T> it = listF0.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                f0VarA = b1.f17666c.a(f0Var3).c().n(f0VarA, o1.INVARIANT);
                                l0.o(f0VarA, "{\n                    Ty…ARIANT)\n                }");
                                break;
                            }
                            o1 o1VarC = ((c1) it.next()).c();
                            o1 o1Var = o1.INVARIANT;
                            if (o1VarC != o1Var) {
                                f0 f0VarN = ip.d.f(b1.f17666c.a(f0Var3), false, 1, null).c().n(f0VarA, o1Var);
                                l0.o(f0VarN, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                                f0VarA = a(f0VarN);
                                break;
                            }
                        }
                    } else {
                        f0VarA = b1.f17666c.a(f0Var3).c().n(f0VarA, o1.INVARIANT);
                        l0.o(f0VarA, "{\n                    Ty…ARIANT)\n                }");
                        break;
                    }
                    zH0 = zH0 || f0Var3.H0();
                }
                a1 a1VarG2 = f0VarA.G0();
                if (vVar.a(a1VarG2, a1VarG0)) {
                    return j1.q(f0VarA, zH0);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(a1VarG2) + ", \n\nsupertype: " + b(a1VarG0) + " \n" + vVar.a(a1VarG2, a1VarG0));
            }
            for (f0 f0Var4 : a1VarG1.a()) {
                l0.o(f0Var4, "immediateSupertype");
                arrayDeque.add(new s(f0Var4, sVar));
            }
        }
        return null;
    }
}
