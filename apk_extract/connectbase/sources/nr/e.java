package nr;

import hs.f0;
import hs.i0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@hs.e({i0.LOCAL_VARIABLE, i0.RESOURCE_VARIABLE})
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@f0({})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface e {
    Class<?> value() default Object.class;
}
