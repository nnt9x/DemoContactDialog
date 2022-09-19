package com.bkacad.nnt.democontactdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvContact;
    private ArrayAdapter<String> arrayAdapter;
    private List<String> data;

    private ContactDialog contactDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvContact = findViewById(R.id.lvContact);
        // Bước 1: cần chuẩn bị dữ liệu
        data = new ArrayList<>();
        data.add("Contact 1 - 019198282");
        data.add("Contact 2 - 019198283");

        //  Tạo adapter
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        // Set adpter cho listview
        lvContact.setAdapter(arrayAdapter);

    }

    public void showDialog(View view) {
        // Show dialog tại đây
        // Nếu dialog chưa có -> tạo và hiển thị lên
        if (contactDialog == null) {
            contactDialog = new ContactDialog(this) {
                @Override
                protected void addNewContact(String contact) {
                    // Thêm dữ liệu vào data source
                    data.add(contact);
                    // Thông báo cho adapter
                    arrayAdapter.notifyDataSetChanged();
                }
            };
        }
        contactDialog.show();

    }
}