package ik;

import java.util.List;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public interface b0 extends fl.o1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f7939b = a.f7940a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f7940a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final b0 f7941b = s.f8187d;

        public static /* synthetic */ void c() {
        }

        @os.l
        public final b0 a(@os.l jn.l<? super c0, l2> lVar) {
            kn.l0.p(lVar, "builder");
            c0 c0Var = new c0(0, 1, null);
            lVar.invoke(c0Var);
            return c0Var.f();
        }

        @os.l
        public final b0 b() {
            return f7941b;
        }
    }

    public static final class b {
        public static boolean a(@os.l b0 b0Var, @os.l String str) {
            kn.l0.p(b0Var, "this");
            kn.l0.p(str, "name");
            return fl.o1.b.a(b0Var, str);
        }

        public static boolean b(@os.l b0 b0Var, @os.l String str, @os.l String str2) {
            kn.l0.p(b0Var, "this");
            kn.l0.p(str, "name");
            kn.l0.p(str2, "value");
            return fl.o1.b.b(b0Var, str, str2);
        }

        public static void c(@os.l b0 b0Var, @os.l jn.p<? super String, ? super List<String>, l2> pVar) {
            kn.l0.p(b0Var, "this");
            kn.l0.p(pVar, "body");
            fl.o1.b.c(b0Var, pVar);
        }

        @os.m
        public static String d(@os.l b0 b0Var, @os.l String str) {
            kn.l0.p(b0Var, "this");
            kn.l0.p(str, "name");
            return fl.o1.b.d(b0Var, str);
        }
    }
}
