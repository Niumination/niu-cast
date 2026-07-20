package in;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.METHOD})
@mm.c
@mm.f(allowedTargets = {mm.b.CLASS, mm.b.FUNCTION, mm.b.PROPERTY, mm.b.TYPE})
@mm.e(mm.a.BINARY)
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface o {
    boolean suppress() default true;
}
