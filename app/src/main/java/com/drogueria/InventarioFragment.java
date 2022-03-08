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
import com.drogueria.databinding.FragmentInventarioBinding;


public class InventarioFragment extends Fragment {

    EditText etFechaRealizacion, etNumeroEstante,etCodProducto,etNombreProducto,
            etConcentracion,etPresentacion,etCantidadDisp,etValorUnitario,etFechaVencimiento;

    private FragmentInventarioBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {


        binding = FragmentInventarioBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        etFechaRealizacion = view.findViewById(R.id.etFechaRealizacion);
        etNumeroEstante = view.findViewById(R.id.etNumeroEstante);
        etCodProducto = view.findViewById(R.id.etCodProducto);
        etNombreProducto = view.findViewById(R.id.etNombreProducto);
        etConcentracion = view.findViewById(R.id.etConcentracion);
        etPresentacion = view.findViewById(R.id.etPresentacion);
        etCantidadDisp = view.findViewById(R.id.etCantidadDisp);
        etValorUnitario = view.findViewById(R.id.etValorUnitario);
        etFechaVencimiento = view.findViewById(R.id.etFechaVencimiento);

        binding.btnGuardarInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                String fechaRealizacion =etFechaRealizacion.getText().toString();
                String numeroEstante =etNumeroEstante.getText().toString();
                String codProducto =etCodProducto.getText().toString();
                String nombreProducto =etNombreProducto.getText().toString();
                String concentracion =etConcentracion.getText().toString();
                String presentacion =etPresentacion.getText().toString();
                String cantidadDisponible =etCantidadDisp.getText().toString();
                String valorUnitario =etValorUnitario.getText().toString();
                String fechaVencimiento =etFechaVencimiento.getText().toString();

                bundle.putString("fechaRealizacion", fechaRealizacion);
                bundle.putString("numeroEstante", numeroEstante);
                bundle.putString("codProducto", codProducto);
                bundle.putString("nombreProducto", nombreProducto);
                bundle.putString("concentracion", concentracion);
                bundle.putString("presentacion", presentacion);
                bundle.putString("cantidadDisponible", cantidadDisponible);
                bundle.putString("valorUnitario", valorUnitario);
                bundle.putString("fechaVencimiento", fechaVencimiento);

                getParentFragmentManager().setFragmentResult("key",bundle);

                if(fechaRealizacion.equals("")|| numeroEstante.equals("")|| codProducto.equals("")||
                nombreProducto.equals("")||concentracion.equals("")||presentacion.equals("")||cantidadDisponible.equals("")||
                valorUnitario.equals("")|| fechaVencimiento.equals(""))
                {
                    Toast.makeText(getActivity(), "Por favor ingresar todos los campos en el formulario", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    NavHostFragment.findNavController(InventarioFragment.this)
                            .navigate(R.id.action_inventarioFragment_to_SecondFragment);
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