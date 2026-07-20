package fr;

import hs.a0;
import hs.p;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@p
@hs.c(qualifier = fr.a.class)
@Documented
@Repeatable(a.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface e {

    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @p
    @hs.c(qualifier = fr.a.class)
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
        e[] value();
    }

    String[] expression();

    @a0("value")
    String[] methods();

    boolean result();
}
