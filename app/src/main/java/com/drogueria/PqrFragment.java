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
import com.drogueria.databinding.FragmentPqrBinding;


public class PqrFragment extends Fragment {

  EditText etNombres, etApellidos, etIdentificacion,etBarrio,etTelefono,
    etEmail,etTipoRecurso,etFecha,etSituacion;

  private FragmentPqrBinding binding;

  @Override
  public View onCreateView(
          LayoutInflater inflater, ViewGroup container,
          Bundle savedInstanceState
  ) {


    binding = FragmentPqrBinding.inflate(inflater, container, false);
    return binding.getRoot();

  }
  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    etNombres = view.findViewById(R.id.etNombres);
    etApellidos = view.findViewById(R.id.etApellidos);
    etIdentificacion = view.findViewById(R.id.etIdentificacion);
    etBarrio = view.findViewById(R.id.etBarrio);
    etTelefono = view.findViewById(R.id.etTelefono);
    etEmail = view.findViewById(R.id.etEmail);
    etTipoRecurso = view.findViewById(R.id.etTipoRecurso);
    etFecha = view.findViewById(R.id.etFecha);
    etSituacion = view.findViewById(R.id.etSituacion);

    binding.btnEnviarPQR.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Bundle bundle = new Bundle();
        String nombreUsuario =etNombres.getText().toString();
        String apellidosUsuario = etApellidos.getText().toString();
        String identificacionUsuario = etIdentificacion.getText().toString();
        String barrio = etBarrio.getText().toString();
        String telefono = etTelefono.getText().toString();
        String email = etEmail.getText().toString();
        String tipoRecurso = etTipoRecurso.getText().toString();
        String fecha = etFecha.getText().toString();
        String situacion = etSituacion.getText().toString();

        bundle.putString("nombreUsuario", nombreUsuario);
        bundle.putString("apellidosUsuario",apellidosUsuario);
        bundle.putString("identificacionUsuario",identificacionUsuario);
        bundle.putString("barrio",barrio);
        bundle.putString("telefono",telefono);
        bundle.putString("email",email);
        bundle.putString("tipoRecurso",tipoRecurso);
        bundle.putString("fecha",fecha);
        bundle.putString("situacion",situacion);

        getParentFragmentManager().setFragmentResult("key",bundle);
        if(nombreUsuario.equals("") || apellidosUsuario.equals("")|| identificacionUsuario.equals("" )||barrio.equals("")|| telefono.equals("")||
                email.equals("")|| tipoRecurso.equals("") || fecha.equals("") || situacion.equals(""))
        {
          Toast.makeText(getActivity(), "Por favor ingresar todos los campos en el formulario", Toast.LENGTH_SHORT).show();

        }else{
          NavHostFragment.findNavController(PqrFragment.this)
                  .navigate(R.id.action_pqrFragment_to_SecondFragment);
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