package tj;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tj.c f15746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a<h0> f15747b;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w0<? extends d> f15750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a<h0> f15751b;

        public b(w0<? extends d> w0Var, a<h0> aVar) {
            this.f15750a = w0Var;
            this.f15751b = aVar;
        }

        public String toString() {
            return "ResultWithPath(result=" + this.f15750a + ", pathFromRoot=" + this.f15751b + ")";
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f15752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a<h0> f15753b;

        public c(d dVar, a<h0> aVar) {
            this.f15752a = dVar;
            this.f15753b = aVar;
        }

        public String toString() {
            return "ValueWithPath(value=" + this.f15752a + ", pathFromRoot=" + this.f15753b + ")";
        }
    }

    public x0(tj.c cVar, a<h0> aVar) {
        this.f15746a = cVar;
        this.f15747b = aVar;
    }

    public static b a(tj.c cVar, u0 u0Var, p0 p0Var) throws d.c {
        if (m.N()) {
            m.L("*** finding '" + p0Var + "' in " + cVar);
        }
        p0 p0Var2 = u0Var.f15736c;
        w0<? extends d> w0VarL = u0Var.m(p0Var).l(cVar, new x0(cVar));
        u0 u0VarM = w0VarL.f15744a.m(p0Var2);
        V v10 = w0VarL.f15745b;
        if (v10 instanceof tj.c) {
            c cVarB = b((tj.c) v10, p0Var);
            return new b(new w0(u0VarM, cVarB.f15752a), cVarB.f15753b);
        }
        throw new sj.c.d("resolved object to non-object " + cVar + " to " + w0VarL);
    }

    public static c b(tj.c cVar, p0 p0Var) {
        try {
            return c(cVar, p0Var, null);
        } catch (sj.c.h e10) {
            throw m.v(p0Var, e10);
        }
    }

    public static c c(tj.c cVar, p0 p0Var, a<h0> aVar) {
        String str = p0Var.f15726a;
        p0 p0Var2 = p0Var.f15727b;
        if (m.N()) {
            m.L("*** looking up '" + str + "' in " + cVar);
        }
        d dVarAttemptPeekWithPartialResolve = cVar.attemptPeekWithPartialResolve(str);
        a aVar2 = aVar == null ? new a(cVar, null) : new a(cVar, aVar);
        if (p0Var2 == null) {
            return new c(dVarAttemptPeekWithPartialResolve, aVar2);
        }
        return dVarAttemptPeekWithPartialResolve instanceof tj.c ? c((tj.c) dVarAttemptPeekWithPartialResolve, p0Var2, aVar2) : new c(null, aVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a<h0> f(a<h0> aVar, h0 h0Var, d dVar) {
        h0 h0Var2 = aVar.f15748a;
        if (h0Var2 != h0Var) {
            throw new sj.c.d("Can only replace() the top node we're resolving; had " + h0Var2 + " on top and tried to replace " + h0Var + " overall list was " + aVar);
        }
        a<h0> aVar2 = aVar.f15749b;
        h0 h0Var3 = aVar2 == null ? null : aVar2.f15748a;
        if (dVar == 0 || !(dVar instanceof h0)) {
            if (h0Var3 == null) {
                return null;
            }
            return f(aVar.f15749b, h0Var3, h0Var3.replaceChild((d) h0Var, null));
        }
        if (h0Var3 == null) {
            return new a<>((h0) dVar, null);
        }
        a<h0> aVarF = f(aVar.f15749b, h0Var3, h0Var3.replaceChild((d) h0Var, dVar));
        return aVarF != null ? new a<>((h0) dVar, aVarF) : new a<>((h0) dVar, null);
    }

    public b d(u0 u0Var, j1 j1Var, int i10) throws d.c {
        if (m.N()) {
            m.K(u0Var.b(), "searching for " + j1Var);
        }
        if (m.N()) {
            m.K(u0Var.b(), j1Var + " - looking up relative to file it occurred in");
        }
        b bVarA = a(this.f15746a, u0Var, j1Var.f15632a);
        if (bVarA.f15750a.f15745b == 0) {
            p0 p0VarM = j1Var.f15632a.m(i10);
            if (i10 > 0) {
                if (m.N()) {
                    m.K(bVarA.f15750a.f15744a.b(), p0VarM + " - looking up relative to parent file");
                }
                bVarA = a(this.f15746a, bVarA.f15750a.f15744a, p0VarM);
            }
            w0<? extends d> w0Var = bVarA.f15750a;
            if (w0Var.f15745b == 0 && w0Var.f15744a.f15735b.f15100a) {
                if (m.N()) {
                    m.K(bVarA.f15750a.f15744a.b(), p0VarM + " - looking up in system environment");
                }
                bVarA = a(m.o(), u0Var, p0VarM);
            }
        }
        if (m.N()) {
            m.K(bVarA.f15750a.f15744a.b(), "resolved to " + bVarA);
        }
        return bVarA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x0 e(h0 h0Var) {
        if (h0Var == 0) {
            throw new sj.c.d("can't push null parent");
        }
        if (m.N()) {
            StringBuilder sb2 = new StringBuilder("pushing parent ");
            sb2.append(h0Var);
            sb2.append(" ==root ");
            sb2.append(h0Var == this.f15746a);
            sb2.append(" onto ");
            sb2.append(this);
            m.L(sb2.toString());
        }
        a<h0> aVar = this.f15747b;
        if (aVar == null) {
            tj.c cVar = this.f15746a;
            if (h0Var == cVar) {
                return new x0(cVar, new a(h0Var, null));
            }
            if (m.N() && this.f15746a.hasDescendant((d) h0Var)) {
                m.L("***** BUG ***** tried to push parent " + h0Var + " without having a path to it in " + this);
            }
            return this;
        }
        h0 h0Var2 = aVar.f15748a;
        if (m.N() && h0Var2 != null && !h0Var2.hasDescendant((d) h0Var)) {
            m.L("***** BUG ***** trying to push non-child of " + h0Var2 + ", non-child was " + h0Var);
        }
        tj.c cVar2 = this.f15746a;
        a<h0> aVar2 = this.f15747b;
        aVar2.getClass();
        return new x0(cVar2, new a(h0Var, aVar2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x0 g(h0 h0Var, h0 h0Var2) {
        if (m.N()) {
            m.L("replaceCurrentParent old " + h0Var + "@" + System.identityHashCode(h0Var) + " replacement " + h0Var2 + "@" + System.identityHashCode(h0Var) + " in " + this);
        }
        if (h0Var == h0Var2) {
            return this;
        }
        a<h0> aVar = this.f15747b;
        if (aVar == null) {
            if (h0Var == this.f15746a) {
                return new x0(j(h0Var2));
            }
            throw new sj.c.d("attempt to replace root " + this.f15746a + " with " + h0Var2);
        }
        a<h0> aVarF = f(aVar, h0Var, (d) h0Var2);
        if (m.N()) {
            m.L("replaced " + h0Var + " with " + h0Var2 + " in " + this);
            StringBuilder sb2 = new StringBuilder("path was: ");
            sb2.append(this.f15747b);
            sb2.append(" is now ");
            sb2.append(aVarF);
            m.L(sb2.toString());
        }
        return aVarF != null ? new x0((tj.c) aVarF.b(), aVarF) : new x0(f1.empty());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x0 h(d dVar, d dVar2) {
        if (m.N()) {
            m.L("replaceWithinCurrentParent old " + dVar + "@" + System.identityHashCode(dVar) + " replacement " + dVar2 + "@" + System.identityHashCode(dVar) + " in " + this);
        }
        if (dVar == dVar2) {
            return this;
        }
        a<h0> aVar = this.f15747b;
        if (aVar != null) {
            h0 h0Var = aVar.f15748a;
            sj.m mVarReplaceChild = h0Var.replaceChild(dVar, dVar2);
            return g(h0Var, mVarReplaceChild instanceof h0 ? (h0) mVarReplaceChild : null);
        }
        if (dVar == this.f15746a && (dVar2 instanceof h0)) {
            return new x0(j((h0) dVar2));
        }
        throw new sj.c.d("replace in parent not possible " + dVar + " with " + dVar2 + " in " + this);
    }

    public x0 i() {
        return this.f15747b == null ? this : new x0(this.f15746a);
    }

    public final tj.c j(h0 h0Var) {
        return h0Var instanceof tj.c ? (tj.c) h0Var : f1.empty();
    }

    public String toString() {
        return "ResolveSource(root=" + this.f15746a + ", pathFromRoot=" + this.f15747b + ")";
    }

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f15748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a<T> f15749b;

        public a(T t10, a<T> aVar) {
            this.f15748a = t10;
            this.f15749b = aVar;
        }

        public T a() {
            return this.f15748a;
        }

        public T b() {
            while (true) {
                a<T> aVar = this.f15749b;
                if (aVar == null) {
                    return this.f15748a;
                }
                this = aVar;
            }
        }

        public a<T> c(T t10) {
            return new a<>(t10, this);
        }

        public a<T> d() {
            if (this.f15749b == null) {
                return this;
            }
            a<T> aVar = new a<>(this.f15748a, null);
            a<T> aVar2 = this.f15749b;
            while (aVar2 != null) {
                a<T> aVar3 = new a<>(aVar2.f15748a, aVar);
                aVar2 = aVar2.f15749b;
                aVar = aVar3;
            }
            return aVar;
        }

        public a<T> e() {
            return this.f15749b;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("[");
            for (a<T> aVarD = d(); aVarD != null; aVarD = aVarD.f15749b) {
                stringBuffer.append(aVarD.f15748a.toString());
                if (aVarD.f15749b != null) {
                    stringBuffer.append(" <= ");
                }
            }
            stringBuffer.append("]");
            return stringBuffer.toString();
        }

        public a(T t10) {
            this(t10, null);
        }
    }

    public x0(tj.c cVar) {
        this.f15746a = cVar;
        this.f15747b = null;
    }
}
