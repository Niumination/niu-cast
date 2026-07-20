package fl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Experimental;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@lm.b1(level = lm.b1.a.WARNING, message = "This API is experimental. It could be removed or changed in future releases, or its behaviour may be different.")
@mm.f(allowedTargets = {mm.b.CLASS, mm.b.TYPEALIAS, mm.b.FUNCTION, mm.b.PROPERTY, mm.b.FIELD, mm.b.CONSTRUCTOR})
@Experimental(level = Experimental.Level.WARNING)
@Retention(RetentionPolicy.RUNTIME)
@lm.k(message = "This annotation is no longer used and there is no need to opt-in into it.")
public @interface v0 {
}
