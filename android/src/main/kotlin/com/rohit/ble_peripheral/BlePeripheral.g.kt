// Autogenerated from Pigeon (v10.1.5), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package com.rohit.ble_peripheral

import android.util.Log
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MessageCodec
import io.flutter.plugin.common.StandardMessageCodec
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

private fun wrapResult(result: Any?): List<Any?> {
  return listOf(result)
}

private fun wrapError(exception: Throwable): List<Any?> {
  if (exception is FlutterError) {
    return listOf(
      exception.code,
      exception.message,
      exception.details
    )
  } else {
    return listOf(
      exception.javaClass.simpleName,
      exception.toString(),
      "Cause: " + exception.cause + ", Stacktrace: " + Log.getStackTraceString(exception)
    )
  }
}

/**
 * Error class for passing custom error details to Flutter via a thrown PlatformException.
 * @property code The error code.
 * @property message The error message.
 * @property details The error details. Must be a datatype supported by the api codec.
 */
class FlutterError (
  val code: String,
  override val message: String? = null,
  val details: Any? = null
) : Throwable()

/**
 * Models
 *
 * Generated class from Pigeon that represents data sent in messages.
 */
data class UUID (
  val value: String

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): UUID {
      val value = list[0] as String
      return UUID(value)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      value,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class BleDescriptor (
  val uuid: UUID,
  val value: ByteArray? = null,
  val permissions: List<Long?>? = null

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): BleDescriptor {
      val uuid = UUID.fromList(list[0] as List<Any?>)
      val value = list[1] as ByteArray?
      val permissions = list[2] as List<Long?>?
      return BleDescriptor(uuid, value, permissions)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      uuid.toList(),
      value,
      permissions,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class BleCharacteristic (
  val uuid: UUID,
  val properties: List<Long?>,
  val permissions: List<Long?>,
  val descriptors: List<BleDescriptor?>? = null,
  val value: ByteArray? = null

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): BleCharacteristic {
      val uuid = UUID.fromList(list[0] as List<Any?>)
      val properties = list[1] as List<Long?>
      val permissions = list[2] as List<Long?>
      val descriptors = list[3] as List<BleDescriptor?>?
      val value = list[4] as ByteArray?
      return BleCharacteristic(uuid, properties, permissions, descriptors, value)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      uuid.toList(),
      properties,
      permissions,
      descriptors,
      value,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class BleService (
  val uuid: UUID,
  val primary: Boolean,
  val characteristics: List<BleCharacteristic?>

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): BleService {
      val uuid = UUID.fromList(list[0] as List<Any?>)
      val primary = list[1] as Boolean
      val characteristics = list[2] as List<BleCharacteristic?>
      return BleService(uuid, primary, characteristics)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      uuid.toList(),
      primary,
      characteristics,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class BleCentral (
  val uuid: UUID

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): BleCentral {
      val uuid = UUID.fromList(list[0] as List<Any?>)
      return BleCentral(uuid)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      uuid.toList(),
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class ReadRequestResult (
  val value: ByteArray,
  val offset: Long? = null

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): ReadRequestResult {
      val value = list[0] as ByteArray
      val offset = list[1].let { if (it is Int) it.toLong() else it as Long? }
      return ReadRequestResult(value, offset)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      value,
      offset,
    )
  }
}
@Suppress("UNCHECKED_CAST")
private object BlePeripheralChannelCodec : StandardMessageCodec() {
  override fun readValueOfType(type: Byte, buffer: ByteBuffer): Any? {
    return when (type) {
      128.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          BleCentral.fromList(it)
        }
      }
      129.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          BleCharacteristic.fromList(it)
        }
      }
      130.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          BleDescriptor.fromList(it)
        }
      }
      131.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          BleService.fromList(it)
        }
      }
      132.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          UUID.fromList(it)
        }
      }
      else -> super.readValueOfType(type, buffer)
    }
  }
  override fun writeValue(stream: ByteArrayOutputStream, value: Any?)   {
    when (value) {
      is BleCentral -> {
        stream.write(128)
        writeValue(stream, value.toList())
      }
      is BleCharacteristic -> {
        stream.write(129)
        writeValue(stream, value.toList())
      }
      is BleDescriptor -> {
        stream.write(130)
        writeValue(stream, value.toList())
      }
      is BleService -> {
        stream.write(131)
        writeValue(stream, value.toList())
      }
      is UUID -> {
        stream.write(132)
        writeValue(stream, value.toList())
      }
      else -> super.writeValue(stream, value)
    }
  }
}

/**
 * Flutter -> Native
 *
 * Generated interface from Pigeon that represents a handler of messages from Flutter.
 */
interface BlePeripheralChannel {
  fun initialize()
  fun isAdvertising(): Boolean
  fun isSupported(): Boolean
  fun stopAdvertising()
  fun addServices(services: List<BleService>)
  fun startAdvertising(services: List<UUID>, localName: String)
  fun updateCharacteristic(central: BleCentral, characteristic: BleCharacteristic, value: ByteArray)

