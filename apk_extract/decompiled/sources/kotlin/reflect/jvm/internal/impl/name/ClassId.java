package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nClassId.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassId.kt\norg/jetbrains/kotlin/name/ClassId\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n*L\n1#1,141:1\n1#2:142\n226#3:143\n226#3:144\n*S KotlinDebug\n*F\n+ 1 ClassId.kt\norg/jetbrains/kotlin/name/ClassId\n*L\n37#1:143\n47#1:144\n*E\n"})
public final class ClassId {
    public static final Companion Companion = new Companion(null);
    private final boolean isLocal;
    private final FqName packageFqName;
    private final FqName relativeClassName;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ClassId fromString$default(Companion companion, String str, boolean z2, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                z2 = false;
            }
            return companion.fromString(str, z2);
        }

        @JvmStatic
        @JvmOverloads
        public final ClassId fromString(String string, boolean z2) {
            String strReplace$default;
            Intrinsics.checkNotNullParameter(string, "string");
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string, '`', 0, false, 6, (Object) null);
            if (iIndexOf$default == -1) {
                iIndexOf$default = string.length();
            }
            int iLastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) string, "/", iIndexOf$default, false, 4, (Object) null);
            String str = "";
            if (iLastIndexOf$default == -1) {
                strReplace$default = StringsKt__StringsJVMKt.replace$default(string, "`", "", false, 4, (Object) null);
            } else {
                String strSubstring = string.substring(0, iLastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String strReplace$default2 = StringsKt__StringsJVMKt.replace$default(strSubstring, '/', '.', false, 4, (Object) null);
                String strSubstring2 = string.substring(iLastIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                strReplace$default = StringsKt__StringsJVMKt.replace$default(strSubstring2, "`", "", false, 4, (Object) null);
                str = strReplace$default2;
            }
            return new ClassId(new FqName(str), new FqName(strReplace$default), z2);
        }

        @JvmStatic
        public final ClassId topLevel(FqName topLevelFqName) {
            Intrinsics.checkNotNullParameter(topLevelFqName, "topLevelFqName");
            FqName fqNameParent = topLevelFqName.parent();
            Intrinsics.checkNotNullExpressionValue(fqNameParent, "parent(...)");
            Name nameShortName = topLevelFqName.shortName();
            Intrinsics.checkNotNullExpressionValue(nameShortName, "shortName(...)");
            return new ClassId(fqNameParent, nameShortName);
        }

        private Companion() {
        }
    }

    public ClassId(FqName packageFqName, FqName relativeClassName, boolean z2) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(relativeClassName, "relativeClassName");
        this.packageFqName = packageFqName;
        this.relativeClassName = relativeClassName;
        this.isLocal = z2;
        relativeClassName.isRoot();
    }

    private static final String asString$escapeSlashes(FqName fqName) {
        String strAsString = fqName.asString();
        Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        if (!StringsKt__StringsKt.contains$default((CharSequence) strAsString, '/', false, 2, (Object) null)) {
            return strAsString;
        }
        return "`" + strAsString + '`';
    }

    @JvmStatic
    public static final ClassId topLevel(FqName fqName) {
        return Companion.topLevel(fqName);
    }

    public final FqName asSingleFqName() {
        if (this.packageFqName.isRoot()) {
            return this.relativeClassName;
        }
        return new FqName(this.packageFqName.asString() + '.' + this.relativeClassName.asString());
    }

    public final String asString() {
        if (this.packageFqName.isRoot()) {
            return asString$escapeSlashes(this.relativeClassName);
        }
        StringBuilder sb2 = new StringBuilder();
        String strAsString = this.packageFqName.asString();
        Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        sb2.append(StringsKt__StringsJVMKt.replace$default(strAsString, '.', '/', false, 4, (Object) null));
        sb2.append("/");
        sb2.append(asString$escapeSlashes(this.relativeClassName));
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final ClassId createNestedClassId(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        FqName fqName = this.packageFqName;
        FqName fqNameChild = this.relativeClassName.child(name);
        Intrinsics.checkNotNullExpressionValue(fqNameChild, "child(...)");
        return new ClassId(fqName, fqNameChild, this.isLocal);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassId)) {
            return false;
        }
        ClassId classId = (ClassId) obj;
        return Intrinsics.areEqual(this.packageFqName, classId.packageFqName) && Intrinsics.areEqual(this.relativeClassName, classId.relativeClassName) && this.isLocal == classId.isLocal;
    }

    public final ClassId getOuterClassId() {
        FqName fqNameParent = this.relativeClassName.parent();
        Intrinsics.checkNotNullExpressionValue(fqNameParent, "parent(...)");
        if (fqNameParent.isRoot()) {
            return null;
        }
        return new ClassId(this.packageFqName, fqNameParent, this.isLocal);
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final FqName getRelativeClassName() {
        return this.relativeClassName;
    }

    public final Name getShortClassName() {
        Name nameShortName = this.relativeClassName.shortName();
        Intrinsics.checkNotNullExpressionValue(nameShortName, "shortName(...)");
        return nameShortName;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isLocal) + ((this.relativeClassName.hashCode() + (this.packageFqName.hashCode() * 31)) * 31);
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    public final boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    public String toString() {
        if (!this.packageFqName.isRoot()) {
            return asString();
        }
        return "/" + asString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ClassId(FqName packageFqName, Name topLevelName) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(topLevelName, "topLevelName");
        FqName fqName = FqName.topLevel(topLevelName);
        Intrinsics.checkNotNullExpressionValue(fqName, "topLevel(...)");
        this(packageFqName, fqName, false);
    }
}
