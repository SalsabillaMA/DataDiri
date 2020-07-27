package id.sch.smktelkom.www.datadiri;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String STATE_RESULT = "state_result";
    private EditText edtNama, edtAlamat, edtTelepon, edtHobi, edtKeinginan, edtTtl;
    private Spinner jk;
    private Button btnHasil;
    private TextView dataResult;
    private int mTahun, mBulan, mHari;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, dataResult.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNama = findViewById(R.id.edit_nama);
        edtTtl = findViewById(R.id.edtDate);
        edtAlamat = findViewById(R.id.edit_alamat);
        edtTelepon = findViewById(R.id.edit_telepon);
        edtHobi = findViewById(R.id.edit_hobi);
        edtKeinginan = findViewById(R.id.edit_keinginan);
        btnHasil = findViewById(R.id.btn_hasil);
        dataResult = findViewById(R.id.data_result);
        jk = findViewById(R.id.edit_jk);

        List<String> listGender = new ArrayList<>();
        listGender.add("Laki - laki");
        listGender.add("Perempuan");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listGender);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jk.setAdapter(adapter);


        btnHasil.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result =
                    savedInstanceState.getString(STATE_RESULT);
            dataResult.setText(result);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hasil) {
            String inputNama = edtNama.getText().toString().trim();
            String inputTtl = edtTtl.getText().toString().trim();
            String inputAlamat = edtAlamat.getText().toString().trim();
            String inputTelepon = edtTelepon.getText().toString().trim();
            String inputHobi = edtHobi.getText().toString().trim();
            String inputKeinginan = edtKeinginan.getText().toString().trim();

            boolean isEmpetyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputNama)) {
                isEmpetyFields = true;
                edtNama.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputTtl)) {
                isEmpetyFields = true;
                edtTtl.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputAlamat)) {
                isEmpetyFields = true;
                edtAlamat.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputTelepon)) {
                isEmpetyFields = true;
                edtTelepon.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHobi)) {
                isEmpetyFields = true;
                edtHobi.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputKeinginan)) {
                isEmpetyFields = true;
                edtKeinginan.setError("Field ini tidak boleh kosong");
            }
            if (!isEmpetyFields) {

                dataResult.setText("Perkenalkan Nama Saya " + inputNama + " Yang lahir pada tanggal " + inputTtl +
                        " dan alamat rumah saya di : " + inputAlamat + " Nomor Telepon saya adalah " + inputTelepon + " hobi saya adalah " +
                        inputHobi + " dan keinginan saya adalah " + inputKeinginan + " Sekian dari saya terimakasih:)");
            }
        }
    }
}