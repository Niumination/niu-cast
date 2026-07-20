package fl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@t0
@mm.f(allowedTargets = {mm.b.CLASS, mm.b.ANNOTATION_CLASS, mm.b.CONSTRUCTOR, mm.b.FUNCTION, mm.b.PROPERTY, mm.b.PROPERTY_SETTER, mm.b.TYPEALIAS})
@mm.e(mm.a.SOURCE)
@Retention(RetentionPolicy.SOURCE)
public @interface j1 {
    String version();
}
