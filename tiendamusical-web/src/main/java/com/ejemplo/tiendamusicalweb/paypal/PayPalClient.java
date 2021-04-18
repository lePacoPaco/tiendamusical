/**
 * 
 */
package com.ejemplo.tiendamusicalweb.paypal;


import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * 
 * @author paco_
 * Clase Client de PayPal que configura las clases necesarias para realizar las transacciones
 * hacia PayPal y también el Client ID y Secret ID de acceso a la aplicación de Sandbox.
 */
public class PayPalClient {

  /**
   *Set up the PayPal Java SDK environment with PayPal access credentials.  
   *This sample uses SandboxEnvironment. In production, use LiveEnvironment.
   */
  private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
	//CLIENT ID
    "AUR8fUEyDlLl9dwLAAb0XQyz8KpNhq9aWYHY3PMzRwNhWcNwkg57CsyjC2KfUFI6FuOfUTmzA9IP67vV",
    //SECRET
    "EKh4DMWuwYGtZKrvM_IiYb6FKsymCcSAkDPcauy-AIbz5e7zFGygurlio6LiCYs4I1DVQ4Qqunfh1iIb");

  /**
   *PayPal HTTP client instance with environment that has access
   *credentials context. Use to invoke PayPal APIs.
   */
  PayPalHttpClient client = new PayPalHttpClient(environment);

  /**
   *Method to get client object
   *
   *@return PayPalHttpClient client
   */
  public PayPalHttpClient client() {
    return this.client;
  }
}