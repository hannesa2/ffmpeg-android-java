package com.github.hiteshsondhi88.libffmpeg;

import android.os.Build;

import timber.log.Timber;

class CpuArchHelper {
    
    static CpuArch getCpuArch() {
        Timber.d("Build.CPU_ABI : %s", Build.CPU_ABI);
        return CpuArch.fromString(Build.CPU_ABI);
    }

}
