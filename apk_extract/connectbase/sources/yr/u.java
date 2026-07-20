package yr;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface u {
    o prefix() default o.one;

    Class<? extends Annotation> quantity();
}
