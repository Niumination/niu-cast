package fl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Experimental;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@lm.b1(level = lm.b1.a.ERROR, message = "This API is internal in Ktor and should not be used. It could be removed or changed without notice.")
@mm.f(allowedTargets = {mm.b.CLASS, mm.b.TYPEALIAS, mm.b.FUNCTION, mm.b.PROPERTY, mm.b.FIELD, mm.b.CONSTRUCTOR, mm.b.PROPERTY_SETTER})
@Experimental(level = Experimental.Level.ERROR)
@Retention(RetentionPolicy.RUNTIME)
public @interface t0 {
}
