package com.google.protobuf;

import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class LegacyDescriptorsUtil {

    /* JADX INFO: renamed from: com.google.protobuf.LegacyDescriptorsUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax;

        static {
            int[] iArr = new int[Descriptors.FileDescriptor.Syntax.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax = iArr;
            try {
                iArr[Descriptors.FileDescriptor.Syntax.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax[Descriptors.FileDescriptor.Syntax.PROTO2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax[Descriptors.FileDescriptor.Syntax.PROTO3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class LegacyFieldDescriptor {
        private LegacyFieldDescriptor() {
        }

        public static boolean hasOptionalKeyword(Descriptors.FieldDescriptor fieldDescriptor) {
            return fieldDescriptor.hasOptionalKeyword();
        }
    }

    public static final class LegacyFileDescriptor {

        public enum Syntax {
            UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN),
            PROTO2("proto2"),
            PROTO3("proto3");

            final String name;

            Syntax(String str) {
                this.name = str;
            }
        }

        private LegacyFileDescriptor() {
        }

        public static Syntax getSyntax(Descriptors.FileDescriptor fileDescriptor) {
            int i8 = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax[fileDescriptor.getSyntax().ordinal()];
            if (i8 == 1) {
                return Syntax.UNKNOWN;
            }
            if (i8 == 2) {
                return Syntax.PROTO2;
            }
            if (i8 == 3) {
                return Syntax.PROTO3;
            }
            throw new IllegalArgumentException("Unexpected syntax");
        }
    }

    public static final class LegacyOneofDescriptor {
        private LegacyOneofDescriptor() {
        }

        public static boolean isSynthetic(Descriptors.OneofDescriptor oneofDescriptor) {
            return oneofDescriptor.isSynthetic();
        }
    }

    private LegacyDescriptorsUtil() {
    }
}
