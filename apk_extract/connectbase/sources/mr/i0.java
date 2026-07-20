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
@hs.g0({hs.i0.EXPLICIT_LOWER_BOUND, hs.i0.EXPLICIT_UPPER_BOUND})
public @interface i0 {
    int value();
}
