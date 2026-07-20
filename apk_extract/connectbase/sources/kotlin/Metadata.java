package kotlin;

import in.i;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import lm.f1;
import lm.k;
import lm.m;
import mm.b;
import mm.e;
import mm.f;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE})
@f(allowedTargets = {b.CLASS})
@e(mm.a.RUNTIME)
@f1(version = "1.3")
@Retention(RetentionPolicy.RUNTIME)
public @interface Metadata {

    public static final class a {
        @k(level = m.WARNING, message = "Bytecode version had no significant use in Kotlin metadata and it will be removed in a future version.")
        public static /* synthetic */ void a() {
        }

        @f1(version = "1.2")
        public static /* synthetic */ void b() {
        }

        @f1(version = "1.1")
        public static /* synthetic */ void c() {
        }
    }

    @i(name = "bv")
    int[] bv() default {1, 0, 3};

    @i(name = "d1")
    String[] d1() default {};

    @i(name = "d2")
    String[] d2() default {};

    @i(name = "k")
    int k() default 1;

    @i(name = "mv")
    int[] mv() default {};

    @i(name = "pn")
    String pn() default "";

    @i(name = "xi")
    int xi() default 0;

    @i(name = "xs")
    String xs() default "";
}
