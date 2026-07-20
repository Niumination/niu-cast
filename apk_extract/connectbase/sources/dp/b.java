package dp;

import el.b0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ boolean f3805d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f3806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f3807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3808c;

    public b(@l c cVar, @l c cVar2, boolean z10) {
        if (cVar == null) {
            a(1);
        }
        if (cVar2 == null) {
            a(2);
        }
        this.f3806a = cVar;
        this.f3807b = cVar2;
        this.f3808c = z10;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    public static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        if (i10 != 5 && i10 != 6 && i10 != 7 && i10 != 9) {
            switch (i10) {
                case 13:
                case 14:
                case 15:
                case 16:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i10 != 5 && i10 != 6 && i10 != 7 && i10 != 9) {
            switch (i10) {
                case 13:
                case 14:
                case 15:
                case 16:
                    i11 = 2;
                    break;
                default:
                    i11 = 3;
                    break;
            }
        } else {
            i11 = 2;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = "string";
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        if (i10 == 5) {
            objArr[1] = "getPackageFqName";
        } else if (i10 == 6) {
            objArr[1] = "getRelativeClassName";
        } else if (i10 == 7) {
            objArr[1] = "getShortClassName";
        } else if (i10 != 9) {
            switch (i10) {
                case 13:
                case 14:
                    objArr[1] = "asString";
                    break;
                case 15:
                case 16:
                    objArr[1] = "asFqNameString";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                    break;
            }
        } else {
            objArr[1] = "asSingleFqName";
        }
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 5 && i10 != 6 && i10 != 7 && i10 != 9) {
            switch (i10) {
                case 13:
                case 14:
                case 15:
                case 16:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    @l
    public static b e(@l String str) {
        if (str == null) {
            a(11);
        }
        return f(str, false);
    }

    @l
    public static b f(@l String str, boolean z10) {
        String str2;
        if (str == null) {
            a(12);
        }
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf == -1) {
            str2 = "";
        } else {
            String strReplace = str.substring(0, iLastIndexOf).replace(b0.f4502a, n1.e.f11183c);
            str = str.substring(iLastIndexOf + 1);
            str2 = strReplace;
        }
        return new b(new c(str2), new c(str), z10);
    }

    @l
    public static b m(@l c cVar) {
        if (cVar == null) {
            a(0);
        }
        return new b(cVar.e(), cVar.g());
    }

    @l
    public c b() {
        if (this.f3806a.d()) {
            c cVar = this.f3807b;
            if (cVar == null) {
                a(9);
            }
            return cVar;
        }
        return new c(this.f3806a.b() + "." + this.f3807b.b());
    }

    @l
    public String c() {
        if (this.f3806a.d()) {
            String strB = this.f3807b.b();
            if (strB == null) {
                a(13);
            }
            return strB;
        }
        String str = this.f3806a.b().replace(n1.e.f11183c, b0.f4502a) + "/" + this.f3807b.b();
        if (str == null) {
            a(14);
        }
        return str;
    }

    @l
    public b d(@l f fVar) {
        if (fVar == null) {
            a(8);
        }
        return new b(h(), this.f3807b.c(fVar), this.f3808c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3806a.equals(bVar.f3806a) && this.f3807b.equals(bVar.f3807b) && this.f3808c == bVar.f3808c;
    }

    @m
    public b g() {
        c cVarE = this.f3807b.e();
        if (cVarE.d()) {
            return null;
        }
        return new b(h(), cVarE, this.f3808c);
    }

    @l
    public c h() {
        c cVar = this.f3806a;
        if (cVar == null) {
            a(5);
        }
        return cVar;
    }

    public int hashCode() {
        return Boolean.valueOf(this.f3808c).hashCode() + ((this.f3807b.hashCode() + (this.f3806a.hashCode() * 31)) * 31);
    }

    @l
    public c i() {
        c cVar = this.f3807b;
        if (cVar == null) {
            a(6);
        }
        return cVar;
    }

    @l
    public f j() {
        f fVarG = this.f3807b.g();
        if (fVarG == null) {
            a(7);
        }
        return fVarG;
    }

    public boolean k() {
        return this.f3808c;
    }

    public boolean l() {
        return !this.f3807b.e().d();
    }

    public String toString() {
        if (!this.f3806a.d()) {
            return c();
        }
        return "/" + c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@l c cVar, @l f fVar) {
        this(cVar, c.k(fVar), false);
        if (cVar == null) {
            a(3);
        }
        if (fVar == null) {
            a(4);
        }
    }
}
