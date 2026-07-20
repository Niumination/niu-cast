package ik;

import java.util.List;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public interface b1 extends fl.o1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f7942c = a.f7943a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f7943a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final b1 f7944b = t.f8188d;

        public static /* synthetic */ void c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @os.l
        public final b1 a(@os.l jn.l<? super c1, l2> lVar) {
            kn.l0.p(lVar, "builder");
            c1 c1Var = new c1(0, null, 3, 0 == true ? 1 : 0);
            lVar.invoke(c1Var);
            return c1Var.f();
        }

        @os.l
        public final b1 b() {
            return f7944b;
        }
    }

    public static final class b {
        public static boolean a(@os.l b1 b1Var, @os.l String str) {
            kn.l0.p(b1Var, "this");
            kn.l0.p(str, "name");
            return fl.o1.b.a(b1Var, str);
        }

        public static boolean b(@os.l b1 b1Var, @os.l String str, @os.l String str2) {
            kn.l0.p(b1Var, "this");
            kn.l0.p(str, "name");
            kn.l0.p(str2, "value");
            return fl.o1.b.b(b1Var, str, str2);
        }

        public static void c(@os.l b1 b1Var, @os.l jn.p<? super String, ? super List<String>, l2> pVar) {
            kn.l0.p(b1Var, "this");
            kn.l0.p(pVar, "body");
            fl.o1.b.c(b1Var, pVar);
        }

        @os.m
        public static String d(@os.l b1 b1Var, @os.l String str) {
            kn.l0.p(b1Var, "this");
            kn.l0.p(str, "name");
            return fl.o1.b.d(b1Var, str);
        }

        @os.l
        public static z1 e(@os.l b1 b1Var) {
            kn.l0.p(b1Var, "this");
            return z1.DEFAULT;
        }
    }

    @os.l
    z1 c();
}
