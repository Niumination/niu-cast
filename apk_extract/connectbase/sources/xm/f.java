package xm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import lm.f1;
import p6.s;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE})
@mm.f(allowedTargets = {mm.b.CLASS})
@f1(version = "1.3")
@Retention(RetentionPolicy.RUNTIME)
public @interface f {
    @in.i(name = "c")
    String c() default "";

    @in.i(name = "f")
    String f() default "";

    @in.i(name = b9.i.f771b)
    int[] i() default {};

    @in.i(name = a8.l.f173c)
    int[] l() default {};

    @in.i(name = p6.m.f13003a)
    String m() default "";

    @in.i(name = p6.n.f13005a)
    String[] n() default {};

    @in.i(name = s.f13016a)
    String[] s() default {};

    @in.i(name = "v")
    int v() default 1;
}
