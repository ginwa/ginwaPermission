package com.m.ginwa.ind.ginwapermission


import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

class GinwaPermission {

    data class Builder(
        var activity: Activity,
        var permissions: Array<String> = emptyArray(),
        var code: Int? = null
    ) {

        /**
         * permissionList in array
         * example arrayOf(READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE)
         */
        fun permissions(permissions: Array<String>) = apply {
            this.permissions = permissions
        }

        /**
         * permissionCode
         */
        fun code(code: Int?) = apply {
            this.code = code
        }

        /**
         * request Permission based on permissionList
         */
        fun reqPermissions() = apply {
            ActivityCompat.requestPermissions(activity, permissions, code!!)
        }

        /**
         * If permission is Refuse return False
         */
        fun checkPermissions(permissions: Array<String>): Boolean {
            return permissions.all { permission ->
                ActivityCompat.checkSelfPermission(
                    activity,
                    permission
                ) == PackageManager.PERMISSION_GRANTED
            }
        }
    }
}