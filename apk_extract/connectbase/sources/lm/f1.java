package lm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@mm.c
@mm.f(allowedTargets = {mm.b.CLASS, mm.b.PROPERTY, mm.b.FIELD, mm.b.CONSTRUCTOR, mm.b.FUNCTION, mm.b.PROPERTY_GETTER, mm.b.PROPERTY_SETTER, mm.b.TYPEALIAS})
@mm.e(mm.a.BINARY)
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface f1 {
    String version();
}
