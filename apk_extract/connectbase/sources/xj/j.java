package xj;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE})
@mm.f(allowedTargets = {mm.b.CLASS})
@mm.e(mm.a.RUNTIME)
@Retention(RetentionPolicy.RUNTIME)
public @interface j {
    Class<?> value();
}
