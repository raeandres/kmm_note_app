import platform.UIKit.UIDevice

class IOSPlatform : CommonPlatform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun testContent(): CommonPlatform = IOSPlatform()