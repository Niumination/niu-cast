package os;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    public @interface a {
        @ns.d(prefix = "class Renderer{Object[] $childrenArray(){return ", suffix = ";}}", value = "JAVA")
        @k
        String childrenArray() default "";

        @ns.d(prefix = "class Renderer{boolean $hasChildren(){return ", suffix = ";}}", value = "JAVA")
        @k
        String hasChildren() default "";

        @ns.d(prefix = "class Renderer{String $text(){return ", suffix = ";}}", value = "JAVA")
        @k
        String text() default "";
    }

    public f() {
        throw new AssertionError("Debug should not be instantiated");
    }
}
