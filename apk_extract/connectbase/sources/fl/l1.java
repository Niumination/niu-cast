package fl;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public final class l1 {
    @lm.k(message = "This will be removed. Please file a ticket if you need it.")
    @lm.z0
    @os.l
    public static final Type a(@os.l un.s sVar) {
        kn.l0.p(sVar, "<this>");
        un.g gVarI = sVar.i();
        if (!sVar.n().isEmpty()) {
            return new u0(sVar);
        }
        if (gVarI instanceof un.d) {
            return in.b.g((un.d) gVarI);
        }
        if (gVarI instanceof un.t) {
            throw new IllegalStateException("KType parameter classifier is not supported");
        }
        throw new IllegalStateException(kn.l0.C("Unsupported type ", sVar).toString());
    }
}
