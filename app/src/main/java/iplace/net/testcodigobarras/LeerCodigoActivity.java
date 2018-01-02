package iplace.net.testcodigobarras;

import android.app.Activity;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

/**
 * Created by Carlos Salas on 29/12/2017.
 */

public class LeerCodigoActivity extends Activity implements ZBarScannerView.ResultHandler {

    ZBarScannerView zBarScannerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        zBarScannerView = new ZBarScannerView(this);
        setContentView(zBarScannerView);
    }
    @Override
    public void onResume() {
        super.onResume();
        zBarScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        zBarScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        zBarScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        String tipoCodigo = "CODE39";
        Uri notificacion;
        Log.e("Scan:", rawResult.getContents()); // Prints scan results
        Log.e("Tipo de codigo:", rawResult.getBarcodeFormat().getName()); // Prints the scan format (qrcode, pdf417 etc.)

        if(rawResult.getBarcodeFormat().getName().equals(tipoCodigo)){

            notificacion = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        }
        else{

            notificacion = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        Ringtone r = RingtoneManager.getRingtone(this, notificacion);
        r.play();


        // If you would like to resume scanning, call this method below:
        zBarScannerView.resumeCameraPreview(this);
    }
}
