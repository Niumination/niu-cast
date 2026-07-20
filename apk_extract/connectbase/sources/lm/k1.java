package lm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@mm.f(allowedTargets = {mm.b.CLASS, mm.b.ANNOTATION_CLASS, mm.b.TYPE_PARAMETER, mm.b.PROPERTY, mm.b.FIELD, mm.b.LOCAL_VARIABLE, mm.b.VALUE_PARAMETER, mm.b.CONSTRUCTOR, mm.b.FUNCTION, mm.b.PROPERTY_GETTER, mm.b.PROPERTY_SETTER, mm.b.TYPE, mm.b.EXPRESSION, mm.b.FILE, mm.b.TYPEALIAS})
@mm.e(mm.a.SOURCE)
@Retention(RetentionPolicy.SOURCE)
public @interface k1 {
    String[] names();
}
