package com.drogueria;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.drogueria.databinding.FragmentInfoPedidoBinding;
import com.drogueria.databinding.FragmentRegistroBinding;


public class RegistroFragment extends Fragment {

   EditText etNombreRegistro, etApellidoRegistro,etCedulaRegistro,etNombreUsuario;
    private FragmentRegistroBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentRegistroBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etNombreRegistro = view.findViewById(R.id.etNombreRegistro);
        etApellidoRegistro = view.findViewById(R.id.etApellidoRegistro);
        etCedulaRegistro = view.findViewById(R.id.etCedulaRegistro);
        etNombreUsuario = view.findViewById(R.id.etNombreUsuario);

        binding.btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                String nombreRegistro =etNombreRegistro.getText().toString();
                String apellidoRegistro =etApellidoRegistro.getText().toString();
                String cedulaRegistro =etCedulaRegistro.getText().toString();
                String nombreUsuarioRegistro =etNombreUsuario.getText().toString();

                bundle.putString("nombreRegistro", nombreRegistro);
                bundle.putString("apellidoRegistro", apellidoRegistro);
                bundle.putString("cedulaRegistro", cedulaRegistro);
                bundle.putString("nombreUsuarioRegistro", nombreUsuarioRegistro);

                getParentFragmentManager().setFragmentResult("key",bundle);
                if(nombreRegistro.equals("")|| apellidoRegistro.equals("")||
                cedulaRegistro.equals("")|| nombreUsuarioRegistro.equals(""))
                {
                    Toast.makeText(getActivity(), "Por favor ingresar todos los campos en el formulario", Toast.LENGTH_SHORT).show();
                }else
                {
                    NavHostFragment.findNavController(RegistroFragment.this)
                            .navigate(R.id.action_registroFragment_to_FirstFragment);
                    onDestroyView();
                }
            }
        });
    }

    @Override
        public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}