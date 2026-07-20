package lm;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({})
@mm.c
@mm.f(allowedTargets = {})
@mm.e(mm.a.BINARY)
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface a1 {
    String expression();

    String[] imports();
}
