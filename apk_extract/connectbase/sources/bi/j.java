package bi;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ThreadLocal<j> f861n = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r f863b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ei.p f867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<s, ei.n> f868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<t> f869h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f874m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f864c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Stack<x> f865d = new Stack<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f866e = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public u f870i = u.SHALLOW;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g f871j = new g(Collections.EMPTY_SET);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedList<Object> f872k = new LinkedList<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final s f873l = new s();

    public static class a extends ThreadLocal<j> {
        public j a() {
            return new j();
        }

        @Override // java.lang.ThreadLocal
        public j initialValue() {
            return new j();
        }
    }

    public static void c() {
        f861n.remove();
    }

    public static j p() {
        return f861n.get();
    }

    public x A() {
        if (this.f865d.isEmpty()) {
            return null;
        }
        return this.f865d.peek();
    }

    public void B() {
        this.f865d.pop();
    }

    public void C() {
        this.f874m = false;
        if (this.f864c) {
            this.f863b.c("\n");
            this.f866e -= 4;
            F();
        }
        this.f863b.c("]");
        B();
    }

    public void D() {
        this.f874m = false;
        if (this.f864c) {
            this.f863b.c("\n");
            this.f866e -= 4;
            F();
        }
        this.f863b.c("}");
        B();
    }

    public void E() {
        this.f874m = true;
    }

    public void F() {
        for (int i10 = 0; i10 < this.f866e; i10++) {
            this.f863b.c(" ");
        }
    }

    public x G() {
        x xVarA;
        I();
        if (this.f864c && (xVarA = A()) != null && xVarA.c() == c.ARRAY) {
            F();
        }
        x xVar = new x(c.ARRAY);
        h(xVar);
        this.f863b.c("[");
        if (this.f864c) {
            this.f866e += 4;
            this.f863b.c("\n");
        }
        return xVar;
    }

    public x H() {
        x xVarA;
        I();
        if (this.f864c && (xVarA = A()) != null && xVarA.c() == c.ARRAY) {
            F();
        }
        x xVar = new x(c.OBJECT);
        h(xVar);
        this.f863b.c("{");
        if (this.f864c) {
            this.f866e += 4;
            this.f863b.c("\n");
        }
        return xVar;
    }

    public final void I() {
        if (this.f874m) {
            this.f863b.c(ks.g.f9491d);
            if (this.f864c) {
                this.f863b.c("\n");
            }
            this.f874m = false;
        }
    }

    public final void J() {
        this.f874m = false;
    }

    public final ei.n K() {
        return this.f868g.get(this.f873l);
    }

    public t a(List<t> list) {
        for (t tVar : list) {
            if (tVar.b(this.f873l)) {
                return tVar;
            }
        }
        return null;
    }

    public ei.n b(e eVar, Object obj) throws IllegalAccessException, InstantiationException {
        ei.n nVarK = K();
        if (nVarK != null) {
            return nVarK;
        }
        if (eVar != null) {
            nVarK = eVar.j();
        }
        return nVarK == null ? this.f867f.a(obj) : nVarK;
    }

    public final void d(char c10) {
        this.f863b.c("\\u");
        int i10 = 0;
        int i11 = c10;
        while (i10 < 4) {
            this.f863b.c(String.valueOf(m.f877f[(61440 & i11) >> 12]));
            i10++;
            i11 <<= 4;
        }
    }

    public void e(g gVar) {
        this.f871j = gVar;
    }

    public void f(r rVar) {
        this.f863b = rVar;
    }

    public void g(u uVar) {
        this.f870i = uVar;
    }

    public void h(x xVar) {
        this.f865d.push(xVar);
    }

    public void i(ei.p pVar) {
        this.f867f = pVar;
    }

    public void j(Object obj) {
        ei.n nVarK = K();
        if (nVarK == null) {
            nVarK = this.f867f.a(obj);
        }
        nVarK.a(obj);
    }

    public void k(String str) {
        this.f862a = str;
    }

    public void l(Map<s, ei.n> map) {
        this.f868g = map;
    }

    public void m(boolean z10) {
        this.f864c = z10;
    }

    public boolean n(e eVar) {
        t tVarA = a(this.f869h);
        if (tVarA != null) {
            return tVarA.a();
        }
        Boolean boolL = eVar.l();
        if (boolL != null) {
            return boolL.booleanValue();
        }
        if (eVar.o().booleanValue()) {
            return false;
        }
        if (this.f870i != u.SHALLOW) {
            return true;
        }
        Class clsH = eVar.h();
        return (clsH.isArray() || Iterable.class.isAssignableFrom(clsH) || Map.class.isAssignableFrom(clsH)) ? false : true;
    }

    public boolean o(String str, Object obj) {
        t tVarA = a(this.f869h);
        if (tVarA != null) {
            return tVarA.a();
        }
        String strY = f861n.get().y();
        if (obj == null) {
            return true;
        }
        u uVar = this.f870i;
        u uVar2 = u.SHALLOW;
        if ((uVar != uVar2 || strY == null || this.f873l.c() <= 1) && !(this.f870i == uVar2 && strY == null)) {
            return true;
        }
        Class<?> cls = obj.getClass();
        return (cls.isArray() || Iterable.class.isAssignableFrom(cls)) ? false : true;
    }

    public final ei.n q(Object obj) {
        return this.f867f.a(obj);
    }

    public void r(String str) {
        I();
        x xVarA = A();
        if (xVarA != null && xVarA.c() == c.ARRAY) {
            F();
        }
        this.f863b.c(str);
    }

    public void s(List<t> list) {
        this.f869h = list;
    }

    public LinkedList<Object> t() {
        return this.f872k;
    }

    public void u(String str) {
        I();
        if (this.f864c) {
            F();
        }
        if (str != null) {
            w(str);
        } else {
            r(d6.a.E);
        }
        this.f863b.c(":");
        if (this.f864c) {
            this.f863b.c(" ");
        }
    }

    public r v() {
        return this.f863b;
    }

    public void w(String str) {
        x xVarA;
        I();
        if (this.f864c && (xVarA = A()) != null && xVarA.c() == c.ARRAY) {
            F();
        }
        this.f863b.c("\"");
        int length = str.length();
        int iA = 0;
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\"') {
                iA = this.f863b.b(str, iA, i10, "\\u0022");
            } else if (cCharAt == '&') {
                iA = this.f863b.b(str, iA, i10, "\\u0026");
            } else if (cCharAt == '\'') {
                iA = this.f863b.b(str, iA, i10, "\\u0027");
            } else if (cCharAt == '<') {
                iA = this.f863b.b(str, iA, i10, "\\u003c");
            } else if (cCharAt == '>') {
                iA = this.f863b.b(str, iA, i10, "\\u003e");
            } else if (cCharAt == '\\') {
                iA = this.f863b.b(str, iA, i10, "\\\\");
            } else if (cCharAt == '\b') {
                iA = this.f863b.b(str, iA, i10, "\\b");
            } else if (cCharAt == '\f') {
                iA = this.f863b.b(str, iA, i10, "\\f");
            } else if (cCharAt == '\n') {
                iA = this.f863b.b(str, iA, i10, "\\n");
            } else if (cCharAt == '\r') {
                iA = this.f863b.b(str, iA, i10, "\\r");
            } else if (cCharAt == '\t') {
                iA = this.f863b.b(str, iA, i10, "\\t");
            } else if (Character.isISOControl(cCharAt)) {
                iA = this.f863b.a(str, iA, i10) + 1;
                d(cCharAt);
            }
        }
        if (iA < str.length()) {
            this.f863b.a(str, iA, str.length());
        }
        this.f863b.c("\"");
    }

    public s x() {
        return this.f873l;
    }

    public String y() {
        return this.f862a;
    }

    public g z() {
        return this.f871j;
    }
}
