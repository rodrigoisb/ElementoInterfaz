package com.example.elementointerfaz;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.example.elementointerfaz.databinding.FragmentPasswordBinding;

public class PasswordFragment extends Fragment {

    private FragmentPasswordBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPasswordBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = s.toString();
                if (isPasswordValid(password)) {
                    binding.buttonCheckPassword.setEnabled(true);
                } else {
                    binding.buttonCheckPassword.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        binding.buttonCheckPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(PasswordFragment.this)
                        .navigate(R.id.action_FirstFragment_to_ResultFragment);
            }
        });
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 5 && password.matches(".*[A-Z].*");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
