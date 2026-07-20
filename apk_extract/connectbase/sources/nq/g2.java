package nq;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.METHOD})
@lm.b1(level = lm.b1.a.ERROR, message = "This is an internal kotlinx.coroutines API that should not be used from outside of kotlinx.coroutines. No compatibility guarantees are provided. It is recommended to report your use-case of internal API to kotlinx.coroutines issue tracker, so stable API could be provided instead")
@mm.f(allowedTargets = {mm.b.CLASS, mm.b.FUNCTION, mm.b.TYPEALIAS, mm.b.PROPERTY})
@mm.e(mm.a.BINARY)
@Retention(RetentionPolicy.CLASS)
public @interface g2 {
}
