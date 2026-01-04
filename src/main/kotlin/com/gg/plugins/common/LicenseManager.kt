package com.gg.plugins.common

import com.intellij.ide.ExternalId
import com.intellij.ide.licensing.LicenseManager

object GGLicenseManager {
    private const val PRODUCT_CODE = "PGG_YOUR_CODE" // This will be replaced by script

    fun isProEnabled(): Boolean {
        // 1. Check if forced via System Property (Local Dev)
        if (System.getProperty("gg.isPro") == "true") return true

        // 2. Check JetBrains Marketplace License
        val license = LicenseManager.getInstance().getLicenseStatus(ExternalId.PRODUCT, PRODUCT_CODE)
        return license?.isValid == true
    }
}
