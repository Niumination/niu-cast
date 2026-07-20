package fs;

import hs.a0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@hs.p
@hs.c(qualifier = o.class)
@Documented
@Repeatable(a.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface g {

    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @hs.p
    @hs.c(qualifier = o.class)
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
        g[] value();
    }

    String[] expression();

    boolean result();

    @a0("value")
    int targetValue() default 0;
}
