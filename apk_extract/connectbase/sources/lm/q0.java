package lm;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@mm.f(allowedTargets = {mm.b.CLASS, mm.b.PROPERTY, mm.b.LOCAL_VARIABLE, mm.b.VALUE_PARAMETER, mm.b.CONSTRUCTOR, mm.b.FUNCTION, mm.b.PROPERTY_GETTER, mm.b.PROPERTY_SETTER, mm.b.EXPRESSION, mm.b.FILE, mm.b.TYPEALIAS})
@mm.e(mm.a.SOURCE)
@f1(version = "1.3")
@Retention(RetentionPolicy.SOURCE)
public @interface q0 {
    Class<? extends Annotation>[] markerClass();
}
