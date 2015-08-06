package com.guna.taskmanager;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginActivityFragment extends Fragment {

    private EditText userName;
    private EditText passWord;
    private Button login;

    public LoginActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userName = (EditText) view.findViewById(R.id.editText);
        passWord = (EditText) view.findViewById(R.id.editText2);
        login = (Button) view.findViewById(R.id.button);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString().toLowerCase();
                String password = passWord.getText().toString().toLowerCase();
                if (name.equals(password) && (name.equals("admin") || name.equals("user"))) {
                    Intent i = new Intent(getActivity(), UploadActivity.class);
                    i.putExtra("name", name);
                    startActivity(i);
                }else {
                    Toast.makeText(getActivity(),"Please check credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
