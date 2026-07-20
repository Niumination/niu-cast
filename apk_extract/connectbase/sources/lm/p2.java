package lm;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@mm.f(allowedTargets = {mm.b.CLASS, mm.b.PROPERTY, mm.b.CONSTRUCTOR, mm.b.FUNCTION, mm.b.TYPEALIAS})
@mm.e(mm.a.BINARY)
@Retention(RetentionPolicy.CLASS)
public @interface p2 {
    Class<? extends Annotation>[] markerClass();
}
