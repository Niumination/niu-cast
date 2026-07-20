package bq;

import eo.y;
import kn.l0;
import kn.n0;
import kn.w;
import os.m;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k implements bq.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f1091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<ao.h, f0> f1092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final String f1093c;

    public static final class a extends k {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public static final a f1094d = new a();

        /* JADX INFO: renamed from: bq.k$a$a, reason: collision with other inner class name */
        public static final class C0046a extends n0 implements jn.l<ao.h, f0> {
            public static final C0046a INSTANCE = new C0046a();

            public C0046a() {
                super(1);
            }

            @Override // jn.l
            @os.l
            public final f0 invoke(@os.l ao.h hVar) {
                l0.p(hVar, "$this$null");
                vp.n0 n0VarN = hVar.n();
                l0.o(n0VarN, "booleanType");
                return n0VarN;
            }
        }

        public a() {
            super("Boolean", C0046a.INSTANCE);
        }
    }

    public static final class b extends k {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public static final b f1095d = new b();

        public static final class a extends n0 implements jn.l<ao.h, f0> {
            public static final a INSTANCE = new a();

            public a() {
                super(1);
            }

            @Override // jn.l
            @os.l
            public final f0 invoke(@os.l ao.h hVar) {
                l0.p(hVar, "$this$null");
                vp.n0 n0VarD = hVar.D();
                l0.o(n0VarD, "intType");
                return n0VarD;
            }
        }

        public b() {
            super("Int", a.INSTANCE);
        }
    }

    public static final class c extends k {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public static final c f1096d = new c();

        public static final class a extends n0 implements jn.l<ao.h, f0> {
            public static final a INSTANCE = new a();

            public a() {
                super(1);
            }

            @Override // jn.l
            @os.l
            public final f0 invoke(@os.l ao.h hVar) {
                l0.p(hVar, "$this$null");
                vp.n0 n0VarZ = hVar.Z();
                l0.o(n0VarZ, "unitType");
                return n0VarZ;
            }
        }

        public c() {
            super("Unit", a.INSTANCE);
        }
    }

    public /* synthetic */ k(String str, jn.l lVar, w wVar) {
        this(str, lVar);
    }

    @Override // bq.b
    @m
    public String a(@os.l y yVar) {
        return bq.b.a.a(this, yVar);
    }

    @Override // bq.b
    public boolean b(@os.l y yVar) {
        l0.p(yVar, "functionDescriptor");
        return l0.g(yVar.getReturnType(), this.f1092b.invoke(lp.a.g(yVar)));
    }

    @Override // bq.b
    @os.l
    public String getDescription() {
        return this.f1093c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(String str, jn.l<? super ao.h, ? extends f0> lVar) {
        this.f1091a = str;
        this.f1092b = lVar;
        this.f1093c = l0.C("must return ", str);
    }
}