  companion object {
    /** The codec used by BlePeripheralChannel. */
    val codec: MessageCodec<Any?> by lazy {
      BlePeripheralChannelCodec
    }
    /** Sets up an instance of `BlePeripheralChannel` to handle messages through the `binaryMessenger`. */
    @Suppress("UNCHECKED_CAST")
    fun setUp(binaryMessenger: BinaryMessenger, api: BlePeripheralChannel?) {
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.initialize", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              api.initialize()
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.isAdvertising", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.isAdvertising())
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.isSupported", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.isSupported())
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.stopAdvertising", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              api.stopAdvertising()
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.addServices", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val servicesArg = args[0] as List<BleService>
            var wrapped: List<Any?>
            try {
              api.addServices(servicesArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.startAdvertising", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val servicesArg = args[0] as List<UUID>
            val localNameArg = args[1] as String
            var wrapped: List<Any?>
            try {
              api.startAdvertising(servicesArg, localNameArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BlePeripheralChannel.updateCharacteristic", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val centralArg = args[0] as BleCentral
            val characteristicArg = args[1] as BleCharacteristic
            val valueArg = args[2] as ByteArray
            var wrapped: List<Any?>
            try {
              api.updateCharacteristic(centralArg, characteristicArg, valueArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
    }
  }
}
@Suppress("UNCHECKED_CAST")
private object BleCallbackCodec : StandardMessageCodec() {
  override fun readValueOfType(type: Byte, buffer: ByteBuffer): Any? {
    return when (type) {
      128.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          BleCentral.fromList(it)
        }
      }
      129.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          BleCharacteristic.fromList(it)
        }
      }
      130.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          BleDescriptor.fromList(it)
        }
      }
      131.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          BleService.fromList(it)
        }
      }
      132.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          ReadRequestResult.fromList(it)
        }
      }
      133.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          UUID.fromList(it)
        }
      }
      else -> super.readValueOfType(type, buffer)
    }
  }
  override fun writeValue(stream: ByteArrayOutputStream, value: Any?)   {
    when (value) {
      is BleCentral -> {
        stream.write(128)
        writeValue(stream, value.toList())
      }
      is BleCharacteristic -> {
        stream.write(129)
        writeValue(stream, value.toList())
      }
      is BleDescriptor -> {
        stream.write(130)
        writeValue(stream, value.toList())
      }
      is BleService -> {
        stream.write(131)
        writeValue(stream, value.toList())
      }
      is ReadRequestResult -> {
        stream.write(132)
        writeValue(stream, value.toList())
      }
      is UUID -> {
        stream.write(133)
        writeValue(stream, value.toList())
      }
      else -> super.writeValue(stream, value)
    }
  }
}

/**
 * Native -> Flutter
 *
 * Generated class from Pigeon that represents Flutter messages that can be called from Kotlin.
 */
@Suppress("UNCHECKED_CAST")
class BleCallback(private val binaryMessenger: BinaryMessenger) {
  companion object {
    /** The codec used by BleCallback. */
    val codec: MessageCodec<Any?> by lazy {
      BleCallbackCodec
    }
  }
  fun onReadRequest(characteristicArg: BleCharacteristic, offsetArg: Long, valueArg: ByteArray?, callback: (ReadRequestResult?) -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BleCallback.onReadRequest", codec)
    channel.send(listOf(characteristicArg, offsetArg, valueArg)) {
      val result = it as ReadRequestResult?
      callback(result)
    }
  }
  fun onWriteRequest(characteristicArg: BleCharacteristic, offsetArg: Long, valueArg: ByteArray?, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BleCallback.onWriteRequest", codec)
    channel.send(listOf(characteristicArg, offsetArg, valueArg)) {
      callback()
    }
  }
  fun onCharacteristicSubscriptionChange(centralArg: BleCentral, characteristicArg: BleCharacteristic, isSubscribedArg: Boolean, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BleCallback.onCharacteristicSubscriptionChange", codec)
    channel.send(listOf(centralArg, characteristicArg, isSubscribedArg)) {
      callback()
    }
  }
  fun onSubscribe(bleCentralArg: BleCentral, characteristicArg: BleCharacteristic, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BleCallback.onSubscribe", codec)
    channel.send(listOf(bleCentralArg, characteristicArg)) {
      callback()
    }
  }
  fun onUnsubscribe(bleCentralArg: BleCentral, characteristicArg: BleCharacteristic, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BleCallback.onUnsubscribe", codec)
    channel.send(listOf(bleCentralArg, characteristicArg)) {
      callback()
    }
  }
  fun onAdvertisingStarted(errorArg: String?, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BleCallback.onAdvertisingStarted", codec)
    channel.send(listOf(errorArg)) {
      callback()
    }
  }
  fun onBleStateChange(stateArg: Boolean, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BleCallback.onBleStateChange", codec)
    channel.send(listOf(stateArg)) {
      callback()
    }
  }
  fun onServiceAdded(serviceArg: BleService, errorArg: String?, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BleCallback.onServiceAdded", codec)
    channel.send(listOf(serviceArg, errorArg)) {
      callback()
    }
  }
  fun onConnectionStateChange(centralArg: BleCentral, connectedArg: Boolean, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BleCallback.onConnectionStateChange", codec)
    channel.send(listOf(centralArg, connectedArg)) {
      callback()
    }
  }
  fun onBondStateChange(centralArg: BleCentral, bondStateArg: Long, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.ble_peripheral.BleCallback.onBondStateChange", codec)
    channel.send(listOf(centralArg, bondStateArg)) {
      callback()
    }
  }


  fun onMtuChanged(bleCentralArg: BleCentral, mtuArg: Long, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(
      binaryMessenger,
      "dev.flutter.pigeon.ble_peripheral.BleCallback.onMtuChanged",
      codec
    )
    channel.send(listOf(bleCentralArg, mtuArg)) {
      callback()
    }
  }
}
