package io;

import eo.l1;
import eo.m1;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f8285a = new a();

    /* JADX INFO: renamed from: io.a$a, reason: collision with other inner class name */
    public static final class C0218a extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @l
        public static final C0218a f8286c = new C0218a();

        public C0218a() {
            super("package", false);
        }

        @Override // eo.m1
        @m
        public Integer a(@l m1 m1Var) {
            l0.p(m1Var, "visibility");
            if (this == m1Var) {
                return 0;
            }
            return l1.f4610a.b(m1Var) ? 1 : -1;
        }

        @Override // eo.m1
        @l
        public String b() {
            return "public/*package*/";
        }

        @Override // eo.m1
        @l
        public m1 d() {
            return l1.g.f4619c;
        }
    }

    public static final class b extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @l
        public static final b f8287c = new b();

        public b() {
            super("protected_and_package", true);
        }

        @Override // eo.m1
        @m
        public Integer a(@l m1 m1Var) {
            l0.p(m1Var, "visibility");
            if (l0.g(this, m1Var)) {
                return 0;
            }
            if (m1Var == l1.b.f4614c) {
                return null;
            }
            return Integer.valueOf(l1.f4610a.b(m1Var) ? 1 : -1);
        }

        @Override // eo.m1
        @l
        public String b() {
            return "protected/*protected and package*/";
        }

        @Override // eo.m1
        @l
        public m1 d() {
            return l1.g.f4619c;
        }
    }

    public static final class c extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @l
        public static final c f8288c = new c();

        public c() {
            super("protected_static", true);
        }

        @Override // eo.m1
        @l
        public String b() {
            return "protected/*protected static*/";
        }

        @Override // eo.m1
        @l
        public m1 d() {
            return l1.g.f4619c;
        }
    }
}
