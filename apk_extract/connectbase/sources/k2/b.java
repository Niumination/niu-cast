package k2;

import android.view.MotionEvent;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public interface b {

    public static final class a {
        public static int a(@l b bVar, @l f2.a aVar) {
            l0.p(bVar, "this");
            l0.p(aVar, "config");
            return 0;
        }

        public static void b(@l b bVar, int i10) {
            l0.p(bVar, "this");
        }

        public static void c(@l b bVar) {
            l0.p(bVar, "this");
        }

        public static boolean d(@l b bVar, @l MotionEvent motionEvent) {
            l0.p(bVar, "this");
            l0.p(motionEvent, "ev");
            return false;
        }

        public static void e(@l b bVar) {
            l0.p(bVar, "this");
        }

        public static void f(@l b bVar) {
            l0.p(bVar, "this");
        }

        public static void g(@l b bVar, int i10) {
            l0.p(bVar, "this");
        }
    }

    void a(int i10);

    void b();

    boolean c(@l MotionEvent motionEvent);

    void d();

    int e(@l f2.a aVar);

    void f(int i10);

    void g();
}
