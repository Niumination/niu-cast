package ck;

import java.util.Map;
import vj.o1;
import vj.p1;
import vj.x1;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    public static final class a extends p1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f1619b = "no service config";

        @Override // vj.o1.d
        public o1 a(o1.f fVar) {
            return new o(fVar);
        }

        @Override // vj.p1
        public String b() {
            return "round_robin";
        }

        @Override // vj.p1
        public int c() {
            return 5;
        }

        @Override // vj.p1
        public boolean d() {
            return true;
        }

        @Override // vj.p1
        public x1.c e(Map<String, ?> map) {
            return x1.c.a(f1619b);
        }
    }
}
