package com.bkacad.nnt.democontactdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

public abstract class ContactDialog extends Dialog {

    private EditText edtContact;
    private Button btnSave, btnCancel;


    public ContactDialog(@NonNull Context context) {
        super(context);
    }

    protected abstract void addNewContact(String contact);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_contact);
        edtContact = findViewById(R.id.edt_dialog_contact);
        btnCancel = findViewById(R.id.btn_dialog_cancel);
        btnSave = findViewById(R.id.btn_dialog_save);

        // Đăng kí sự kiện onclicl
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogSave();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCancel();
            }
        });

    }

    private void dialogSave() {
        // Lấy dữ liệu bên trong Edittext => gửi về MainActivity xử lý
        String contact = edtContact.getText().toString();
        if (contact.isEmpty()) {
            edtContact.setError("Hãy nhập dữ liệu");
            return;
        }
        addNewContact(contact);
        edtContact.setText("");
        dismiss();
    }

    private void dialogCancel() {
        // Ẩn đi// hiện 1 notify
        Toast.makeText(getContext(), "Thoát", Toast.LENGTH_SHORT).show();
        dismiss();
    }

}
