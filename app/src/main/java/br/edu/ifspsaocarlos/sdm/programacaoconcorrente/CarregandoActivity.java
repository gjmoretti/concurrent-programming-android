package br.edu.ifspsaocarlos.sdm.programacaoconcorrente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

/**
 * Created by Gustavo on 29/05/2015.
 */
public class CarregandoActivity extends Activity {

    private final int ABRIR_ACTIVITY_PRINCIPAL = 0;
    private final int TEMPO_CARREGAMENTO = 3000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carregando);

        Toast.makeText(this, R.string.mensagem_carregando, Toast.LENGTH_SHORT).show();

        Message mensagem = new Message();
        mensagem.what = ABRIR_ACTIVITY_PRINCIPAL;
        handler.sendMessageDelayed(mensagem, TEMPO_CARREGAMENTO);
    }

    private Handler handler = new Handler(){
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case ABRIR_ACTIVITY_PRINCIPAL:
                    // Cria a intent, inicia activity principal e fecha esta activity
                    Intent intent = new Intent(getBaseContext(), PrincipalActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                default:
                    break;
            }
        }
    };
}


