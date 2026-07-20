package dp;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import jn.l;
import nm.r;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f3812e = f.n("<root>");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f3813f = Pattern.compile("\\.");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l<String, f> f3814g = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f3815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient c f3816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient d f3817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient f f3818d;

    public static class a implements l<String, f> {
        public f a(String str) {
            return f.h(str);
        }

        @Override // jn.l
        public f invoke(String str) {
            return f.h(str);
        }
    }

    public d(@os.l String str, @os.l c cVar) {
        if (str == null) {
            a(0);
        }
        if (cVar == null) {
            a(1);
        }
        this.f3815a = str;
        this.f3816b = cVar;
    }

    public static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i11 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        if (i10 != 1) {
            switch (i10) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i10) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                throw new IllegalStateException(str2);
            case 9:
            case 15:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @os.l
    public static d m(@os.l f fVar) {
        if (fVar == null) {
            a(16);
        }
        return new d(fVar.b(), c.f3809c.j(), fVar);
    }

    @os.l
    public String b() {
        String str = this.f3815a;
        if (str == null) {
            a(4);
        }
        return str;
    }

    @os.l
    public d c(@os.l f fVar) {
        String strB;
        if (fVar == null) {
            a(9);
        }
        if (this.f3815a.isEmpty()) {
            strB = fVar.b();
        } else {
            strB = this.f3815a + "." + fVar.b();
        }
        return new d(strB, this, fVar);
    }

    public final void d() {
        int iLastIndexOf = this.f3815a.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            this.f3818d = f.h(this.f3815a.substring(iLastIndexOf + 1));
            this.f3817c = new d(this.f3815a.substring(0, iLastIndexOf));
        } else {
            this.f3818d = f.h(this.f3815a);
            this.f3817c = c.f3809c.j();
        }
    }

    public boolean e() {
        return this.f3815a.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && this.f3815a.equals(((d) obj).f3815a);
    }

    public boolean f() {
        return this.f3816b != null || b().indexOf(60) < 0;
    }

    @os.l
    public d g() {
        d dVar = this.f3817c;
        if (dVar != null) {
            if (dVar == null) {
                a(7);
            }
            return dVar;
        }
        if (this.f3815a.isEmpty()) {
            throw new IllegalStateException("root");
        }
        d();
        d dVar2 = this.f3817c;
        if (dVar2 == null) {
            a(8);
        }
        return dVar2;
    }

    @os.l
    public List<f> h() {
        List<f> listEmptyList = this.f3815a.isEmpty() ? Collections.emptyList() : r.ni(f3813f.split(this.f3815a), f3814g);
        if (listEmptyList == null) {
            a(14);
        }
        return listEmptyList;
    }

    public int hashCode() {
        return this.f3815a.hashCode();
    }

    @os.l
    public f i() {
        f fVar = this.f3818d;
        if (fVar != null) {
            if (fVar == null) {
                a(10);
            }
            return fVar;
        }
        if (this.f3815a.isEmpty()) {
            throw new IllegalStateException("root");
        }
        d();
        f fVar2 = this.f3818d;
        if (fVar2 == null) {
            a(11);
        }
        return fVar2;
    }

    @os.l
    public f j() {
        if (this.f3815a.isEmpty()) {
            f fVar = f3812e;
            if (fVar == null) {
                a(12);
            }
            return fVar;
        }
        f fVarI = i();
        if (fVarI == null) {
            a(13);
        }
        return fVarI;
    }

    public boolean k(@os.l f fVar) {
        if (fVar == null) {
            a(15);
        }
        if (this.f3815a.isEmpty()) {
            return false;
        }
        int iIndexOf = this.f3815a.indexOf(46);
        String str = this.f3815a;
        String strB = fVar.b();
        if (iIndexOf == -1) {
            iIndexOf = this.f3815a.length();
        }
        return str.regionMatches(0, strB, 0, iIndexOf);
    }

    @os.l
    public c l() {
        c cVar = this.f3816b;
        if (cVar != null) {
            if (cVar == null) {
                a(5);
            }
            return cVar;
        }
        c cVar2 = new c(this);
        this.f3816b = cVar2;
        return cVar2;
    }

    @os.l
    public String toString() {
        String strB = this.f3815a.isEmpty() ? f3812e.b() : this.f3815a;
        if (strB == null) {
            a(17);
        }
        return strB;
    }

    public d(@os.l String str) {
        if (str == null) {
            a(2);
        }
        this.f3815a = str;
    }

    public d(@os.l String str, d dVar, f fVar) {
        if (str == null) {
            a(3);
        }
        this.f3815a = str;
        this.f3817c = dVar;
        this.f3818d = fVar;
    }
}
