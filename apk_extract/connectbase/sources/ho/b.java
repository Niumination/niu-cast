package ho;

import eo.c1;
import eo.z0;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends e {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@os.l up.n nVar, @os.l eo.m mVar, @os.l fo.g gVar, @os.l dp.f fVar, @os.l o1 o1Var, boolean z10, int i10, @os.l z0 z0Var, @os.l c1 c1Var) {
        super(nVar, mVar, gVar, fVar, o1Var, z10, i10, z0Var, c1Var);
        if (nVar == null) {
            B(0);
        }
        if (mVar == null) {
            B(1);
        }
        if (gVar == null) {
            B(2);
        }
        if (fVar == null) {
            B(3);
        }
        if (o1Var == null) {
            B(4);
        }
        if (z0Var == null) {
            B(5);
        }
        if (c1Var == null) {
            B(6);
        }
    }

    public static /* synthetic */ void B(int i10) {
        Object[] objArr = new Object[3];
        switch (i10) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // ho.j
    public String toString() {
        String str = "";
        String str2 = j() ? "reified " : "";
        if (m() != o1.INVARIANT) {
            str = m() + " ";
        }
        return String.format("%s%s%s", str2, str, getName());
    }
}
