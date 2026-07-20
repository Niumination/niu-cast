package kn;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE})
@mm.f(allowedTargets = {mm.b.CLASS})
@mm.e(mm.a.BINARY)
@lm.f1(version = "1.8")
@Retention(RetentionPolicy.CLASS)
public @interface r1 {
    String[] value();
}
