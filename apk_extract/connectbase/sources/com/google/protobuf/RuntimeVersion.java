package com.google.protobuf;

import java.util.logging.Logger;
import m.a;

/* JADX INFO: loaded from: classes.dex */
public final class RuntimeVersion {
    public static final int MAJOR = 4;
    public static final int MINOR = 26;
    public static final int PATCH = 1;
    public static final String SUFFIX = "";
    public static final RuntimeDomain DOMAIN = RuntimeDomain.PUBLIC;
    private static final String VERSION_STRING = versionString(4, 26, 1, "");
    private static final Logger logger = Logger.getLogger(RuntimeVersion.class.getName());

    public static final class ProtobufRuntimeVersionException extends RuntimeException {
        public ProtobufRuntimeVersionException(String message) {
            super(message);
        }
    }

    public enum RuntimeDomain {
        GOOGLE_INTERNAL,
        PUBLIC
    }

    private RuntimeVersion() {
    }

    private static boolean checkDisabled() {
        String str = System.getenv("TEMORARILY_DISABLE_PROTOBUF_VERSION_CHECK");
        return str != null && str.equals("true");
    }

    public static void validateProtobufGencodeVersion(RuntimeDomain domain, int major, int minor, int patch, String suffix, String location) {
        if (checkDisabled()) {
            return;
        }
        validateProtobufGencodeVersionImpl(domain, major, minor, patch, suffix, location);
    }

    private static void validateProtobufGencodeVersionImpl(RuntimeDomain domain, int major, int minor, int patch, String suffix, String location) {
        if (checkDisabled()) {
            return;
        }
        String strVersionString = versionString(major, minor, patch, suffix);
        if (major < 0 || minor < 0 || patch < 0) {
            throw new ProtobufRuntimeVersionException(a.a("Invalid gencode version: ", strVersionString));
        }
        RuntimeDomain runtimeDomain = DOMAIN;
        if (domain != runtimeDomain) {
            throw new ProtobufRuntimeVersionException(String.format("Detected mismatched Protobuf Gencode/Runtime domains when loading %s: gencode %s, runtime %s. Cross-domain usage of Protobuf is not supported.", location, domain, runtimeDomain));
        }
        if (major != 4) {
            throw new ProtobufRuntimeVersionException(String.format("Detected mismatched Protobuf Gencode/Runtime major versions when loading %s: gencode %s, runtime %s. Same major version is required.", location, strVersionString, VERSION_STRING));
        }
        if (26 < minor || (26 == minor && 1 < patch)) {
            throw new ProtobufRuntimeVersionException(String.format("Detected incompatible Protobuf Gencode/Runtime versions when loading %s: gencode %s, runtime %s. Runtime version cannot be older than the linked gencode version.", location, strVersionString, VERSION_STRING));
        }
        if (!suffix.equals("")) {
            throw new ProtobufRuntimeVersionException(String.format("Detected mismatched Protobuf Gencode/Runtime version suffixes when loading %s: gencode %s, runtime %s. Version suffixes must be the same.", location, strVersionString, VERSION_STRING));
        }
    }

    private static String versionString(int major, int minor, int patch, String suffix) {
        return String.format("%d.%d.%d%s", Integer.valueOf(major), Integer.valueOf(minor), Integer.valueOf(patch), suffix);
    }
}
