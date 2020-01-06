package com.lidong1.license;


import com.verhas.licensor.HardwareBinder;
import com.verhas.licensor.License;
import org.bouncycastle.openpgp.PGPException;

import java.io.IOException;

public class TestLicense3 {

    private License lic = null;

    public void checkLicense() throws IOException, PGPException {
               lic = new License();
               lic.loadKeyRingFromResource("pubring.gpg", null);
               lic.setLicenseEncodedFromFile("E:\\data\\project\\idea\\license\\src\\main\\resources\\license-decoded.txt");
               checkDateAndVersionValidity();
               String edition = lic.getFeature("edition");
    }

    protected void checkDateAndVersionValidity() {
        String issueDate = lic.getFeature("expiryDate");
        System.out.println(issueDate);
//        String today = getTodayString();
//        LicenseDate todayLD = new LicenseDate(today);
//        if (!todayLD.isLaterThan(issueDate)) {
//            throw new IllegalArgumentException(
//                    "Issue date is too late, probably tampered system time");
//        }
//        String validDate = lic.getFeature("valid-date");
//        if (validDate != null) {
//            LicenseDate validDateLD = new LicenseDate(validDate);
//            if (todayLD.isLaterThan(validDateLD)) {
//                throw new IllegalArgumentException("License expired.");
//            }
//        }

    }

    public static void main(String[] args) throws IOException, PGPException {
//        TestLicense3 testLicense3 = new TestLicense3();
//        testLicense3.getClass().getClassLoader().getResourceAsStream("application.properties");
//        testLicense3.checkLicense();
        HardwareBinder hardwareBinder = new HardwareBinder();
        hardwareBinder.ignoreHostName();
//        hardwareBinder.ignoreNetwork();
        hardwareBinder.ignoreArchitecture();
        System.out.println(hardwareBinder.getMachineIdString());
        System.out.println(System.getProperty("os.arch"));
    }

}
