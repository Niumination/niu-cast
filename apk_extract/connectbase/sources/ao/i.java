package ao;

import java.util.Set;
import kn.l0;
import kn.n0;
import kn.w;
import lm.d0;
import lm.f0;
import lm.h0;
import nm.o1;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r4v0 ao.i, still in use, count: 1, list:
  (r4v0 ao.i) from 0x006d: FILLED_NEW_ARRAY (r4v0 ao.i), (r5v0 ao.i), (r6v0 ao.i), (r7v0 ao.i), (r8v0 ao.i), (r9v0 ao.i), (r10v0 ao.i) A[WRAPPED] elemType: ao.i
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");


    @in.f
    @os.l
    public static final Set<i> NUMBER_TYPES = o1.u(new i("Char"), new i("Byte"), new i("Short"), new i("Int"), new i("Float"), new i("Long"), new i("Double"));

    @os.l
    private final d0 arrayTypeFqName$delegate;

    @os.l
    private final dp.f arrayTypeName;

    @os.l
    private final d0 typeFqName$delegate;

    @os.l
    private final dp.f typeName;

    @os.l
    public static final a Companion = new a();

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public static final class b extends n0 implements jn.a<dp.c> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final dp.c invoke() {
            dp.c cVarC = k.f565m.c(i.this.getArrayTypeName());
            l0.o(cVarC, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
            return cVarC;
        }
    }

    public static final class c extends n0 implements jn.a<dp.c> {
        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final dp.c invoke() {
            dp.c cVarC = k.f565m.c(i.this.getTypeName());
            l0.o(cVarC, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
            return cVarC;
        }
    }

    static {
    }

    public i(String str) {
        super(str, i);
        dp.f fVarK = dp.f.k(str);
        l0.o(fVarK, "identifier(typeName)");
        this.typeName = fVarK;
        dp.f fVarK2 = dp.f.k(l0.C(str, "Array"));
        l0.o(fVarK2, "identifier(\"${typeName}Array\")");
        this.arrayTypeName = fVarK2;
        h0 h0Var = h0.PUBLICATION;
        this.typeFqName$delegate = f0.c(h0Var, new c());
        this.arrayTypeFqName$delegate = f0.c(h0Var, new b());
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) f539a.clone();
    }

    @os.l
    public final dp.c getArrayTypeFqName() {
        return (dp.c) this.arrayTypeFqName$delegate.getValue();
    }

    @os.l
    public final dp.f getArrayTypeName() {
        return this.arrayTypeName;
    }

    @os.l
    public final dp.c getTypeFqName() {
        return (dp.c) this.typeFqName$delegate.getValue();
    }

    @os.l
    public final dp.f getTypeName() {
        return this.typeName;
    }
}
