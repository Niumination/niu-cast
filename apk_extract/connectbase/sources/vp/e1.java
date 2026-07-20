package vp;

/* JADX INFO: loaded from: classes3.dex */
public class e1 extends d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o1 f17678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f17679b;

    public e1(@os.l o1 o1Var, @os.l f0 f0Var) {
        if (o1Var == null) {
            d(0);
        }
        if (f0Var == null) {
            d(1);
        }
        this.f17678a = o1Var;
        this.f17679b = f0Var;
    }

    public static /* synthetic */ void d(int i10) {
        String str = (i10 == 4 || i10 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5) ? 2 : 3];
        switch (i10) {
            case 1:
            case 2:
            case 3:
                objArr[0] = ik.y0.a.f8215h;
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i10 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i10 == 3) {
            objArr[2] = "replaceType";
        } else if (i10 != 4 && i10 != 5) {
            if (i10 != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 != 4 && i10 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // vp.c1
    public boolean a() {
        return false;
    }

    @Override // vp.c1
    @os.l
    public c1 b(@os.l wp.g gVar) {
        if (gVar == null) {
            d(6);
        }
        return new e1(this.f17678a, gVar.a(this.f17679b));
    }

    @Override // vp.c1
    @os.l
    public o1 c() {
        o1 o1Var = this.f17678a;
        if (o1Var == null) {
            d(4);
        }
        return o1Var;
    }

    @Override // vp.c1
    @os.l
    public f0 getType() {
        f0 f0Var = this.f17679b;
        if (f0Var == null) {
            d(5);
        }
        return f0Var;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e1(@os.l f0 f0Var) {
        this(o1.INVARIANT, f0Var);
        if (f0Var == null) {
            d(2);
        }
    }
}
