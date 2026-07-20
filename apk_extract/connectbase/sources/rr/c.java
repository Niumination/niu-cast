package rr;

import hs.a0;
import hs.p;
import hs.r;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@p
@hs.c(qualifier = f.class)
@Documented
@Repeatable(a.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface c {

    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @p
    @hs.c(qualifier = f.class)
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
        c[] value();
    }

    String[] expression();

    @a0("value")
    @r
    String[] map();

    boolean result();
}
