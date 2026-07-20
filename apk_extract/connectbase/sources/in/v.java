package in;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@mm.f(allowedTargets = {mm.b.FUNCTION, mm.b.PROPERTY_GETTER, mm.b.PROPERTY_SETTER, mm.b.CONSTRUCTOR})
@mm.e(mm.a.SOURCE)
@Retention(RetentionPolicy.SOURCE)
public @interface v {
    Class<? extends Throwable>[] exceptionClasses();
}
