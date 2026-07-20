package in;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@mm.c
@mm.f(allowedTargets = {mm.b.FUNCTION, mm.b.CONSTRUCTOR, mm.b.PROPERTY_GETTER, mm.b.PROPERTY_SETTER, mm.b.CLASS})
@mm.e(mm.a.SOURCE)
@Documented
@Retention(RetentionPolicy.SOURCE)
public @interface t {
}
