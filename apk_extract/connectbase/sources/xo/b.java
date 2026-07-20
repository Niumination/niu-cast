package xo;

import cp.e;
import dp.f;
import eo.z0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import no.z;
import os.l;
import os.m;
import wo.p;

/* JADX INFO: loaded from: classes3.dex */
public class b implements p.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f20450j = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<dp.b, xo.a.EnumC0527a> f20451k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f20452a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20453b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20454c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f20455d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String[] f20456e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String[] f20457f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String[] f20458g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public xo.a.EnumC0527a f20459h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String[] f20460i = null;

    /* JADX INFO: renamed from: xo.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0529b implements p.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f20461a = new ArrayList();

        private static /* synthetic */ void f(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "enumEntryName";
            } else if (i10 == 2) {
                objArr[0] = "classLiteralValue";
            } else if (i10 != 3) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i10 == 2) {
                objArr[2] = "visitClassLiteral";
            } else if (i10 != 3) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // wo.p.b
        public void a() {
            g((String[]) this.f20461a.toArray(new String[0]));
        }

        @Override // wo.p.b
        public void b(@l dp.b bVar, @l f fVar) {
            if (bVar == null) {
                f(0);
            }
            if (fVar == null) {
                f(1);
            }
        }

        @Override // wo.p.b
        public void c(@l jp.f fVar) {
            if (fVar == null) {
                f(2);
            }
        }

        @Override // wo.p.b
        @m
        public p.a d(@l dp.b bVar) {
            if (bVar != null) {
                return null;
            }
            f(3);
            return null;
        }

        @Override // wo.p.b
        public void e(@m Object obj) {
            if (obj instanceof String) {
                this.f20461a.add((String) obj);
            }
        }

        public abstract void g(@l String[] strArr);
    }

    public class c implements p.a {

        public class a extends AbstractC0529b {
            public a() {
            }

            public static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
            }

            @Override // xo.b.AbstractC0529b
            public void g(@l String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                b.this.f20456e = strArr;
            }
        }

        /* JADX INFO: renamed from: xo.b$c$b, reason: collision with other inner class name */
        public class C0530b extends AbstractC0529b {
            public C0530b() {
            }

            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
            }

            @Override // xo.b.AbstractC0529b
            public void g(@l String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                b.this.f20457f = strArr;
            }
        }

        /* JADX INFO: renamed from: xo.b$c$c, reason: collision with other inner class name */
        public class C0531c extends AbstractC0529b {
            public C0531c() {
            }

            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$3", "visitEnd"));
            }

            @Override // xo.b.AbstractC0529b
            public void g(@l String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                b.this.f20460i = strArr;
            }
        }

        public c() {
        }

        public static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i10 == 7) {
                objArr[0] = "classId";
            } else if (i10 == 4) {
                objArr[0] = "enumClassId";
            } else if (i10 != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            switch (i10) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // wo.p.a
        public void a() {
        }

        @Override // wo.p.a
        public void b(@l f fVar, @l dp.b bVar, @l f fVar2) {
            if (fVar == null) {
                g(3);
            }
            if (bVar == null) {
                g(4);
            }
            if (fVar2 == null) {
                g(5);
            }
        }

        @Override // wo.p.a
        public void c(@m f fVar, @m Object obj) {
            if (fVar == null) {
                return;
            }
            String strB = fVar.b();
            if ("k".equals(strB)) {
                if (obj instanceof Integer) {
                    b.this.f20459h = xo.a.EnumC0527a.getById(((Integer) obj).intValue());
                    return;
                }
                return;
            }
            if ("mv".equals(strB)) {
                if (obj instanceof int[]) {
                    b.this.f20452a = (int[]) obj;
                    return;
                }
                return;
            }
            if ("xs".equals(strB)) {
                if (obj instanceof String) {
                    b.this.f20453b = (String) obj;
                    return;
                }
                return;
            }
            if ("xi".equals(strB)) {
                if (obj instanceof Integer) {
                    b.this.f20454c = ((Integer) obj).intValue();
                    return;
                }
                return;
            }
            if ("pn".equals(strB) && (obj instanceof String)) {
                b.this.f20455d = (String) obj;
            }
        }

        @Override // wo.p.a
        @m
        public p.b d(@l f fVar) {
            if (fVar == null) {
                g(2);
            }
            String strB = fVar.b();
            if ("d1".equals(strB)) {
                return new a();
            }
            if ("d2".equals(strB)) {
                return new C0530b();
            }
            if ("si".equals(strB)) {
                return new C0531c();
            }
            return null;
        }

        @Override // wo.p.a
        @m
        public p.a e(@l f fVar, @l dp.b bVar) {
            if (fVar == null) {
                g(6);
            }
            if (bVar != null) {
                return null;
            }
            g(7);
            return null;
        }

        @Override // wo.p.a
        public void f(@l f fVar, @l jp.f fVar2) {
            if (fVar == null) {
                g(0);
            }
            if (fVar2 == null) {
                g(1);
            }
        }

        @l
        public final p.b h() {
            return new a();
        }

        @l
        public final p.b i() {
            return new C0531c();
        }

        @l
        public final p.b j() {
            return new C0530b();
        }
    }

    public class d implements p.a {

        public class a extends AbstractC0529b {
            public a() {
            }

            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
            }

            @Override // xo.b.AbstractC0529b
            public void g(@l String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                b.this.f20456e = strArr;
            }
        }

        /* JADX INFO: renamed from: xo.b$d$b, reason: collision with other inner class name */
        public class C0532b extends AbstractC0529b {
            public C0532b() {
            }

            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
            }

            @Override // xo.b.AbstractC0529b
            public void g(@l String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                b.this.f20457f = strArr;
            }
        }

        public d() {
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i10 == 7) {
                objArr[0] = "classId";
            } else if (i10 == 4) {
                objArr[0] = "enumClassId";
            } else if (i10 != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            switch (i10) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @l
        private p.b h() {
            return new a();
        }

        @l
        private p.b i() {
            return new C0532b();
        }

        @Override // wo.p.a
        public void a() {
        }

        @Override // wo.p.a
        public void b(@l f fVar, @l dp.b bVar, @l f fVar2) {
            if (fVar == null) {
                g(3);
            }
            if (bVar == null) {
                g(4);
            }
            if (fVar2 == null) {
                g(5);
            }
        }

        @Override // wo.p.a
        public void c(@m f fVar, @m Object obj) {
            if (fVar == null) {
                return;
            }
            String strB = fVar.b();
            if (lb.f.f9782f.equals(strB)) {
                if (obj instanceof int[]) {
                    b.this.f20452a = (int[]) obj;
                }
            } else if ("multifileClassName".equals(strB)) {
                b.this.f20453b = obj instanceof String ? (String) obj : null;
            }
        }

        @Override // wo.p.a
        @m
        public p.b d(@l f fVar) {
            if (fVar == null) {
                g(2);
            }
            String strB = fVar.b();
            if ("data".equals(strB) || "filePartClassNames".equals(strB)) {
                return new a();
            }
            if ("strings".equals(strB)) {
                return new C0532b();
            }
            return null;
        }

        @Override // wo.p.a
        @m
        public p.a e(@l f fVar, @l dp.b bVar) {
            if (fVar == null) {
                g(6);
            }
            if (bVar != null) {
                return null;
            }
            g(7);
            return null;
        }

        @Override // wo.p.a
        public void f(@l f fVar, @l jp.f fVar2) {
            if (fVar == null) {
                g(0);
            }
            if (fVar2 == null) {
                g(1);
            }
        }
    }

    static {
        HashMap map = new HashMap();
        f20451k = map;
        map.put(dp.b.m(new dp.c("kotlin.jvm.internal.KotlinClass")), xo.a.EnumC0527a.CLASS);
        map.put(dp.b.m(new dp.c("kotlin.jvm.internal.KotlinFileFacade")), xo.a.EnumC0527a.FILE_FACADE);
        map.put(dp.b.m(new dp.c("kotlin.jvm.internal.KotlinMultifileClass")), xo.a.EnumC0527a.MULTIFILE_CLASS);
        map.put(dp.b.m(new dp.c("kotlin.jvm.internal.KotlinMultifileClassPart")), xo.a.EnumC0527a.MULTIFILE_CLASS_PART);
        map.put(dp.b.m(new dp.c("kotlin.jvm.internal.KotlinSyntheticClass")), xo.a.EnumC0527a.SYNTHETIC_CLASS);
    }

    public static /* synthetic */ void d(int i10) {
        Object[] objArr = new Object[3];
        if (i10 != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // wo.p.c
    public void a() {
    }

    @Override // wo.p.c
    @m
    public p.a b(@l dp.b bVar, @l z0 z0Var) {
        xo.a.EnumC0527a enumC0527a;
        if (bVar == null) {
            d(0);
        }
        if (z0Var == null) {
            d(1);
        }
        if (bVar.b().equals(z.f11800a)) {
            return new c();
        }
        if (f20450j || this.f20459h != null || (enumC0527a = f20451k.get(bVar)) == null) {
            return null;
        }
        this.f20459h = enumC0527a;
        return new d();
    }

    @m
    public xo.a m() {
        if (this.f20459h == null || this.f20452a == null) {
            return null;
        }
        e eVar = new e(this.f20452a, (this.f20454c & 8) != 0);
        if (!eVar.h()) {
            this.f20458g = this.f20456e;
            this.f20456e = null;
        } else if (n() && this.f20456e == null) {
            return null;
        }
        String[] strArr = this.f20460i;
        return new xo.a(this.f20459h, eVar, this.f20456e, this.f20458g, this.f20457f, this.f20453b, this.f20454c, this.f20455d, strArr != null ? cp.a.e(strArr) : null);
    }

    public final boolean n() {
        xo.a.EnumC0527a enumC0527a = this.f20459h;
        return enumC0527a == xo.a.EnumC0527a.CLASS || enumC0527a == xo.a.EnumC0527a.FILE_FACADE || enumC0527a == xo.a.EnumC0527a.MULTIFILE_CLASS_PART;
    }
}
