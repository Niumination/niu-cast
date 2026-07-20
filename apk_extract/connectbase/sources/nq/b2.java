package nq;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.METHOD})
@lm.b1(level = lm.b1.a.WARNING, message = "This declaration is in a preview state and can be changed in a backwards-incompatible manner with a best-effort migration. Its usage should be marked with '@kotlinx.coroutines.FlowPreview' or '@OptIn(kotlinx.coroutines.FlowPreview::class)' if you accept the drawback of relying on preview API")
@Retention(RetentionPolicy.CLASS)
@mm.c
@mm.f(allowedTargets = {mm.b.CLASS, mm.b.FUNCTION, mm.b.TYPEALIAS, mm.b.PROPERTY})
@mm.e(mm.a.BINARY)
@Documented
public @interface b2 {
}
