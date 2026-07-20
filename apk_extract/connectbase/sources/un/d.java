package un;

import java.util.Collection;
import java.util.List;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
public interface d<T> extends h, b, g {

    public static final class a {
        public static /* synthetic */ void a() {
        }

        public static /* synthetic */ void b() {
        }

        public static /* synthetic */ void c() {
        }

        public static /* synthetic */ void d() {
        }

        @f1(version = "1.3")
        public static /* synthetic */ void e() {
        }

        @f1(version = "1.1")
        public static /* synthetic */ void f() {
        }

        @f1(version = "1.1")
        public static /* synthetic */ void g() {
        }

        @f1(version = "1.1")
        public static /* synthetic */ void h() {
        }

        @f1(version = "1.1")
        public static /* synthetic */ void i() {
        }

        @f1(version = "1.1")
        public static /* synthetic */ void j() {
        }

        @f1(version = "1.1")
        public static /* synthetic */ void k() {
        }

        @f1(version = "1.1")
        public static /* synthetic */ void l() {
        }

        @f1(version = "1.4")
        public static /* synthetic */ void m() {
        }

        @f1(version = "1.1")
        public static /* synthetic */ void n() {
        }

        @f1(version = "1.1")
        public static /* synthetic */ void o() {
        }

        @f1(version = "1.1")
        public static /* synthetic */ void p() {
        }

        @f1(version = "1.5")
        public static /* synthetic */ void q() {
        }
    }

    @os.l
    List<s> a();

    boolean c();

    @Override // un.h
    @os.l
    Collection<c<?>> d();

    @os.l
    Collection<d<?>> e();

    boolean equals(@os.m Object obj);

    @os.l
    Collection<i<T>> g();

    @os.l
    List<t> getTypeParameters();

    @os.m
    w getVisibility();

    @os.m
    T h();

    int hashCode();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    @os.l
    List<d<? extends T>> k();

    boolean l();

    boolean q();

    @f1(version = "1.1")
    boolean r(@os.m Object obj);

    boolean t();

    boolean u();

    @os.m
    String v();

    @os.m
    String w();

    boolean x();
}
