package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import a1.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes3.dex */
public final class IncompatibleVersionErrorData<T> {
    private final T actualVersion;
    private final ClassId classId;
    private final T compilerVersion;
    private final T expectedVersion;
    private final String filePath;
    private final T languageVersion;

    public IncompatibleVersionErrorData(T t3, T t8, T t10, T t11, String filePath, ClassId classId) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(classId, "classId");
        this.actualVersion = t3;
        this.compilerVersion = t8;
        this.languageVersion = t10;
        this.expectedVersion = t11;
        this.filePath = filePath;
        this.classId = classId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IncompatibleVersionErrorData)) {
            return false;
        }
        IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
        return Intrinsics.areEqual(this.actualVersion, incompatibleVersionErrorData.actualVersion) && Intrinsics.areEqual(this.compilerVersion, incompatibleVersionErrorData.compilerVersion) && Intrinsics.areEqual(this.languageVersion, incompatibleVersionErrorData.languageVersion) && Intrinsics.areEqual(this.expectedVersion, incompatibleVersionErrorData.expectedVersion) && Intrinsics.areEqual(this.filePath, incompatibleVersionErrorData.filePath) && Intrinsics.areEqual(this.classId, incompatibleVersionErrorData.classId);
    }

    public int hashCode() {
        T t3 = this.actualVersion;
        int iHashCode = (t3 == null ? 0 : t3.hashCode()) * 31;
        T t8 = this.compilerVersion;
        int iHashCode2 = (iHashCode + (t8 == null ? 0 : t8.hashCode())) * 31;
        T t10 = this.languageVersion;
        int iHashCode3 = (iHashCode2 + (t10 == null ? 0 : t10.hashCode())) * 31;
        T t11 = this.expectedVersion;
        return this.classId.hashCode() + a.e((iHashCode3 + (t11 != null ? t11.hashCode() : 0)) * 31, 31, this.filePath);
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", compilerVersion=" + this.compilerVersion + ", languageVersion=" + this.languageVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ", classId=" + this.classId + ')';
    }
}
