package pr;

import hs.f0;
import hs.g0;
import hs.i0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE_USE})
@f0({f.class})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@g0({i0.RECEIVER, i0.PARAMETER, i0.RETURN})
public @interface c {
    int value() default -1;
}
