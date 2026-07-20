package un;

import java.util.List;
import java.util.Map;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
public interface c<R> extends b {

    public static final class a {
        @an.g
        public static /* synthetic */ void a() {
        }

        public static /* synthetic */ void b() {
        }

        public static /* synthetic */ void c() {
        }

        @f1(version = "1.1")
        public static /* synthetic */ void d() {
        }

        @f1(version = "1.1")
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

        @f1(version = "1.3")
        public static /* synthetic */ void i() {
        }
    }

    R call(@os.l Object... objArr);

    R callBy(@os.l Map<n, ? extends Object> map);

    @os.l
    String getName();

    @os.l
    List<n> getParameters();

    @os.l
    s getReturnType();

    @os.l
    List<t> getTypeParameters();

    @os.m
    w getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
