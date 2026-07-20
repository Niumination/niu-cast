package nq;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/NodeList\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n*L\n1#1,1454:1\n341#2,6:1455\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/NodeList\n*L\n1364#1:1455,6\n*E\n"})
public final class y2 extends vq.y implements e2 {
    @os.l
    public final String G(@os.l String str) {
        StringBuilder sbA = e.a.a("List{", str, "}[");
        Object objN = n();
        kn.l0.n(objN, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        boolean z10 = true;
        for (vq.a0 a0VarO = (vq.a0) objN; !kn.l0.g(a0VarO, this); a0VarO = a0VarO.o()) {
            if (a0VarO instanceof s2) {
                s2 s2Var = (s2) a0VarO;
                if (z10) {
                    z10 = false;
                } else {
                    sbA.append(", ");
                }
                sbA.append(s2Var);
            }
        }
        sbA.append("]");
        String string = sbA.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // nq.e2
    @os.l
    public y2 b() {
        return this;
    }

    @Override // nq.e2
    public boolean isActive() {
        return true;
    }

    @Override // vq.a0
    @os.l
    public String toString() {
        return super.toString();
    }
}
