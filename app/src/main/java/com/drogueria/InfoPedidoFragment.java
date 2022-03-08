package com.drogueria;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.drogueria.databinding.FragmentInfoPedidoBinding;
import com.drogueria.databinding.FragmentLoginBinding;

public class InfoPedidoFragment extends Fragment {

    EditText etNombreUsuarioPedido, etConcentracionPedido, etPresentacionPedido,
            etCodProductoPedido, etValorUnitarioPedido, etCantidadPedido,
            etNombrePedido, etApellidosPedido, etIdentificacionPedido,
            etDireccionPedido, etBarrioPedido, etTelefonoPedido, etDomiciliarioPedido;


    private FragmentInfoPedidoBinding binding;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {


        binding = FragmentInfoPedidoBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etNombreUsuarioPedido = view.findViewById(R.id.etNombreUsuarioPedido);
        etConcentracionPedido = view.findViewById(R.id.etConcentracionPedido);
        etPresentacionPedido = view.findViewById(R.id.etPresentacionPedido);
        etCodProductoPedido = view.findViewById(R.id.etCodProductoPedido);
        etValorUnitarioPedido = view.findViewById(R.id.etValorUnitarioPedido);
        etCantidadPedido = view.findViewById(R.id.etCantidadPedido);
        etNombrePedido = view.findViewById(R.id.etNombrePedido);
        etApellidosPedido = view.findViewById(R.id.etApellidosPedido);
        etIdentificacionPedido = view.findViewById(R.id.etIdentificacionPedido);
        etDireccionPedido = view.findViewById(R.id.etDireccionPedido);
        etBarrioPedido = view.findViewById(R.id.etBarrioPedido);
        etTelefonoPedido = view.findViewById(R.id.etTelefonoPedido);
        etDomiciliarioPedido = view.findViewById(R.id.etDomiciliarioPedido);

        binding.btnfinalizacionPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                String nombreUsuario =etNombreUsuarioPedido.getText().toString();
                String concentraciónPedido = etConcentracionPedido.getText().toString();
                String presentacionPedido = etPresentacionPedido.getText().toString();
                String productoPedido = etCodProductoPedido.getText().toString();
                String valorUnitarioPedido = etValorUnitarioPedido.getText().toString();
                String cantidadPedido = etCantidadPedido.getText().toString();
                String nombrePedido = etNombrePedido.getText().toString();
                String apellidosPedido = etApellidosPedido.getText().toString();
                String identificacionPedido = etIdentificacionPedido.getText().toString();
                String direccionPedido = etDireccionPedido.getText().toString();
                String barrioPedido = etBarrioPedido.getText().toString();
                String telefonoPedido = etTelefonoPedido.getText().toString();
                String domiciliarioPedido = etDomiciliarioPedido.getText().toString();

                bundle.putString("nombreUsuario", nombreUsuario);
                bundle.putString("concentraciónPedido",concentraciónPedido);
                bundle.putString("presentacionPedido",presentacionPedido);
                bundle.putString("productoPedido",productoPedido);
                bundle.putString("valorUnitarioPedido",valorUnitarioPedido);
                bundle.putString("cantidadPedido",cantidadPedido);
                bundle.putString("nombrePedido",nombrePedido);
                bundle.putString("apellidosPedido",apellidosPedido);
                bundle.putString("identificacionPedido",identificacionPedido);
                bundle.putString("direccionPedido",direccionPedido);
                bundle.putString("barrioPedido",barrioPedido);
                bundle.putString("telefonoPedido",telefonoPedido);
                bundle.putString("domiciliarioPedido",domiciliarioPedido);

                getParentFragmentManager().setFragmentResult("key",bundle);
                if(nombreUsuario.equals("") || concentraciónPedido.equals("")|| presentacionPedido.equals("" )||productoPedido.equals("")|| valorUnitarioPedido.equals("")||
                        cantidadPedido.equals("")|| nombrePedido.equals("") || apellidosPedido.equals("") || identificacionPedido.equals("")||direccionPedido.equals("")||
                barrioPedido.equals("")||telefonoPedido.equals("")||  domiciliarioPedido.equals(""))
                {
                    Toast.makeText(getActivity(), "Por favor ingresar todos los campos en el formulario", Toast.LENGTH_SHORT).show();

                }else{
                    NavHostFragment.findNavController(InfoPedidoFragment.this)
                            .navigate(R.id.action_infoPedidoFragment_to_SecondFragment);
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