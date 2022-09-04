package com.hc.kotlin.encrypt.rsa

import java.security.KeyFactory
import java.security.KeyPairGenerator
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import java.util.Base64
import javax.crypto.Cipher

fun main() {
//    getKeyPair()
    val publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCT0pTVXn4GAoFXGyh8VYWM3ojJsVjTolZ+Dru" +
            "TkOTZ0I/T05rSmtFQXBih5YZsVsjyqe/JbRyX9ir5SMhD1TqNFUwAWrdSWNVHHLUTaS8KshgAnM9mzUJz" +
            "O+KYZyUihgTEaINy2BFXp6QfgmzKh6npFC64Xh6NMPDnX+p1UQIZVQIDAQAB"
    val privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJPSlNVefgYCgVcbKHxVhYzeiMmx" +
            "WNOiVn4Ou5OQ5NnQj9PTmtKa0VBcGKHlhmxWyPKp78ltHJf2KvlIyEPVOo0VTABat1JY1UcctRNpLwqyGACcz2" +
            "bNQnM74phnJSKGBMRog3LYEVenpB+CbMqHqekULrheHo0w8Odf6nVRAhlVAgMBAAECgYA4MxNKm4YmGsW5rCWU" +
            "P59qkyBGLhqrO0jO3CMMU0XuWZCU5Bo0f4+ckab7xht5DPWQ7HKxjb4VOA3WgIlC4MpFSTB3SGVu7lAMr4/iREL" +
            "QCwbvl4h3+SWJvB4FTPzX9sl/6bugPpDwguTliexuNC9Av6fK08yBnQgFZpNPjXhCAQJBAPU7mqB39/UR0VMNT" +
            "MpEwU0Jp+xB4d4yw6o54ZxbmDcCdqv27q0f5R7Vn1S49tRmNS8P0slIxtZnyNZUwGetlLUCQQCaUBg1Khy+w+G" +
            "iEnKdYiqs8nR82c1qDWVULcZrauw1RD0EeaxMTXm6cEynVSK5vjTfPPSBEt+H7qXOQJydTPYhAkBmXvFXl30d" +
            "AskdIGoz7au72xIMYBxHw21GvE7gFKRgIlkjxDsybiQZURfoKCZx2BDPio11lTnb+wst3cdMAHwZAkA2KHAmkI" +
            "4gIa1Z7XGObPqfUkSx4NsoImVywtIFtzQJidaEcJOZAAP9/BXbEJUsbWYvBzyk5FPRaF+G4MRWrMEhAkBEQH9s" +
            "Wwe4tgxz+AHJZPnVKZEW7g6G6Lsyrq+bkdEYosz92AJKPgmHwAOEZHxiKnFeyW/zUl2loYLUnVZWztqq"

    val message = "I love spring"

    encrypt(message, publicKey)
//    val encryptMessage = "kwIjMh3RwDxYpou7r8T9RZSmek11SeoAUfTVFUNtFwQ5oa4KZN8OL6OjiG9BCx204z+XaKNOLVfXzPpjl2G49olEfqb7oHvI/scei0wMadUAott4+Tn5otmaaYAzaFrrI9TkQo/39pydwcHxi4FxDB8AAERcNzgf1f+1WfF/4uA="

//    decrypt(encryptMessage, privateKey)


}

// 生成密钥：公钥、私钥
fun getKeyPair() {
    // 基于RSA算法生成对象，用于生成公钥和密钥对
    val keyPairGen = KeyPairGenerator.getInstance("RSA")
    // 初始化密钥对生成器，密钥大小为 96 - 1024 位
    keyPairGen.initialize(1024)

    // 生成一个密钥对，保存在KeyPair中。其中包含一个私钥和一个公钥
    val keyPair = keyPairGen.generateKeyPair()
    val privateKey = keyPair.private
    val publicKey = keyPair.public

    // 得到密钥字符串
    val privateKeyStr = String(Base64.getEncoder().encode(privateKey.encoded))
    val publicKeyStr = String(Base64.getEncoder().encode(publicKey.encoded))

    println("private key $privateKeyStr")
    println("public key $publicKeyStr")
}

// 加密
fun encrypt(message: String, publicKey: String) {
    // 公钥Base64解码
    val decodedKey = Base64.getDecoder().decode(publicKey)
    // 根据 byte[] 重新生成 RSA 公钥
    val pubKey = KeyFactory.getInstance("RSA").generatePublic(X509EncodedKeySpec(decodedKey))

    // RSA 加密
    val cipher = Cipher.getInstance("RSA")
    cipher.init(Cipher.ENCRYPT_MODE, pubKey)
    val encryptResult = cipher.doFinal(message.toByteArray())
    val output = Base64.getEncoder().encodeToString(encryptResult)

    println("encrypt out $output")
}

// 解密
fun decrypt(message: String, privateKey: String) {
    // base 64 解码的私钥
    val decodeKey = Base64.getDecoder().decode(privateKey)
    val priKey = KeyFactory.getInstance("RSA").generatePrivate(PKCS8EncodedKeySpec(decodeKey))

    // 解密
    val cipher = Cipher.getInstance("RSA")
    cipher.init(Cipher.DECRYPT_MODE, priKey)
    // base64 解码加密字符串
    val decryptResult = cipher.doFinal(Base64.getDecoder().decode(message))

    val out = String(decryptResult)
    println("decrypt out: $out")
}
