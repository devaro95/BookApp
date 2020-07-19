package com.data.manager

import android.content.Context
import android.net.ConnectivityManager
import com.domain.STRING_EMPTY
import com.domain.manager.NetworkManager
import java.net.Inet4Address
import java.net.NetworkInterface
import java.net.SocketException


class ContextNetworkManager(private val context: Context) : NetworkManager {

    override fun isNetworkAvailable(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }

    override fun getDeviceIp(): String {
        try {
            val en = NetworkInterface.getNetworkInterfaces()
            while (en.hasMoreElements()) {
                val intf = en.nextElement()
                val enumIpAddr = intf.inetAddresses
                while (enumIpAddr.hasMoreElements()) {
                    val inetAddress = enumIpAddr.nextElement()
                    if (!inetAddress.isLoopbackAddress && inetAddress is Inet4Address) {
                        return inetAddress.getHostAddress()
                    }
                }
            }
        } catch (ex: SocketException) {
            ex.printStackTrace()
        }

        return STRING_EMPTY
    }
}