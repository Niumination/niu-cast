package kn;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nTypeParameterReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeParameterReference.kt\nkotlin/jvm/internal/TypeParameterReference\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n1#2:59\n*E\n"})
@lm.f1(version = "1.4")
public final class v1 implements un.t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final a f9367f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final Object f9368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f9369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final un.v f9370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.m
    public volatile List<? extends un.s> f9372e;

    public static final class a {

        /* JADX INFO: renamed from: kn.v1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0246a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f9373a;

            static {
                int[] iArr = new int[un.v.values().length];
                try {
                    iArr[un.v.INVARIANT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[un.v.IN.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[un.v.OUT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f9373a = iArr;
            }
        }

        public a() {
        }

        @os.l
        public final String a(@os.l un.t tVar) {
            l0.p(tVar, "typeParameter");
            StringBuilder sb2 = new StringBuilder();
            int i10 = C0246a.f9373a[tVar.m().ordinal()];
            if (i10 == 2) {
                sb2.append("in ");
            } else if (i10 == 3) {
                sb2.append("out ");
            }
            sb2.append(tVar.getName());
            String string = sb2.toString();
            l0.o(string, "toString(...)");
            return string;
        }

        public a(w wVar) {
        }
    }

    public v1(@os.m Object obj, @os.l String str, @os.l un.v vVar, boolean z10) {
        l0.p(str, "name");
        l0.p(vVar, "variance");
        this.f9368a = obj;
        this.f9369b = str;
        this.f9370c = vVar;
        this.f9371d = z10;
    }

    public static /* synthetic */ void b() {
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof v1) {
            v1 v1Var = (v1) obj;
            if (l0.g(this.f9368a, v1Var.f9368a) && l0.g(this.f9369b, v1Var.f9369b)) {
                return true;
            }
        }
        return false;
    }

    public final void f(@os.l List<? extends un.s> list) {
        l0.p(list, "upperBounds");
        if (this.f9372e == null) {
            this.f9372e = list;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    @Override // un.t
    @os.l
    public String getName() {
        return this.f9369b;
    }

    @Override // un.t
    @os.l
    public List<un.s> getUpperBounds() {
        List list = this.f9372e;
        if (list != null) {
            return list;
        }
        List<un.s> listK = nm.x.k(l1.n(Object.class));
        this.f9372e = listK;
        return listK;
    }

    public int hashCode() {
        Object obj = this.f9368a;
        return this.f9369b.hashCode() + ((obj != null ? obj.hashCode() : 0) * 31);
    }

    @Override // un.t
    public boolean j() {
        return this.f9371d;
    }

    @Override // un.t
    @os.l
    public un.v m() {
        return this.f9370c;
    }

    @os.l
    public String toString() {
        return f9367f.a(this);
    }
}
