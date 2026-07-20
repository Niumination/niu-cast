package ho;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends fo.b implements eo.m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final dp.f f7359b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@os.l fo.g gVar, @os.l dp.f fVar) {
        super(gVar);
        if (gVar == null) {
            B(0);
        }
        if (fVar == null) {
            B(1);
        }
        this.f7359b = fVar;
    }

    private static /* synthetic */ void B(int i10) {
        String str = (i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i10 == 2) {
            objArr[1] = "getName";
        } else if (i10 == 3) {
            objArr[1] = "getOriginal";
        } else if (i10 == 5 || i10 == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (i10 != 2 && i10 != 3) {
            if (i10 == 4) {
                objArr[2] = "toString";
            } else if (i10 != 5 && i10 != 6) {
                objArr[2] = "<init>";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 != 2 && i10 != 3 && i10 != 5 && i10 != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @os.l
    public static String Z(@os.l eo.m mVar) {
        if (mVar == null) {
            B(4);
        }
        try {
            String str = gp.c.f6770j.s(mVar) + "[" + mVar.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(mVar)) + "]";
            if (str == null) {
                B(5);
            }
            return str;
        } catch (Throwable unused) {
            String str2 = mVar.getClass().getSimpleName() + " " + mVar.getName();
            if (str2 == null) {
                B(6);
            }
            return str2;
        }
    }

    @os.l
    public eo.m a() {
        return this;
    }

    @Override // eo.i0
    @os.l
    public dp.f getName() {
        dp.f fVar = this.f7359b;
        if (fVar == null) {
            B(2);
        }
        return fVar;
    }

    public String toString() {
        return Z(this);
    }
}
