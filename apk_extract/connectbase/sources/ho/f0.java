package ho;

/* JADX INFO: loaded from: classes3.dex */
public class f0 extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ boolean f7343e = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final eo.m f7344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public pp.e f7345d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(@os.l eo.m mVar, @os.l pp.e eVar, @os.l fo.g gVar) {
        super(gVar);
        if (mVar == null) {
            B(0);
        }
        if (eVar == null) {
            B(1);
        }
        if (gVar == null) {
            B(2);
        }
        this.f7344c = mVar;
        this.f7345d = eVar;
    }

    private static /* synthetic */ void B(int i10) {
        String str = (i10 == 3 || i10 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 3 || i10 == 4) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "value";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 5:
                objArr[0] = "newOwner";
                break;
            case 6:
                objArr[0] = "outType";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i10 == 3) {
            objArr[1] = "getValue";
        } else if (i10 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i10 != 3 && i10 != 4) {
            if (i10 == 5) {
                objArr[2] = "copy";
            } else if (i10 != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "setOutType";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 != 3 && i10 != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // eo.m
    @os.l
    public eo.m b() {
        eo.m mVar = this.f7344c;
        if (mVar == null) {
            B(4);
        }
        return mVar;
    }

    @Override // eo.w0
    @os.l
    public pp.e getValue() {
        pp.e eVar = this.f7345d;
        if (eVar == null) {
            B(3);
        }
        return eVar;
    }
}
