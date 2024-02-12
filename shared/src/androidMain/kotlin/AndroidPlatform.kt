

class AndroidPlatform : CommonPlatform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"

}

actual fun testContent(): CommonPlatform = AndroidPlatform()