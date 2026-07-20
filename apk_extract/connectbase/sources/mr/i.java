package mr;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@hs.f0({h.class})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface i {
    @hs.r
    String[] offset() default {};

    @hs.r
    String[] value();
}
