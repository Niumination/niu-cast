package com.google.protobuf.kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import lm.b1;
import mm.a;
import mm.b;
import mm.e;
import mm.f;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@b1(level = b1.a.ERROR, message = "\n    This API is only intended for use by generated protobuf code, the code generator, and their own\n    tests.  If this does not describe your code, you should not be using this API.\n  ")
@f(allowedTargets = {b.CONSTRUCTOR, b.ANNOTATION_CLASS})
@e(a.BINARY)
@Retention(RetentionPolicy.CLASS)
public @interface OnlyForUseByGeneratedProtoCode {
}
