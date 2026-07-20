package androidx.annotation.experimental;

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
@Target({ElementType.ANNOTATION_TYPE})
@f(allowedTargets = {b.ANNOTATION_CLASS})
@e(a.BINARY)
@Retention(RetentionPolicy.CLASS)
@k(message = "This annotation has been replaced by `@RequiresOptIn`", replaceWith = @a1(expression = "RequiresOptIn", imports = {"androidx.annotation.RequiresOptIn"}))
public @interface Experimental {

    public enum Level {
        WARNING,
        ERROR
    }

    Level level() default Level.ERROR;
}
