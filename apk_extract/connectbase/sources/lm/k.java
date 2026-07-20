package lm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@mm.c
@mm.f(allowedTargets = {mm.b.CLASS, mm.b.FUNCTION, mm.b.PROPERTY, mm.b.ANNOTATION_CLASS, mm.b.CONSTRUCTOR, mm.b.PROPERTY_SETTER, mm.b.PROPERTY_GETTER, mm.b.TYPEALIAS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface k {
    m level() default m.WARNING;

    String message();

    a1 replaceWith() default @a1(expression = "", imports = {});
}
