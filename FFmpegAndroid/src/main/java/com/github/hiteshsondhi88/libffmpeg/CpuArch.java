package com.github.hiteshsondhi88.libffmpeg;

import android.text.TextUtils;

enum CpuArch {
    x86_64("x86_64"),
    armv7("armeabi-v7a"),
    arm64_v8a("arm64-v8a"),
    NONE(null);

    private final String value;

    CpuArch(String sha1) {
        this.value = sha1;
    }

    String getValue(){
        return value;
    }

    static CpuArch fromString(String value) {
        if (!TextUtils.isEmpty(value)) {
            for (CpuArch cpuArch : CpuArch.values()) {
                if (value.equalsIgnoreCase(cpuArch.value)) {
                    return cpuArch;
                }
            }
        }
        return NONE;
    }
}
