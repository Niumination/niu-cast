package androidx.annotation.experimental;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import lm.a1;
import lm.k;
import mm.a;
import mm.b;
import mm.e;
import mm.f;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@f(allowedTargets = {b.CLASS, b.PROPERTY, b.LOCAL_VARIABLE, b.VALUE_PARAMETER, b.CONSTRUCTOR, b.FUNCTION, b.PROPERTY_GETTER, b.PROPERTY_SETTER, b.FILE, b.TYPEALIAS})
@e(a.BINARY)
@Retention(RetentionPolicy.CLASS)
@k(message = "This annotation has been replaced by `@OptIn`", replaceWith = @a1(expression = "OptIn", imports = {"androidx.annotation.OptIn"}))
public @interface UseExperimental {
    Class<? extends Annotation>[] markerClass();
}
