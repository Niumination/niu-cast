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
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@c
@f(allowedTargets = {b.VALUE_PARAMETER, b.LOCAL_VARIABLE, b.FUNCTION, b.PROPERTY_GETTER, b.PROPERTY_SETTER, b.FIELD, b.ANNOTATION_CLASS})
@e(a.BINARY)
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface Size {
    long max() default Long.MAX_VALUE;

    long min() default Long.MIN_VALUE;

    long multiple() default 1;

    long value() default -1;
}
