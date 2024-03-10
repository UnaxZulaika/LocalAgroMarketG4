package com.example.localagromarket;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfilaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfilaFragment extends Fragment {

    private FirebaseAuth mAuth;
    private EditText etIzena;
    private ImageButton ibEditIzena;
    private EditText etAbizenak;
    private ImageButton ibEditAbizena;

    public ProfilaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProfilaFragment.
     */
    public static ProfilaFragment newInstance() {
        return new ProfilaFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profila, container, false);

        EditText etEposta = view.findViewById(R.id.etEposta);
        etIzena = view.findViewById(R.id.etIzena);
        ibEditIzena = view.findViewById(R.id.ibEditIzenaProfila);
        etAbizenak = view.findViewById(R.id.etAbizenak);
        ibEditAbizena = view.findViewById(R.id.ibEditAbizenaProfila);
        EditText etHelbidea = view.findViewById(R.id.etHelbideaProfila);
        Button btnAldatuPasahitza = view.findViewById(R.id.btnAldatuPasahitza);
        Button btnItxiSaioa = view.findViewById(R.id.btnItxiSaioa);
        Button btnEzabatuKontua = view.findViewById(R.id.btnEzabatuKontua);

//        mAuth = FirebaseAuth.getInstance();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//
//        // Erabiltzailearen informazioa datu basetik hartzen da
//        List<SaltzaileaClass> saltzaileak = null;
//        boolean isSaltzailea = false;
//
//        for (int i = 0; i < saltzaileak.size(); i++) {
//            assert currentUser != null;
//            if (Objects.requireNonNull(currentUser.getEmail()).equalsIgnoreCase(saltzaileak.get(i).getEmail())) { // MIRAME ESTA AINGERUU
//                isSaltzailea = true;
//            }
//        }
//
//        BezeroaClass bezeroak;
//        SaltzaileaClass saltzailea;
//        if (isSaltzailea) {
//            bezeroak = null;
//            saltzaileak = new SaltzaileaDAOClass().getSaltzaileak();
//
//            etEposta.setText(irakaslea.getEmail());
//            etIzena.setText(irakaslea.getIzena());
//            etAbizenak.setText(irakaslea.getAbizenak());
//            etKurtsoa.setText(irakaslea.getKurtsoa());
//        } else {
//            irakaslea = null;
//            IkasleaDao ikaselaDao = LoginActivity.db.ikasleaDao();
//            ikaslea = ikaselaDao.getIkasleaByEmail(Objects.requireNonNull(mAuth.getCurrentUser()).getEmail());
//
//            etEposta.setText(ikaslea.getEmail());
//            etIzena.setText(ikaslea.getIzena());
//            etAbizenak.setText(ikaslea.getAbizenak());
//            etKurtsoa.setText(ikaslea.getKurtsoa());
//        }
//
//
//        boolean finalIsIrakaslea = isIrakaslea;
//        firestore = FirebaseFirestore.getInstance();
//
//        // Izena editatzeko aukera. Izena aldatzen denean Room eta Firestoren eguneratzen da.
//        ibEditIzena.setOnClickListener(view1 -> {
//            boolean isEnabled = etIzena.isEnabled();
//
//            if (!isEnabled) {
//                etIzena.setEnabled(true);
//                ibEditIzena.setImageResource(R.drawable.save_24);
//            } else {
//                AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
//                builder.setMessage(getString(R.string.aldaketakGorde))
//                        .setPositiveButton(getString(R.string.bai), (dialog, id) -> {
//                            if(finalIsIrakaslea){
//                                // Room Irakaslea
//                                irakaslea.setIzena(etIzena.getText().toString());
//                                LoginActivity.db.irakasleaDao().update(irakaslea);
//                                etIzena.setText(irakaslea.getIzena());
//
//                                // Firestore Irakaslea
//                                firestore.collection("Irakasleak").document(currentUser.getEmail()).set(irakaslea);
//                            }else{
//                                // Room Ikaslea
//                                ikaslea.setIzena(etIzena.getText().toString());
//                                LoginActivity.db.ikasleaDao().update(ikaslea);
//                                etIzena.setText(ikaslea.getIzena());
//
//                                // Firestore Ikaslea
//                                assert currentUser != null;
//                                firestore.collection("Ikasleak").document(Objects.requireNonNull(currentUser.getEmail())).set(ikaslea);
//                            }
//                            etIzena.setEnabled(false);
//                            ibEditIzena.setImageResource(R.drawable.edit_pencil_24);
//                        })
//                        .setNegativeButton(getString(R.string.ez), (dialog, id) -> {
//                            if(finalIsIrakaslea){
//                                etIzena.setText(irakaslea.getIzena());
//                            }else{
//                                etIzena.setText(ikaslea.getIzena());
//                            }
//                            etIzena.setEnabled(false);
//                            dialog.dismiss();
//                            ibEditIzena.setImageResource(R.drawable.edit_pencil_24);
//                        })
//                        .setOnDismissListener(dialogInterface -> {
//                            if(finalIsIrakaslea) {
//                                etIzena.setText(irakaslea.getIzena());
//                            }else{
//                                etIzena.setText(ikaslea.getIzena());
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//
//        // Abizena editatzeko aukera. Abizena aldatzen denean Room eta Firestoren eguneratzen da.
//        ibEditAbizena.setOnClickListener(view2 -> {
//            boolean isEnabled = etAbizenak.isEnabled();
//
//            if (!isEnabled) {
//                etAbizenak.setEnabled(true);
//                ibEditAbizena.setImageResource(R.drawable.save_24);
//            } else {
//                AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
//                builder.setMessage(getString(R.string.aldaketakGorde))
//                        .setPositiveButton(getString(R.string.bai), (dialog, id) -> {
//                            if(finalIsIrakaslea){
//                                // Room Irakaslea
//                                irakaslea.setAbizenak(etAbizenak.getText().toString());
//                                LoginActivity.db.irakasleaDao().update(irakaslea);
//                                etAbizenak.setText(irakaslea.getAbizenak());
//
//                                // Firestore Irakaslea
//                                firestore.collection("Irakasleak").document(Objects.requireNonNull(currentUser.getEmail())).set(irakaslea);
//                            }else{
//                                // Room Ikaslea
//                                ikaslea.setAbizenak(etAbizenak.getText().toString());
//                                LoginActivity.db.ikasleaDao().update(ikaslea);
//                                etAbizenak.setText(ikaslea.getAbizenak());
//
//                                // Firestore Ikaslea
//                                assert currentUser != null;
//                                firestore.collection("Ikasleak").document(Objects.requireNonNull(currentUser.getEmail())).set(ikaslea);
//                            }
//                            etAbizenak.setEnabled(false);
//                            ibEditAbizena.setImageResource(R.drawable.edit_pencil_24);
//                        })
//                        .setNegativeButton(getString(R.string.ez), (dialog, id) -> {
//                            if(finalIsIrakaslea){
//                                etAbizenak.setText(irakaslea.getAbizenak());
//                            }else{
//                                etAbizenak.setText(ikaslea.getAbizenak());
//                            }
//                            etAbizenak.setEnabled(false);
//                            dialog.dismiss();
//                            ibEditAbizena.setImageResource(R.drawable.edit_pencil_24);
//                        })
//                        .setOnDismissListener(dialogInterface -> {
//                            assert ikaslea != null;
//                            etAbizenak.setText(ikaslea.getAbizenak());
//                        });
//                builder.create().show();
//            }
//        });
//
//        // Pasahitza aldatzeko aukera. Pasahitza aldatzen denean Room-en eta Authenticator-en eguneratzen da.
//        btnAldatuPasahitza.setOnClickListener(view3 -> {
//            // Edit text pasahitz berria sartzeko
//            final EditText etPasahitzBerriaInput = new EditText(getActivity());
//
//            etPasahitzBerriaInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
//            builder.setMessage(getString(R.string.pasahitzBerria)).setView(etPasahitzBerriaInput)
//                    .setPositiveButton(getString(R.string.aldatu), (dialogInterface, i) -> {
//                        // Sartutako pasahitz berria eskuratu
//                        String newPassword = etPasahitzBerriaInput.getText().toString();
//                        // Pasahitz berria beteta dagoela egiaztazen du
//                        if (!TextUtils.isEmpty(newPassword)) {
//                            // Momentuko erabiltzailea eskuratu
//                            FirebaseUser erabiltzailea = mAuth.getCurrentUser();
//                            if (erabiltzailea != null) {
//                                // Pasahitza eguneratu
//                                if(finalIsIrakaslea){
//                                    // Room Irakaslea
//                                    LoginActivity.db.irakasleaDao().update(irakaslea);
//                                }else{
//                                    // Room Ikaslea
//                                    LoginActivity.db.ikasleaDao().update(ikaslea);
//                                }
//
//                                erabiltzailea.updatePassword(newPassword).addOnCompleteListener(task -> {
//                                    if (task.isSuccessful()) {
//                                        // Pasahitza ondo aldatu da
//                                        Toast.makeText(getContext(), getString(R.string.pasahitzaOndoAldatuta), Toast.LENGTH_SHORT).show();
//                                    } else {
//                                        Exception exception = task.getException();
//                                        if (exception instanceof FirebaseNetworkException) {
//                                            // Ezin izan da pasahitza aldatu, konexio gabe dagoelako
//                                            Toast.makeText(getContext(), getString(R.string.internetKonexioEz), Toast.LENGTH_SHORT).show();
//                                        } else if (exception instanceof FirebaseAuthWeakPasswordException) {
//                                            // Ezin izan da pasahitza aldatu, pasahitzak ez duelako betetzen gutxieneko baldintzak
//                                            Toast.makeText(getContext(), getString(R.string.pasahitzFormaEz), Toast.LENGTH_SHORT).show();
//                                        } else {
//                                            // Ezin izan da pasahitza aldatu
//                                            Toast.makeText(getContext(), getString(R.string.pasahitzaGaizkiAldatuta), Toast.LENGTH_SHORT).show();
//                                        }
//                                    }
//                                });
//                            }
//                        } else {
//                            // Pasahitza berria hutsik egonda
//                            Toast.makeText(getContext(), getString(R.string.pasahitzaHutsik), Toast.LENGTH_SHORT).show();
//                        }
//                    })
//                    .setNegativeButton(getString(R.string.ezeztatu), (dialogInterface, i) -> {
//                        // Pasahitz aldaketa ezeztatu da.
//                        dialogInterface.dismiss();
//                    });
//            builder.create().show();
//        });
//
//        // Saioa ixten du
//        btnItxiSaioa.setOnClickListener(view4 -> {
//            mAuth.signOut();
//            requireActivity().finish();
//        });
//
//        // Kontua ezabatzeko aukera. Kontua Room-en eta Authenticator-en ezabatzen da.
//        btnEzabatuKontua.setOnClickListener(view5 -> {
//            AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
//            builder.setMessage(getString(R.string.kontuaEzabatuGaldera))
//                    .setPositiveButton(getString(R.string.bai), (dialogInterface, i) -> {
//                        // Kontua ezabatu
//                        FirebaseUser erabiltzailea = FirebaseAuth.getInstance().getCurrentUser();
//                        if (erabiltzailea != null) {
//                            if(finalIsIrakaslea){
//                                // Room Irakaslea
//                                LoginActivity.db.irakasleaDao().delete(irakaslea);
//                            }else{
//                                // Room Ikaslea
//                                LoginActivity.db.ikasleaDao().delete(ikaslea);
//                            }
//                            erabiltzailea.delete().addOnCompleteListener(task -> {
//                                if (task.isSuccessful()) {
//                                    // Kontua ondo ezabatu da
//                                    Toast.makeText(getContext(), getString(R.string.kontuaEzabatuta), Toast.LENGTH_SHORT).show();
//                                    requireActivity().finish();
//                                } else {
//                                    // Error al eliminar la cuenta
//                                    Exception exception = task.getException();
//                                    if (exception instanceof FirebaseNetworkException) {
//                                        // Ezin izan da pasahitza aldatu, konexio gabe dagoelako
//                                        Toast.makeText(getContext(), getString(R.string.internetKonexioEz), Toast.LENGTH_SHORT).show();
//                                    } else {
//                                        Toast.makeText(getContext(), getString(R.string.kontuaEzEzabatuta), Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            });
//                        }
//                    })
//                    .setNegativeButton(getString(R.string.ez), (dialogInterface, i) -> {
//                        // Ez ezabatzeko aukeratzen bada.
//                        dialogInterface.dismiss();
//                    });
//            builder.create().show();
//        });

        return view;
    }
}
