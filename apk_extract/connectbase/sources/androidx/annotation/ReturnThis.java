package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import mm.a;
import mm.b;
import mm.c;
import mm.e;
import mm.f;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE, ElementType.METHOD})
@c
@f(allowedTargets = {b.FUNCTION, b.CLASS})
@e(a.BINARY)
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface ReturnThis {
}
