/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKCETest;

import com.vng.zalo.sdk.utils.PKCEUtil;

/**
 *
 * @author hienhh
 */
public class PKCETest {

    public static void main(String[] args) {
        String verifier = PKCEUtil.Instance.genCodeVerifier();
        System.err.println(verifier);
        try {
            String genCodeChallenge = PKCEUtil.Instance.genCodeChallenge(verifier);

            System.err.println(genCodeChallenge);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        System.exit(0);
    }
}
