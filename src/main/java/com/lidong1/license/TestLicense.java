package com.lidong1.license;


import com.verhas.licensor.License;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class TestLicense {

    public static void main(String[] args) {
        try {
            File licenseFile = new File("E:\\data\\project\\idea\\license\\src\\main\\resources\\license-decoded.txt");

            if (!licenseFile.exists()) {
                // license 文件生成
                OutputStream os = new FileOutputStream("E:\\data\\project\\idea\\license\\src\\main\\resources\\license-decoded.txt");
                os.write(new License()
                        // license 的原文
                        .setLicense(new File("E:\\data\\project\\idea\\license\\src\\main\\resources\\license-plain.txt"))
                        // 私钥与之前生成密钥时产生的USER-ID
                        .loadKey("E:\\data\\project\\idea\\license\\src\\main\\resources\\secring.gpg","Peter Verhas (licensor test key) <peter@verhas.com>")
                        // 生成密钥时输入的密码
                        .encodeLicense("alma").getBytes("utf-8"));
                os.close();
            } else {
                // licence 文件验证
                License license = new License();
                if (license
                        .loadKeyRing("E:\\data\\project\\idea\\license\\src\\main\\resources\\pubring.gpg", null)
                        .setLicenseEncodedFromFile("E:\\data\\project\\idea\\license\\src\\main\\resources\\license-decoded.txt").isVerified()) {
                    System.out.println(license.getFeature("expiryDate"));
                    System.out.println(license.getFeature("issuer"));
                    System.out.println(license.getFeature("licensor"));
                    System.out.println(license.getFeature("licensee"));
                    System.out.println(license.getFeature("issueDate"));
                    System.out.println(license.getFeature("addrs"));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
