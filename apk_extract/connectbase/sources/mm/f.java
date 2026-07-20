package mm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE})
@c
@f(allowedTargets = {b.ANNOTATION_CLASS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface f {
    b[] allowedTargets();
}
