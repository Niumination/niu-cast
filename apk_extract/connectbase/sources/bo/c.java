package bo;

import ao.k;
import dp.f;
import in.n;
import jq.e0;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'KFunction' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    @l
    public static final a Companion;
    public static final c KFunction;
    public static final c KSuspendFunction;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ c[] f999a;

    @l
    private final String classNamePrefix;
    private final boolean isReflectType;
    private final boolean isSuspendType;

    @l
    private final dp.c packageFqName;
    public static final c Function = new c("Function", 0, k.f565m, "Function", false, false);
    public static final c SuspendFunction = new c("SuspendFunction", 1, k.f557e, "SuspendFunction", true, false);

    public static final class a {

        /* JADX INFO: renamed from: bo.c$a$a, reason: collision with other inner class name */
        public static final class C0035a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @l
            public final c f1000a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f1001b;

            public C0035a(@l c cVar, int i10) {
                l0.p(cVar, "kind");
                this.f1000a = cVar;
                this.f1001b = i10;
            }

            @l
            public final c a() {
                return this.f1000a;
            }

            public final int b() {
                return this.f1001b;
            }

            @l
            public final c c() {
                return this.f1000a;
            }

            public boolean equals(@m Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0035a)) {
                    return false;
                }
                C0035a c0035a = (C0035a) obj;
                return this.f1000a == c0035a.f1000a && this.f1001b == c0035a.f1001b;
            }

            public int hashCode() {
                return (this.f1000a.hashCode() * 31) + this.f1001b;
            }

            @l
            public String toString() {
                StringBuilder sb2 = new StringBuilder("KindWithArity(kind=");
                sb2.append(this.f1000a);
                sb2.append(", arity=");
                return u.a.a(sb2, this.f1001b, ')');
            }
        }

        public a() {
        }

        @m
        public final c a(@l dp.c cVar, @l String str) {
            l0.p(cVar, "packageFqName");
            l0.p(str, cb.b.C0062b.f1395b);
            c[] cVarArrValues = c.values();
            int length = cVarArrValues.length;
            int i10 = 0;
            while (i10 < length) {
                c cVar2 = cVarArrValues[i10];
                i10++;
                if (l0.g(cVar2.getPackageFqName(), cVar) && e0.s2(str, cVar2.getClassNamePrefix(), false, 2, null)) {
                    return cVar2;
                }
            }
            return null;
        }

        @m
        @n
        public final c b(@l String str, @l dp.c cVar) {
            l0.p(str, cb.b.C0062b.f1395b);
            l0.p(cVar, "packageFqName");
            C0035a c0035aC = c(str, cVar);
            if (c0035aC == null) {
                return null;
            }
            return c0035aC.f1000a;
        }

        @m
        public final C0035a c(@l String str, @l dp.c cVar) {
            l0.p(str, cb.b.C0062b.f1395b);
            l0.p(cVar, "packageFqName");
            c cVarA = a(cVar, str);
            if (cVarA == null) {
                return null;
            }
            String strSubstring = str.substring(cVarA.getClassNamePrefix().length());
            l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
            Integer numD = d(strSubstring);
            if (numD == null) {
                return null;
            }
            return new C0035a(cVarA, numD.intValue());
        }

        public final Integer d(String str) {
            if (str.length() == 0) {
                return null;
            }
            int length = str.length();
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                char cCharAt = str.charAt(i10);
                i10++;
                int i12 = cCharAt - '0';
                if (i12 < 0 || i12 >= 10) {
                    return null;
                }
                i11 = (i11 * 10) + i12;
            }
            return Integer.valueOf(i11);
        }

        public a(w wVar) {
        }
    }

    static {
        dp.c cVar = k.f562j;
        KFunction = new c("KFunction", 2, cVar, "KFunction", false, true);
        KSuspendFunction = new c("KSuspendFunction", 3, cVar, "KSuspendFunction", true, true);
        f999a = a();
        Companion = new a();
    }

    public c(String str, int i10, dp.c cVar, String str2, boolean z10, boolean z11) {
        super(str, i10);
        this.packageFqName = cVar;
        this.classNamePrefix = str2;
        this.isSuspendType = z10;
        this.isReflectType = z11;
    }

    public static final /* synthetic */ c[] a() {
        return new c[]{Function, SuspendFunction, KFunction, KSuspendFunction};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f999a.clone();
    }

    @l
    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    @l
    public final dp.c getPackageFqName() {
        return this.packageFqName;
    }

    @l
    public final f numberedClassName(int i10) {
        f fVarK = f.k(l0.C(this.classNamePrefix, Integer.valueOf(i10)));
        l0.o(fVarK, "identifier(\"$classNamePrefix$arity\")");
        return fVarK;
    }
}
