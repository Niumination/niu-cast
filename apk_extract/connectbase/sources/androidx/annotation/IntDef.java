package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import mm.a;
import mm.b;
import mm.e;
import mm.f;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.ANNOTATION_TYPE})
@f(allowedTargets = {b.ANNOTATION_CLASS})
@e(a.SOURCE)
@Retention(RetentionPolicy.SOURCE)
public @interface IntDef {
    boolean flag() default false;

    boolean open() default false;

    int[] value() default {};
}
