package ho;

/* JADX INFO: loaded from: classes3.dex */
public class q extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final eo.e f7435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final pp.c f7436d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@os.l eo.e eVar) {
        super(fo.g.a.f6169b);
        if (eVar == null) {
            B(0);
        }
        fo.g.f6167h.getClass();
        this.f7435c = eVar;
        this.f7436d = new pp.c(eVar, null);
    }

    private static /* synthetic */ void B(int i10) {
        String str = (i10 == 1 || i10 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 1 || i10 == 2) ? 2 : 3];
        if (i10 == 1 || i10 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i10 != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i10 == 1) {
            objArr[1] = "getValue";
        } else if (i10 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // eo.m
    @os.l
    public eo.m b() {
        eo.e eVar = this.f7435c;
        if (eVar == null) {
            B(2);
        }
        return eVar;
    }

    @Override // eo.w0
    @os.l
    public pp.e getValue() {
        pp.c cVar = this.f7436d;
        if (cVar == null) {
            B(1);
        }
        return cVar;
    }

    @Override // ho.j
    public String toString() {
        return "class " + this.f7435c.getName() + "::this";
    }
}
